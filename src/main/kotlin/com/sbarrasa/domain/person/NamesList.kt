package com.sbarrasa.domain.person

interface NamesList {
   val list: List<String>
   val count: Int get() = list.size

   operator fun get(index: Int) = list[index]

}