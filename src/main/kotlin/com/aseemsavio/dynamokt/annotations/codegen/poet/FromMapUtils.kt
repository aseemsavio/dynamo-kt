package com.aseemsavio.dynamokt.annotations.codegen.poet

import com.aseemsavio.dynamokt.annotations.codegen.KotlinDataClassInfo
import com.aseemsavio.dynamokt.annotations.codegen.KotlinProperty
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.MemberName

internal fun FunSpec.Builder.generateDataClassConstructionCode(dataClassInfo: KotlinDataClassInfo) = apply {
    addStatement("%T(", ClassName(packageName = dataClassInfo.packageName, dataClassInfo.simpleName))
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
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asNullableStringFrom"),
            )

            false -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asStringFrom"),
            )
        }

        "Int" -> when (prop.isNullable) {
            true -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asNullableIntegerFrom"),
            )

            false -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asIntegerFrom"),
            )
        }

        "Float" -> when (prop.isNullable) {
            true -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asNullableFloatFrom"),
            )

            false -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asFloatFrom"),
            )
        }

        "Double" -> when (prop.isNullable) {
            true -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asNullableDoubleFrom"),
            )

            false -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asDoubleFrom"),
            )
        }

        "Long" -> when (prop.isNullable) {
            true -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asNullableLongFrom"),
            )

            false -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asLongFrom"),
            )
        }

        "Boolean" -> when (prop.isNullable) {
            true -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asNullableBooleanFrom"),
            )

            false -> addStatement(
                "\t%N = \"%L\" %M this,",
                prop.name,
                prop.name,
                MemberName(packageName = "com.aseemsavio.dynamokt.extensions", "asBooleanFrom"),
            )
        }



        else -> ""
    }
}
