package asavio.dynamokt.services.serde

import kotlinx.serialization.json.*
import software.amazon.awssdk.services.dynamodb.model.AttributeValue

internal inline fun <reified T> T.toDynamoMap(): Map<String, AttributeValue> {
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
        is JsonNull -> dynamoNull
        is JsonPrimitive -> if (element.content.all { char -> char.isDigit() }) element.content.dynamoNumber else element.content.dynamoString
        is JsonArray -> dynamoNull // todo edit
        is JsonObject -> jsonObjectToMap(element).dynamoMap
    }
}
