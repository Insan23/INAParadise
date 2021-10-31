package id.ac.unej.inaparadise.ui

import android.widget.Button
import id.ac.unej.inaparadise.MainActivity

class LoginActivity : AppCompatActivity() {
    var email: EditText? = null
    var password: EditText? = null
    var daftar: Button? = null
    var masuk: Button? = null
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        email = findViewById<EditText>(R.id.email)
        password = findViewById<EditText>(R.id.password)
        daftar = findViewById<Button>(R.id.daftar)
        masuk = findViewById<Button>(R.id.masuk)
        daftar!!.setOnClickListener {
            startActivity(
                Intent(
                    this@LoginActivity,
                    RegisterActivity::class.java
                )
            )
        }
        masuk!!.setOnClickListener {
            startActivity(
                Intent(
                    this@LoginActivity,
                    MainActivity::class.java
                )
            )
        }
    }
}