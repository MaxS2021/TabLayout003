package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding

    private val listFrag = listOf(
        Fragment1.newInstance(),
        Fragment2.newInstance(),
        Fragment3.newInstance()
    )
    private val listText = listOf(
        "Фото",
        "Плей лист",
        "Видео"
    )
    private val listIcon = listOf(
        R.drawable.ic_baseline_queue_music_24,
        R.drawable.ic_baseline_library_music_24,
        R.drawable.ic_baseline_video_library_24
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val adapter = VpAdapter(this, listFrag)
        bind.vp2.adapter = adapter
        TabLayoutMediator(bind.tabLayout, bind.vp2) {
            tab, pos ->
            //tab.text = listText[pos]
            tab.icon = ContextCompat.getDrawable(this, listIcon[pos])

        }.attach()

//        supportFragmentManager.beginTransaction()
//            .replace(R.id.placeHolder,listFrag[0]).commit()
//
//        bind.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                supportFragmentManager.beginTransaction()
//                    .replace(R.id.placeHolder,listFrag[tab?.position!!]).commit()
//                Toast.makeText(this@MainActivity, "Выбран раздел ${tab?.text} Id ${tab?.position}",Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//                Toast.makeText(this@MainActivity, "Повторно выбран раздел ${tab?.text} Id ${tab?.position}",Toast.LENGTH_SHORT).show()
//
//            }
//
//        })


    }
}