package com.sairic.example.kotlinstandardfunctions

data class Bimmer(val year: Int, val model: String, val horsePower: Int, val price: Double, var isAccelerating: Boolean = false) {

    fun showStatus() = "My $year BMW $model with $horsePower HP which cost me $price is ${displayAccelerationStatus()}"

    fun displayAccelerationStatus() = if(this.isAccelerating) "Speeding past everyone" else "Stopped"
}