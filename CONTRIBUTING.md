# Contributing to [dynamokt]()

Thank you for your interest in contributing to [dynamokt](). We value the contributions of our community members and
appreciate your help in making our library even better.

## How to Contribute

To get started with contributing, please follow these steps:

1. **Fork the Repository**: Click the "Fork" button at the top right corner of the GitHub page to create your copy of
   the repository.
2. **Clone Your Fork**: Clone your forked repository to your local machine using Git:

```
git clone https://github.com/your-user-name/dynamokt.git
```

3. **Set Up Your Development Environment**: Ensure that you have a working Kotlin and Gradle environment. You can use
   IntelliJ IDEA or another IDE of your choice.
4. **Create a Branch**: Create a new branch for your contribution. Please use a descriptive name for your branch that
   reflects the nature of your work.

```
git checkout -b feature/your-feature-name
```

5. **Make Your Changes**: Make your code changes, add new features, or fix issues in your branch. Ensure that your code
   adheres to our coding standards.
6. **Write Tests**: If applicable, write tests for the changes you have made to ensure they are robust and won't
   introduce regressions.
7. **Ensure Build-ability**: Make sure to run [these](#some-tips-during-development) before you commit your changes.
   8**Commit Your Changes**: Commit your changes with a clear and concise commit message. Be sure to reference any
   relevant
   issues or pull requests.

```
git commit -m "Your descriptive commit message"
```

9**Push Your Changes**: Push your branch to your GitHub fork.

```
git push origin feature/your-feature-name
```

10. **Create a Pull Request**: Go to the main repository and click the "New Pull Request" button. Fill in the details
    about your
    changes, including a clear title and description.
11. **Code Review**: Your pull request will undergo code review from the maintainers. Be prepared to address any
    feedback or make necessary changes.

12. **Merge**: Once your pull request is approved, it will be merged into the main branch.

**Thank You**! Congratulations on your contribution! Your efforts help improve our library.

## Code of Conduct

Please note that this project has adopted a Code of Conduct. We expect all contributors to adhere to it. It ensures a
friendly and inclusive environment for everyone.

1. **Be Respectful** Treat everyone with kindness and respect, regardless of differences.
2. **Be Inclusive** Welcome diverse backgrounds and perspectives.
3. **Be Collaborative** Work together in a cooperative and inclusive manner.
4. **Be Mindful** Use respectful language and consider others' time and effort.

#### Unacceptable Behavior

Harassment, discrimination, hate speech, trolling, spam, and disruptive behavior are not tolerated.

#### Reporting Violations

Report violations to aseemsavio3@gmail.com. All reports will be kept confidential.

## Issue Tracker

If you don't know where to start or need assistance, check our issue tracker for open issues and discussions. Feel free
to participate in ongoing conversations or open new issues.

We appreciate your contributions, whether they are code, documentation improvements, bug reports, or feature requests.
Together, we can make [dynamokt]() even better!

Thank you for contributing to [dynamokt]()!

---

## Some Tips during Development

### Building the project:

```
./gradlew clean build --refresh-dependencies
```

### Testing the project:

```
./gradlew test
```

### Kt Lint Format Correction

```
./gradlew ktlintFormat
```

### Generating HTML Kotlin Documentation

```
./gradlew dokkaHtml
```
