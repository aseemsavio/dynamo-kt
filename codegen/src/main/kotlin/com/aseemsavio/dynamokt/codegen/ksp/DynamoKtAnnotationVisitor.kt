package com.aseemsavio.dynamokt.codegen.ksp

import com.aseemsavio.dynamokt.codegen.poet.generateAwsSdkCode
import com.aseemsavio.dynamokt.codegen.preparation.dataClassInfo
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSVisitorVoid

internal class DynamoKtAnnotationVisitor(
    private val codeGenerator: CodeGenerator,
    private val format: DynamoKtOutputSdkFormat,
    private val logger: KSPLogger
) : KSVisitorVoid() {

    override fun visitClassDeclaration(classDeclaration: KSClassDeclaration, data: Unit) {
        val dataClassInfo = classDeclaration.dataClassInfo

        when (format) {
            DynamoKtOutputSdkFormat.JavaV1 -> generateAwsSdkCode(
                packageName = "com.aseemsavio.dynamokt.extensions.java.v1",
                dataClassInfo = dataClassInfo,
                classDeclaration = classDeclaration,
                codeGenerator = codeGenerator,
                logger = logger
            )

            DynamoKtOutputSdkFormat.JavaV2 -> generateAwsSdkCode(
                packageName = "com.aseemsavio.dynamokt.extensions.java.v2",
                dataClassInfo = dataClassInfo,
                classDeclaration = classDeclaration,
                codeGenerator = codeGenerator,
                logger = logger
            )

            DynamoKtOutputSdkFormat.Kotlin -> generateAwsSdkCode(
                packageName = "com.aseemsavio.dynamokt.extensions.kotlin",
                dataClassInfo = dataClassInfo,
                classDeclaration = classDeclaration,
                codeGenerator = codeGenerator,
                logger = logger
            )
        }

        logger.info("Information about the parsed data class: $dataClassInfo")
    }
}
