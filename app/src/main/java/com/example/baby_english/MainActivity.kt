package com.example.baby_english

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var alphabet=Array<String>(26){""}
        var j=65;
        for (i in 0..25)
        {
            alphabet[i]=Character.toString(j.toChar())
            j++
        }

      //  var adapter=ArrayAdapter<String>(applicationContext,android.R.layout.simple_dropdown_item_1line,imageIDs)
      //  LayoutInflater.from(context).inflate(R.layout.row, parent, false)
       // gridview.adapter=ImageAdopter()
        gridview.adapter=ImageAdopter(this)

        gridview.setOnItemClickListener { adapterView, view, i, l ->
            var intent =Intent(applicationContext,AlphabetActivity::class.java)
            intent.putExtra("name",alphabet[i])
            startActivity(intent)
            finish()
        }
        img_home.setOnClickListener{
            startActivity(Intent(applicationContext,HomeActivity::class.java))
            finish()
        }

    }

  public class ImageAdopter(private val context: Context) : BaseAdapter() {
      var imageIDs = arrayOf(
          R.drawable.aa, R.drawable.bb, R.drawable.cc,
          R.drawable.dd, R.drawable.ee, R.drawable.ff,
          R.drawable.gg, R.drawable.hh, R.drawable.ii,
          R.drawable.jj, R.drawable.kk, R.drawable.ll,
          R.drawable.mm, R.drawable.nn, R.drawable.oo,
          R.drawable.pp, R.drawable.qq, R.drawable.rr,
          R.drawable.ss, R.drawable.tt, R.drawable.uu,
          R.drawable.vv, R.drawable.ww, R.drawable.xx,
          R.drawable.yy, R.drawable.zz
      )

      override fun getCount(): Int {
          return imageIDs.size
      }

      override fun getItem(p0: Int): Any {
          return p0
      }

      override fun getItemId(p0: Int): Long {
          return p0.toLong()
      }

      override fun getView(position: Int, view: View?, parent: ViewGroup): View {
          val mImageView: ImageView
       //   convertView = LayoutInflater.from(context).inflate(R.layout.row, parent, false)

          if (view == null) {
              mImageView = ImageView(context)
              mImageView.layoutParams = AbsListView.LayoutParams(512, 512)
              mImageView.scaleType = ImageView.ScaleType.CENTER_CROP
              mImageView.setPadding(16, 16, 16, 16)

          } else {
              mImageView = view as ImageView
          }
         mImageView.setImageResource(imageIDs[position])
          return mImageView
      }
  }

}