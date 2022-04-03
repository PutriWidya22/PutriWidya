package com.putri.widya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.putri.widya.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // untuk menampilkan layout ActivityMain menggunakan metode binding.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // menambahkan ClickListener kepada btnLogin yang nantinya jika di klik
        // akan mengecek password pada cekPass().
        binding.btnLogin.setOnClickListener { cekPass() }

    }
    // di dalam cekPass() terdapat username dan password dengan metode binding.
    private fun cekPass() {
        val username = binding.editNama.text.toString()
        val password = binding.editPass.text.toString()

        // mengecek apakah username dan password sudah terisi, jika belum maka
        // akan menampilkan pop-up bahwa "Usrname dan Password harus diisi".
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Username dan Password harus di isi", Toast.LENGTH_SHORT).show()
            return
        }

        // mengecek apakah username dan password telah terisi sesuai yang ditentukan.
        if(username == "admin" && password == "456"){
            // contoh intent eksplisit
            // jika form login yang diisi sudah sesuai maka saat klik button btnLogin
                // akan berpindah ke tampilan HalamanDua.
            val intent = Intent(this, HalamanDua::class.java)

            // memasukkan data-data yang telah terisi ke dalam "user" di HalamanDua.kt
            intent.putExtra("user", binding.editNama.text.toString())

            // menjalankan activity intent
            startActivity(intent)

            // MainActivity akan dihapus dari backStack jika telah finish.
            finish()
            // jika data username dan password yang diisi tidak sesuai maka akan menampilkan
            // pop-up bahwa "Username atau password salah"
        }else{
            Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
            return
        }
    }
}