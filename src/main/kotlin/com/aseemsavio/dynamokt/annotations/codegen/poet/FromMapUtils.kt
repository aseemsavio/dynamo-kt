package com.aseemsavio.dynamokt.annotations.codegen.poet

import com.aseemsavio.dynamokt.annotations.codegen.KotlinDataClassInfo
import com.aseemsavio.dynamokt.annotations.codegen.KotlinProperty
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.MemberName

internal fun FunSpec.Builder.generateDataClassConstructionCode(dataClassInfo: KotlinDataClassInfo) = apply {
    addStatement(" return %T(", ClassName(packageName = dataClassInfo.packageName, dataClassInfo.simpleName))
    dataClassInfo.properties.forEach { generateCodeForProperty(it) }
    addStatement(")")
}

internal fun FunSpec.Builder.generateCodeForProperty(prop: KotlinProperty) = apply {
    when (prop.type) {
        "String" -> when (prop.isNullable) {
            true -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asNullableStringFrom")
            )

            false -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asStringFrom")
            )
        }

        "Int" -> when (prop.isNullable) {
            true -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asNullableIntegerFrom")
            )

            false -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asIntegerFrom")
            )
        }

        "Float" -> when (prop.isNullable) {
            true -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asNullableFloatFrom")
            )

            false -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asFloatFrom")
            )
        }

        "Double" -> when (prop.isNullable) {
            true -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asNullableDoubleFrom")
            )

            false -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asDoubleFrom")
            )
        }

        "Long" -> when (prop.isNullable) {
            true -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asNullableLongFrom")
            )

            false -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asLongFrom")
            )
        }

        "Boolean" -> when (prop.isNullable) {
            true -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asNullableBooleanFrom")
            )

            false -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asBooleanFrom")
            )
        }

        "List" -> when (prop.isNullable) {
            true -> when (prop.typeParameters.first().typeName) {
                "String" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asNullableStringListFrom")
                )

                "Int" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asNullableIntegerListFrom")
                )

                "Long" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asNullableLongListFrom")
                )

                "Float" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asNullableFloatListFrom")
                )

                "Double" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asNullableDoubleListFrom")
                )

                else -> addStatement(
                    "\t%N = \"%L\".%M(this) { to${prop.typeParameters.first().typeName}() },",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asNullableObjectListFrom")
                )
            }

            false -> when (prop.typeParameters.first().typeName) {
                "String" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asStringListFrom")
                )

                "Int" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asIntegerListFrom")
                )

                "Long" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asLongListFrom")
                )

                "Float" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asFloatListFrom")
                )

                "Double" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asDoubleListFrom")
                )

                else -> addStatement(
                    "\t%N = \"%L\".%M(this) { to${prop.typeParameters.first().typeName}() },",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asObjectListFrom")
                )
            }
        }

        "Set" -> when (prop.isNullable) {
            true -> when (prop.typeParameters.first().typeName) {
                "String" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asNullableStringSetFrom")
                )

                "Int" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asNullableIntegerSetFrom")
                )

                "Long" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asNullableLongSetFrom")
                )

                "Float" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asNullableFloatSetFrom")
                )

                "Double" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asNullableDoubleSetFrom")
                )

                else -> {
                    error("A set of object is not supported by Dynamo DB.")
                }
            }

            false -> when (prop.typeParameters.first().typeName) {
                "String" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asStringSetFrom")
                )

                "Int" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asIntegerSetFrom")
                )

                "Long" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asLongSetFrom")
                )

                "Float" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asFloatSetFrom")
                )

                "Double" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asDoubleSetFrom")
                )

                else -> {
                    error("A set of object is not supported by Dynamo DB.")
                }
            }
        }

        else -> when (prop.isNullable) {
            true -> addStatement(
                "\t%N = \"%L\".%M(this) { to${prop.type}() },",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asNullableObjectFrom")
            )

            false -> addStatement(
                "\t%N = \"%L\".%M(this) { to${prop.type}() },",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions.attributes", "asObjectFrom")
            )
        }
    }
}
