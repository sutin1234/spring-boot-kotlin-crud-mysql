package com.kotlin.demo.model

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "hotels")
data class HotelEntity(val name: String, val classification: Int, val nbRoom: Int){
    @Id
    val id: String = UUID.randomUUID().toString()


    var nbFreeRoom: Int = this.nbRoom

    fun checkIn(nbGuests: Int){
        if(this.nbFreeRoom >= nbGuests){
            this.nbFreeRoom -= nbGuests
        }
    }
    fun checkOut(nbGuests: Int){
            this.nbFreeRoom += nbGuests
    }

    fun updateRoom(nbGuests: Int){
        this.nbFreeRoom = nbGuests
    }
}