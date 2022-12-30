import asavio.dynamokt.dsl.dynamoClient
import asavio.dynamokt.dsl.find
import asavio.dynamokt.dsl.save
import asavio.dynamokt.services.crud.findBy
import asavio.dynamokt.services.serde.*

import kotlinx.serialization.Serializable
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

    val personFound = client.find<Person> {
        table = "person"
        findBy = findBy(
            "uuid" to "03b73fb6-c723-4884-a349-934c3d82cb4f",
            "age" to 25
        )
    }

    println(personFound)
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

