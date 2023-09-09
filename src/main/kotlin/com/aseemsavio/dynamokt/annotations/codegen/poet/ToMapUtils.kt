package com.aseemsavio.dynamokt.annotations.codegen.poet

import com.aseemsavio.dynamokt.annotations.codegen.KotlinDataClassInfo
import com.aseemsavio.dynamokt.annotations.codegen.KotlinProperty
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.MemberName

internal fun FunSpec.Builder.addPropertiesToMap(dataClassInfo: KotlinDataClassInfo) = apply {
    dataClassInfo.properties.forEach { addStatementAccordingToType(it) }
}

internal fun FunSpec.Builder.addStatementAccordingToType(prop: KotlinProperty) = apply {
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
            MemberName(
                packageName = "com.aseemsavio.dynamokt.extensions",
                simpleName = "attributeValue"
            )
        )

        "List" -> {
            when (prop.typeParameters.first().typeName) {
                "String" -> addStatement(
                    format = "attributeMap[%S] = %N.%M()",
                    prop.name,
                    prop.name,
                    MemberName(
                        packageName = "com.aseemsavio.dynamokt.extensions",
                        simpleName = "attributeValueForStringList"
                    )
                )

                in setOf(
                    "Int",
                    "Long",
                    "Float",
                    "Double",
                    "Number"
                ) -> addStatement(
                    format = "attributeMap[%S] = %N.%M()",
                    prop.name,
                    prop.name,
                    MemberName(
                        packageName = "com.aseemsavio.dynamokt.extensions",
                        simpleName = "attributeValueForNumberList"
                    )
                )

                else -> addStatement(
                    format = if (prop.typeParameters.first().isNullable) "attributeMap[%S] = %N.%M { this?.toAttributeMap().%M }" else "attributeMap[%S] = %N.%M { this.toAttributeMap().%M }",
                    prop.name,
                    prop.name,
                    MemberName(
                        packageName = "com.aseemsavio.dynamokt.extensions",
                        simpleName = "attributeValueForObjectList"
                    ),
                    MemberName(
                        packageName = "com.aseemsavio.dynamokt.extensions",
                        simpleName = "attributeValue"
                    )
                )
            }
        }

        "Set" -> {
            when (prop.typeParameters.first().typeName) {
                "String" -> addStatement(
                    format = "attributeMap[%S] = %N.%M()",
                    prop.name,
                    prop.name,
                    MemberName(
                        packageName = "com.aseemsavio.dynamokt.extensions",
                        simpleName = "attributeValueForStringSet"
                    )
                )

                in setOf(
                    "Int",
                    "Long",
                    "Float",
                    "Double",
                    "Number"
                ) -> addStatement(
                    format = "attributeMap[%S] = %N.%M()",
                    prop.name,
                    prop.name,
                    MemberName(
                        packageName = "com.aseemsavio.dynamokt.extensions",
                        simpleName = "attributeValueForNumberSet"
                    )
                )
            }
        }

        else -> addStatement(
            format = "attributeMap[%S] = %N.toAttributeMap().%M",
            prop.name,
            prop.name,
            MemberName(
                packageName = "com.aseemsavio.dynamokt.extensions",
                simpleName = "attributeValue"
            )
        )
    }
}
