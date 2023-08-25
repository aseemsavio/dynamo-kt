package com.aseemsavio.dynamokt.utils

import java.time.LocalDateTime

internal object DynamoKtLogger {

    private val logger: System.Logger = System.getLogger("DynamoKtLogger")
    private fun constructMessage(time: LocalDateTime, message: String) = "$time | DynamoKt | $message"

    /**
     * Prints an info level message
     */
    fun info(message: () -> String) {
        logger.log(
            System.Logger.Level.INFO, constructMessage(
                time = LocalDateTime.now(),
                message = message()
            )
        )
    }

    /**
     * Prints a debug level message
     */
    fun debug(message: () -> String) {
        logger.log(
            System.Logger.Level.DEBUG, constructMessage(
                time = LocalDateTime.now(),
                message = message()
            )
        )
    }

    /**
     * Prints a error level message
     */
    fun error(message: () -> String) {
        logger.log(
            System.Logger.Level.ERROR, constructMessage(
                time = LocalDateTime.now(),
                message = message()
            )
        )
    }

}