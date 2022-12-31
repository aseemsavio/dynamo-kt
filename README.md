# dynamo-kt

[![](https://img.shields.io/badge/Author-Aseem%20Savio-blue.svg)](http://aseemsavio.com)
[![Awesome Kotlin Badge](https://kotlin.link/awesome-kotlin.svg)](https://github.com/KotlinBy/awesome-kotlin)

This is a pure Kotlin functional library that lets users interact with AWS Dynamo DB with sweet 
Kotlin DSLs. As you might have guessed, this is a wrapper around the verbose [Java SDK for Dynamo DB](https://mvnrepository.com/artifact/software.amazon.awssdk/dynamodb).

#### Note:

This library does not use Kotlin Coroutines. 
This is intended to be used with JVM Virtual Threads ([Project Loom](https://openjdk.org/jeps/425)).
I hope, by the time this library becomes stable, Kotlin will get Loom support.

## How to get started?

I assume you have your AWS side of things all sorted out. Then, fire up Intellij Idea (or any of your favorite IDE).

We start by creating a `Client` object using the `dynamoClient` closure like so. It's that easy.

```kotlin
     val client = dynamoClient {
        accessKey = "YOUR_ACCESS_KEY"
        secretKey = "YOUR_SECRET_KEY"
        region = "us-east-1"
    }
```

Once we have the client object, we can create/update, find, and delete records from Dynamo DB tables.

The library requires the data classes be annotated by `Serializable` like so:

```kotlin

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
```

Now that we have our data classes ready, we can roll.

### Create or Update

```kotlin
    val person = Person(
        uuid = UUID.randomUUID().toString(),
        age = 25,
        name = "Aseem Savio",
        address = Address(
            street = "Marthandam",
            city = "Kanyakumari",
            zip = 111
        )
    )

    val written: Boolean = client.save {
        table = "person"
        data = dynamoData {
            person
        }
    }

    println("Written to Dynamo? $written")
```

### Find

```kotlin
    val personFound: Person = client.find<Person> {
        table = "person"
        by = filter(
            "uuid" to "03b73fb6-c723-4884-a349-934c3d82cb4f",
            "age" to 25
        )
    }

    println(personFound)
```

### Delete

```kotlin
    val deleted: Boolean = client.remove {
        table = "person"
        by = filter(
            "uuid" to "03b73fb6-c723-4884-a349-934c3d82cb4f",
            "age" to 25
        )
    }

    println(deleted)
```

#### Disclaimer: 

This library is not production ready yet, and is a work in progress. Feel free to open issues and send PRs my way.

