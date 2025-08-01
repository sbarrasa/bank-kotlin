package com.sbarrasa.util

import kotlin.test.Test

class EnumRangeTest{
   enum class Color {
      ROJO, NARANJA, AMARILLO, VERDE, AZUL, INDIGO, VIOLETA
   }

   fun <T : Enum<T>> printRange(range: List<T>) {
      println(range.joinToString(", "))
   }
   @Test
   fun testEnumRange() {
      val range1 = enumRange(Color.ROJO, Color.VERDE)
      assert(range1 == listOf(Color.ROJO, Color.NARANJA, Color.AMARILLO, Color.VERDE))
      printRange(range1)

      val range2 = enumRange(Color.VERDE, Color.ROJO)
      assert(range2 == listOf(Color.VERDE, Color.AMARILLO, Color.NARANJA, Color.ROJO))
      printRange(range2)

      val range3 = enumRange(Color.AZUL)
      assert(range3 == listOf(Color.AZUL, Color.INDIGO, Color.VIOLETA))
      printRange(range3)

      val range4 = enumRange(Color.VIOLETA, Color.ROJO)
      assert(range4 == listOf(Color.VIOLETA, Color.INDIGO, Color.AZUL, Color.VERDE, Color.AMARILLO, Color.NARANJA, Color.ROJO))
      printRange(range4)

   }



}