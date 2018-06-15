package io.reactiverse.kotlin.pgclient

import io.reactiverse.pgclient.PgTransaction
import io.vertx.kotlin.coroutines.awaitResult

/**
 *  Like [PgTransaction.commit] with an handler to be notified when the transaction commit has completed
 */
suspend fun PgTransaction.commitSuspending() {
  awaitResult<Void?> { this.commit(it) }
}

/**
 *  Like [PgTransaction.rollback] with an handler to be notified when the transaction rollback has completed
 */
suspend fun PgTransaction.rollbackSuspending() {
  awaitResult<Void?> { this.rollback(it) }
}
