package com.aseemsavio.dynamokt.annotations.codegen.poet

import com.aseemsavio.dynamokt.annotations.codegen.KotlinDataClassInfo
import com.aseemsavio.dynamokt.annotations.codegen.KotlinProperty
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.MemberName

internal fun FunSpec.Builder.addPropertiesToMap(dataClassInfo: KotlinDataClassInfo): FunSpec.Builder = apply {
    dataClassInfo.properties.forEach { addStatementAccordingToType(it) }
}

internal fun FunSpec.Builder.addStatementAccordingToType(prop: KotlinProperty): FunSpec.Builder = apply {
    when (prop.type) {
        in setOf(
            "String",
            "Int",
            "Long",
            "Boolean",
            "Float",
            "Double",
            "Number"
        ) -> addStatement(
            format = "attributeMap[%S] = %N.%M",
            prop.name,
            prop.name,
            MemberName(packageName = "com.aseemsavio.dynamokt.extensions", simpleName = "attributeValue")
        )

        "List" -> {

        }

        "Set" -> {
            when (prop.typeParameters.first().typeName) {
                "String" -> addStatement("attributeMap[\"${prop.name}\"] = ${prop.name}.stringSetAttributeValue()")
                in setOf(
                    "Int",
                    "Long",
                    "Float",
                    "Double",
                    "Number"
                ) -> addStatement("attributeMap[\"${prop.name}\"] = ${prop.name}.numberSetAttributeValue()")
            }
        }

        else -> addStatement("attributeMap[\"${prop.name}\"] = ${prop.name}.toAttributeMap().attributeValue")
    }

}


