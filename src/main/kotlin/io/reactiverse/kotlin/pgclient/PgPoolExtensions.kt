package io.reactiverse.kotlin.pgclient

import io.reactiverse.pgclient.PgConnection
import io.reactiverse.pgclient.PgPool
import io.reactiverse.pgclient.PgRowSet
import io.reactiverse.pgclient.Tuple
import io.vertx.kotlin.coroutines.awaitResult
import kotlin.String
import kotlin.collections.MutableList

suspend fun PgPool.preparedQuery(sql: String): PgRowSet {
  return awaitResult { this.preparedQuery(sql, it) }
}

suspend fun PgPool.query(sql: String): PgRowSet {
  return awaitResult { this.query(sql, it) }
}

suspend fun PgPool.preparedQuery(sql: String, arguments: Tuple): PgRowSet {
  return awaitResult { this.preparedQuery(sql, arguments, it) }
}

suspend fun PgPool.preparedBatch(sql: String, batch: MutableList<Tuple>): PgRowSet {
  return awaitResult { this.preparedBatch(sql, batch, it) }
}

/**
 *  Get a connection from the pool. */
suspend fun PgPool.getConnection(): PgConnection {
  return awaitResult { this.getConnection(it) }
}
