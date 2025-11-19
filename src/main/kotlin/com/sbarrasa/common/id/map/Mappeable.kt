package com.sbarrasa.common.id.map

interface Mappeable<K,T> {
   fun asMap(): Map<K, T>
}