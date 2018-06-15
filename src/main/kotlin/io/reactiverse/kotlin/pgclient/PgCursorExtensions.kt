package io.reactiverse.kotlin.pgclient

import io.reactiverse.pgclient.PgCursor
import io.reactiverse.pgclient.PgRowSet
import io.vertx.kotlin.coroutines.awaitResult
import kotlin.Int

/**
 *  Read rows from the cursor, the result is provided asynchronously to the `handler`.
 * @param count the amount of rows to read */
suspend fun PgCursor.read(count: Int): PgRowSet {
  return awaitResult { this.read(count, it) }
}

/**
 *  Like [PgCursor.close] but with a `completionHandler` called when the cursor has been released.
 */
suspend fun PgCursor.closeSuspending() {
  awaitResult<Void?> { this.close(it) }
}
