package kg.zim.yiman_nuru_service.service

import kg.zim.yiman_nuru_service.dto.DuaDto
import kg.zim.yiman_nuru_service.entity.DuaEntity
import kg.zim.yiman_nuru_service.exception.NotFoundException
import kg.zim.yiman_nuru_service.repository.DuaRepository
import org.springframework.data.domain.Sort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class DuaService(
    private val repository: DuaRepository,
) {
    fun getAll(): List<DuaDto> = repository
        .findAll(Sort.by(Sort.Direction.ASC, "id"))
        .map { it.toDto() }

    fun getById(id: Int): DuaDto = repository
        .findById(id)
        .map { it.toDto() }
        .orElseThrow(::NotFoundException)

    fun save(dto: DuaDto): DuaDto = repository
        .findById(dto.id)
        .orElse(
            DuaEntity.fromDto(dto.copy())
        )
        .let {
            if (it.id == 0) {
                repository.save(it)
            } else {
                it.title = dto.title
                it.content = dto.content
            }
            it
        }.toDto()

    fun removeById(id: Int) {
        repository.findByIdOrNull(id)
            ?.also(repository::delete)
    }
}
