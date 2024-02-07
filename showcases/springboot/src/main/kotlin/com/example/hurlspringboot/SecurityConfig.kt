package com.example.hurlspringboot

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.jwt.JwtDecoder;

@Configuration
class JWTSecurityConfig {
    @Value("\${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    var issuerUri: String? = null
    @Value("\${spring.security.oauth2.resourceserver.jwt.hmac256Secret}")
    var hmac256Secret: String? = null

    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .authorizeHttpRequests { authorizeRequests ->
                authorizeRequests.requestMatchers("/api/healthz").permitAll()
                    .anyRequest().authenticated()
            }
            .oauth2ResourceServer { oauth2ResourceServer: OAuth2ResourceServerConfigurer<HttpSecurity?> ->
                oauth2ResourceServer
                    .jwt { jwt ->
                        jwt.decoder { token ->
                            issuerUri?.let { issuer -> JwtDecoders.fromIssuerLocation(issuer) }
                                ?: hmac256Secret?.let { secret -> LocalJwtDecoder(secret).decode(token) }
                                ?: throw IllegalArgumentException("No issuer and no secret set, see env vars")
                        }

                    }
            }.build()
    }
}

class LocalJwtDecoder(private val hmac256Secret: String): JwtDecoder{
    override fun decode(token: String?): Jwt {
       val verified = JWT.require(Algorithm.HMAC256(hmac256Secret)).build().verify(token)
      return Jwt.withTokenValue(verified.token).build()
    }

}