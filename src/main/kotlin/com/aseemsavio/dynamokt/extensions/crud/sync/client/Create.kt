package com.aseemsavio.dynamokt.extensions.crud.sync.client

import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.services.dynamodb.DynamoDbClientBuilder

/**
 * DSL for building a synchronous DynamoDb Client.
 *
 * @since 0.0.1
 */
fun dynamoDbClient(block: DynamoDbClientBuilder.() -> Unit): DynamoDbClient = DynamoDbClient.builder().apply(block).build()
