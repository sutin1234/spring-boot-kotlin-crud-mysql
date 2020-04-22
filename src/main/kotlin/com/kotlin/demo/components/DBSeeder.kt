package com.kotlin.demo.components

import com.kotlin.demo.model.HotelEntity
import com.kotlin.demo.repository.HotelRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.util.*

@Component
class DBSeeder(val hotelRepository: HotelRepository): CommandLineRunner{
    override fun run(vararg args: String?) {
//        this.hotelRepository.deleteAll()
        var ibisRoom = HotelEntity("หอพักดินแดง 1", 3, 30)
        var intercontinentalRoom = HotelEntity("หอพักดินแดง 2", 10, 30)
        var goldenRoom = HotelEntity("หอพักดินแดง 3", 1, 20)

        var hotels = mutableListOf<HotelEntity>()
        hotels.add(ibisRoom)
        hotels.add(intercontinentalRoom)
        hotels.add(goldenRoom)

        this.hotelRepository.saveAll(hotels)
        println("---- Database has been initialized ----")

        for(hotel in this.hotelRepository.findAll()){
            println("uuid: ${hotel.id} hotel name: ${hotel.name} free room: ${hotel.nbFreeRoom}")
        }

    }
}