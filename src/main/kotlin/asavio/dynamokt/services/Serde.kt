package asavio.dynamokt.services

import kotlinx.serialization.json.*
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


internal inline fun <reified T> T.toMap(): Map<String, AttributeValue> {
    val JSON = Json { encodeDefaults = true }
    return jsonObjectToMap(JSON.encodeToJsonElement(this).jsonObject)
}

internal fun jsonObjectToMap(element: JsonObject): Map<String, AttributeValue> {
    return element.entries.associate {
        it.key to extractValue(it.value)
    }
}

private fun extractValue(element: JsonElement): AttributeValue {
    return when (element) {
        is JsonNull -> AttributeValue.builder().nul(true).build()
        is JsonPrimitive -> if (element.content.all { char -> char.isDigit() }) element.content.dynamoNumber else element.content.dynamoString
        is JsonArray -> AttributeValue.builder().nul(true).build() // todo edit
        is JsonObject -> AttributeValue.builder().nul(true).build() // todo edit
        //is JsonObject -> jsonObjectToMap(element)
    }
}


