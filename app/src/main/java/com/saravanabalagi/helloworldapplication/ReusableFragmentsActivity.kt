package com.saravanabalagi.helloworldapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.reusable_fragments_activity.*


class ReusableFragmentsActivity: AppCompatActivity(R.layout.reusable_fragments_activity) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragment, UserDescriptionFragment().apply {
                    arguments = Bundle().apply {
                        putString("NAME", "Spiderman")
                    }
                })
            }
        }

        view_pager.adapter = object: FragmentStateAdapter(this) {
            override fun getItemCount(): Int = 3
            override fun createFragment(position: Int): Fragment = ViewPagerFragment().apply {
                arguments = Bundle().apply {
                    putInt("PAGE_NUMBER", position)
                }
            }
        }

        TabLayoutMediator(tab_layout, view_pager) { view, position ->
//            view.text = "Page $position"
            view.icon = ContextCompat.getDrawable(this, R.drawable.coffee)
        }.attach()

    }
}