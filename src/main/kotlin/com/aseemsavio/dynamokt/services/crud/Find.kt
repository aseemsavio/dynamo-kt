package com.aseemsavio.dynamokt.services.crud

import com.aseemsavio.dynamokt.services.Client
import com.aseemsavio.dynamokt.services.serde.toJsonObject
import com.aseemsavio.dynamokt.services.serde.toPureMap
import kotlinx.serialization.json.JsonObject
import software.amazon.awssdk.services.dynamodb.model.AttributeValue
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest

class FindBuilder constructor(private val client: Client) {

    var table: String? = null
    var findBy: Map<String, AttributeValue>? = null

    fun build(): JsonObject? {

        check(table != null) { "Table name cannot be left empty. Please provide it in the DSL" }
        check(findBy != null) { "You should provide something to search by." }

        val request = GetItemRequest.builder()
            .key(findBy)
            .tableName(table)
            .build()

        return try {
            client.client.getItem(request).item().toPureMap().toJsonObject()
        } catch (e: Exception) {
            println(e)
            null
        }

    }

}