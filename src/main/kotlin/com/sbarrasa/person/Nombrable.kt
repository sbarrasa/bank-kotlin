package com.sbarrasa.person

interface Nombrable {
   val names: List<String>
   val lastNames: List<String>
   val firstName: String
   val lastName: String
   fun fullName(): String
}
