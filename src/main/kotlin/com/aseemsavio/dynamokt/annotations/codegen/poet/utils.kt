package com.aseemsavio.dynamokt.annotations.codegen.poet

import com.aseemsavio.dynamokt.annotations.codegen.KotlinDataClassInfo
import com.squareup.kotlinpoet.FunSpec

internal fun FunSpec.Builder.addPropertiesToMap(dataClassInfo: KotlinDataClassInfo): FunSpec.Builder = apply {
    dataClassInfo.properties.forEach { prop ->
        addStatement("attributeMap[\"${prop.name}\"] = ${prop.name}.attributeValue")
    }
}

