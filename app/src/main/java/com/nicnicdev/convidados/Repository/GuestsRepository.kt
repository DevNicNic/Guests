package com.nicnicdev.convidados.Repository

import android.content.ContentValues
import android.content.Context
import com.nicnicdev.convidados.Constants.DataBaseConstants
import com.nicnicdev.convidados.Model.GuestModel

class GuestsRepository private constructor(context: Context) { // esta classe faz a manipulação de dados usando a conecção com o banco.

    private val guestDataBase =
        GuestDataBase(context) //esta variavel  conecta o repositorio com o banco.

    companion object { //isnto é um Singleton a minha variavel nunca vai se inicializar duas vezes.
        private lateinit var repository: GuestsRepository
        fun getInstanace(context: Context): GuestsRepository { // essa condição verifica se a variavel repositoty foi inicializada alguma vez.
            if (!Companion::repository.isInitialized) { // se não for
                repository = GuestsRepository(context) //Instãnciando o GuestsREpository
            }
            return repository
        }

    }

    fun insert(guest: GuestModel): Boolean {
       return try {
           val db = guestDataBase.writableDatabase

           val presence = if (guest.presence) 1 else 0 // usando o if como uma instrução

           val values =
               ContentValues() // esses conteúdos vão carregar as informações para o nosso banco
           values.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
           values.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, presence)

           db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, values)
           true
       } catch (e: Exception){
           false

       }

    }

    fun update() {

    }

}