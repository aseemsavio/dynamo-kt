package com.aseemsavio.dynamokt.codegen.ksp

import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider

internal class DynamoKtAnnotationProcessorProvider : SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor =
        DynamoKtAnnotationProcessor(
            codeGenerator = environment.codeGenerator,
            logger = environment.logger
        )
}

private fun hello1() {}
