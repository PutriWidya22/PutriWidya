package com.putri.widya

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.putri.widya.databinding.HalamanDuaBinding

class HalamanDua : AppCompatActivity() {
    private var idPegawai = ""

    companion object {
        const val Pegawai = "user"
        const val Web = "https://instagram.com/bunga_hias_berkualitas?utm_medium=copy_link"
        const val fb = "https://facebook.com/groups/483377752919209/"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // untuk menampilkan layout ActivityMain menggunakan metode binding.
        val binding = HalamanDuaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // mengambil data dari halaman MainActivity.
        idPegawai = intent?.extras?.getString(Pegawai).toString()
        // judul atau text yang akan ditampilkan di dalam App-bar
        title = "Halaman Admin"

        // text yang akan ditampilkan dengan menyisipkan $idPegawai di bagian TextView
        // yang memiliki id teksSapaan.
        binding.teksSapaan.text = "Hai $idPegawai"

        // menambahkan ClickListener kepada btnIg yang nantinya jika di klik
        // akan menuju cekInstagram().
        binding.btnIg.setOnClickListener { cekInstagram() }

        // menambahkan ClickListener kepada btnIg yang nantinya jika di klik
        // akan menuju cekFacebook().
        binding.btnFb.setOnClickListener { cekFacebook() }
    }

    private fun cekInstagram() {
        // cntoh intent eksplisit
        // menambahkan link yang berada di web + idPegawai
        val queryUrl: Uri = Uri.parse("$Web${idPegawai}")
        // pada intent memuat parameter variabel queryUrl
        val intent = Intent(Intent.ACTION_VIEW, queryUrl)
        // memulai intent
        startActivity(intent)
        }
    private fun cekFacebook() {
        // cntoh intent eksplisit
        // menambahkan link yang berada di fb + idPegawai
        val queryUrl: Uri = Uri.parse("$fb${idPegawai}")
        // pada intent memuat parameter variabel queryUrl
        val intent = Intent(Intent.ACTION_VIEW, queryUrl)
        // memulai intent
        startActivity(intent)
    }
}
