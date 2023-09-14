package com.aseemsavio.dynamokt.extensions.crud.sync.client

import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClientBuilder

/**
 * DSL for applying a [Region] to [DynamoDbClientBuilder].
 */
fun DynamoDbClientBuilder.region(block: () -> String): DynamoDbClientBuilder = apply { region(Region.of(block())) }
