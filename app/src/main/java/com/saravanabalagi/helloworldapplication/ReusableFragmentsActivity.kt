package com.saravanabalagi.helloworldapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import kotlinx.android.synthetic.main.reusable_fragments_activity.*


class ReusableFragmentsActivity: AppCompatActivity(R.layout.reusable_fragments_activity) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)

//                val frag = UserDescriptionFragment()
//                val bundle = Bundle()
//                bundle.putString("NAME", "Spiderman")
//                frag.arguments = bundle

                add(R.id.fragment, UserDescriptionFragment().apply {
                    arguments = Bundle().apply {
                        putString("NAME", "Spiderman")
                    }
                })
            }
        }
    }
}