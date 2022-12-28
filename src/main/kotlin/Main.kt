import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.services.dynamodb.model.AttributeValue
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest
import java.lang.Exception


const val ACCESS = ""
const val SECRET = ""
fun main(args: Array<String>) {

    val client = DynamoDbClient.builder()
        .region(Region.US_EAST_1)
        .credentialsProvider(
            StaticCredentialsProvider.create(
                AwsBasicCredentials.create(
                    ACCESS,
                    SECRET
                )
            )
        ).build()

    val person = Person("askjdha", 26, "Aseem").toMap()
    client.save("person", person)
}

fun DynamoDbClient.save(tableName: String, map: Map<String, AttributeValue>): Boolean {
    val request = PutItemRequest.builder()
        .tableName(tableName)
        .item(map)
        .build()

    return try {
        putItem(request)
        true
    } catch (e: Exception) {
        println(e)
        false
    }
}

fun <T : Any> T.dict(): Map<String, Any> {

    return mapOf()
}

@Serializable
data class Person(
    val uuid: String,
    val age: Int,
    val name: String,
)


inline fun <reified T> T.toMap(): Map<String, AttributeValue> {
    val JSON = Json { encodeDefaults = true }
    return jsonObjectToMap(JSON.encodeToJsonElement(this).jsonObject)
}

fun jsonObjectToMap(element: JsonObject): Map<String, AttributeValue> {
    return element.entries.associate {
        it.key to when(extractValue(it.value)) {
            is String -> it.value.toString().s
            is Int -> it.value.toString().s
            else -> it.value.toString().s
        }
    }
}

private fun extractValue(element: JsonElement): Any? {
    return when (element) {
        is JsonNull -> null
        is JsonPrimitive -> element.content
        is JsonArray -> element.map { extractValue(it) }
        is JsonObject -> jsonObjectToMap(element)
    }
}

val String.s get() = AttributeValue.builder().s(this).build()
val Int.s get() = AttributeValue.builder().s(this.toString()).build()


