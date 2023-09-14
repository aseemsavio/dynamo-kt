package com.aseemsavio.dynamokt.extensions.crud.sync.tables

import software.amazon.awssdk.core.waiters.WaiterResponse
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.services.dynamodb.model.AttributeDefinition
import software.amazon.awssdk.services.dynamodb.model.CreateTableRequest
import software.amazon.awssdk.services.dynamodb.model.DescribeTableRequest
import software.amazon.awssdk.services.dynamodb.model.DescribeTableResponse
import software.amazon.awssdk.services.dynamodb.model.GlobalSecondaryIndex
import software.amazon.awssdk.services.dynamodb.model.KeySchemaElement
import software.amazon.awssdk.services.dynamodb.model.LocalSecondaryIndex
import software.amazon.awssdk.services.dynamodb.model.ProvisionedThroughput
import software.amazon.awssdk.services.dynamodb.model.SSESpecification
import software.amazon.awssdk.services.dynamodb.model.StreamSpecification
import software.amazon.awssdk.services.dynamodb.model.Tag

// https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/examples-dynamodb.html

/**
 * DSL for creating a new Dynamo DB table.
 */
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
 * DSL for creating a [Tag].
 */
fun tag(block: Tag.Builder.() -> Unit): Tag = Tag.builder().apply(block).build()

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
 * DSL for creating [StreamSpecification].
 */
fun CreateTableRequest.Builder.streamSpecificationDynamoKt(block: StreamSpecification.Builder.() -> Unit) = apply {
    streamSpecification(StreamSpecification.builder().apply(block).build())
}

/**
 * [TableName] is a [String].
 */
@JvmInline
value class TableName(val value: String)
