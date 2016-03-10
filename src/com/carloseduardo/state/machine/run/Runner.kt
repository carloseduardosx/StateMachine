package com.carloseduardo.state.machine.run

import com.carloseduardo.state.machine.action.StateAction
import com.carloseduardo.state.machine.constants.State
import com.carloseduardo.state.machine.constants.Symbols
import com.carloseduardo.state.machine.validation.StateValidation
import com.sun.javaws.exceptions.InvalidArgumentException

class Runner {

    private var currentState = State.Q0
    private val inputProduction = "1"
    private val showStateMachineInformation = "2";
    private val leave = "3"
    private val success = 1

    private fun showActions() {

        println("1- Input Sentence")
        println("2- State Machine Information")
        println("3- Leave")

        print("\nChoose an option: ")
        executeAction(readLine())
    }

    private fun executeAction(action: String?) {

        action ?: throw InvalidArgumentException(arrayOf())

        Runtime.getRuntime().exec("/bin/bash clear")

        when (action) {

            inputProduction -> treatSentence()

            showStateMachineInformation -> showAlphabetic()

            leave -> System.exit(success)

            else -> println("Invalid Option! Please select a valid option.")
        }

        showActions()
    }

    private fun showAlphabetic() {
        println(Symbols.STATUS_LABEL)
        println(Symbols.STATES.format(State.Q0, State.Q1, State.Q2, State.Q3))
        println(Symbols.SYMBOLS_LABEL)
        println(Symbols.SYMBOLS.format("0", "1", "2"))
        println(Symbols.TRANSITIONS_LABEL)
        println(Symbols.TRANSITIONS)
    }

    private fun treatSentence() {

        print("Input your sentence: ")
        val production = readLine();

        production?.forEach { currentState = StateAction().treatInput(currentState, it.toString()) }

        if (StateValidation(currentState).isFinalState()) {

            println("Production is valid!\n")
        } else if (StateValidation(currentState).isInvalidState()) {

            println("Please insert a valid sentence!\n")
        } else {

            println("Production invalid!\n")
        }

        currentState = State.Q0
    }

    fun run() {
        showActions()
    }
}