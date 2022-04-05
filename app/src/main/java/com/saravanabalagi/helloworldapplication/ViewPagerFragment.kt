package com.saravanabalagi.helloworldapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_view_pager.*

class ViewPagerFragment: Fragment(R.layout.fragment_view_pager) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey("PAGE_NUMBER") }.apply {
            page_number.text = "Page Number ${arguments?.getInt("PAGE_NUMBER", -1)}"
        }
    }
}