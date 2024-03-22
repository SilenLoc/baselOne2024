package com.example.hurlspringboot

import com.nimbusds.jwt.JWTClaimNames
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer
import org.springframework.security.oauth2.core.*
import org.springframework.security.oauth2.jwt.*
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.security.web.util.matcher.OrRequestMatcher
import javax.crypto.spec.SecretKeySpec

@Configuration
class JWTSecurityConfig {
    @Value("\${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    var issuerUri: String? = null

    @Value("\${spring.security.oauth2.resourceserver.jwt.hmac256Secret}")
    var hmac256Secret: String? = null

    @Value("\${spring.security.oauth2.resourceserver.jwt.audience}")
    var audience: String? = null

    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .authorizeHttpRequests { authorizeRequests ->
                authorizeRequests.requestMatchers(unauthenticatedMatcher).permitAll()
                authorizeRequests.anyRequest().authenticated()
            }
            .oauth2ResourceServer { oauth2ResourceServer: OAuth2ResourceServerConfigurer<HttpSecurity?> ->
                oauth2ResourceServer
                    .jwt { jwt ->
                        val decoder = createDecoder(secret = hmac256Secret, issuerUri = issuerUri)
                        decoder?.setJwtValidator(createTokenValidator(audience))
                        jwt.decoder(decoder)
                    }
            }.build()
    }

    companion object {
        private val unauthenticatedMatcher = OrRequestMatcher(
            AntPathRequestMatcher("/api/healthz"),
        )
    }
}


private fun createDecoder(issuerUri: String?, secret: String?) =
    secret?.let {
        val spec = SecretKeySpec(secret.toByteArray(), 0, secret.length, "HmacSHA256")
        NimbusJwtDecoder.withSecretKey(spec).build()
    } ?: issuerUri?.let { JwtDecoders.fromOidcIssuerLocation(it) }


fun createTokenValidator(
    audience: String?
): OAuth2TokenValidator<Jwt> = DelegatingOAuth2TokenValidator(
    audience?.let { claimAudienceValidator(it) } ?: throw IllegalStateException("audience must be set") ,
)

internal fun claimAudienceValidator(audience: String) =
    JwtClaimValidator<List<String>?>(JWTClaimNames.AUDIENCE) { aud ->
        aud?.contains(audience) ?: false
    }