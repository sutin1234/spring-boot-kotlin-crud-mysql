package com.kotlin.demo.repository

import com.kotlin.demo.model.HotelEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface HotelRepository : CrudRepository<HotelEntity, String>{
    fun findByName(name: String): List<HotelEntity>
//    fun findByOnce(id: String): List<HotelEntity>
}