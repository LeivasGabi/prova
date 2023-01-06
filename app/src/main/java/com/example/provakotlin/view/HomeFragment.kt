package com.example.provakotlin.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.provakotlin.R


class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        goToList(view)
        goToRegistration(view)
    }

    private fun goToList(view: View) {
        view.findViewById<Button>(R.id.btn_create).setOnClickListener {
            findNavController().navigate(R.id.actionHomeToRegistration)
        }
    }

    private fun goToRegistration(view: View) {
        view.findViewById<Button>(R.id.btn_list).setOnClickListener {
            findNavController().navigate(R.id.actionHomeToList)
        }
    }
}