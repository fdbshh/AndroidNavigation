package com.google.example.deprecated

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

//    private lateinit var myLocationListener: MyLocationListener
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
////        val navigationView = findViewById<NavigationView>(R.id.nav_view)
////        val navController: NavController = findNavController(R.id.my_nav_host_fragment)
////        navigationView.setupWithNavController(navController)
//
//        setupNavigation()
//        setupLocation()
//    }
//
//
//
//    override fun onSupportNavigateUp(): Boolean {
//        return navigateUp(drawerLayout, findNavController(R.id.my_nav_host_fragment))
//    }
//
//    override fun onBackPressed() {
//        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
//            drawerLayout.closeDrawer(GravityCompat.START)
//        } else {
//            super.onBackPressed()
//        }
//    }
//
//    private fun setupLocation() {
//        myLocationListener = MyLocationListener(this) { location ->
//            // Update UI
//        }
//        lifecycle.addObserver(myLocationListener)
//    }
//
//    private fun setupNavigation() {
//        val navController: NavController = findNavController(R.id.my_nav_host_fragment)
//
//        // Update action bar to reflect navigation
//        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
//
////        val navigationView = findViewById<NavigationView>(R.id.nav_view)
//        // Handle nav drawer item clicks
//        nav_view.setNavigationItemSelectedListener { menuItem ->
//            menuItem.isChecked = true
//            drawerLayout.closeDrawers()
//            true
//        }
//
//        // Tie nav graph to items in nav drawer
//        NavigationUI.setupWithNavController(nav_view, navController)
//    }
//}
//
//
//internal class MyLocationListener(
//        private val context: Context,
//        private val callback: (Location) -> Unit
//) : LifecycleObserver {
//
//    @OnLifecycleEvent(Lifecycle.Event.ON_START)
//    fun start() {
//        // connect to system location service
//    }
//
//    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
//    fun stop() {
//        // disconnect from system location service
//    }
}