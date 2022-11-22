package com.example.praktika8


import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var login: EditText
    lateinit var password: EditText
    lateinit var sharedd: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login=findViewById(R.id.uv)
        password=findViewById((R.id.pv))
        sharedd=getSharedPreferences("ACCOUNT_TASKS", MODE_PRIVATE)
        if (sharedd.contains("MY_LOGIN_TASK") && sharedd.contains("MY_PASSWORD_TASK")){
            var l=sharedd.getString("MY_LOGIN_TASK","NONE")
            var p=sharedd.getString("MY_PASSWORD_TASK","NONE")
            login.setText(l)
            password.setText(p)
        }
    }
    fun voidite(view: android.view.View){
        if(!sharedd.contains("MY_LOGIN_TASK") && !sharedd.contains("MY_PASSWORD_TASK")){
            if ( login.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()){
                var editing=sharedd.edit()
                editing.putString("MY_LOGIN_TASK",login.text.toString())
                editing.putString("MY_PASSWORD_TASK",password.text.toString())
                editing.apply()
                val intent= Intent(this,GeneralActivity::class.java)
                startActivity(intent)
            }
            else{
                val alert= AlertDialog.Builder(this)
                    .setTitle("Ошибка").setMessage("У вас не заполненные поля").setPositiveButton("Ok", null).create().show()

            }

        }
        else{
            var l=sharedd.getString("MY_LOGIN_TASK","NONE")
            var p=sharedd.getString("MY_PASSWORD_TASK","NONE")
            login.setText(l)
            password.setText(p)
            val intent= Intent(this,GeneralActivity::class.java)
            startActivity(intent)

        }

    }
}