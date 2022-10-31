package kg.zim.yiman_nuru_service.repository

import kg.zim.yiman_nuru_service.entity.DuaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface DuaRepository: JpaRepository<DuaEntity, Int>