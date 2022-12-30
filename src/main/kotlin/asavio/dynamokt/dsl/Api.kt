package asavio.dynamokt.dsl

import asavio.dynamokt.services.Client
import asavio.dynamokt.services.DynamoDbClientBuilder
import asavio.dynamokt.services.crud.CreateBuilder

/**
 * This DSL creates a DynamoDB [Client] object. Accepts accessKey, secretKey and region.
 * The returned client object can be used to make further operations on.
 *
 * Example Usage:
 * ```
 * val client = dynamoClient {
 *     accessKey = "YOUR_ACCESS_KEY"
 *     secretKey = "YOUR_SECRET_KEY"
 *     region = "us-east-1"
 * }
 * ```
 */
fun dynamoClient(fn: DynamoDbClientBuilder.() -> Unit): Client = DynamoDbClientBuilder().apply(fn).build()

/**
 * The [save] closure can be called on the [Client] object. It can be used to save (create and update) objects.
 * The data classes used should be annotated with [Serializable].
 *
 * Example Usage:
 * ```
 *      @Serializable
 *      data class Person(
 *          val uuid: String,
 *          val age: Int,
 *          val name: String,
 *          val address: Address
 *      )
 *
 *      @Serializable
 *      data class Address(
 *          val street: String,
 *          val city: String,
 *          val zip: Int? = null
 *      )
 *
 *      val person = Person(
 *         uuid = UUID.randomUUID().toString(),
 *         age = 25,
 *         name = "Aseem",
 *         address = Address(
 *             street = "Vencode",
 *             city = "Kanyakumari",
 *             zip = 111
 *         )
 *     )
 *
 *     val written = client.save {
 *         table = "person"
 *         data = dynamoData {
 *             person
 *         }
 *     }
 *
 *     println(written)
 * ```
 */
fun Client.save(fn: CreateBuilder.() -> Unit): Boolean = CreateBuilder(this).apply(fn).build()
