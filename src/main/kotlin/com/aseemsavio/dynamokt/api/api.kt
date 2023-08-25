package com.aseemsavio.dynamokt.api

import com.aseemsavio.dynamokt.utils.DynamoKtLogger

/**
 * This is a test function to see everything works
 */

internal val logger = DynamoKtLogger
fun helloWorld(): String {
    logger.info { "Hello Method reached" }
    return "Hello from dynamokt hello"
}
