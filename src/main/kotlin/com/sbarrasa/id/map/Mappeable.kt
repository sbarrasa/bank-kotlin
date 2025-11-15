package com.sbarrasa.id.map

interface Mappeable<K,T> {
   fun asMap(): Map<K, T>
}