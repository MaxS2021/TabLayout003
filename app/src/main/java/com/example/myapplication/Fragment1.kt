package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.edit


class Fragment1 : Fragment() {

    private var playMusic = false
    private var trek = 0
    private val listMusic = ArrayList<Int>()
    private var pref: SharedPreferences? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // считывание данных с базы
        pref = requireContext().getSharedPreferences("TABLE", Context.MODE_PRIVATE)
        trek = pref?.getInt("trek",0)!!

        val editor = pref?.edit()
      listMusic.add(R.raw.fon_music1)
        listMusic.add(R.raw.fon_music2)
        listMusic.add(R.raw.fon_music3)

        val view = inflater.inflate(R.layout.fragment_1, container, false)
        val bMus = view.findViewById<Button>(R.id.button)
        val tvTrek = view.findViewById<TextView>(R.id.tvTrek)
        tvTrek.text = "Играет трек № ${trek.toString()}"
        var mediaPlayer = MediaPlayer.create(context, listMusic[trek])
        bMus.setOnClickListener {
            if (!playMusic) {
                mediaPlayer.start()
                playMusic = true
                tvTrek.text = "Играет трек № ${trek.toString()}"
                editor?.putInt("trek", trek)
                editor?.apply()
                trek += 1

                if (trek > listMusic.size - 1) trek = 0

            } else {
                mediaPlayer.stop()
                playMusic = false
                mediaPlayer = MediaPlayer.create(context, listMusic[trek])

            }
        }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment1()
    }
}