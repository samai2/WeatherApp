package com.example.mshadrin.weatherapp.domain

interface Command<out T> {
    fun execute(): T
}