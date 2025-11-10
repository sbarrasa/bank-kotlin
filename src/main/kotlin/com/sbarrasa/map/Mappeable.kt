package com.sbarrasa.map

interface Mappeable<K,T> {
   fun asMap(): Map<K, T>
}