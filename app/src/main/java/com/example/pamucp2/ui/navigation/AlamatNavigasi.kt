package com.example.pamucp2.ui.navigation

interface AlamatNavigasi {
    val route: String
}
object DestinasiHomeDok : AlamatNavigasi {
    override val route: String = "home_dok"
}
object DestinasiHomeJdl : AlamatNavigasi {
    override val route: String = "home_jdl"
}
object DestinasiDetail : AlamatNavigasi {
    override val route = "detail"
    const val IDJDL = "idJdl"
    val routeWithArg = "$route/{$IDJDL}"
}
object DestinasiUpdate : AlamatNavigasi {
    override val route = "update"
    const val IDJDL = "idJdl"
    val routeWithArg = "$route/{$IDJDL}"
}