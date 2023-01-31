package com.example.data.accountstorage

import androidx.room.Insert
import androidx.room.Query
import com.example.data.accountstorage.model.AccountModel
import kotlinx.coroutines.flow.Flow

@androidx.room.Dao
interface Dao {
    @Insert
    fun insertAccount(account: AccountModel) : Long

    @Query("SELECT * FROM accounts")
    fun getAllAccounts(): Flow<List<AccountModel>>

    @Query("SELECT * FROM accounts WHERE number = :number AND password = :password")
    suspend fun getUserByNameAndPassword(number: String, password: String): AccountModel
}