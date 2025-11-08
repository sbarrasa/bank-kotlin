package com.sbarrasa.util.id

import com.sbarrasa.util.case.*

open class IdDescClassMap(classes: List<IdDescMap>, keyCase: Case = Case.SNAKE)
   : Map<String, Map<String, String>> by buildMap(classes, keyCase) {

      constructor(keyCase: Case = Case.SNAKE, vararg classes: IdDescMap) : this(classes.toList(), keyCase)

      companion object {
         private fun buildMap(classList: List<IdDescMap>, aCase: Case) =
            classList.associate {
               val key = it::class.simpleName!!.toCase(aCase)
               key to it.asMap()
            }
      }
}