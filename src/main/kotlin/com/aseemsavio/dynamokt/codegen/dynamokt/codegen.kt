package com.aseemsavio.dynamokt.codegen.dynamokt

import com.aseemsavio.dynamokt.annotations.DynamoKt
import com.aseemsavio.dynamokt.utils.DynamoKtLogger
import com.aseemsavio.dynamokt.utils.variables
import com.google.auto.service.AutoService
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.Processor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.SourceVersion
import javax.lang.model.element.ElementKind
import javax.lang.model.element.TypeElement

@AutoService(Processor::class)
class DynamoKtAnnotationProcessor : AbstractProcessor() {

    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latestSupported()
    }

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return mutableSetOf(DynamoKt::class.java.name)
    }

    override fun process(annotations: MutableSet<out TypeElement>?, roundEnv: RoundEnvironment?): Boolean {

        val annotatedElements = roundEnv?.getElementsAnnotatedWith(DynamoKt::class.java) ?: emptySet()

        annotatedElements
            .mapNotNull { element ->
                if (element.kind == ElementKind.CLASS) element as TypeElement else null
            }.forEach { element ->
                val variables = variables(
                    element = element,
                    processingEnv = processingEnv
                )
                DynamoKtLogger.info { "Variables: $variables" }
            }
        return true
    }
}
