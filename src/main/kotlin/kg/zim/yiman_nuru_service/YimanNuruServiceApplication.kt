package kg.zim.yiman_nuru_service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class YimanNuruServiceApplication{

}

fun main(args: Array<String>) {
	runApplication<YimanNuruServiceApplication>(*args)
}
