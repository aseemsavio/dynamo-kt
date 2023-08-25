package com.aseemsavio.dynamokt.annotations

/**
 * This annotation is meant to be applied only to (immutable) Kotlin data classes.
 * Upon building the project, dynamokt generates:
 * 1. An extension property named [attributeMap] with a receiver type of the data class.
 * This returns an attribute Map for Dynamo DB.
 * 2. An extension property named after the data class' name in camel case with a receiver type of the above
 * generated attribute map.
 *
 * Note: Please make sure to rebuild your project every time you make changes to the data classes annotated with
 * this annotation.
 */
@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.CLASS)
annotation class DynamoKt
