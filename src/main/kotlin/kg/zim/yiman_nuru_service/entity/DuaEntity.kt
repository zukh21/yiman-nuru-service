package kg.zim.yiman_nuru_service.entity

import kg.zim.yiman_nuru_service.dto.DuaDto
import javax.persistence.*

@Entity()
@Table(name = "duas", schema = "yiman_nuru")
data class DuaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    val id: Int,
    var title: String,
    var content: String
) {
    fun toDto() = DuaDto(id = id, title = title, content = content)

    companion object {
        fun fromDto(dto: DuaDto) = DuaEntity(id = dto.id, title = dto.title, content = dto.content)
    }
}
