package com.sbarrasa.repository

import org.slf4j.LoggerFactory

abstract class AbstractRepositoryFactory<T> {
   private val log = LoggerFactory.getLogger(this::class.simpleName)

   fun get(repositoryId: String?): T {
      log.info("Repository type: $repositoryId")
      return repositories.get(repositoryId)
         ?.invoke()
         ?: throw RepositoryException("RepositoryId: $repositoryId not found")
   }

   val repositories by lazy { buildRepositories() }
   abstract protected fun buildRepositories(): MutableMap<String, ()-> T>

}