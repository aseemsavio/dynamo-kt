package com.aseemsavio.dynamokt.annotations.codegen

internal data class KotlinDataClassInfo(
    val simpleName: String,
    val packageName: String,
    val properties: List<KotlinProperty>
)

internal data class KotlinProperty(
    val name: String,
    val type: String,
    val typeParameters: List<KotlinTypeParam>,
    val isNullable: Boolean,
)

internal data class KotlinTypeParam(
    val typeName: String,
    val packageName: String,
    val isNullable: Boolean
)
