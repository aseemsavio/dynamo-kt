package com.aseemsavio.dynamokt.annotations.codegen.poet

import com.aseemsavio.dynamokt.annotations.codegen.KotlinDataClassInfo
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.ksp.writeTo

internal fun generateAttributeMapCode(
    dataClassInfo: KotlinDataClassInfo,
    classDeclaration: KSClassDeclaration,
    codeGenerator: CodeGenerator,
    logger: KSPLogger
) {
    FileSpec.builder(
        packageName = dataClassInfo.packageName,
        fileName = "${dataClassInfo.simpleName}Ext"
    ).addFunction(
        FunSpec.builder(
            name = "helloFunction"
        ).receiver(ClassName(packageName = dataClassInfo.packageName, dataClassInfo.simpleName))
            .returns(Int::class)
            .addCode(
                """
                    return 1
                """.trimIndent()
            )
            .build()
    ).build().writeTo(codeGenerator, aggregating = false).also {
        logger.info("Generated code for ${classDeclaration.simpleName.asString()}")
    }
}
