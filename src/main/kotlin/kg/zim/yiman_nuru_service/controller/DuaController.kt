package kg.zim.yiman_nuru_service.controller

import kg.zim.yiman_nuru_service.dto.DuaDto
import kg.zim.yiman_nuru_service.service.DuaService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/duas")
class DuaController(private val service: DuaService) {
    @GetMapping
    fun getAll() = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int) = service.getById(id)

    @PostMapping
    fun save(@RequestBody dto: DuaDto) = service.save(dto)

    @DeleteMapping("/{id}")
    fun removeById(@PathVariable id: Int) = service.removeById(id)
}