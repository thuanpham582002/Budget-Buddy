package com.proptit.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.proptit.presentation.R
import com.proptit.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        navController = navHostFragment.navController
        initBottomNavigationView()
        fakeSignIn()
    }

    private fun initBottomNavigationView() {
        binding.bottomNavigationView.apply {
            itemIconTintList = null
            setupWithNavController(navController)
        }
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.transactionsFragment, R.id.walletFragment, R.id.analyticsFragment, R.id.moreFragment -> {
                    binding.bottomNavigationView.visibility = View.VISIBLE
                }

                else -> {
                    binding.bottomNavigationView.visibility = View.GONE
                }
            }
        }
    }

    private fun fakeSignIn() {
        if (!mainViewModel.isSignedIn()) {
            mainViewModel.signIn(1)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}