package com.example.support

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast

/**
  * Created by huanghh on 2016/12/9.
  */
class MainActivity extends Activity {
  val thisClass: Class[MainActivity] = classOf[MainActivity]
  val TAG: String = thisClass.getName

  implicit var tv: TextView = null

  override def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_activtity)


    var viewId :Int = R.id.tv

    tv = getView(viewId)
    tv.setText("HelloAndroidWithScala")
  }
  def leftBtnClick(v: View) {
    Toast.makeText(MainActivity.this, "leftBtnClick", Toast.LENGTH_LONG).show();
  }

  def rightBtnClick(v: View) {
    Toast.makeText(MainActivity.this, "rightBtnClick", Toast.LENGTH_LONG).show();
  }

  def getView[V <: View]( id: Int): V = {

    try {
      return findViewById(id).asInstanceOf[V]
    }
    catch {
      case ex: ClassCastException => {
        System.err.println("Could not cast View to concrete class." + ex)
        throw ex
      }
    }
  }
}
