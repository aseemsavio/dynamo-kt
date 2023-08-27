package com.aseemsavio.dynamokt.annotations.codegen

import com.google.devtools.ksp.symbol.KSClassDeclaration

/**
 * Reads and registers the type information of a given data class
 */
internal val KSClassDeclaration.dataClassInfo: KotlinDataClassInfo
    get() {
        val properties = getAllProperties().map {
            KotlinProperty(
                name = it.simpleName.asString(),
                type = it.type.toString(),
                typeParameters = it.type.resolve().arguments.mapNotNull { tp ->
                    val typeName = tp.type?.resolve()?.declaration?.simpleName?.getShortName()

                    if (null != typeName) KotlinTypeParam(
                        typeName = typeName,
                        packageName = tp.type?.resolve()?.declaration?.packageName?.asString()!!,
                        isNullable = tp.type?.resolve()?.isMarkedNullable!!
                    ) else null
                },
                isNullable = it.type.resolve().isMarkedNullable
            )
        }.toList()

        return KotlinDataClassInfo(
            simpleName = simpleName.asString(),
            packageName = packageName.asString(),
            properties = properties
        )
    }
