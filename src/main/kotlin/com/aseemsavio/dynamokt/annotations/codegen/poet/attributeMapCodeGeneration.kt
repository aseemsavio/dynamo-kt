package com.aseemsavio.dynamokt.annotations.codegen.poet

import com.aseemsavio.dynamokt.annotations.codegen.KotlinDataClassInfo
import com.aseemsavio.dynamokt.extensions.attributeValue
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.asClassName
import com.squareup.kotlinpoet.asTypeName
import com.squareup.kotlinpoet.ksp.writeTo

internal fun generateAttributeMapCode(
    dataClassInfo: KotlinDataClassInfo,
    classDeclaration: KSClassDeclaration,
    codeGenerator: CodeGenerator,
    logger: KSPLogger
) {

    val mapType = Map::class.asClassName().parameterizedBy(String::class.asTypeName(), Any::class.asTypeName())


    FileSpec.builder(
        packageName = dataClassInfo.packageName,
        fileName = "${dataClassInfo.simpleName}Ext"
    )
        .addImport(packageName = "com.aseemsavio.dynamokt.extensions", "attributeValue")
        .addImport(packageName = "software.amazon.awssdk.services.dynamodb.model", "AttributeValue")

        .addFunction(
            FunSpec.builder(
                name = "toAttributeMap"
            ).receiver(ClassName(packageName = dataClassInfo.packageName, dataClassInfo.simpleName))

                .returns(mapType)
                .addStatement("val attributeMap = mutableMapOf<String, AttributeValue>()")
                .also { funSpec ->
                    dataClassInfo.properties.forEach { prop ->
                        funSpec/*.addStatement("attributeMap[%S] = %T", prop.name, prop.name.attributeValue)*/
                            .addStatement("attributeMap[\"${prop.name}\"] = ${prop.name}.attributeValue")

                        /*funSpec.addStatement("attributeMap[%S] = %T()", prop.name,
                            ClassName(dataClassInfo.packageName, prop.type)
                        )*/
                    }
                }
                // add other code here
                .addStatement("return attributeMap")
                /*.returns(Int::class)
                .addCode(
                    """
                        return 1
                    """.trimIndent()
                )*/
                .build()
        ).build().writeTo(codeGenerator, aggregating = false).also {
            logger.info("Generated code for ${classDeclaration.simpleName.asString()}")
        }
}
