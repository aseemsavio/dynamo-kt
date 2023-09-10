# dynamo-kt: Simplified DynamoDB Interactions for Kotlin

[![License](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)
[![Contributors](https://img.shields.io/github/contributors/aseemsavio/dynamo-kt)](https://github.com/aseemsavio/dynamo-kt/graphs/contributors)


Welcome to dynamo-kt – a Kotlin library that simplifies and enhances interactions with the official AWS DynamoDB SDK.
This library provides a set of extension functions, utility classes, and code generation capabilities to make working
with DynamoDB easier, more efficient, and more enjoyable for Kotlin developers.

## Features

* **Extension Functions**: Easily work with DynamoDB using Kotlin's concise and expressive syntax. We've added extension functions to the AWS SDK to streamline common operations.

* **Code Generation**: Say goodbye to boilerplate code when defining DynamoDB tables. dynamo-kt comes with code generation capabilities that automatically generate the necessary code for table definitions, so you can focus on your application logic.

* **Type Safety**: Benefit from Kotlin's type safety to ensure your DynamoDB interactions are free from runtime errors.

* **Open Source**: dynamo-kt is an open-source project released under the MIT License. Contributions and feedback are welcome!

## Getting Started

### Installation

You need Google's KSP plugin for code generation. It can be added to your project's `build.gradle.kts` as follows.

```kotlin
plugins {
    id("com.google.devtools.ksp") version "<kotlin_version-ksp_version>"
}
```
Note that the version of KSP is compatible with the version of Kotlin you're running.

```kotlin
dependencies {
    implementation("com.aseemsavio:dynamokt:<version>")
    ksp("com.aseemsavio:dynamokt:<version>")
}
```
### Documentation

For detailed documentation and examples, please visit our [documentation page.](https://aseemsavio.github.io/dynamo-kt/index.html).

### Contributing

Contributions to dynamo-kt are highly encouraged. Whether you want to report a bug, request a feature, or submit a pull request, we're open to collaboration. Please read our [Contribution Guidelines](CONTRIBUTING.md) for more information on how to get started.

### License

This project is licensed under the MIT License - see the LICENSE file for details.

### Acknowledgments

Special thanks to the AWS SDK team for their work on the official DynamoDB SDK.
We welcome contributions and feedback from the open-source community to make dynamo-kt even better!

