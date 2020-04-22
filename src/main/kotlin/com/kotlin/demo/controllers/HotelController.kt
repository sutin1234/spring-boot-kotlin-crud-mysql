package com.kotlin.demo.controllers

import com.kotlin.demo.model.HotelEntity
import com.kotlin.demo.repository.HotelRepository
import com.kotlin.demo.services.CheckInRequest
import com.kotlin.demo.services.CheckOutRequest
import com.kotlin.demo.services.HotelRequest
import net.bytebuddy.implementation.bytecode.Throw
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/hotels")
class HotelController(var hotelRepository: HotelRepository) {

    @GetMapping("/all")
    fun all(): MutableIterable<HotelEntity> = this.hotelRepository.findAll()

    @GetMapping("/findById/{id}")
    fun findHotel(@PathVariable("id") id: String): Optional<HotelEntity> {
        return this.hotelRepository.findById(id)
    }

    @GetMapping("/findByName/{name}")
    fun findByName(@PathVariable(value = "name") name: String): List<HotelEntity> {
        return this.hotelRepository.findByName(name)
    }

    @PostMapping("/add")
    fun addHotel(@RequestBody hotelEntity: HotelEntity): ResponseEntity<String>{
        try {
            this.hotelRepository.save(hotelEntity)
            return ResponseEntity.status(HttpStatus.OK).body("Hotel Added!")
        }catch (e: Exception){
            print(e.stackTrace)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.toString())
        }

    }

    @PostMapping("/checkin")
    fun checkIn(@RequestBody checkInRequest: CheckInRequest): ResponseEntity<String>{
        val hotel = this.hotelRepository.findByName(checkInRequest.hotelName).get(0)
        hotel.checkIn(checkInRequest.nbGuest)
        this.hotelRepository.save(hotel)
        return ResponseEntity.status(HttpStatus.OK).body("Hotel Checkin!")
    }

    @PostMapping("/checkout")
    fun checkOut(@RequestBody checkOutRequest: CheckOutRequest): ResponseEntity<String>{
        val hotel = this.hotelRepository.findByName(checkOutRequest.hotelName).get(0)
        hotel.checkOut(checkOutRequest.nbGuest)
        this.hotelRepository.save(hotel)
        return ResponseEntity.status(HttpStatus.OK).body("Hotel Checkout!")
    }

    @PutMapping("/update/{id}")
    fun updateRoom(@PathVariable("id") id: String, @RequestBody hotelRequest: HotelRequest): ResponseEntity<String>{
        val hotel = this.hotelRepository.findById(id).get()
        hotel.updateRoom(hotelRequest.nbGuest)
        this.hotelRepository.save(hotel)
        return ResponseEntity.status(HttpStatus.OK).body("Hotel Updated!")
    }

    @PutMapping("/deleteById/{id}")
    fun deleteRoom(@PathVariable("id") id: String): ResponseEntity<String>{
        this.hotelRepository.deleteById(id)
        return ResponseEntity.status(HttpStatus.OK).body("Hotel Deleted!")
    }

}