package com.example.pamucp2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pamucp2.ui.view.dokter.DestinasiInsertDok
import com.example.pamucp2.ui.view.dokter.HomeDokView
import com.example.pamucp2.ui.view.dokter.InsertDokView
import com.example.pamucp2.ui.view.jadwal.DestinasiInsertJdl
import com.example.pamucp2.ui.view.jadwal.DetailJdlView
import com.example.pamucp2.ui.view.jadwal.HomeJdlView
import com.example.pamucp2.ui.view.jadwal.InsertJdlView
import com.example.pamucp2.ui.view.jadwal.UpdateJdlView

@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = DestinasiHomeDok.route
    ) {
        composable(
            route = DestinasiHomeDok.route
        ) {
            HomeDokView(
                onAddDok = {
                    navController.navigate(DestinasiInsertDok.route)
                },
                onSeeJdl = {
                    navController.navigate(DestinasiHomeJdl.route)
                },
                modifier = modifier
            )
        }
        composable(
            route = DestinasiInsertDok.route
        ) {
            InsertDokView(
                onBack = {
                    navController.popBackStack()
                },
                onNavigate = {
                    navController.popBackStack()
                },
                modifier = modifier
            )
        }
        composable(
            route = DestinasiHomeJdl.route
        ) {
            HomeJdlView(
                onAddJdl = {
                    navController.navigate(DestinasiInsertJdl.route)
                },
                onSeeDok = {
                    navController.navigate(DestinasiHomeDok.route)
                },
                onDetailClick = { idJdl ->
                    navController.navigate("${DestinasiDetail.route}/$idJdl")
                    println("PengelolaHalaman: idJdl = $idJdl")
                },
                modifier = modifier
            )
        }
        composable(
            route = DestinasiInsertJdl.route
        ) {
            InsertJdlView(
                onBack = {
                navController.popBackStack()
            },
                onNavigate = {
                    navController.popBackStack()
                },
                modifier = modifier
            )
        }
        composable(
            DestinasiDetail.routeWithArg,
            arguments = listOf(
                navArgument(DestinasiDetail.IDJDL){
                    type = NavType.StringType
                }
            )
        ){
            val noJdl = it.arguments?.getString(DestinasiDetail.IDJDL)
            noJdl?.let { noJdl ->
                DetailJdlView(
                    onBack = {
                        navController.popBackStack()
                    },
                    onEditClick = {
                        navController.navigate("${DestinasiUpdate.route}/$it")
                    },
                    modifier = modifier,
                    onDeleteClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
        composable(
            DestinasiUpdate.routeWithArg,
            arguments = listOf(
                navArgument(DestinasiUpdate.IDJDL){
                    type = NavType.StringType
                }
            )
        ){
            UpdateJdlView(
                onBack = {
                    navController.popBackStack()
                },
                onNavigate = {
                    navController.popBackStack()
                },
                modifier = modifier
            )
        }
    }
}
