package com.aseemsavio.dynamokt.codegen.poet

import com.aseemsavio.dynamokt.codegen.preparation.KotlinDataClassInfo
import com.aseemsavio.dynamokt.codegen.preparation.KotlinProperty
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.MemberName

internal fun FunSpec.Builder.generateDataClassConstructionCode(
    dataClassInfo: KotlinDataClassInfo,
    packageName: String
) = apply {
    addStatement(" return %T(", ClassName(packageName = dataClassInfo.packageName, dataClassInfo.simpleName))
    dataClassInfo.properties.forEach { generateCodeForProperty(prop = it, packageName = packageName) }
    addStatement(")")
}

internal fun FunSpec.Builder.generateCodeForProperty(prop: KotlinProperty, packageName: String) = apply {
    when (prop.type) {
        "String" -> when (prop.isNullable) {
            true -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = packageName, "asNullableStringFrom")
            )

            false -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = packageName, "asStringFrom")
            )
        }

        "Int" -> when (prop.isNullable) {
            true -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = packageName, "asNullableIntegerFrom")
            )

            false -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = packageName, "asIntegerFrom")
            )
        }

        "Float" -> when (prop.isNullable) {
            true -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = packageName, "asNullableFloatFrom")
            )

            false -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = packageName, "asFloatFrom")
            )
        }

        "Double" -> when (prop.isNullable) {
            true -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = packageName, "asNullableDoubleFrom")
            )

            false -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = packageName, "asDoubleFrom")
            )
        }

        "Long" -> when (prop.isNullable) {
            true -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = packageName, "asNullableLongFrom")
            )

            false -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = packageName, "asLongFrom")
            )
        }

        "Boolean" -> when (prop.isNullable) {
            true -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = packageName, "asNullableBooleanFrom")
            )

            false -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = packageName, "asBooleanFrom")
            )
        }

        "List" -> when (prop.isNullable) {
            true -> when (prop.typeParameters.first().typeName) {
                "String" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(
                        packageName = packageName,
                        "asNullableStringListFrom"
                    )
                )

                "Int" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(
                        packageName = packageName,
                        "asNullableIntegerListFrom"
                    )
                )

                "Long" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = packageName, "asNullableLongListFrom")
                )

                "Float" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = packageName, "asNullableFloatListFrom")
                )

                "Double" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(
                        packageName = packageName,
                        "asNullableDoubleListFrom"
                    )
                )

                else -> addStatement(
                    "\t%N = \"%L\".%M(this) { to${prop.typeParameters.first().typeName}() },",
                    prop.name,
                    prop.name,
                    MemberName(
                        packageName = packageName,
                        "asNullableObjectListFrom"
                    )
                )
            }

            false -> when (prop.typeParameters.first().typeName) {
                "String" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = packageName, "asStringListFrom")
                )

                "Int" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = packageName, "asIntegerListFrom")
                )

                "Long" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = packageName, "asLongListFrom")
                )

                "Float" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = packageName, "asFloatListFrom")
                )

                "Double" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = packageName, "asDoubleListFrom")
                )

                else -> addStatement(
                    "\t%N = \"%L\".%M(this) { to${prop.typeParameters.first().typeName}() },",
                    prop.name,
                    prop.name,
                    MemberName(packageName = packageName, "asObjectListFrom")
                )
            }
        }

        "Set" -> when (prop.isNullable) {
            true -> when (prop.typeParameters.first().typeName) {
                "String" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = packageName, "asNullableStringSetFrom")
                )

                "Int" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(
                        packageName = packageName,
                        "asNullableIntegerSetFrom"
                    )
                )

                "Long" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = packageName, "asNullableLongSetFrom")
                )

                "Float" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = packageName, "asNullableFloatSetFrom")
                )

                "Double" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = packageName, "asNullableDoubleSetFrom")
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
                    MemberName(packageName = packageName, "asStringSetFrom")
                )

                "Int" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = packageName, "asIntegerSetFrom")
                )

                "Long" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = packageName, "asLongSetFrom")
                )

                "Float" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = packageName, "asFloatSetFrom")
                )

                "Double" -> addStatement(
                    "\t%N = \"%L\" %M this,",
                    prop.name,
                    prop.name,
                    MemberName(packageName = packageName, "asDoubleSetFrom")
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
                MemberName(packageName = packageName, "asNullableObjectFrom")
            )

            false -> addStatement(
                "\t%N = \"%L\".%M(this) { to${prop.type}() },",
                prop.name,
                prop.name,
                MemberName(packageName = packageName, "asObjectFrom")
            )
        }
    }
}
