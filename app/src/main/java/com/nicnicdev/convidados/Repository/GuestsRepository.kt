package com.nicnicdev.convidados.Repository

class GuestsRepository  private constructor() {

    companion object{ //isnto é um Singleton a minha variavel nunca vai se inicializar duas vezes.
        private lateinit var  repository: GuestsRepository
        fun getInstanace(): GuestsRepository { // essa condição verifica se a variavel repositoty foi inicializada alguma vez
            if(!Companion::repository.isInitialized){ // se não for
                repository = GuestsRepository() //Instãnciando o GuestsREpository
            }
            return repository
        }

    }





}