package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.view.ResumenScreen
import com.example.myapplication.view.formularioScreen
import com.example.myapplication.viewmodel.UsuarioViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()
            val usuarioViewModel : UsuarioViewModel = viewModel()
            NavHost(navController = navController, startDestination = "FormularioScreen") {
                composable("FormularioScreen") {
                    formularioScreen(
                        navController, usuarioViewModel
                    )
                }
                composable("resumen") {
                    ResumenScreen(
                        usuarioViewModel
                    )
                }
            }

        }
    }
}
