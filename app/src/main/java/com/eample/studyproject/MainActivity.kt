package com.eample.studyproject

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.eample.studyproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        binding.main = this@MainActivity
        setSupportActionBar(binding.bar.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.icon_menu)
        supportActionBar?.setTitle("")

        // NavigationDrawer 설정
        appBarConfiguration = AppBarConfiguration.Builder(
            R.id.home_nav, R.id.menu1_nav, R.id.menu2_nav, R.id.menu3_nav )
            .setDrawerLayout(binding.drawerLayout)
            .build()

        var navController = Navigation.findNavController(this@MainActivity, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this@MainActivity, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(binding.navigation, navController)

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    // toolbar 메뉴 등록
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.m_info -> {
                Toast.makeText(this, "Info Menu Touch", Toast.LENGTH_SHORT).show()
                return true}
            R.id.m_setting -> {
                Toast.makeText(this, "Setting Menu Touch", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SettingActivity::class.java)
                startActivity(intent)
                return true}
            R.id.m_logout -> {
                Toast.makeText(this, "Logout Menu Touch", Toast.LENGTH_SHORT).show()
                return true}
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        var navController = Navigation.findNavController(this@MainActivity, R.id.nav_host_fragment)
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp()
    }
}