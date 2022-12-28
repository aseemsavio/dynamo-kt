package asavio.dynamokt.dsl

import asavio.dynamokt.services.Client
import asavio.dynamokt.services.DynamoDbClientBuilder

/**
 * This DSL creates a DynamoDB [Client] object. Accepts accessKey, secretKey and region.
 *
 */
fun dynamoClient(fn: DynamoDbClientBuilder.() -> Unit): Client = DynamoDbClientBuilder().apply(fn).build()
