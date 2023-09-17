package com.aseemsavio.dynamokt.codegen.ksp

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.validate

internal class DynamoKtAnnotationProcessor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
) : SymbolProcessor {
    override fun process(resolver: Resolver): List<KSAnnotated> {
        logger.info("KSP doing its job...")
        val symbols = resolver.dynamoKtSymbols()
        symbols?.symbols?.let { symbol ->
            symbol.filter {
                it is KSClassDeclaration && it.validate()
            }.forEach {
                it.accept(
                    DynamoKtAnnotationVisitor(
                        codeGenerator = codeGenerator,
                        format = symbols.type,
                        logger = logger
                    ),
                    Unit
                )
            }
        }
        return symbols?.symbols?.filter { !it.validate() }?.toList() ?: emptyList()
    }
}
