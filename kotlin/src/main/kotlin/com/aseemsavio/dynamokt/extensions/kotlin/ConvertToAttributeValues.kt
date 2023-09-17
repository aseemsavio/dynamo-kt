package com.aseemsavio.dynamokt.extensions.kotlin

import aws.sdk.kotlin.services.dynamodb.model.AttributeValue

/**
 * This property converts a nullable [String] to DynamoDb [DynamoAttributeValue].
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
val String?.attributeValue: DynamoAttributeValue
    get() = if (null != this) {
        AttributeValue.S(this)
    } else {
        AttributeValue.Null(true)
    }

/**
 * This property converts a nullable [Number] to DynamoDb [DynamoAttributeValue].
 * Here, the receiver can be any object that extends the class [Number]
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
val Number?.attributeValue: DynamoAttributeValue
    get() = if (null != this) {
        AttributeValue.N(this.toString())
    } else {
        AttributeValue.Null(true)
    }

/**
 * This property converts a nullable [Boolean] to DynamoDb [DynamoAttributeValue].
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
val Boolean?.attributeValue: DynamoAttributeValue
    get() = if (null != this) {
        AttributeValue.Bool(this)
    } else {
        AttributeValue.Null(true)
    }

/**
 * This function converts a nullable [Set] of non-nullable [Number]s to DynamoDb [DynamoAttributeValue].
 * Here, the receiver can be any object that extends the class [Number]
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
fun Set<Number>?.attributeValueForNumberSet(): DynamoAttributeValue =
    if (null != this) {
        AttributeValue.Ns(this.map { it.toString() })
    } else {
        AttributeValue.Null(true)
    }

/**
 * This function converts a nullable [Set] of non-nullable [String]s to DynamoDb [DynamoAttributeValue].
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
fun Set<String>?.attributeValueForStringSet(): DynamoAttributeValue =
    if (null != this) {
        AttributeValue.Ss(this.toList())
    } else {
        AttributeValue.Null(true)
    }

/**
 * This function converts a nullable [List] of non-nullable [Number]s to DynamoDb [DynamoAttributeValue].
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
fun List<String>?.attributeValueForStringList(): DynamoAttributeValue =
    if (null != this) {
        AttributeValue.L(map { it.attributeValue })
    } else {
        AttributeValue.Null(true)
    }

/**
 * This function converts a nullable [List] of non-nullable [Number]s to DynamoDb [DynamoAttributeValue].
 * Here, the receiver can be any object that extends the class [Number]
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
fun List<Number>?.attributeValueForNumberList(): DynamoAttributeValue =
    if (null != this) {
        AttributeValue.L(map { it.attributeValue })
    } else {
        AttributeValue.Null(true)
    }

/**
 * This function converts a nullable [List] of non-nullable [T]s to DynamoDb [DynamoAttributeValue].
 * The object [T] should be annotated with [DynamoKt].
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
fun <T> List<T>?.attributeValueForObjectList(attributeValue: T.() -> DynamoAttributeValue): DynamoAttributeValue =
    if (null != this) {
        AttributeValue.L(map { it.attributeValue() })
    } else {
        AttributeValue.Null(true)
    }

/**
 * This property converts a nullable [AttributeMap] to DynamoDb [DynamoAttributeValue].
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
val AttributeMap?.attributeValue: DynamoAttributeValue
    get() = if (null != this) {
        AttributeValue.M(this)
    } else {
        AttributeValue.Null(true)
    }

/**
 * A [Map] of [String] and [DynamoAttributeValue] is called [AttributeMap]
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
typealias AttributeMap = Map<String, DynamoAttributeValue>

/**
 * [DynamoAttributeValue] is the type alias for [AttributeValue] from AWS Dynamo DB v2 SDK.
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
typealias DynamoAttributeValue = AttributeValue
