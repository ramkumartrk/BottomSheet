package com.example.bottomsheet

import android.app.Activity.RESULT_OK
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.content.FileProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class Model_BottomSheet(layoutStyle : Int) : BottomSheetDialogFragment()
{





    var pathToFile : String?=null;


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        if(resultCode == RESULT_OK)
        {
            if(requestCode ==1)
            {

                val bitmap : Bitmap = BitmapFactory.decodeFile(pathToFile)
               // capturedImageView.setImageBitmap(bitmap)

            }
        }
    }


    var counter : Int = 0
    var mLayoutStyle : Int = layoutStyle


    override fun setupDialog(dialog: Dialog, style: Int) {

        super.setupDialog(dialog, style)

        var view : View = View.inflate(context,this.mLayoutStyle,null)




        if(this.mLayoutStyle == R.layout.layout_model_bottomsheet_one)
        {

            view.findViewById<ImageButton>(R.id.previewImageButton).setOnClickListener(View.OnClickListener {

                Toast.makeText(context,"PreviewImage Button Clicked",Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            })

            view.findViewById<ImageButton>(R.id.shareImageButton).setOnClickListener(View.OnClickListener {
                Toast.makeText(context,"Share Button Clicked",Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            })


            view.findViewById<ImageButton>(R.id.linkImageButton).setOnClickListener(View.OnClickListener {
                Toast.makeText(context,"Link Button Clicked",Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            })



            view.findViewById<ImageButton>(R.id.copyImageButton).setOnClickListener(View.OnClickListener {
                Toast.makeText(context,"Copy Button Clicked",Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            })


            view.findViewById<ImageButton>(R.id.emailImageButton).setOnClickListener(View.OnClickListener {
                Toast.makeText(context,"Email Button Clicked",Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            })


            view.findViewById<ImageButton>(R.id.deleteImageButton).setOnClickListener(View.OnClickListener {
                Toast.makeText(context,"Delete Button Clicked",Toast.LENGTH_SHORT).show()
                var intent : Intent = Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)

                startActivity(intent)
              //  dialog.dismiss()
            })

            view.findViewById<ImageButton>(R.id.cameraImageButton).setOnClickListener(View.OnClickListener {
                Toast.makeText(context,"Camera Button Clicked",Toast.LENGTH_SHORT).show()


             dispatchPictureAction()
//                var cameraIntent : Intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//
//
//                startActivity(cameraIntent)

            })

            view.findViewById<ImageButton>(R.id.contactImageButton).setOnClickListener(View.OnClickListener {
                Toast.makeText(context,"Contact button clicked",Toast.LENGTH_SHORT).show()
                dialog.dismiss()

            })

            view.findViewById<ImageButton>(R.id.locationImageButton).setOnClickListener(View.OnClickListener {
                Toast.makeText(context,"Location button clicked",Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            })


        }






        else if (this.mLayoutStyle == R.layout.layout_model_bottomsheet_two)
        {
            view.findViewById<Button>(R.id.previewImageButton2).setOnClickListener(View.OnClickListener {
                Toast.makeText(context,"Preview ImageButton2 Clicked!!",Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            })

            view.findViewById<Button>(R.id.shareImageButton2).setOnClickListener(View.OnClickListener {
                Toast.makeText(context,"Share Button2 Clicked",Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            })


            view.findViewById<Button>(R.id.linkImageButton2).setOnClickListener(View.OnClickListener {
                Toast.makeText(context,"Link Button2 Clicked",Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            })



            view.findViewById<Button>(R.id.copyImageButton2).setOnClickListener(View.OnClickListener {
                Toast.makeText(context,"Copy Button2 Clicked",Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            })


            view.findViewById<Button>(R.id.emailImageButton2).setOnClickListener(View.OnClickListener {
                Toast.makeText(context,"Email Button2 Clicked",Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            })


            view.findViewById<Button>(R.id.deleteImageButton2).setOnClickListener(View.OnClickListener {
                Toast.makeText(context,"Delete Button2 Clicked",Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            })


            view.findViewById<Button>(R.id.cameraImageButton2).setOnClickListener(View.OnClickListener {
                Toast.makeText(context,"Camera Button2 Clicked",Toast.LENGTH_SHORT).show()



                 dispatchPictureAction()

            })

            view.findViewById<Button>(R.id.contactImageButton2).setOnClickListener(View.OnClickListener {
                Toast.makeText(context,"Contact button2 clicked",Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            })

            view.findViewById<Button>(R.id.locationImageButton2).setOnClickListener(View.OnClickListener {
                Toast.makeText(context,"Location button2 clicked",Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            })



        }

        if(Build.VERSION.SDK_INT >=23)
        {
            requestPermissions(arrayOf<String>(android.Manifest.permission.CAMERA,android.Manifest.permission.WRITE_EXTERNAL_STORAGE),2)
        }

        dialog.setContentView(view)
    }







    fun dispatchPictureAction()
    {
        val cameraIntent   = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        var photoFile = createPhotoFile()

        if(photoFile!=null)
        {
            pathToFile =  photoFile.absolutePath
            val photoURI: Uri = FileProvider.getUriForFile(context!!,"com.example.bottomsheet.fileprovider",photoFile)
            cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,photoURI)
            startActivityForResult(cameraIntent,1)
        }
    }

    fun createPhotoFile() : File
    {
        var image  : File?  =null;
        val name : String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())


        val storageDir : File  = context!!.getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!

        try {
             image = File.createTempFile("bottomsheet_" + name,".jpeg",storageDir)

        }
        catch (exception  : IOException)
        {
            println("Exception at creating files:" + exception)
            Toast.makeText(context,"Exception at creating files",Toast.LENGTH_SHORT).show()
        }

           return image!!;
    }

    override fun onPause() {
        super.onPause()
        println("OnPause")
    }

    override fun onStop() {
        super.onStop()

        println("OnStop")
    }

    override fun onResume() {
        super.onResume()

        println("OnResume")
    }

    override fun onStart() {
        super.onStart()

        println("OnStart")
    }

    override fun onDestroy() {
        super.onDestroy()

        println("OnDestroy")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        println("OnAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        println("OnCreate")
        this.retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        println("OnCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }



    override fun onDestroyView() {
        println("OnDestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        println("OnDetach")
        super.onDetach()
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        println("OnViewStateRestored")
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        println("OnSaveInstanceState")
        super.onSaveInstanceState(outState)
    }



}