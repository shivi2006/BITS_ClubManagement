package com.example.shiviMittal.Events.View

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.shiviMittal.R
import kotlinx.android.synthetic.main.events_layout01.*


class Events01 : Fragment() {

    var stringdecode: String? = null
    val result_load_image = 1
    val requestCode=1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.events_layout01, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val result_load_image = 1

        //val context: Context = activity!!.applicationContext



        fun loadImageFromGallery() {
            val galleryIntent: Intent = Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )
            startActivityForResult(galleryIntent, requestCode)
        }




        upload_from_gallery.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                loadImageFromGallery()
            }
        }
        )
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, galleryIntent: Intent?) {
        super.onActivityResult(requestCode, resultCode, galleryIntent)

        //Log.d("check", "result code received")
        //Log.d("check","value of requestcode"+Int.toString(requestCode))
        try {
            // Log.d("check","enetered in try block")

            if (requestCode == result_load_image && resultCode == RESULT_OK) {
                Log.d("check", "condition true")
                val selectedImage: Uri? = galleryIntent?.getData()
                Log.d("check", "URI received")
                Glide.with(imageView2).load(selectedImage)
                    .centerCrop()
                    .into(imageView2)





                /*val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)

                val cursor: Cursor? = context?.getContentResolver()!!
                    .query(selectedImage!!, filePathColumn, null, null, null)


                cursor?.moveToFirst()

                val columnIndex: Int = cursor!!.getColumnIndex(filePathColumn[0])

                stringdecode = cursor.getString(columnIndex)

                Log.d("check", "check block try")

                cursor.close()

                Log.d("check", "cursor closed")

                imageView2.setImageBitmap(

                    BitmapFactory.decodeFile(stringdecode)
                )
                Log.d("check","image uploaded")
            }*/} else {
                Toast.makeText(
                    activity?.applicationContext, "You havent picked up", +
                    Toast.LENGTH_LONG
                ).show()

            }
        } catch (e: Exception) {
            Toast.makeText(
                activity?.applicationContext,
                "Something went wrong",
                Toast.LENGTH_LONG
            )
                .show()
        }
    }
}













