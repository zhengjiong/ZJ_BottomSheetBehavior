package com.zj.widget.bottomsheetbehavior

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_pager.*
import java.lang.ref.WeakReference

/**
 *
 * Company: 上加下信息技术成都有限公司
 * CreateTime:2018/9/13  08:39
 * @author 郑炯
 * @version 1.0
 */

class ViewPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager)
        val behavior = CustomBottomSheetBehavior2.from(viewPager)
        behavior.state = CustomBottomSheetBehavior2.STATE_HALF
        behavior.isHideable = false

        val pagerAdapter = PagerAdapter(
                supportFragmentManager,
                mutableListOf(TestFragment(), TestFragment()),
                mutableListOf("1", "2")
        )
        viewPager.adapter = pagerAdapter
        viewPager.offscreenPageLimit = 2

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                val fragment = pagerAdapter.getItem(position) as TestFragment
                behavior.setNestedScrollingChildRef1(WeakReference(fragment.recyclerView1))
                behavior.setNestedScrollingChildRef2(WeakReference(fragment.recyclerView2))
            }

        })
    }

    class PagerAdapter(fm: FragmentManager, val fragments: MutableList<Fragment>, val titles: MutableList<String>) : FragmentPagerAdapter(fm) {

        override fun instantiateItem(container: View, position: Int): Any {
            return super.instantiateItem(container, position)
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            super.destroyItem(container, position, `object`)
        }

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getPageTitle(position: Int): CharSequence {
            return titles[position]
        }

    }
}