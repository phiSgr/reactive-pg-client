package io.reactiverse.kotlin.pgclient

import io.reactiverse.pgclient.PgConnection
import io.reactiverse.pgclient.PgPreparedQuery
import io.reactiverse.pgclient.PgRowSet
import io.reactiverse.pgclient.Tuple
import io.vertx.kotlin.coroutines.awaitResult
import kotlin.String
import kotlin.collections.MutableList

/**
 *  Create a prepared query.
 * @param sql the sql */
suspend fun PgConnection.prepare(sql: String): PgPreparedQuery {
  return awaitResult { this.prepare(sql, it) }
}

suspend fun PgConnection.preparedQuery(sql: String): PgRowSet {
  return awaitResult { this.preparedQuery(sql, it) }
}

suspend fun PgConnection.query(sql: String): PgRowSet {
  return awaitResult { this.query(sql, it) }
}

suspend fun PgConnection.preparedQuery(sql: String, arguments: Tuple): PgRowSet {
  return awaitResult { this.preparedQuery(sql, arguments, it) }
}

suspend fun PgConnection.preparedBatch(sql: String, batch: MutableList<Tuple>): PgRowSet {
  return awaitResult { this.preparedBatch(sql, batch, it) }
}
