package com.khmelenko.lab.fitnessml

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.tensorflow.contrib.android.TensorFlowInferenceInterface
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.start_btn).setOnClickListener {
            view -> runPrediction()
        }
    }

    fun runPrediction() {

        // TODO we need to use optimized model. Do model optimization once it's exported

        val modelName = "file:///android_asset/saved_model.pb"

        val inferenceInterface = TensorFlowInferenceInterface(assets, modelName)


        inferenceInterface.feed("gender", intArrayOf(1))
        inferenceInterface.feed("goal", intArrayOf(1))
        inferenceInterface.feed("level", intArrayOf(1))

        inferenceInterface.run(arrayOf<String>("cluster"), false)

        val resu = floatArrayOf(0f, 0f)
        inferenceInterface.fetch("cluster", resu)

    }
}
