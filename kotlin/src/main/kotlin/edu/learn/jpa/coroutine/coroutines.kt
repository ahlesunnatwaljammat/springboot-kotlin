package edu.learn.jpa.coroutine

import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

fun main(args: Array<String>) {
    println("Start")
    println(Thread.currentThread().name)

    // Start a coroutine
    launch {
        delay(500)
        print("Hello ")
        println(Thread.currentThread().name)
    }

    Thread.sleep(2000) // wait for 2 seconds
    println("Stop")
}