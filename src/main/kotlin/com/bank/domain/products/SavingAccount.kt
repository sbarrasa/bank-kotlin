package com.bank.domain.products

import com.swelms.domain.id.cbu.CBU
import com.swelms.domain.locale.Currency
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("CA")
data class SavingAccount(
   override val cbu: CBU,
   override val currency: Currency
) : Product, Account