package io.reactiverse.kotlin.pgclient

import io.reactiverse.pgclient.PgPreparedQuery
import io.reactiverse.pgclient.PgRowSet
import io.reactiverse.pgclient.Tuple
import io.vertx.kotlin.coroutines.awaitResult
import kotlin.collections.MutableList

/**
 *  Calls [PgPreparedQuery.execute] with an empty tuple argument.
 */
suspend fun PgPreparedQuery.execute(): PgRowSet {
  return awaitResult { this.execute(it) }
}

/**
 *  Create a cursor with the provided `arguments`.
 * @param args the list of arguments
 * @return the query
 */
suspend fun PgPreparedQuery.execute(args: Tuple): PgRowSet {
  return awaitResult { this.execute(args, it) }
}

/**
 *  Execute a batch.
 * @param argsList the list of tuple for the batch
 * @return the createBatch
 */
suspend fun PgPreparedQuery.batch(argsList: MutableList<Tuple>): PgRowSet {
  return awaitResult { this.batch(argsList, it) }
}

/**
 *  Like [PgPreparedQuery.close] but notifies the `completionHandler` when it's closed.
 */
suspend fun PgPreparedQuery.closeSuspending() {
  awaitResult<Void?> { this.close(it) }
}
