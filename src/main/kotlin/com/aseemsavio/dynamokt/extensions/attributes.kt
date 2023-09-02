package com.aseemsavio.dynamokt.extensions

import software.amazon.awssdk.services.dynamodb.model.AttributeValue

val String?.attributeValue: AttributeValue
    get() = if (null != this) AttributeValue.builder().s(this).build()
    else AttributeValue.builder().nul(true).build()

val Number?.attributeValue: AttributeValue
    get() = if (null != this) AttributeValue.builder().n(this.toString()).build()
    else AttributeValue.builder().nul(true).build()

val Boolean?.attributeValue: AttributeValue
    get() = if (null != this) AttributeValue.builder().bool(this).build()
    else AttributeValue.builder().nul(true).build()

fun Set<Number>?.attributeValueForNumberSet(): AttributeValue =
    if (null != this) AttributeValue.builder().ns(this.map { it.toString() }).build()
    else AttributeValue.builder().nul(true).build()

fun Set<String>?.attributeValueForStringSet(): AttributeValue =
    if (null != this) AttributeValue.builder().ss(this).build()
    else AttributeValue.builder().nul(true).build()

fun List<String>?.attributeValueForStringList(): AttributeValue =
    if (null != this) AttributeValue.builder().l(map { it.attributeValue }).build()
    else AttributeValue.builder().nul(true).build()

fun List<Number>?.attributeValueForNumberList(): AttributeValue =
    if (null != this) AttributeValue.builder().l(map { it.attributeValue }).build()
    else AttributeValue.builder().nul(true).build()

fun <T> List<T>?.attributeValueForObjectList(attributeValue: T.() -> AttributeValue): AttributeValue =
    if (null != this) AttributeValue.builder().l(map { it.attributeValue() }).build()
    else AttributeValue.builder().nul(true).build()

val AttributeMap?.attributeValue: AttributeValue
    get() = if (null != this) AttributeValue.builder().m(this).build()
    else AttributeValue.builder().nul(true).build()

typealias AttributeMap = Map<String, AttributeValue>
