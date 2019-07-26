package com.example.bottomsheet.Adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.bottomsheet.R
import java.io.File


class GridAdapter(context : Context,list : ArrayList<File>): BaseAdapter()
{
    var mlist = list;
    val mcontext  = context

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val convertView:View =LayoutInflater.from(mcontext).inflate(R.layout.layout_custom_grid_imageview,null)

        val gridImageView :ImageView= convertView.findViewById<ImageView>(R.id.gridImageView) as ImageView

         gridImageView.setImageURI(Uri.parse(getItem(position).toString()))

        return gridImageView
    }



    override fun getCount(): Int {
       return mlist.size
    }

    override fun getItem(position: Int): Any {
        return mlist.get(position)
    }

    override fun getItemId(position: Int): Long {
            return 0
    }

}