package io.reactiverse.kotlin.pgclient.pubsub

import io.reactiverse.pgclient.pubsub.PgSubscriber
import io.vertx.kotlin.coroutines.awaitResult

/**
 *  Connect the subscriber to Postgres.
 * @return a reference to this, so the API can be used fluently
 */
suspend fun PgSubscriber.connect() {
  awaitResult<Void?> { this.connect(it) }
}
