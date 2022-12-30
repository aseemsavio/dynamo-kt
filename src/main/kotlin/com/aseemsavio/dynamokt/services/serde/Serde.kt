package com.aseemsavio.dynamokt.services.serde

import software.amazon.awssdk.services.dynamodb.model.AttributeValue

/**
 * Converts a [String] into Dynamo String
 */
internal val String.dynamoString get() = AttributeValue.builder().s(this).build()

/**
 * Converts a [String] into Dynamo Number
 */
internal val String.dynamoNumber get() = AttributeValue.builder().n(this).build()

/**
 * Converts an [Int] to a Dynamo Number
 */
internal val Int.dynamoNumber get() = AttributeValue.builder().n(this.toString()).build()

/**
 * Converts a [Float] to a Dynamo Number
 */
internal val Float.dynamoNumber get() = AttributeValue.builder().n(this.toString()).build()

/**
 * Converts a [Double] to a Dynamo Number
 */
internal val Double.dynamoNumber get() = AttributeValue.builder().n(this.toString()).build()

/**
 * Converts a [Boolean] to a Dynamo Boolean
 */
internal val Boolean.dynamoBoolean get() = AttributeValue.builder().bool(this).build()

/**
 * Converts a [Map] of [String] and [AttributeValue] to a Dynamo Map.
 */
internal val Map<String, AttributeValue>.dynamoMap get() = AttributeValue.builder().m(this).build()

/**
 * Returns a Null for Dynamo DB
 */
internal val dynamoNull get() = AttributeValue.builder().nul(true).build()

