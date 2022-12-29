package asavio.dynamokt.services

import software.amazon.awssdk.services.dynamodb.model.AttributeValue
import software.amazon.awssdk.services.dynamodb.model.AttributeValue.Type.*

internal fun Map<String, AttributeValue>.toPureMap(): Map<String, Any?> = entries.associate {
    val value = it.value
    it.key to when (value.type()) {
        S -> value.s()
        N -> with(value.n()) {
            if (contains(".")) toDouble() else toLong()
        }

        M -> value.m().toPureMap()
        NUL -> null
        else -> null
    }
}
