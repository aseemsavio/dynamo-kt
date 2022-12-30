import asavio.dynamokt.dsl.dynamoClient
import asavio.dynamokt.dsl.save
import asavio.dynamokt.services.Client
import asavio.dynamokt.services.serde.*

import kotlinx.serialization.Serializable
import software.amazon.awssdk.services.dynamodb.model.AttributeValue
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest
import java.util.UUID


fun main(args: Array<String>) {

    val client = dynamoClient {
        accessKey = ""
        secretKey = ""
        region = "us-east-1"
    }

    val person = Person(
        uuid = UUID.randomUUID().toString(),
        age = 25,
        name = "Aseem",
        address = Address(
            street = "Vencode",
            city = "Kanyakumari",
            zip = 111
        )
    )

    val written = client.save {
        table = "person"
        data = dynamoData {
            person
        }
    }

    println(written)

    //client.save("person", person)

    /*val findRes = client.find(
        "person", mapOf(
            "uuid" to "asd".dynamoString,
            "age" to 25.dynamoNumber
        )
    )

    println(findRes)
    println(findRes.toPureMap().toJsonObject().toPojo<Person>())*/

    /*val map = mapOf(
        "uuid" to "agsdjhdg",
        "age" to 26,
        "name" to "Aseem",
        "address" to mapOf(
            "city" to "Chennai",
            "street" to "street1",
            "zip" to 12345
        )
    )

    println(map.toJsonObject().toPojo<Person>())*/

}

/*fun Client.save(tableName: String, map: Map<String, AttributeValue>): Boolean {
    val request = PutItemRequest.builder()
        .tableName(tableName)
        .item(map)
        .build()

    return try {
        val resp = client.putItem(request)
        print(resp.attributes())
        true
    } catch (e: Exception) {
        println(e)
        false
    }
}*/

fun Client.find(tableName: String, findBy: Map<String, AttributeValue>): Map<String, AttributeValue> {
    val request = GetItemRequest.builder()
        .key(findBy)
        .tableName(tableName)
        .build()
    return try {
        client.getItem(request).item()
    } catch (e: Exception) {
        println(e)
        emptyMap()
    }
}

@Serializable
data class Person(
    val uuid: String,
    val age: Int,
    val name: String,
    val address: Address
)

@Serializable
data class Address(
    val street: String,
    val city: String,
    val zip: Int? = null
)

