package com.khmelenko.lab.fitnessml

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.tensorflow.contrib.android.TensorFlowInferenceInterface
import android.widget.TextView


private val INPUT_NODE = "I"
private val OUTPUT_NODE = "O"

private val INPUT_SIZE = longArrayOf(1L, 3L)


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun runPrediction() {

        val modelName = "model.pb"

        val inferenceInterface = TensorFlowInferenceInterface(assets, modelName)

//        val inputFloats = floatArrayOf(num1, num2, num3)


        // inferenceInterface.feed(INPUT_NODE, inputFloats, 1, 3)

        // Execute the output node's dependency sub-graph.

//        inferenceInterface.run(arrayOf<String>(OUTPUT_NODE), false)
        // Copy the data from TensorFlow back into our array.

//        val resu = floatArrayOf(0f, 0f)
//        inferenceInterface.fetch(OUTPUT_NODE, resu)




        inferenceInterface.feed("gender", intArrayOf(1))
        inferenceInterface.feed("goal", intArrayOf(1))
        inferenceInterface.feed("level", intArrayOf(1))
        // Execute the output node's dependency sub-graph.

        inferenceInterface.run(arrayOf<String>("cluster"), false)
        // Copy the data from TensorFlow back into our array.

        val resu = floatArrayOf(0f, 0f)
        inferenceInterface.fetch("cluster", resu)

    }
}
