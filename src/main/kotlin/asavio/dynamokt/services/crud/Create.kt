package asavio.dynamokt.services.crud

import asavio.dynamokt.services.Client
import software.amazon.awssdk.services.dynamodb.model.AttributeValue
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest

class CreateBuilder constructor(private val client: Client) {
    var table: String? = null
    var data: Map<String, AttributeValue>? = null

    fun build(): Boolean {
        check(table != null) { "Table name cannot be left empty. Please provide it in the DSL" }
        check(data != null) { "Gimme something to write. You need to provide something to write to Dynamo." }

        val request = PutItemRequest.builder()
            .tableName(table)
            .item(data)
            .build()

        return try {
            client.client.putItem(request)
            true
        } catch (e: Exception) {
            println(e)
            false
        }
    }
}