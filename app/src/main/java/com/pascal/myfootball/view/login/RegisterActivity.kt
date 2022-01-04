package com.pascal.myfootball.view.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.pascal.myfootball.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.hide()

        registerCode()
    }

    private fun registerCode() {
        mAuth = FirebaseAuth.getInstance()

        btn_register.setOnClickListener {
            val email = edt_RegisterEmail.text.toString().trim()
            val password = edt_RegisterPassword.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                mAuth!!.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(
                        this
                    ) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("FragmentActivity.TAG", "createUserWithEmail:success")
                            val user = mAuth!!.currentUser
                            updateUI(user)
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(
                                "FragmentActivity.TAG",
                                "createUserWithEmail:failure",
                                task.exception
                            )
                            showToast("Register gagal")
                        }
                    }
            } else {
                showToast("Email atau Password harus diisi")
            }
        }
    }

    private fun updateUI(user: FirebaseUser?) {
        showToast("Register berhasil")
        finish()
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}