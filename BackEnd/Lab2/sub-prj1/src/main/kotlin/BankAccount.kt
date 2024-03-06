package org.example

import java.math.BigDecimal

class BankAccount (val firstName: String, val lastName: String, private val balance: BigDecimal){
    fun deposit(amount: BigDecimal) : BigDecimal = balance.add(amount)

    fun withdraw(amount: BigDecimal) : BigDecimal = balance.add(-amount)
}