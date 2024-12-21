package com.example.pamucp2

import android.app.Application
import com.example.pamucp2.dependeciesinjection.ContainerApp


class RsApp : Application() {
    lateinit var containerApp: ContainerApp
    override fun onCreate() {


        super.onCreate()
        containerApp = ContainerApp(this)
    }
}