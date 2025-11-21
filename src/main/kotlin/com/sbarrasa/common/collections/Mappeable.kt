package com.sbarrasa.common.collections

interface Mappeable<K,T> {
   fun asMap(): Map<K, T>
}

