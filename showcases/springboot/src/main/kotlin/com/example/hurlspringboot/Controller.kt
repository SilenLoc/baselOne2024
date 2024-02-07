import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
internal class Controller{

    @GetMapping("/healthz")
    fun healthz(): ResponseEntity<Unit> {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/protected")
    fun protected(): ResponseEntity<Unit> {
        return ResponseEntity.ok().build();
    }


}