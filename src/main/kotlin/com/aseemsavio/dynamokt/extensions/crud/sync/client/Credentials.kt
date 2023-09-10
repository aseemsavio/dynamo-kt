package com.aseemsavio.dynamokt.extensions.crud.sync.client

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider
import software.amazon.awssdk.services.dynamodb.DynamoDbClientBuilder

/**
 * DSL for applying a [StaticCredentialsProvider] to [DynamoDbClientBuilder].
 */
fun DynamoDbClientBuilder.credentials(block: StaticCredentialsBuilder.() -> Unit): DynamoDbClientBuilder = apply {
    credentialsProvider(StaticCredentialsBuilder().apply(block).build())
}

class StaticCredentialsBuilder {

    var accessKey: String? = null
    var secretKey: String? = null

    fun build(): StaticCredentialsProvider {
        checkNotNull(accessKey) { "accessKey should not be null" }
        checkNotNull(secretKey) { "secretKey should not be null" }
        return StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey))
    }
}
