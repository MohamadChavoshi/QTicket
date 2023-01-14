package com.easyetech.qticket.startup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.easyetech.qticket.R

class StartUp : AppCompatActivity() {

    private lateinit var slideItemsAdapter: SlideItemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_up)

        setSlideItems()

    }


    private fun setSlideItems(){
        slideItemsAdapter = SlideItemsAdapter(
            listOf(
                SlidItem(
                    SlideTitle = "Fast As Blink",
                    SlideImage = R.drawable.ic_slide1,
                    SlideDescription = "We Scan , create and Store all the ticket’s in just a few seconds. Your Time is important to us."

                ),
                SlidItem(
                    SlideTitle = "Safed like a safe",
                    SlideImage = R.drawable.ic_slide2,
                    SlideDescription = "We care about your safety, your safety is our safety. Don't worry about that leave it to us."
                ),
                SlidItem(
                    SlideTitle = "Save Your Money",
                    SlideImage = R.drawable.ic_slide3,
                    SlideDescription = "Don’t waste your money on old and super-expensive scanning systems. You can have all the features even more and smarter with just 1$ per month."
                ),
                SlidItem(
                    SlideTitle = "Generate Ticket",
                    SlideImage = R.drawable.ic_slide4,
                    SlideDescription = "You can easily create ticket in generate section . all you need to do is tell us how many ticket do you need & click on generate. that's all !"
                ),
                SlidItem(
                    SlideTitle = "Scan Ticket",
                    SlideImage = R.drawable.ic_slide5,
                    SlideDescription = "After creating Ticket now it is time to scan them. in order to do that just Go to Scanner section and just click on scan now . easy peasy."
                ),
                SlidItem(
                    SlideTitle = "What Are You Waiting For? Lets Do This",
                    SlideImage = R.drawable.ic_slide6,
                    SlideDescription = ""
                )
            )
        )
        val SlideViewPager = findViewById<ViewPager2>(R.id.SlideViewPager)
        SlideViewPager.adapter = slideItemsAdapter
    }
}