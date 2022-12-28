package asavio.dynamokt.dsl

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient

fun dynamoClient(fn: DynamoDbClientBuilder.() -> Unit): Client = DynamoDbClientBuilder().apply(fn).build()

data class Client(val client: DynamoDbClient)

class DynamoDbClientBuilder {

    var region: String? = null
    var accessKey: String? = null
    var secretKey: String? = null

    fun build(): Client {
        check(region != null)
        check(accessKey != null)
        check(secretKey != null)
        return Client(
            DynamoDbClient.builder()
                .region(Region.of(region))
                .credentialsProvider(
                    StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey))
                ).build()
        )
    }
}


