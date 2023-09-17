package com.aseemsavio.dynamokt.annotations.kotlin

/**
 * An annotation used to generate extension functions for converting data classes to and from DynamoDB AttributeMaps.
 * Use this annotation on your data class to enable automatic generation of conversion functions.
 * This annotation generates code compatible with the Kotlin Amazon AWS SDK
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class DynamoKt
