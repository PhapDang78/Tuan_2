package com.example.tuan2
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Xử lý khi chọn menu trong BottomNavigationView
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_quanly -> loadFragment(QuanLyFragment())
                R.id.nav_dssach -> loadFragment(DanhSachSachFragment())
                R.id.nav_nhanvien -> loadFragment(NhanVienFragment())
            }
            true
        }

        // Mặc định hiển thị màn hình Quản lý khi mở ứng dụng
        if (savedInstanceState == null) {
            loadFragment(QuanLyFragment())
        }
    }

    // Hàm để load Fragment vào FrameLayout
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}