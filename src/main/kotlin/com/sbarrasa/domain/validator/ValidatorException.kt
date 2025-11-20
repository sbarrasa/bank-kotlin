package com.sbarrasa.domain.validator

class ValidatorException(override val message: String?) : IllegalArgumentException(message)