package com.aseemsavio.dynamokt.codegen.ksp

import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSAnnotated

internal fun Resolver.dynamoKtSymbols(): KsAnnotatedEnriched? {
    val javaV1Symbols =
        com.aseemsavio.dynamokt.annotations.java.v1.DynamoKt::class.qualifiedName?.let { getSymbolsWithAnnotation(it) }
            ?.toList()

    val javaV2Symbols =
        com.aseemsavio.dynamokt.annotations.java.v2.DynamoKt::class.qualifiedName?.let { getSymbolsWithAnnotation(it) }
            ?.toList()

    val kotlinSymbols =
        com.aseemsavio.dynamokt.annotations.kotlin.DynamoKt::class.qualifiedName?.let { getSymbolsWithAnnotation(it) }
            ?.toList()

    /* Stream out the first one that is not null  */
    return if (!javaV1Symbols.isNullOrEmpty()) {
        KsAnnotatedEnriched(
            type = DynamoKtOutputSdkFormat.JavaV1,
            symbols = javaV1Symbols.asSequence()
        )
    } else if (!javaV2Symbols.isNullOrEmpty()) {
        KsAnnotatedEnriched(
            type = DynamoKtOutputSdkFormat.JavaV2,
            symbols = javaV2Symbols.asSequence()
        )
    } else if (!kotlinSymbols.isNullOrEmpty()) {
        KsAnnotatedEnriched(
            type = DynamoKtOutputSdkFormat.Kotlin,
            symbols = kotlinSymbols.asSequence()
        )
    } else {
        null
    }
}

internal enum class DynamoKtOutputSdkFormat {
    JavaV1,
    JavaV2,
    Kotlin
}

internal data class KsAnnotatedEnriched(
    val type: DynamoKtOutputSdkFormat,
    val symbols: Sequence<KSAnnotated>?
)
