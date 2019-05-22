package com.egmdevelopers.test01

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.util.SparseArray
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.android.gms.samples.vision.barcodereader.BarcodeCapture
import com.google.android.gms.samples.vision.barcodereader.BarcodeGraphic
import com.google.android.gms.vision.barcode.Barcode

import kotlinx.android.synthetic.main.activity_main.*
import xyz.belvi.mobilevisionbarcodescanner.BarcodeRetriever

class MainActivity : AppCompatActivity(), BarcodeRetriever {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initQRFragment()
    }

    private fun initQRFragment() {
        val barcodeCapture = supportFragmentManager.findFragmentById(R.id.barcode) as BarcodeCapture
        barcodeCapture.setRetrieval(this)
    }

    fun onClick(v: View) {
        when(v.id) {
        }
    }


    /*
    Interface BarcodeRetriever
     */
    override fun onRetrieved(barcode: Barcode?) {
        Log.d(TAG, "onRetrieved -> ${barcode!!.rawValue}")
        runOnUiThread {
            toast("QR: ${barcode.displayValue}")
            val intent = Intent(this@MainActivity, ResultActivity::class.java)
            intent.putExtra("qrData", barcode)
            startActivity(intent)
        }
    }

    override fun onRetrievedMultiple(p0: Barcode?, p1: MutableList<BarcodeGraphic>?) {
        Log.d(TAG, "onRetrieveMultiple")
    }

    override fun onBitmapScanned(p0: SparseArray<Barcode>?) {
        Log.d(TAG, "onBitmapScanned")
    }

    override fun onRetrievedFailed(p0: String?) {
        Log.d(TAG, "onRetrievedFailed")
    }

    override fun onPermissionRequestDenied() {
        Log.d(TAG, "onPermissionRequestDenied")
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


    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}
