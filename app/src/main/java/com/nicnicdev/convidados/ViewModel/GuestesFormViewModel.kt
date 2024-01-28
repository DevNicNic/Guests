package com.nicnicdev.convidados.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.nicnicdev.convidados.Model.GuestModel
import com.nicnicdev.convidados.Repository.GuestsRepository

class GuestesFormViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = GuestsRepository.getInstanace(application)
    fun insert (guest: GuestModel) {
        repository.insert(guest)


    }

}