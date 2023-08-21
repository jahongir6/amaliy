package com.example.amaliy.models

class User {
    var id: Int? = null
    var name: String? = null
    var age: Int? = null
    var zaxirami: Int = 1

    constructor(id: Int?, name: String?, age: Int?, zaxirami: Int) {
        this.id = id
        this.name = name
        this.age = age
        this.zaxirami = zaxirami
    }

    constructor(name: String?, age: Int?, zaxirami: Int) {
        this.name = name
        this.age = age
        this.zaxirami = zaxirami
    }
}
