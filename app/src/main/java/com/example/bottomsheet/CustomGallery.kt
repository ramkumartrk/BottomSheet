package com.example.bottomsheet

import android.os.Bundle
import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import com.example.bottomsheet.Adapter.GridAdapter
import kotlinx.android.synthetic.main.activity_custom_gallery.*
import java.io.File

class CustomGallery : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_gallery)
       // setSupportActionBar(toolbar)


        println("CustomGallery")
        var list  :ArrayList<File> = imageReader(Environment.getExternalStorageDirectory())
        println("Printing ImageNames:" + list.toString())

        val gridAdapter : GridAdapter = GridAdapter(this,list)
        gridView.adapter = gridAdapter;




//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
    }



    fun imageReader(root : File) :ArrayList<File>
    {
        var list : ArrayList<File> = ArrayList();
        var i : Int = 0;

            val files = root.listFiles()


        for(i in  0..files.size-1)
        {
                if(files[i].isDirectory)
                {
                   println("\n\n\n" + files[i].name + " \n\n\n")
                        list.addAll(imageReader(files[i]))
                }
            else
                {
                    if(files[i].name.endsWith(".jpeg") || files[i].name.endsWith(".jpg"))
                    {
                        list.add(files[i])
                    }
                }
        }

        return list;
    }
}
