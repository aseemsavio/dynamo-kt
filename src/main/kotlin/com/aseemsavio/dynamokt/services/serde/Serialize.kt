package com.aseemsavio.dynamokt.services.serde

import kotlinx.serialization.json.*
import software.amazon.awssdk.services.dynamodb.model.AttributeValue

/**
 * Converts a given Data Class into a format understood by Dynamo DB.
 */
inline fun <reified T> dynamoData(fn: () -> T) = fn().toDynamoMap()

inline fun <reified T> T.toDynamoMap(): Map<String, AttributeValue> {
    val json = Json { encodeDefaults = true }
    return jsonObjectToMap(json.encodeToJsonElement(this).jsonObject)
}

fun jsonObjectToMap(element: JsonObject): Map<String, AttributeValue> {
    return element.entries.associate {
        it.key to extractValue(it.value)
    }
}

private fun extractValue(element: JsonElement): AttributeValue {
    return when (element) {
        is JsonNull -> dynamoNull
        is JsonPrimitive -> if (element.content.all { char -> char.isDigit() }) element.content.dynamoNumber else element.content.dynamoString
        is JsonArray -> dynamoNull // todo edit
        is JsonObject -> jsonObjectToMap(element).dynamoMap
    }
}
