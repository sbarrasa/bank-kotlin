package com.sbarrasa.person

import kotlinx.serialization.Serializable

@Serializable
data class Name (
   override val names: MutableList<String> = ArrayList(),
   override val lastNames: MutableList<String> = ArrayList()
): Nombrable {

   constructor(names: String, lastNames: String = ""): this() {
      this.names.addAll(split(names))
      this.lastNames.addAll(split(lastNames))
   }

   constructor(fullName: String): this() {
      val parts = split(fullName)
      if (parts.isNotEmpty()) {
         lastNames.add(parts.last())
         names.addAll(parts.dropLast(1))
      }
   }

   private fun split(value: String) = value.trim().split("\\s+".toRegex())

   override val firstName: String
      get() = names.get(0)

   override val lastName: String
      get() = lastNames.joinToString(" ")


   val size: Int
      get() = names.size + lastNames.size

   operator fun get(index: Int) = fullName().get(index-1)

   override fun fullName() = "${onlyNames()} ${lastNames()}"

   fun militaryName() = "$lastName, $firstName"

   fun lastNames() = lastNames.joinToString(" ")

   fun onlyNames() = names.joinToString(" ")

   override fun toString(): String {
      return fullName()
   }
}