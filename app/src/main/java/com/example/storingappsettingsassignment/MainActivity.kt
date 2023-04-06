package com.example.storingappsettingsassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast



class MainActivity : AppCompatActivity() {

    lateinit var firstName: EditText
    lateinit var lastName: EditText
    lateinit var password: EditText
    lateinit var email: EditText
    lateinit var studentCheck: CheckBox
    lateinit var petCheck: CheckBox
    lateinit var saveButton: Button
    lateinit var loadButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstName = findViewById(R.id.first_name_input)
        lastName = findViewById(R.id.last_name_input)
        password = findViewById(R.id.number_password_input)
        email = findViewById(R.id.email_input)
        studentCheck = findViewById(R.id.checkBox)
        petCheck = findViewById(R.id.checkBox2)
        saveButton = findViewById(R.id.save_button)
        loadButton = findViewById(R.id.load_button)

        saveButton.setOnClickListener{
            Toast.makeText(this@MainActivity, "SAVED!", Toast.LENGTH_SHORT).show()

            val sharedPreferences = getSharedPreferences("myPreferences", MODE_PRIVATE)
            val myEditor = sharedPreferences.edit()

            myEditor.apply{
                putString("first_name", firstName.text.toString())
                putString("last_name", lastName.text.toString())
                putString("password", password.text.toString())
                putString("email", email.text.toString())
                putBoolean("student", studentCheck.isChecked)
                putBoolean("pet", petCheck.isChecked)
                apply()
            }
        }

        loadButton.setOnClickListener{
            Toast.makeText(this@MainActivity, "LOADED!", Toast.LENGTH_SHORT).show()

            val sharedPreferences = getSharedPreferences("myPreferences", MODE_PRIVATE)

            val key1 = sharedPreferences.getString("first_name", "No First Name")
            val key2 = sharedPreferences.getString("last_name", "No Last Name")
            val key3 = sharedPreferences.getString("password", "No Password")
            val key4 = sharedPreferences.getString("email", "No Email")
            val key5 = sharedPreferences.getBoolean("student", false)
            val key6 = sharedPreferences.getBoolean("pet", false)

            firstName.setText(key1)
            lastName.setText(key2)
            password.setText(key3)
            email.setText(key4)
            studentCheck.isChecked = key5
            petCheck.isChecked = key6

        }

    }
}