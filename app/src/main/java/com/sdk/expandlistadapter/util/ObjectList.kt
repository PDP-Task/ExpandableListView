package com.sdk.expandlistadapter.util

object ObjectList {

    val title: MutableList<String> = ArrayList()
    val subTitle: MutableList<MutableList<String>> = ArrayList()

    fun footballClubs(): MutableList<String> {
        return mutableListOf(
            "Real Madrid",
            "Barcelona",
            "Bayern Munch",
            "Liverpool",
            "Man City",
            "Tottenham",
            "Juventus",
            "Inter",
            "AtmMadrid",
            "PSG",
            "Chelsea",
            "Man Utd"
        )
    }
    fun languageList(): MutableList<String> {
        return mutableListOf(
            "Java",
            "Kotlin",
            "Dart",
            "C",
            "Python",
            "JavaScript",
            "C++",
            "Ruby",
            "Swift",
            "C#"
        )
    }
}