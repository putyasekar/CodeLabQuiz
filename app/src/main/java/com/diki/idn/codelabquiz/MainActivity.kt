package com.diki.idn.codelabquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.diki.idn.codelabquiz.databinding.ActivityMainBinding
import com.diki.idn.codelabquiz.databinding.FragmentEndGameBinding

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var binding: ActivityMainBinding
    private lateinit var likeBinding: EndGameFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val likeBinding =
            DataBindingUtil.setContentView<FragmentEndGameBinding>(this, R.layout.fragment_end_game)

        drawerLayout = binding.drawerLayout

        val mainViewModel = ViewModelProviders.of(this).get(MainVM::class.java)

//        binding.preview = mainViewModel
        binding.lifecycleOwner = this

        val navController = this.findNavController(R.id.myNavHostFragment)

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}
