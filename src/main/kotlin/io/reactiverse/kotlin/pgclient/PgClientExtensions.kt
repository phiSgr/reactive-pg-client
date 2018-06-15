package io.reactiverse.kotlin.pgclient

import io.reactiverse.pgclient.PgClient
import io.reactiverse.pgclient.PgConnectOptions
import io.reactiverse.pgclient.PgConnection
import io.reactiverse.pgclient.PgRowSet
import io.reactiverse.pgclient.Tuple
import io.vertx.core.Vertx
import io.vertx.kotlin.coroutines.awaitResult
import kotlin.String
import kotlin.collections.MutableList

/**
 *  Execute a simple query.
 * @param sql the query SQL
 * @return a reference to this, so the API can be used fluently
 */
suspend fun PgClient.query(sql: String): PgRowSet {
  return awaitResult { this.query(sql, it) }
}

/**
 *  Prepare and execute a query.
 * @param sql the prepared query SQL
 * @return a reference to this, so the API can be used fluently
 */
suspend fun PgClient.preparedQuery(sql: String): PgRowSet {
  return awaitResult { this.preparedQuery(sql, it) }
}

/**
 *  Prepare and execute a query.
 * @param sql the prepared query SQL
 * @param arguments the list of arguments
 * @return a reference to this, so the API can be used fluently
 */
suspend fun PgClient.preparedQuery(sql: String, arguments: Tuple): PgRowSet {
  return awaitResult { this.preparedQuery(sql, arguments, it) }
}

/**
 *  Prepare and execute a createBatch.
 * @param sql the prepared query SQL
 * @param batch the batch of tuples
 * @return a reference to this, so the API can be used fluently
 */
suspend fun PgClient.preparedBatch(sql: String, batch: MutableList<Tuple>): PgRowSet {
  return awaitResult { this.preparedBatch(sql, batch, it) }
}

object PgClientExtensions {
 /**
  *  Connects to the database and returns the connection if that succeeds.
  *  <p/>
  *  The connection interracts directly with the database is not a proxy, so closing the
  *  connection will close the underlying connection to the database.
  * @param vertx the vertx instance
  * @param options the connect options */
 suspend fun connect(vertx: Vertx, options: PgConnectOptions): PgConnection {
   return awaitResult { PgClient.connect(vertx, options, it) }
 }

 /**
  *  Like [PgClient.connect] with options build from the environment variables.
  */
 suspend fun connect(vertx: Vertx): PgConnection {
   return awaitResult { PgClient.connect(vertx, it) }
 }

 /**
  *  Like [PgClient.connect] with options build from `connectionUri`.
  */
 suspend fun connect(vertx: Vertx, connectionUri: String): PgConnection {
   return awaitResult { PgClient.connect(vertx, connectionUri, it) }
 }
}
