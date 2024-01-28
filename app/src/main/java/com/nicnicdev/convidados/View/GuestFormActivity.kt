package com.nicnicdev.convidados.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.nicnicdev.convidados.Model.GuestModel
import com.nicnicdev.convidados.R
import com.nicnicdev.convidados.ViewModel.GuestesFormViewModel
import com.nicnicdev.convidados.databinding.ActivityGuestFormBinding

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityGuestFormBinding // vou inicializar essa váriavel de forma tardia
    private lateinit var viewModel: GuestesFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGuestFormBinding.inflate(layoutInflater) //conecta o código com o layout
        setContentView(binding.root) //fornece acesso ao elemento raiz do layout associado.

        viewModel = ViewModelProvider(this)[GuestesFormViewModel::class.java]

        binding.buttonSave.setOnClickListener(this)
        binding.radioPresent.isChecked = true // deixar a opção presente marcado
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_save) {
            val name = binding.editName.text.toString()
            val presence =
                binding.radioPresent.isChecked // como ao abrir a tela o presence ja esta marcado , vamos colocar ele como verdadeiro.

            val model = GuestModel(0, name, presence)
            viewModel.insert(model)
        }
    }
}