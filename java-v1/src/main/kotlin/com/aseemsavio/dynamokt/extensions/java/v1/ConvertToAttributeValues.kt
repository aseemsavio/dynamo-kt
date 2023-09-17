package com.aseemsavio.dynamokt.extensions.java.v1

import com.amazonaws.services.dynamodbv2.model.AttributeValue

/**
 * This property converts a nullable [String] to DynamoDb [DynamoAttributeValue].
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
val String?.attributeValue: DynamoAttributeValue
    get() = if (null != this) {
        DynamoAttributeValue().withS(this)
    } else {
        DynamoAttributeValue().withNULL(true)
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
        DynamoAttributeValue().withN(this.toString())
    } else {
        DynamoAttributeValue().withNULL(true)
    }

/**
 * This property converts a nullable [Boolean] to DynamoDb [DynamoAttributeValue].
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
val Boolean?.attributeValue: DynamoAttributeValue
    get() = if (null != this) {
        DynamoAttributeValue().withBOOL(this)
    } else {
        DynamoAttributeValue().withNULL(true)
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
        DynamoAttributeValue().withNS(this.map { it.toString() })
    } else {
        DynamoAttributeValue().withNULL(true)
    }

/**
 * This function converts a nullable [Set] of non-nullable [String]s to DynamoDb [DynamoAttributeValue].
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
fun Set<String>?.attributeValueForStringSet(): DynamoAttributeValue =
    if (null != this) {
        DynamoAttributeValue().withSS(this)
    } else {
        DynamoAttributeValue().withNULL(true)
    }

/**
 * This function converts a nullable [List] of non-nullable [Number]s to DynamoDb [DynamoAttributeValue].
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
fun List<String>?.attributeValueForStringList(): DynamoAttributeValue =
    if (null != this) {
        DynamoAttributeValue().withL(map { it.attributeValue })
    } else {
        DynamoAttributeValue().withNULL(true)
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
        DynamoAttributeValue().withL(map { it.attributeValue })
    } else {
        DynamoAttributeValue().withNULL(true)
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
        DynamoAttributeValue().withL(map { it.attributeValue() })
    } else {
        DynamoAttributeValue().withNULL(true)
    }

/**
 * This property converts a nullable [AttributeMap] to DynamoDb [DynamoAttributeValue].
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
val AttributeMap?.attributeValue: DynamoAttributeValue
    get() = if (null != this) {
        DynamoAttributeValue().withM(this)
    } else {
        DynamoAttributeValue().withNULL(true)
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
