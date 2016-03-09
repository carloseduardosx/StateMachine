package com.carloseduardo.state.machine.run

import com.carloseduardo.state.machine.action.StateAction
import com.carloseduardo.state.machine.constants.State
import com.carloseduardo.state.machine.validation.StateValidation
import com.sun.javaws.exceptions.InvalidArgumentException

class Runner {

    private var currentState = State.Q0
    private val inputProduction = "1"
    private val leave = "2"
    private val success = 1

    private fun showActions() {

        println("1- Input Production")
        println("2- Leave")

        print("\nChoose an option: ")
        executeAction(readLine())
    }

    private fun executeAction(action: String?) {

        action ?: throw InvalidArgumentException(arrayOf())

        Runtime.getRuntime().exec("/bin/bash clear")

        when (action) {

            inputProduction -> treatProduction()

            leave -> System.exit(success)

            else -> println("Invalid Option! Please select a valid option.")
        }

        showActions()
    }

    private fun treatProduction() {

        print("Input your production: ")
        val production = readLine();

        production?.forEach { currentState = StateAction().treatInput(currentState, it.toString()) }

        if (StateValidation(currentState).isFinalState()) {

            println("Production is valid!\n")
        } else if (StateValidation(currentState).isInvalidState()) {

            println("Please insert a valid production!\n")
        } else {

            println("Production invalid!\n")
        }

        currentState = State.Q0
    }

    fun run() {
        showActions()
    }
}