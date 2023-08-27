package com.aseemsavio.dynamokt.annotations.visitors

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSVisitorVoid

class DynamoKtAnnotationVisitor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
) : KSVisitorVoid() {

    override fun visitClassDeclaration(classDeclaration: KSClassDeclaration, data: Unit) {
        val props = classDeclaration.getAllProperties().toList()
        logger.info("my props: ${props.map { it.simpleName.getShortName() to it.type.toString() }}")
    }

}
