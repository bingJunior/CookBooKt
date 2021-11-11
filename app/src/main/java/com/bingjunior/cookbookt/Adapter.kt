package com.bingjunior.cookbookt

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class Adapter(private var context: Activity, var resources:Int, var items:List<Model>):ArrayAdapter<Model>(context, resources, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater:LayoutInflater = LayoutInflater.from(context)
        val view:View = layoutInflater.inflate(resources, null)

        val topicImageView:ImageView = view.findViewById(R.id.topicImageView)
        val topicTextView:TextView = view.findViewById(R.id.topicTextView)

        //var mItem:Model = items[position]
        //topicImageView.setImageDrawable(context.resources.getDrawable(mItem.image))
        //topicTextView.text = mItem.topic

        topicImageView.setImageResource(items[position].image)
        topicTextView.text = items[position].topic

        return view
    }
}