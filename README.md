# dynamo-kt: Simplified DynamoDB Interactions for Kotlin

[![License](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)
[![Contributors](https://img.shields.io/github/contributors/aseemsavio/dynamo-kt)](https://github.com/aseemsavio/dynamo-kt/graphs/contributors)

Introducing `dynamo-kt`, your ticket to effortless DynamoDB mastery in Kotlin. Our powerful library simplifies and
elevates your interactions with the official AWS DynamoDB SDKs, effortlessly generating code for mapping your immutable
data classes into Attribute Maps across Java v1, v2, and Kotlin SDKs. With a wealth of extension functions and
properties at your fingertips, handling Attribute Values becomes a breeze. Dynamo-kt not only streamlines DynamoDB
operations but also injects an extra dose of efficiency and joy into your Kotlin development journey, making DynamoDB
not just easier but downright delightful for Kotlin aficionados. Welcome to a world of DynamoDB magic with `dynamo-kt`!

## Features

* 🚀 **Code Generation**: Say goodbye to manual mapping! `dynamo-kt` effortlessly generates the code
  needed to map your immutable data classes into Attribute Maps for the Java v1, v2, and Kotlin SDKs.

* 🎉 **Extension Magic**: We've sprinkled in a delightful set of extension functions and properties to make handling
  Attribute Values a breeze. It's like having DynamoDB superpowers at your fingertips!

* 💪🏼 **Efficiency Boost**: `dynamo-kt` is your trusty sidekick, streamlining your DynamoDB workflow. You'll be amazed at
  how
  efficiently you can work with DynamoDB using our library.

* **Open Source**: `dynamo-kt` is an open-source project released under the MIT License. Contributions and feedback are
  welcome!

## Getting Started

### Installation

You need Google's KSP plugin for code generation. It can be added to your project's `build.gradle.kts` as follows. Note
that the version of KSP is compatible with the version of Kotlin you're running.

```kotlin
plugins {
    id("com.google.devtools.ksp") version "<kotlin_version-ksp_version>"
}
```

To unlock the full potential of `dynakoKt`'s code generation prowess, you'll first want to incorporate the `codegen`
module within `ksp`. Once you've accomplished this crucial step, you can then choose from among these specialized
modules to harness support for the AWS SDKs you require: Opt for `java-v1` to embrace the capabilities of the v1 Java
SDK, opt for `java-v2` to harness the prowess of the v2 Java SDK, or select `kotlin` to tap into the rich
functionalities of the Kotlin SDK.

```kotlin
dependencies {
    ksp("com.aseemsavio.dynamokt:codegen:<version>")
    implementation("com.aseemsavio.dynamokt:<module>:<version>")
}
```

Now, all that's left for you to do is to annotate your data classes with one of the available `@DynamoKt` annotations,
each tailored to a specific AWS SDK as discussed above. As soon as you build your application using
the `./gradlew clean build` command, the library will work its magic, and generates an extension function
named `toAttributeMap()`, with your data class as the receiver, returning an Attribute Map compatible with your chosen
AWS SDK. That's not all – it also generates another extension function following the format `to<data-class-name>()`, 
effortlessly facilitating the conversion from an AWS Attribute Map back into your data class. 
It's as seamless as DynamoDB mapping can get!

Here's an example:
```kotlin
@DynamoKt
data class Dog(
    val name: String,
    val age: Int,
    val favoriteFood: String?,
    val owner: Owner
)

@DynamoKt
data class Owner(
    val name: String,
    val city: String
)

```

### Documentation

For detailed documentation and examples, please visit
our [documentation page.](https://aseemsavio.github.io/dynamo-kt/index.html).

### Contributing

Contributions to dynamo-kt are highly encouraged. Whether you want to report a bug, request a feature, or submit a pull
request, we're open to collaboration. Please read our [Contribution Guidelines](CONTRIBUTING.md) for more information on
how to get started.

### License

This project is licensed under the MIT License - see the LICENSE file for details.

### Acknowledgments

Special thanks to the AWS SDK team for their work on the official DynamoDB SDK.
We welcome contributions and feedback from the open-source community to make dynamo-kt even better!
