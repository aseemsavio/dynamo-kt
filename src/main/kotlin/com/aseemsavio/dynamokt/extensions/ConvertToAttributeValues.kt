package com.aseemsavio.dynamokt.extensions

import software.amazon.awssdk.services.dynamodb.model.AttributeValue

/**
 * This property converts a nullable [String] to DynamoDb [AttributeValue].
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
val String?.attributeValue: AttributeValue
    get() = if (null != this) {
        AttributeValue.builder().s(this).build()
    } else {
        AttributeValue.builder().nul(true).build()
    }

/**
 * This property converts a nullable [Number] to DynamoDb [AttributeValue].
 * Here, the receiver can be any object that extends the class [Number]
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
val Number?.attributeValue: AttributeValue
    get() = if (null != this) {
        AttributeValue.builder().n(this.toString()).build()
    } else {
        AttributeValue.builder().nul(true).build()
    }

/**
 * This property converts a nullable [Boolean] to DynamoDb [AttributeValue].
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
val Boolean?.attributeValue: AttributeValue
    get() = if (null != this) {
        AttributeValue.builder().bool(this).build()
    } else {
        AttributeValue.builder().nul(true).build()
    }

/**
 * This function converts a nullable [Set] of non-nullable [Number]s to DynamoDb [AttributeValue].
 * Here, the receiver can be any object that extends the class [Number]
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
fun Set<Number>?.attributeValueForNumberSet(): AttributeValue =
    if (null != this) {
        AttributeValue.builder().ns(this.map { it.toString() }).build()
    } else {
        AttributeValue.builder().nul(true).build()
    }

/**
 * This function converts a nullable [Set] of non-nullable [String]s to DynamoDb [AttributeValue].
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
fun Set<String>?.attributeValueForStringSet(): AttributeValue =
    if (null != this) {
        AttributeValue.builder().ss(this).build()
    } else {
        AttributeValue.builder().nul(true).build()
    }

/**
 * This function converts a nullable [List] of non-nullable [Number]s to DynamoDb [AttributeValue].
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
fun List<String>?.attributeValueForStringList(): AttributeValue =
    if (null != this) {
        AttributeValue.builder().l(map { it.attributeValue }).build()
    } else {
        AttributeValue.builder().nul(true).build()
    }

/**
 * This function converts a nullable [List] of non-nullable [Number]s to DynamoDb [AttributeValue].
 * Here, the receiver can be any object that extends the class [Number]
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
fun List<Number>?.attributeValueForNumberList(): AttributeValue =
    if (null != this) {
        AttributeValue.builder().l(map { it.attributeValue }).build()
    } else {
        AttributeValue.builder().nul(true).build()
    }

/**
 * This function converts a nullable [List] of non-nullable [T]s to DynamoDb [AttributeValue].
 * The object [T] should be annotated with [DynamoKt].
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
fun <T> List<T>?.attributeValueForObjectList(attributeValue: T.() -> AttributeValue): AttributeValue =
    if (null != this) {
        AttributeValue.builder().l(map { it.attributeValue() }).build()
    } else {
        AttributeValue.builder().nul(true).build()
    }

/**
 * This property converts a nullable [AttributeMap] to DynamoDb [AttributeValue].
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
val AttributeMap?.attributeValue: AttributeValue
    get() = if (null != this) {
        AttributeValue.builder().m(this).build()
    } else {
        AttributeValue.builder().nul(true).build()
    }

/**
 * A [Map] of [String] and [AttributeValue] is called [AttributeMap]
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
typealias AttributeMap = Map<String, AttributeValue>
