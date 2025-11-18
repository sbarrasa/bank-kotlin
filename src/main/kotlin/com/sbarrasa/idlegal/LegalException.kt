package com.sbarrasa.idlegal

class LegalException(override val message: String?) : IllegalArgumentException(message)