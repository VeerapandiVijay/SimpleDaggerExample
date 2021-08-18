package com.hapmate.simpledaggerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hapmate.simpledaggerexample.application.AppController
import com.hapmate.simpledaggerexample.utils.CommonMethods
import com.optisol.dagger2example.config.SessionManager
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    internal lateinit var sessionManager: SessionManager

    @Inject
    internal lateinit var commonMethods: CommonMethods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppController.appComponent.inject(this)

        tv_main.text = commonMethods.getAppName()
    }
}