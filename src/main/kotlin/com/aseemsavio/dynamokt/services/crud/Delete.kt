package com.aseemsavio.dynamokt.services.crud

import com.aseemsavio.dynamokt.services.Client
import software.amazon.awssdk.services.dynamodb.model.AttributeValue
import software.amazon.awssdk.services.dynamodb.model.DeleteItemRequest


class RemoveBuilder constructor(private val client: Client) {

    var table: String? = null
    var by: Map<String, AttributeValue>? = null

    fun build(): Boolean {

        check(table != null) { "Table name cannot be left empty. Please provide it in the DSL" }
        check(by != null) { "You should provide something to delete by." }

        val request = DeleteItemRequest.builder()
            .tableName(table)
            .key(by)
            .build()

        return try {
            client.client.deleteItem(request)
            true
        } catch (e: Exception) {
            println(e)
            false
        }
    }
}