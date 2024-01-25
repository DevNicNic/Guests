package com.nicnicdev.convidados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.nicnicdev.convidados.databinding.ActivityGuestFormBinding

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private  lateinit var binding: ActivityGuestFormBinding // vou inicializar essa váriavel de forma tardia
    private lateinit var viewModel: GuestesFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGuestFormBinding.inflate(layoutInflater) //conecta o código com o layout
        setContentView(binding.root) //fornece acesso ao elemento raiz do layout associado.

        viewModel = ViewModelProvider(this ).get(GuestesFormViewModel::class.java)

        binding.buttonSave.setOnClickListener(this)
        binding.radioPresent.isChecked = true // deixar a opção presente marcado
    }

    override fun onClick(v: View) {
      if (v.id == R.id.button_save){

      }
    }
}