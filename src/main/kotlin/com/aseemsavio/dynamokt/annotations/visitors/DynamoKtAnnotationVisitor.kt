package com.aseemsavio.dynamokt.annotations.visitors

import com.aseemsavio.dynamokt.annotations.codegen.dataClassInfo
import com.aseemsavio.dynamokt.annotations.codegen.poet.generateAttributeMapCode
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSVisitorVoid

class DynamoKtAnnotationVisitor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
) : KSVisitorVoid() {

    override fun visitClassDeclaration(classDeclaration: KSClassDeclaration, data: Unit) {
        val dataClassInfo = classDeclaration.dataClassInfo

        generateAttributeMapCode(
            dataClassInfo = dataClassInfo,
            classDeclaration = classDeclaration,
            codeGenerator = codeGenerator,
            logger = logger
        )

        logger.info("data class info: $dataClassInfo")
    }
}
