package com.easyetech.qticket.startup

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.UnderlineSpan
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.text.toSpannable
import androidx.core.text.toSpanned
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import carbon.widget.ConstraintLayout
import com.easyetech.qticket.Login
import com.easyetech.qticket.R
import com.easyetech.qticket.Signup
import com.easyetech.qticket.databinding.ActivityMainBinding
import com.easyetech.qticket.databinding.ActivityStartUpBinding

class StartUp : AppCompatActivity() {

    private lateinit var slideItemsAdapter: SlideItemsAdapter
    private lateinit var binding: ActivityStartUpBinding
    private lateinit var slidedescriptionslid1 : SpannableString
    private lateinit var slidedescriptionslid2 : SpannableString
    private lateinit var slidedescriptionslid3 : SpannableString
    private lateinit var slidedescriptionslid4 : SpannableString
    private lateinit var slidedescriptionslid5 : SpannableString
    private lateinit var slidetitleslid1 : SpannableString
    private lateinit var slidetitleslid2 : SpannableString
    private lateinit var slidetitleslid3 : SpannableString
    private lateinit var slidetitleslid4 : SpannableString
    private lateinit var slidetitleslid5 : SpannableString
    private lateinit var slidetitleslid6 : SpannableString
    private lateinit var indicatorContainer: LinearLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_up)
        binding = ActivityStartUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.GetStartBtn.setOnClickListener {
            val intent = Intent(this@StartUp, Signup::class.java)
            startActivity(intent)
            binding.GetStartBtn2.visibility = View.INVISIBLE
        }
        binding.LoginBtnStartup.setOnClickListener {
            val intent = Intent(this@StartUp, Login::class.java)
            startActivity(intent)
        }

        slidedescriptionslid1 = SpannableString("We Scan , create and Store all the ticket’s in just a few seconds. Your Time is important to us.")
        slidedescriptionslid1.setSpan(ForegroundColorSpan(Color.rgb(232,170,20)), 54, 65, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        slidedescriptionslid2 = SpannableString("We care about your safety, your safety is our safety. Don't worry about that leave it to us.")
        slidedescriptionslid2.setSpan(ForegroundColorSpan(Color.rgb(232,170,20)), 19, 25, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        slidedescriptionslid3 = SpannableString("Don’t waste your money on old and super-expensive scanning systems. You can have all the features even more and smarter with just 1$ per month.")
        slidedescriptionslid3.setSpan(ForegroundColorSpan(Color.rgb(232,170,20)), 130, 132, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        slidedescriptionslid3.setSpan(RelativeSizeSpan(1.3f), 130, 132, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        slidedescriptionslid4 = SpannableString("You can easily create ticket in generate section . all you need to do is tell us how many ticket do you need & click on generate. that's all !")
        slidedescriptionslid4.setSpan(ForegroundColorSpan(Color.rgb(232,170,20)), 120, 128, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        slidedescriptionslid5 = SpannableString("After creating Ticket now it is time to scan them. in order to do that just Go to Scanner section and just click on scan now . easy peasy.")
        slidedescriptionslid5.setSpan(ForegroundColorSpan(Color.rgb(232,170,20)), 127, 137, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)


        slidetitleslid1 = SpannableString("Fast As Blink")
        slidetitleslid2 = SpannableString("Safed like a safe")
        slidetitleslid3 = SpannableString("Save Your Money")
        slidetitleslid4 = SpannableString("Generate Ticket")
        slidetitleslid5 = SpannableString("Scan Ticket")


        slidetitleslid6 = SpannableString("What Are You Waiting For? Lets Do This")
        slidetitleslid6.setSpan(ForegroundColorSpan(Color.rgb(232,170,20)), 26, 38, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        slidetitleslid6.setSpan(RelativeSizeSpan(1.3f), 26, 38, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)


        setSlideItems()
        setupIndicators()
        setCurrentIndicator(0)
    }


    private fun setSlideItems(){
        slideItemsAdapter = SlideItemsAdapter(
            listOf(
                SlidItem(
                    SlideTitle = slidetitleslid1,
                    SlideImage = R.drawable.ic_slide1,
                    SlideDescription = slidedescriptionslid1

                ),
                SlidItem(
                    SlideTitle = slidetitleslid2,
                    SlideImage = R.drawable.ic_slide2,
                    SlideDescription = slidedescriptionslid2
                ),
                SlidItem(
                    SlideTitle = slidetitleslid3,
                    SlideImage = R.drawable.ic_slide3,
                    SlideDescription = slidedescriptionslid3
                ),
                SlidItem(
                    SlideTitle = slidetitleslid4,
                    SlideImage = R.drawable.ic_slide4,
                    SlideDescription = slidedescriptionslid4
                ),
                SlidItem(
                    SlideTitle = slidetitleslid5,
                    SlideImage = R.drawable.ic_slide5,
                    SlideDescription = slidedescriptionslid5
                ),
                SlidItem(
                    SlideTitle = slidetitleslid6,
                    SlideImage = R.drawable.ic_slide6,
                    SlideDescription = null
                )
            )
        )
        val SlideViewPager = findViewById<ViewPager2>(R.id.SlideViewPager)
        SlideViewPager.adapter = slideItemsAdapter
        SlideViewPager.registerOnPageChangeCallback(object :
        ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        (SlideViewPager.getChildAt(0) as RecyclerView).overScrollMode =
            RecyclerView.OVER_SCROLL_NEVER
    }

    private fun setupIndicators(){
        indicatorContainer = findViewById(R.id.indicatorsContainer)
        val indicators = arrayOfNulls<ImageView>(slideItemsAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT,WRAP_CONTENT)
        layoutParams.setMargins(
            8,
            0,
            8,
            0
        )
        for (i in indicators.indices){
            indicators[i] = ImageView(applicationContext)
            indicators[i]?.let {
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                )
                it.layoutParams = layoutParams
                indicatorContainer.addView(it)
            }
        }
    }

    private fun setCurrentIndicator(position: Int){
        val childCount = indicatorContainer.childCount
        for (i in 0 until childCount){
            val imageView = indicatorContainer.getChildAt(i) as ImageView
            if (i == position){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active_background
                    )
                )
            }else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                )
            }
        }
    }
}