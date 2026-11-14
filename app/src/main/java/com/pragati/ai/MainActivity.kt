package com.pragati.ai

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.widget.*
import android.graphics.drawable.GradientDrawable

class MainActivity : Activity() {

    private val bg = Color.rgb(8, 17, 38)
    private val card = Color.rgb(19, 34, 62)
    private val green = Color.rgb(90, 220, 140)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this)
        root.orientation = LinearLayout.VERTICAL
        root.setPadding(20, 35, 20, 20)
        root.setBackgroundColor(bg)

        val scroll = ScrollView(this)
        val content = LinearLayout(this)
        content.orientation = LinearLayout.VERTICAL

        val title = TextView(this)
        title.text = "PRAGATI AI"
        title.textSize = 30f
        title.setTextColor(Color.WHITE)
        title.typeface = Typeface.DEFAULT_BOLD
        content.addView(title)

        val subtitle = TextView(this)
        subtitle.text = "Smart AI for Real-World Solutions"
        subtitle.textSize = 14f
        subtitle.setTextColor(green)
        content.addView(subtitle)

        val heading = TextView(this)
        heading.text = "\nExplore AI Solutions"
        heading.textSize = 21f
        heading.setTextColor(Color.WHITE)
        heading.typeface = Typeface.DEFAULT_BOLD
        content.addView(heading)

        val features = listOf(
            "🤖  AI Problem Solver",
            "🌱  Agriculture AI",
            "⚡  Electricity AI",
            "🎓  Education AI",
            "🏙️  Smart City AI",
            "📸  AI Image Analyzer",
            "📄  AI PDF Analyzer"
        )

        for (feature in features) {
            val button = TextView(this)
            button.text = feature
            button.textSize = 17f
            button.setTextColor(Color.WHITE)
            button.gravity = Gravity.CENTER_VERTICAL
            button.setPadding(20, 22, 15, 22)

            val shape = GradientDrawable()
            shape.setColor(card)
            shape.cornerRadius = 20f
            button.background = shape

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(0, 12, 0, 4)
            content.addView(button, params)

            button.setOnClickListener {
                Toast.makeText(
                    this,
                    "$feature selected",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        scroll.addView(content)
        root.addView(scroll)
        setContentView(root)
    }
}