package com.aseemsavio.dynamokt.utils

import javax.annotation.processing.ProcessingEnvironment
import javax.lang.model.element.TypeElement
import javax.lang.model.element.VariableElement
import javax.lang.model.type.DeclaredType
import javax.lang.model.type.TypeMirror


/**
 * Gets all the variables in the elements
 */
internal fun variables(
    element: TypeElement,
    processingEnv: ProcessingEnvironment,
) = element.enclosedElements
    .filterIsInstance<VariableElement>()
    .map {
        javaType(
            variable = it,
            processingEnv = processingEnv
        )
    }

internal fun javaType(variable: VariableElement, processingEnv: ProcessingEnvironment): JvmTypeElement {
    val simpleName = variable.simpleName.toString()
    val type = typeElement(variable, processingEnv)
    return JvmTypeElement(
        name = simpleName,
        fullyQualifiedType = type.first,
        typeArgument = type.second?.firstOrNull()
    )
}

internal fun typeElement(
    variable: VariableElement,
    processingEnv: ProcessingEnvironment
): Pair<TypeElement, List<TypeMirror>?> {
    val typeMirror = variable.asType()
    return if (typeMirror is DeclaredType) {
        Pair(typeMirror.asElement() as TypeElement, typeMirror.typeArguments)
    } else {
        Pair((processingEnv.typeUtils.asElement(typeMirror) as? TypeElement)!!, null)
    }
}

data class JvmTypeElement(
    val name: String,
    val fullyQualifiedType: TypeElement,
    val typeArgument: TypeMirror?
)
