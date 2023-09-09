package com.aseemsavio.dynamokt.extensions

infix fun AttributeMap.stringNamed(name: String): String = this[name]!!.s()
infix fun AttributeMap.nullableStringNamed(name: String): String? = this[name]?.s()
infix fun AttributeMap.integerNamed(name: String): Int = this[name]!!.n().toInt()
infix fun AttributeMap.nullableIntegerNamed(name: String): Int? = this[name]?.n()?.toInt()
infix fun AttributeMap.floatNamed(name: String): Float = this[name]!!.n().toFloat()
infix fun AttributeMap.nullableFloatNamed(name: String): Float? = this[name]?.n()?.toFloat()
infix fun AttributeMap.doubleNamed(name: String): Double = this[name]!!.n().toDouble()
infix fun AttributeMap.nullableDoubleNamed(name: String): Double? = this[name]?.n()?.toDouble()
infix fun AttributeMap.longNamed(name: String): Long = this[name]!!.n().toLong()
infix fun AttributeMap.nullableLongNamed(name: String): Long? = this[name]?.n()?.toLong()
infix fun AttributeMap.booleanNamed(name: String): Boolean = this[name]!!.bool()
infix fun AttributeMap.nullableBooleanNamed(name: String): Boolean? = this[name]?.bool()
infix fun AttributeMap.stringListNamed(name: String): List<String> = this[name]!!.l().map { it.s() }
infix fun AttributeMap.nullableStringListNamed(name: String): List<String>? = this[name]?.l()?.map { it.s() }
infix fun AttributeMap.integerListNamed(name: String): List<Int> = this[name]!!.l().map { it.n().toInt() }
infix fun AttributeMap.nullableIntegerListNamed(name: String): List<Int>? = this[name]?.l()?.map { it.n().toInt() }
infix fun AttributeMap.longListNamed(name: String): List<Long> = this[name]!!.l().map { it.n().toLong() }
infix fun AttributeMap.nullableLongListNamed(name: String): List<Long>? = this[name]?.l()?.map { it.n().toLong() }
infix fun AttributeMap.floatListNamed(name: String): List<Float> = this[name]!!.l().map { it.n().toFloat() }
infix fun AttributeMap.nullableFloatListNamed(name: String): List<Float>? = this[name]?.l()?.map { it.n().toFloat() }
infix fun AttributeMap.doubleListNamed(name: String): List<Double> = this[name]!!.l().map { it.n().toDouble() }
infix fun AttributeMap.nullableDoubleListNamed(name: String): List<Double>? = this[name]?.l()?.map { it.n().toDouble() }
inline fun <T> AttributeMap.objectListNamed(name: String, objConverter: AttributeMap.() -> T): List<T> =
    this[name]!!.l().map { it.m().objConverter() }

inline fun <T> AttributeMap.nullableObjectListNamed(name: String, objConverter: AttributeMap.() -> T): List<T>? =
    this[name]?.l()?.map { it.m().objConverter() }

infix fun AttributeMap.stringSetNamed(name: String): Set<String> = this[name]!!.ss().toSet()
infix fun AttributeMap.nullableStringSetNamed(name: String): Set<String>? = this[name]?.ss()?.toSet()
infix fun AttributeMap.integerSetNamed(name: String): Set<Int> = this[name]!!.ns().map { it.toInt() }.toSet()
infix fun AttributeMap.nullableIntegerSetNamed(name: String): Set<Int>? = this[name]?.ns()?.map { it.toInt() }?.toSet()
infix fun AttributeMap.longSetNamed(name: String): Set<Long> = this[name]!!.ns().map { it.toLong() }.toSet()
infix fun AttributeMap.nullableLongSetNamed(name: String): Set<Long>? = this[name]?.ns()?.map { it.toLong() }?.toSet()
infix fun AttributeMap.floatSetNamed(name: String): Set<Float> = this[name]!!.ns().map { it.toFloat() }.toSet()
infix fun AttributeMap.nullableFloatSetNamed(name: String): Set<Float>? =
    this[name]?.ns()?.map { it.toFloat() }?.toSet()

infix fun AttributeMap.doubleSetNamed(name: String): Set<Double> = this[name]!!.ns().map { it.toDouble() }.toSet()
infix fun AttributeMap.nullableDoubleSetNamed(name: String): Set<Double>? =
    this[name]?.ns()?.map { it.toDouble() }?.toSet()

inline fun <T> AttributeMap.objectNamed(name: String, objConverter: AttributeMap.() -> T): T =
    this[name]!!.m().objConverter()

inline fun <T> AttributeMap.nullableObjectNamed(name: String, objConverter: AttributeMap.() -> T): T? =
    this[name]?.m()?.objConverter()

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
