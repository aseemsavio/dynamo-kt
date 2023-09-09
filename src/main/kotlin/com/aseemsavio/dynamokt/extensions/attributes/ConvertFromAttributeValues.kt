package com.aseemsavio.dynamokt.extensions.attributes

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a [String]
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asStringFrom(map: AttributeMap): String = map[this]!!.s()

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a nullable [String]
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asNullableStringFrom(map: AttributeMap): String? = map[this]?.s()

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a [Int]
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asIntegerFrom(map: AttributeMap): Int = map[this]!!.n().toInt()

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a nullable [Int]
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asNullableIntegerFrom(map: AttributeMap): Int? = map[this]?.n()?.toInt()

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a [Float]
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asFloatFrom(map: AttributeMap): Float = map[this]!!.n().toFloat()

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a nullable [Float]
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asNullableFloatFrom(map: AttributeMap): Float? = map[this]?.n()?.toFloat()

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a [Double]
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asDoubleFrom(map: AttributeMap): Double = map[this]!!.n().toDouble()

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a nullable [Double]
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asNullableDoubleFrom(map: AttributeMap): Double? = map[this]?.n()?.toDouble()

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a [Long]
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asLongFrom(map: AttributeMap): Long = map[this]!!.n().toLong()

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a nullable [Long]
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asNullableLongFrom(map: AttributeMap): Long? = map[this]?.n()?.toLong()

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a [Boolean]
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asBooleanFrom(map: AttributeMap): Boolean = map[this]!!.bool()

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a nullable [Boolean]
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asNullableBooleanFrom(map: AttributeMap): Boolean? = map[this]?.bool()

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a [List] of [String]s
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asStringListFrom(map: AttributeMap): List<String> = map[this]!!.l().map { it.s() }

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a nullable [List] of [String]s
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asNullableStringListFrom(map: AttributeMap): List<String>? = map[this]?.l()?.map { it.s() }

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a [List] of [Int]s
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asIntegerListFrom(map: AttributeMap): List<Int> = map[this]!!.l().map { it.n().toInt() }

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a nullable [List] of [Int]s
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asNullableIntegerListFrom(map: AttributeMap): List<Int>? = map[this]?.l()?.map { it.n().toInt() }

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a [List] of [Long]s
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asLongListFrom(map: AttributeMap): List<Long> = map[this]!!.l().map { it.n().toLong() }

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a nullable [List] of [Long]s
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asNullableLongListFrom(map: AttributeMap): List<Long>? = map[this]?.l()?.map { it.n().toLong() }

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a [List] of [Float]s
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asFloatListFrom(map: AttributeMap): List<Float> = map[this]!!.l().map { it.n().toFloat() }

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a nullable [List] of [Float]s
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asNullableFloatListFrom(map: AttributeMap): List<Float>? =
    map[this]?.l()?.map { it.n().toFloat() }

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a [List] of [Double]s
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asDoubleListFrom(map: AttributeMap): List<Double> = map[this]!!.l().map { it.n().toDouble() }

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a nullable [List] of [Double]s
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asNullableDoubleListFrom(map: AttributeMap): List<Double>? =
    map[this]?.l()?.map { it.n().toDouble() }

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a [List] of [T]s
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
inline fun <T> PropertyName.asObjectListFrom(map: AttributeMap, objConverter: AttributeMap.() -> T): List<T> =
    map[this]!!.l().map { it.m().objConverter() }

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a nullable [List] of [T]s
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
inline fun <T> PropertyName.asNullableObjectListFrom(map: AttributeMap, objConverter: AttributeMap.() -> T): List<T>? =
    map[this]?.l()?.map { it.m().objConverter() }

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a [Set] of [String]s
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asStringSetFrom(map: AttributeMap): Set<String> = map[this]!!.ss().toSet()

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a nullable [Set] of [String]s
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asNullableStringSetFrom(map: AttributeMap): Set<String>? = map[this]?.ss()?.toSet()

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a [Set] of [Int]s
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asIntegerSetFrom(map: AttributeMap): Set<Int> = map[this]!!.ns().map { it.toInt() }.toSet()

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a nullable [Set] of [Int]s
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asNullableIntegerSetFrom(map: AttributeMap): Set<Int>? =
    map[this]?.ns()?.map { it.toInt() }?.toSet()

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a [Set] of [Long]s
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asLongSetFrom(map: AttributeMap): Set<Long> = map[this]!!.ns().map { it.toLong() }.toSet()

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a nullable [Set] of [Long]s
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asNullableLongSetFrom(map: AttributeMap): Set<Long>? =
    map[this]?.ns()?.map { it.toLong() }?.toSet()

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a [Set] of [Float]s
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asFloatSetFrom(map: AttributeMap): Set<Float> = map[this]!!.ns().map { it.toFloat() }.toSet()

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a nullable [Set] of [Float]s
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asNullableFloatSetFrom(map: AttributeMap): Set<Float>? =
    map[this]?.ns()?.map { it.toFloat() }?.toSet()

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a [Set] of [Double]s
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asDoubleSetFrom(map: AttributeMap): Set<Double> = map[this]!!.ns().map { it.toDouble() }.toSet()

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a nullable [Set] of [Double]s
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
infix fun PropertyName.asNullableDoubleSetFrom(map: AttributeMap): Set<Double>? =
    map[this]?.ns()?.map { it.toDouble() }?.toSet()

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a [T]
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
inline fun <T> PropertyName.asObjectFrom(map: AttributeMap, objConverter: AttributeMap.() -> T): T =
    map[this]!!.m().objConverter()

/**
 * Extracts the value of [PropertyName] from the provided [AttributeMap] as a nullable [T]
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
inline fun <T> PropertyName.asNullableObjectFrom(map: AttributeMap, objConverter: AttributeMap.() -> T): T? =
    map[this]?.m()?.objConverter()

/**
 * A [PropertyName] is actually a [String]
 *
 * @author Aseem Savio
 * @since 0.0.1
 */
typealias PropertyName = String
