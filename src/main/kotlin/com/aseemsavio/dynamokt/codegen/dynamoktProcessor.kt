package com.aseemsavio.dynamokt.codegen

import com.aseemsavio.dynamokt.annotations.DynamoKt
import com.aseemsavio.dynamokt.utils.DynamoKtLogger
import com.aseemsavio.dynamokt.utils.asTypeElementIfClass
import com.google.auto.service.AutoService
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.Processor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement

/**
 * This class identifies and processes the data class with
 */
@AutoService(Processor::class)
class DynamoKtAnnotationProcessor : AbstractProcessor() {

    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latestSupported()
    }

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return mutableSetOf(DynamoKt::class.java.name)
    }

    override fun process(annotations: MutableSet<out TypeElement>?, roundEnv: RoundEnvironment?): Boolean {

        /* Check if roundEnv is not null and proceed or exit. */
        if (null != roundEnv) {

            /* Get Elements annotated with [DynamoKt] annotation */
            val annotatedElements = roundEnv.getElementsAnnotatedWith(DynamoKt::class.java) ?: emptySet()

            /* Proceed with code generation only if there are annotated elements */
            if (annotatedElements.isNotEmpty()) {

                /* Filter only the class elements annotated by DynamoKt */
                annotatedElements.mapNotNull { element -> element.asTypeElementIfClass }

                    /* Generate code for each of them */
                    .forEach { annotatedElement ->
                        dynamoKtCodegen(
                            element = annotatedElement,
                            annotation = DynamoKt::class.java,
                            processingEnv = processingEnv
                        )
                    }
            } else {
                DynamoKtLogger.info { "Nothing is annotated with @DynamoKt. Not proceeding with code generation." }
            }
        } else {
            DynamoKtLogger.info { "RoundEnvironment is null. Not proceeding with code generation." }
        }
        return true
    }
}
