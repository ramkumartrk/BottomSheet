package com.example.bottomsheet

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("Activity -  OnCreate")

        openDialogButton1.setOnClickListener(View.OnClickListener {
            Snackbar.make(it,"DialogButton1 Pressed",Snackbar.LENGTH_SHORT).show()
            show_BottomSheetDialog(R.layout.layout_model_bottomsheet_one)
        })

        openDialogButton2.setOnClickListener(View.OnClickListener {
            Snackbar.make(it,"DialogButton2 pressed",Snackbar.LENGTH_SHORT).show()
            show_BottomSheetDialog(R.layout.layout_model_bottomsheet_two)
        })


    }

    fun show_BottomSheetDialog(layoutStyle : Int)
    {
        println("Activity -  Show_BottomSheetDialog")
        var bottomSheetDialogFragment : BottomSheetDialogFragment = Model_BottomSheet(layoutStyle)

       //bottomSheetDialogFragment.isCancelable = false
        bottomSheetDialogFragment.showsDialog = true




        bottomSheetDialogFragment.show(supportFragmentManager,"BottomSheetDialog")

//        if(layoutStyle == R.layout.layout_model_bottomsheet_one)
//        {
//            val linearLayout = findViewById<LinearLayout>(R.id.bottomSheetOneLinearLayout)
//            val bottomSheetBehavior = BottomSheetBehavior.from(linearLayout)
//
//        }
//
//        else
//        {
//            val linearLayout =findViewById<LinearLayout>(R.id.bottomSheetTwoLinearLayout)
//            val bottomSheetBehavior = BottomSheetBehavior.from(linearLayout)
//        }



    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
            println("Activity - OnRestoreInstanceState")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        println("Activity - OnSaveInstanceState")
    }





}
