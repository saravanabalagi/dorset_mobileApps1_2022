package com.saravanabalagi.helloworldapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_user_description.*

class UserDescriptionFragment: Fragment(R.layout.fragment_user_description) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey("NAME") }.apply {
            val argName = this?.getString("NAME", "No Name")
            name.text = argName
        }
    }
}