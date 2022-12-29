import asavio.dynamokt.services.Client

import asavio.dynamokt.dsl.dynamoClient
import asavio.dynamokt.services.toMap
import kotlinx.serialization.Serializable
import software.amazon.awssdk.services.dynamodb.model.AttributeValue
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest
import java.lang.Exception


fun main(args: Array<String>) {

    /*val client = dynamoClient {
        accessKey = ""
        secretKey = ""
        region = "us-east-1"
    }*/

    val person = Person("jdhgsdjashgdsajhd", 26, "Aseem", Address("Vencode", "Kanyakumari")).toMap()

    print(person)
//client.save("person", person)
}

fun Client.save(tableName: String, map: Map<String, AttributeValue>): Boolean {
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
    val city: String

)




val String.s get() = AttributeValue.builder().s(this).build()
val Int.s get() = AttributeValue.builder().s(this.toString()).build()


