package com.carloseduardo.state.machine.run

import com.carloseduardo.state.machine.action.StateAction
import com.carloseduardo.state.machine.constants.State
import com.carloseduardo.state.machine.validation.StateValidation
import com.sun.javaws.exceptions.InvalidArgumentException
import kotlin.system.exitProcess

class Runner {

    private var currentState = State.Q0
    private val inputProduction = "1"
    private val leave = "2"
    private val success = 1

    private fun showActions() {

        println("1- Input Production")
        println("2- Leave")

        print("\nWrite a value to insert: ")
        executeAction(readLine())
    }

    private fun executeAction(action: String?) {

        action ?: throw InvalidArgumentException(arrayOf())

        Runtime.getRuntime().exec("clear")

        when (action) {

            inputProduction -> treatProduction()

            leave -> exitProcess(success)

            else -> println("Invalid Option! Please select a valid option.")
        }

        showActions()
    }

    private fun treatProduction() {

        print("Input your production: ")
        val production = readLine();

        production?.forEach { currentState = StateAction().treatInput(currentState, it.toString()) }

        if (StateValidation(currentState).isFinalState()) {
            println("Production is valid!")
        } else {
            println("Production invalid!")
        }
    }

    fun run() {
        showActions()
    }
}