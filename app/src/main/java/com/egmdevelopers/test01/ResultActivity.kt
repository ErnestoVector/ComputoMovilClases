package com.egmdevelopers.test01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.vision.barcode.Barcode
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    private lateinit var bundle : Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        bundle = intent.extras!!
        val qr = bundle.get("qrData") as Barcode

        tvResult.text = qr.displayValue
        Log.d(TAG, "QR -> ${qr.displayValue}")
    }


    companion object {
        private val TAG = ResultActivity::class.java.simpleName
    }
}
