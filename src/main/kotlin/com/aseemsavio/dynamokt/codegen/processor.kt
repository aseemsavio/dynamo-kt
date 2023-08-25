package com.aseemsavio.dynamokt.codegen

import com.aseemsavio.dynamokt.annotations.DynamoKt
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

        /* Get Elements annotated with [DynamoKt] annotation */
        roundEnv?.getElementsAnnotatedWith(DynamoKt::class.java)

        return true
    }

}
