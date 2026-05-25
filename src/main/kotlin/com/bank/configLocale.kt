package com.bank

import com.bank.locale.*
import com.swelms.common.locale.Locale


fun configLocale() {
   Locale.register(regional_us, regional_ar, lang_en, lang_es )
   val lang = System.getenv("lang")
   Locale.lang = lang
   println("lang=${Locale.lang}")
}
