package com.kotlin.demo.services

class CheckInRequest(val hotelName: String, val nbGuest: Int) {}

class CheckOutRequest(val hotelName: String, val nbGuest: Int){}

class HotelRequest(val id: String, val nbGuest: Int){}