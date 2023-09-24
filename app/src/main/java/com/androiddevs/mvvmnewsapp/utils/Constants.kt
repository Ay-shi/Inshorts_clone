package com.androiddevs.mvvmnewsapp.utils

class Constants {
    companion object{
        //const is intialised at compile time while only val is intialised at runtime,
        //const val cna be used at places where value is needed to be known at compile time(eg . switch case or enum decleration etc)
        const val API_KEY:String="a49a60e109904990b563c4d20678a530"
        const val  BASE_URL:String = "https://newsapi.org"
    }
}