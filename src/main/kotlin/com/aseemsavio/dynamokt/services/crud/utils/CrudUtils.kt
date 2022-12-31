package com.aseemsavio.dynamokt.services.crud.utils

import com.aseemsavio.dynamokt.services.serde.dynamoBoolean
import com.aseemsavio.dynamokt.services.serde.dynamoNull
import com.aseemsavio.dynamokt.services.serde.dynamoNumber
import com.aseemsavio.dynamokt.services.serde.dynamoString
import software.amazon.awssdk.services.dynamodb.model.AttributeValue

/**
 * This function accepts key value pairs of record names and values to search by.
 *
 * Example:
 * ```
 * findBy(
 *     "uuid" to "03b73fb6-c723-4884-a349-934c3d82cb4f",
 *     "age" to 25
 * )
 *``` */
fun filter(vararg pairs: Pair<String, Any>): Map<String, AttributeValue> = pairs.associate {
    val value = it.second
    it.first to when (value) {
        is Int -> value.dynamoNumber
        is String -> value.dynamoString
        is Boolean -> value.dynamoBoolean
        else -> dynamoNull
    }
}
