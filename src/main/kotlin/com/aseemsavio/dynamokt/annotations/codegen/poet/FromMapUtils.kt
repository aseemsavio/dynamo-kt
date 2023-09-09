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
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asNullableStringFrom")
            )

            false -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asStringFrom")
            )
        }

        "Int" -> when (prop.isNullable) {
            true -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asNullableIntegerFrom")
            )

            false -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asIntegerFrom")
            )
        }

        "Float" -> when (prop.isNullable) {
            true -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asNullableFloatFrom")
            )

            false -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asFloatFrom")
            )
        }

        "Double" -> when (prop.isNullable) {
            true -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asNullableDoubleFrom")
            )

            false -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asDoubleFrom")
            )
        }

        "Long" -> when (prop.isNullable) {
            true -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asNullableLongFrom")
            )

            false -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asLongFrom")
            )
        }

        "Boolean" -> when (prop.isNullable) {
            true -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asNullableBooleanFrom")
            )

            false -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asBooleanFrom")
            )
        }

        "List" -> when (prop.isNullable) {
            true -> when (prop.typeParameters.first().typeName) {
                "String" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asNullableStringListFrom")
                )

                "Int" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asNullableIntegerListFrom")
                )

                "Long" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asNullableLongListFrom")
                )

                "Float" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asNullableFloatListFrom")
                )

                "Double" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asNullableDoubleListFrom")
                )

                else -> addStatement(
                    "\t%N = \"%L\".%M(this) { to${prop.typeParameters.first().typeName}() },",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asNullableObjectListFrom")
                )
            }

            false -> when (prop.typeParameters.first().typeName) {
                "String" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asStringListFrom")
                )

                "Int" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asIntegerListFrom")
                )

                "Long" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asLongListFrom")
                )

                "Float" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asFloatListFrom")
                )

                "Double" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asDoubleListFrom")
                )

                else -> addStatement(
                    "\t%N = \"%L\".%M(this) { to${prop.typeParameters.first().typeName}() },",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asObjectListFrom")
                )
            }
        }

        "Set" -> when (prop.isNullable) {
            true -> when (prop.typeParameters.first().typeName) {
                "String" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asNullableStringSetFrom")
                )

                "Int" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asNullableIntegerSetFrom")
                )

                "Long" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asNullableLongSetFrom")
                )

                "Float" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asNullableFloatSetFrom")
                )

                "Double" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asNullableDoubleSetFrom")
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
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asStringSetFrom")
                )

                "Int" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asIntegerSetFrom")
                )

                "Long" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asLongSetFrom")
                )

                "Float" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asFloatSetFrom")
                )

                "Double" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asDoubleSetFrom")
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
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asNullableObjectFrom")
            )

            false -> addStatement(
                "\t%N = \"%L\".%M(this) { to${prop.type}() },",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asObjectFrom")
            )
        }
    }
}
