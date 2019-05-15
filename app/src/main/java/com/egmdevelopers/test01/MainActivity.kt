package com.egmdevelopers.test01

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

//class MainActivity() extends AppCompatActivity()
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("CICLODEVIDA", "ON CREATE")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        btn1.setOnClickListener {
            escribeDigito(1)
        }

        btn2.setOnClickListener {
            escribeDigito(2)
        }

        btn3.setOnClickListener {
            escribeDigito(3)
        }


        fab.setOnClickListener {
            toast("Mensaje")
            //Toast.makeText(this, "Hola TOAST!", Toast.LENGTH_SHORT).show()
            /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()*/
        }

        val random = numeroAleatorio(10)
        Log.d("RANDOM", "Mi valor es $random unidades")
    }

    override fun onStart() {
        super.onStart()
        Log.d("CICLODEVIDA", "ON START")
    }

    override fun onResume() {
        super.onResume()
        Log.d("CICLODEVIDA", "ON RESUME")
    }

    override fun onStop() {
        super.onStop()
        Log.d("CICLODEVIDA", "ON STOP")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("CICLODEVIDA", "ON DESTROY")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("CICLODEVIDA", "ON RESTART")
    }


    private fun numeroAleatorio(max: Int): Double = (Math.random() * max)

    private fun escribeDigito(digito: Int) {
        var actual = tvDigitos.text.toString()
        actual += digito.toString()
        tvDigitos.text = actual
    }



    fun clickBtn4(view: View) {
        escribeDigito(4)
    }

    fun clickBtn5(view: View) {
        escribeDigito(5)
    }

    fun clickBtn6(view: View) {
        escribeDigito(6)
    }



    fun onClick(v: View) {
        when(v.id) {
            R.id.btn7 -> {
                escribeDigito(7)
                //...
            }
            R.id.btn8 -> escribeDigito(8)
            R.id.btn9 -> escribeDigito(9)
            R.id.btn0 -> escribeDigito(0)
        }
    }




    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
