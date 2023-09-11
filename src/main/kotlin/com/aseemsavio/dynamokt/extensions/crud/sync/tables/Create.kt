package com.aseemsavio.dynamokt.extensions.crud.sync.tables

import software.amazon.awssdk.core.waiters.WaiterResponse
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.services.dynamodb.model.*


// https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/examples-dynamodb.html

fun DynamoDbClient.newTable(block: CreateTableRequest.Builder.() -> Unit): TableName {
    val waiter = waiter()
    val createTableRequest = CreateTableRequest.builder().apply(block).build()
    val tableName = createTableRequest.tableName()
    val createTableResponse = createTable(createTableRequest)
    val describeTableRequest = DescribeTableRequest.builder()
            .tableName(tableName)
            .build()
    val waiterResponse: WaiterResponse<DescribeTableResponse> = waiter.waitUntilTableExists(describeTableRequest)
    waiterResponse.matched().response().ifPresent { println(it) }
    return TableName(createTableResponse.tableDescription().tableName())
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

/**
 * DSL for creating a [GlobalSecondaryIndex].
 */
fun globalSecondaryIndex(block: GlobalSecondaryIndex.Builder.() -> Unit): GlobalSecondaryIndex =
        GlobalSecondaryIndex.builder().apply(block).build()

/**
 * DSL for creating a [LocalSecondaryIndex].
 */
fun localSecondaryIndex(block: LocalSecondaryIndex.Builder.() -> Unit): LocalSecondaryIndex =
        LocalSecondaryIndex.builder().apply(block).build()

/**
 * DSL for creating [SSESpecification].
 */
fun CreateTableRequest.Builder.sseSpecificationDynamoKt(block: SSESpecification.Builder.() -> Unit) = apply {
    sseSpecification(SSESpecification.builder().apply(block).build())
}

/**
 * DSL for creating [ProvisionedThroughput].
 */
fun CreateTableRequest.Builder.provisionedThroughputDynamoKt(block: ProvisionedThroughput.Builder.() -> Unit) = apply {
    provisionedThroughput(ProvisionedThroughput.builder().apply(block).build())
}

/**
 * [TableName] is a [String].
 */
@JvmInline
value class TableName(val value: String)