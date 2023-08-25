package com.aseemsavio.dynamokt.codegen

import com.aseemsavio.dynamokt.utils.DynamoKtLogger
import com.aseemsavio.dynamokt.utils.variables
import javax.annotation.processing.ProcessingEnvironment
import javax.lang.model.element.TypeElement

/**
 * Main function to generate code for a type.
 */
internal fun <T : Annotation> dynamoKtCodegen(
    element: TypeElement,
    annotation: Class<T>,
    processingEnv: ProcessingEnvironment
) {
    DynamoKtLogger.info { "Code Generation started for ${element.simpleName}" }

    val variables = variables(
        element = element,
        processingEnv = processingEnv,
        annotation = annotation
    )
    DynamoKtLogger.info { "Variables in ${element.simpleName} are $variables" }

    DynamoKtLogger.info { "Code Generation completed successfully for ${element.simpleName}" }
}

