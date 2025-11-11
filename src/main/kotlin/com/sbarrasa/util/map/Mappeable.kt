package com.sbarrasa.util.map

interface Mappeable<K,T> {
   fun asMap(): Map<K, T>
}