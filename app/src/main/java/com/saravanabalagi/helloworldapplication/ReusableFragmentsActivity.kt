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
                add(R.id.fragment, UserDescriptionFragment())
            }
        }
    }
}