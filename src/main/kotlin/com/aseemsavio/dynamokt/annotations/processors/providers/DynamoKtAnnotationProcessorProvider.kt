package com.aseemsavio.dynamokt.annotations.processors.providers

import com.aseemsavio.dynamokt.annotations.processors.DynamoKtAnnotationProcessor
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider

class DynamoKtAnnotationProcessorProvider : SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor =
        DynamoKtAnnotationProcessor(
            codeGenerator = environment.codeGenerator,
            logger = environment.logger
        )
}