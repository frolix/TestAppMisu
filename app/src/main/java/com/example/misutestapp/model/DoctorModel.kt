package com.example.misutestapp.model

data class DoctorModel(
    var surname: String?,
    var name: String?,
    var patronymic: String?,
    var filterList: List<String>?,
    var location: String?,
    var description: String?,
    var profession: String?,
    var photoUrl: String?
)
