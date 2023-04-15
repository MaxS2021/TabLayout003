package com.example.myapplication

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.myapplication.databinding.Fragment2Binding


class Fragment2 : Fragment() {
    lateinit var bind: Fragment2Binding
    private var playMusic = false
    private var pause = true
    private var trek = 0
    private val listMusic = ArrayList<Int>()
    private val listNameMusic = ArrayList<String>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        listMusic.add(R.raw.fon_music1)
        listMusic.add(R.raw.fon_music2)
        listMusic.add(R.raw.fon_music3)

        listNameMusic.add("Trek 1")
        listNameMusic.add("Trek 2")
        listNameMusic.add("Trek 3")

        var mediaPlayer = MediaPlayer()
        mediaPlayer = MediaPlayer.create(context, listMusic[0])

        bind = Fragment2Binding.inflate(inflater, container, false)
        //val view = inflater.inflate(R.layout.fragment_2, container, false)

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, listNameMusic)
        bind.listV.adapter = adapter
        bind.listV.setOnItemClickListener { parent, view, position, id ->
            mediaPlayer.stop()
            mediaPlayer = MediaPlayer.create(context, listMusic[position])
            mediaPlayer.start()
            playMusic = true

            Toast.makeText(requireContext(),"Играет трек ${listNameMusic[position]}", Toast.LENGTH_LONG).show()
        }

        bind.btPausePlay.setOnClickListener {
            if (!playMusic) {
                mediaPlayer.start()
                playMusic = true
            } else {
                mediaPlayer.pause()
                playMusic = false
            }
        }


        return bind.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment2()
    }
}