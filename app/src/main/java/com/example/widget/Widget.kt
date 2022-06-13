package com.example.widget

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.widget.databinding.ActivityWidgetBinding
import com.google.android.material.snackbar.Snackbar

//membuat variable binding
private lateinit var binding :ActivityWidgetBinding

class Widget : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inisialisasi binding
        binding = ActivityWidgetBinding.inflate(layoutInflater)
        //memanggil layout menggunakan binding.root
        setContentView(binding.root)

       //button Toast
       binding.btnToast.setOnClickListener {
           Toast.makeText(this, "ini adalah toast",Toast.LENGTH_SHORT).show()
       }

       //button snackbar
       binding.btnSnackbar.setOnClickListener {
           Snackbar.make(it, "ini adalah snackbar",Snackbar.LENGTH_SHORT).show()
       }

      //button alert
      binding.btnAlert.setOnClickListener {
          AlertDialog.Builder(this).apply {
              setTitle("Pesan")
              setMessage("Ini adalah Alert dari Iwan")
              setPositiveButton("OK"){dialog, _->
                  Toast.makeText(applicationContext,"anda klik OK",Toast.LENGTH_SHORT).show()
                  dialog.dismiss()
              }
              setNegativeButton("Back"){dialog, _->
                  Toast.makeText(applicationContext,"anda klik Back",Toast.LENGTH_SHORT).show()
                  dialog.dismiss()
              }
          }.show()
      }

      //button custom dialog
      binding.btnCustomDialog.setOnClickListener {
          Dialog(this).apply {
              requestWindowFeature(Window.FEATURE_NO_TITLE)
              setCancelable(false)
              setContentView(R.layout.custom_dialog)

              val btnCancel = this.findViewById<Button>(R.id.btncancel)
              val btnContinue = this.findViewById<Button>(R.id.btncontinou)

              btnCancel.setOnClickListener {
                  Toast.makeText(applicationContext,"anda klik cancel",Toast.LENGTH_SHORT).show()
                  this.dismiss()
              }
              btnContinue.setOnClickListener {
                  Toast.makeText(applicationContext,"anda klik contunue",Toast.LENGTH_SHORT).show()
                  this.dismiss()
              }
          }.show()
      }

    }
}