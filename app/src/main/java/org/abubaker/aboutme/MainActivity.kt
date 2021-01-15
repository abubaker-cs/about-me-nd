package org.abubaker.aboutme

import android.content.Context
import android.hardware.input.InputManager
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.abubaker.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // DataBinding Step 3 - Define our central DataBinding Object
    private lateinit var binding: ActivityMainBinding

    // Populating data based on MyName() class
    private val myName: MyName = MyName("Aleks Haecky")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // DataBinding Step 4 - Replace our Binding Object with setContentView
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Updating myName
        binding.myName = myName

        // Find the DONE button
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }


        // Launch our activity view
        // setContentView(R.layout.activity_main)

        // Done - Actions
        // findViewById<Button>(R.id.done_button).setOnClickListener {
        //     addNickname(it)
        // }
    }

    private fun addNickname(view: View) {

        // Make it easier to read (kotlin)
        binding.apply {

            myName?.nickname = nicknameEdit.text.toString()
            // binding.nicknameText.text = binding.nicknameEdit.text

            // Refresh UI with the NEW Data - invalidate all binding expressions
            // so that they recreated with the correct data
            invalidateAll()

            binding.nicknameEdit.visibility = View.GONE
            binding.doneButton.visibility = View.GONE
            binding.nicknameText.visibility = View.GONE
        }

        // val editText = findViewById<EditText>(R.id.nickname_edit)
        // val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        // nicknameTextView.text = editText.text
        // editText.visibility = View.GONE
        // view.visibility = View.GONE
        // nicknameTextView.visibility = View.VISIBLE

        // Hide the keyboard on pressing OK button
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}