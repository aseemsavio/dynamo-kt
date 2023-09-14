package com.aseemsavio.dynamokt.extensions.crud.sync.records

import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest

/**
 * DSL for creating an item in the given Dynamo DB table.
 */
fun DynamoDbClient.create(block: PutItemRequest.Builder.() -> Unit) {
    val request = PutItemRequest.builder().apply(block).build()
    putItem(request)
}
