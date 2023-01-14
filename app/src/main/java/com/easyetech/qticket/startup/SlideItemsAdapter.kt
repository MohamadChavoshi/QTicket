package com.easyetech.qticket.startup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.easyetech.qticket.R

class SlideItemsAdapter(private val SlidItems : List<SlidItem>):
RecyclerView.Adapter<SlideItemsAdapter.SlideItemViewHolder> (){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlideItemViewHolder {
        return SlideItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.slider_item_container,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SlideItemViewHolder, position: Int) {
        holder.bind(SlidItems[position])
    }

    override fun getItemCount(): Int {
        return SlidItems.size
    }


    inner class SlideItemViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val SlideTitle = view.findViewById<TextView>(R.id.SlideTitle)
        private val SlideImage = view.findViewById<ImageView>(R.id.SlideImage)
        private val SlideDescription = view.findViewById<TextView>(R.id.SlideDescription)


        fun bind(SlidItem : SlidItem){
            SlideTitle.text = SlidItem.SlideTitle
            SlideImage.setImageResource(SlidItem.SlideImage)
            SlideDescription.text = SlidItem.SlideDescription
        }
    }

}