package com.aseemsavio.dynamokt.extensions

infix fun String.asStringFrom(map: AttributeMap): String = map[this]!!.s()
infix fun String.asNullableStringFrom(map: AttributeMap): String? = map[this]?.s()
infix fun String.asIntegerFrom(map: AttributeMap): Int = map[this]!!.n().toInt()
infix fun String.asNullableIntegerFrom(map: AttributeMap): Int? = map[this]?.n()?.toInt()
infix fun String.asFloatFrom(map: AttributeMap): Float = map[this]!!.n().toFloat()
infix fun String.asNullableFloatFrom(map: AttributeMap): Float? = map[this]?.n()?.toFloat()
infix fun String.asDoubleFrom(map: AttributeMap): Double = map[this]!!.n().toDouble()
infix fun String.asNullableDoubleFrom(map: AttributeMap): Double? = map[this]?.n()?.toDouble()
infix fun String.asLongFrom(map: AttributeMap): Long = map[this]!!.n().toLong()
infix fun String.asNullableLongFrom(map: AttributeMap): Long? = map[this]?.n()?.toLong()
infix fun String.asBooleanFrom(map: AttributeMap): Boolean = map[this]!!.bool()
infix fun String.asNullableBooleanFrom(map: AttributeMap): Boolean? = map[this]?.bool()
infix fun String.asStringListFrom(map: AttributeMap): List<String> = map[this]!!.l().map { it.s() }
infix fun String.asNullableStringListFrom(map: AttributeMap): List<String>? = map[this]?.l()?.map { it.s() }
infix fun String.asIntegerListFrom(map: AttributeMap): List<Int> = map[this]!!.l().map { it.n().toInt() }
infix fun String.asNullableIntegerListFrom(map: AttributeMap): List<Int>? = map[this]?.l()?.map { it.n().toInt() }
infix fun String.asLongListFrom(map: AttributeMap): List<Long> = map[this]!!.l().map { it.n().toLong() }
infix fun String.asNullableLongListFrom(map: AttributeMap): List<Long>? = map[this]?.l()?.map { it.n().toLong() }
infix fun String.asFloatListFrom(map: AttributeMap): List<Float> = map[this]!!.l().map { it.n().toFloat() }
infix fun String.asNullableFloatListFrom(map: AttributeMap): List<Float>? = map[this]?.l()?.map { it.n().toFloat() }
infix fun String.asDoubleListFrom(map: AttributeMap): List<Double> = map[this]!!.l().map { it.n().toDouble() }
infix fun String.asNullableDoubleListFrom(map: AttributeMap): List<Double>? = map[this]?.l()?.map { it.n().toDouble() }
inline fun <T> String.asObjectListFrom(map: AttributeMap, objConverter: AttributeMap.() -> T): List<T> =
    map[this]!!.l().map { it.m().objConverter() }

inline fun <T> String.asNullableObjectListFrom(map: AttributeMap, objConverter: AttributeMap.() -> T): List<T>? =
    map[this]?.l()?.map { it.m().objConverter() }

infix fun String.asStringSetFrom(map: AttributeMap): Set<String> = map[this]!!.ss().toSet()
infix fun String.asNullableStringSetFrom(map: AttributeMap): Set<String>? = map[this]?.ss()?.toSet()
infix fun String.asIntegerSetFrom(map: AttributeMap): Set<Int> = map[this]!!.ns().map { it.toInt() }.toSet()
infix fun String.asNullableIntegerSetFrom(map: AttributeMap): Set<Int>? = map[this]?.ns()?.map { it.toInt() }?.toSet()
infix fun String.asLongSetFrom(map: AttributeMap): Set<Long> = map[this]!!.ns().map { it.toLong() }.toSet()
infix fun String.asNullableLongSetFrom(map: AttributeMap): Set<Long>? = map[this]?.ns()?.map { it.toLong() }?.toSet()
infix fun String.asFloatSetFrom(map: AttributeMap): Set<Float> = map[this]!!.ns().map { it.toFloat() }.toSet()
infix fun String.asNullableFloatSetFrom(map: AttributeMap): Set<Float>? =
    map[this]?.ns()?.map { it.toFloat() }?.toSet()

infix fun String.asDoubleSetFrom(map: AttributeMap): Set<Double> = map[this]!!.ns().map { it.toDouble() }.toSet()
infix fun String.asNullableDoubleSetFrom(map: AttributeMap): Set<Double>? =
    map[this]?.ns()?.map { it.toDouble() }?.toSet()

inline fun <T> String.asObjectFrom(map: AttributeMap, objConverter: AttributeMap.() -> T): T =
    map[this]!!.m().objConverter()

inline fun <T> String.asNullableObjectFrom(map: AttributeMap, objConverter: AttributeMap.() -> T): T? =
    map[this]?.m()?.objConverter()

/*
fun Map<String, AttributeValue>.toAllTypes(): AllTypes {

    return AllTypes(
        integer = this integerNamed "integer",
        floating = this floatNamed "floating",
        double = this doubleNamed "double",
        long = this longNamed "long",
        nullableLong = this nullableLongNamed "nullableLong",
        bool = this booleanNamed "bool",
        list = this stringListNamed "list",
        set = this stringSetNamed "set",
        obj = this.objectNamed("obj") { toWorld() },
        objs = this.objectListNamed("objs") { toWorld() },
        nullableObj = this.nullableObjectListNamed("nullableObj") { toWorld() },
        nestedObj = this.objectNamed("nestedObj") { toHello() }

    )
}*/
