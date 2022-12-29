package asavio.dynamokt.dsl

import asavio.dynamokt.services.Client
import asavio.dynamokt.services.DynamoDbClientBuilder

/**
 * This DSL creates a DynamoDB [Client] object. Accepts accessKey, secretKey and region.
 * The returned client object can be used to make further operations on.
 *
 */
fun dynamoClient(fn: DynamoDbClientBuilder.() -> Unit): Client = DynamoDbClientBuilder().apply(fn).build()


