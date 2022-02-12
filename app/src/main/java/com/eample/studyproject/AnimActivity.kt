package com.eample.studyproject

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

abstract class AnimActivity(private val transitionMode: TransitionMode = TransitionMode.NONE): AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        when (transitionMode) {
            TransitionMode.HORIZON -> overridePendingTransition(R.anim.activity_horizon_in, R.anim.activity_none)
            TransitionMode.VERTICAL -> overridePendingTransition(R.anim.activity_vertical_in, R.anim.activity_none)
            else -> Unit
        }
    }

    override fun finish() {
        super.finish()
        when (transitionMode) {
            TransitionMode.HORIZON -> overridePendingTransition(R.anim.activity_none, R.anim.activity_horizon_out)
            TransitionMode.VERTICAL -> overridePendingTransition(R.anim.activity_none, R.anim.activity_vertical_out)
            else -> Unit
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (isFinishing){
            when (transitionMode) {
                TransitionMode.HORIZON -> overridePendingTransition(R.anim.activity_none, R.anim.activity_horizon_out)
                TransitionMode.VERTICAL -> overridePendingTransition(R.anim.activity_none, R.anim.activity_vertical_out)
                else -> Unit
            }
        }
    }

    enum class TransitionMode {
        NONE,
        HORIZON,
        VERTICAL
    }
}