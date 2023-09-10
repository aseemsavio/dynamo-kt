package com.aseemsavio.dynamokt.extensions.crud.sync.tables

import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.services.dynamodb.model.AttributeDefinition
import software.amazon.awssdk.services.dynamodb.model.CreateTableRequest
import software.amazon.awssdk.services.dynamodb.model.KeySchemaElement

// https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/examples-dynamodb.html

fun createTable() {
    val a = CreateTableRequest.builder()

}

fun DynamoDbClient.newTable(block: CreateTableRequest.Builder.() -> Unit) {
    val request = CreateTableRequest.builder().apply(block).build()
    createTable(request)
}

/**
 * DSL for creating an [AttributeDefinition].
 */
fun attributeDefinition(block: AttributeDefinition.Builder.() -> Unit): AttributeDefinition =
        AttributeDefinition.builder().apply(block).build()

/**
 * DSL for creating a [KeySchemaElement].
 */
fun keySchemaElement(block: KeySchemaElement.Builder.() -> Unit): KeySchemaElement =
        KeySchemaElement.builder().apply(block).build()
