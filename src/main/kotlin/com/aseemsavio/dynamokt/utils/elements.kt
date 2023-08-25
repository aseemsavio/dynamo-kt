package com.aseemsavio.dynamokt.utils

import javax.annotation.processing.ProcessingEnvironment
import javax.lang.model.element.Element
import javax.lang.model.element.ElementKind
import javax.lang.model.element.TypeElement
import javax.lang.model.element.VariableElement

/**
 * Returns an element as a [TypeElement] if the element is of kind [ElementKind.CLASS].
 */
internal val Element.asTypeElementIfClass: TypeElement?
    get() = if (kind != ElementKind.CLASS) {
        null
    } else {
        this as TypeElement
    }

/**
 * Gets all the variables in the elements
 */
internal fun <T : Annotation> variables(
    element: TypeElement,
    processingEnv: ProcessingEnvironment,
    annotation: Class<T>
) = element.enclosedElements
    .filterIsInstance<VariableElement>()
    .associate { variable ->
        val type = processingEnv.typeUtils.asElement(variable.asType()) as? TypeElement
        val hasAnnotation = type?.getAnnotation(annotation) != null
        variable.simpleName.toString() to type.takeIf { hasAnnotation }
    }