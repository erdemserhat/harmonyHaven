package com.erdemserhat.harmonyhaven

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.erdemserhat.harmonyhaven.presentation.navigation.SetupNavGraph
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalFoundationApi::class)
@AndroidEntryPoint
class MainActivity  : ComponentActivity() {
    private lateinit var navController: NavHostController
    private val viewModel: ExampleViewModel by viewModels()
    private val mainViewModel:MainViewModel by viewModels()
    //private val homeViewModel:HomeViewModel by viewModels()
    //val loginViewModel:LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        //you have to use your dependency after the
        // super.onCreate() function
        super.onCreate(savedInstanceState)

        //use your dependencies here
        //viewModel.getArticlesByCategory(1)
       // viewModel.saveJwt("serhat")
      //  viewModel.authenticateUser()
       // viewModel.getJwt()
        mainViewModel.prepareJwt()



        setContent {

            navController = rememberNavController()
            SetupNavGraph(navController = navController)
        }
    }

}
