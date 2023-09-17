package com.aseemsavio.dynamokt.codegen.poet

import com.aseemsavio.dynamokt.codegen.preparation.KotlinDataClassInfo
import com.aseemsavio.dynamokt.codegen.preparation.KotlinProperty
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.MemberName

internal fun FunSpec.Builder.addPropertiesToMap(dataClassInfo: KotlinDataClassInfo, packageName: String) = apply {
    dataClassInfo.properties.forEach { addStatementAccordingToType(prop = it, packageName = packageName) }
}

internal fun FunSpec.Builder.addStatementAccordingToType(prop: KotlinProperty, packageName: String) = apply {
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
                packageName = packageName,
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
                        packageName = packageName,
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
                        packageName = packageName,
                        simpleName = "attributeValueForNumberList"
                    )
                )

                else -> addStatement(
                    format = if (prop.typeParameters.first().isNullable) "attributeMap[%S] = %N.%M { this?.toAttributeMap().%M }" else "attributeMap[%S] = %N.%M { this.toAttributeMap().%M }",
                    prop.name,
                    prop.name,
                    MemberName(
                        packageName = packageName,
                        simpleName = "attributeValueForObjectList"
                    ),
                    MemberName(
                        packageName = packageName,
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
                        packageName = packageName,
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
                        packageName = packageName,
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
                packageName = packageName,
                simpleName = "attributeValue"
            )
        )
    }
}
