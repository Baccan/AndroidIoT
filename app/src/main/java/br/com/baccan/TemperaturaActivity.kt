package br.com.baccan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_iluminacao.*
import kotlinx.android.synthetic.main.activity_temperatura.*

class TemperaturaActivity : AppCompatActivity() {

    private lateinit var database: FirebaseDatabase
    private lateinit var temperaturaRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperatura)

        database = FirebaseDatabase.getInstance()
        temperaturaRef = database.getReference("temperatura")

        // Read from the database
        temperaturaRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue(Int::class.java)

                //progressTemperatura.value
                txtTemperatura.text = value.toString()
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

        btnVoltar.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}
