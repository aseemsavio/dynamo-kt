package asavio.dynamokt.services.serde

import kotlinx.serialization.json.*
import software.amazon.awssdk.services.dynamodb.model.AttributeValue
import software.amazon.awssdk.services.dynamodb.model.AttributeValue.Type.*

internal fun Map<String, AttributeValue>.toPureMap(): Map<String, Any?> = entries.associate {
    val value = it.value
    it.key to when (value.type()) {
        S -> value.s()
        N -> with(value.n()) {
            if (contains(".")) toDouble() else toLong()
        }

        BOOL -> value.bool()
        M -> value.m().toPureMap()
        NUL -> null
        else -> null
    }
}

internal fun Map<String, Any?>.toJsonObject(): JsonObject =
    buildJsonObject {
        entries.forEach { (k, v) ->
            when (v) {
                null -> put(k, null)
                is String -> put(k, v)
                is Int -> put(k, v)
                is Long -> put(k, v)
                is Double -> put(k, v)
                is Boolean -> put(k, v)
                is Map<*, *> -> put(k, (v as Map<String, Any?>).toJsonObject())
            }
        }
    }

internal inline fun <reified T : Any> JsonObject.toPojo(): T {
    val JSON = Json { encodeDefaults = true }
    return JSON.decodeFromJsonElement(this)
}


