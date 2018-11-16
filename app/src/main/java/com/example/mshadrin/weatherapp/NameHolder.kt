package com.example.mshadrin.weatherapp

class NameHolder {
   var name : String = ""
    get() = field.toUpperCase()
    set(value) {field = "My Name $value"}
}