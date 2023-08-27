package com.aseemsavio.dynamokt.annotations.processors

import com.aseemsavio.dynamokt.annotations.DynamoKt
import com.aseemsavio.dynamokt.annotations.processors.visitors.DynamoKtAnnotationVisitor
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.validate

class DynamoKtAnnotationProcessor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
) : SymbolProcessor {
    override fun process(resolver: Resolver): List<KSAnnotated> {
        logger.info("KSP Logging found")

        val symbols = DynamoKt::class.qualifiedName?.let {
            resolver.getSymbolsWithAnnotation(it)
        }

        symbols?.let { symbol ->
            symbol.filter {
                it is KSClassDeclaration && it.validate()
            }.forEach {
                it.accept(
                    DynamoKtAnnotationVisitor(
                        codeGenerator = codeGenerator,
                        logger = logger
                    ), Unit
                )
            }
        }
        return symbols?.filter { !it.validate() }?.toList() ?: emptyList()
    }
}
