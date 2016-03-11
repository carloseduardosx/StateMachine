package com.carloseduardo.state.machine.run

import com.carloseduardo.state.machine.action.StateAction
import com.carloseduardo.state.machine.constants.Automaton
import com.carloseduardo.state.machine.constants.State
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

        val actionSelected = readLine()

        executeAction(actionSelected)
    }

    private fun executeAction(action: String?) {

        action ?: throw InvalidArgumentException(arrayOf())

        cleanConsole()

        when (action) {

            inputProduction -> treatSentence()

            showStateMachineInformation -> showAlphabetic()

            leave -> System.exit(success)

            else -> println("Invalid Option! Please select a valid option.\n")
        }

        showActions()
    }

    private fun cleanConsole() {
        ProcessBuilder("clear").inheritIO().start().waitFor()
    }

    private fun showAlphabetic() {

        println(Automaton.STATUS_LABEL)
        println(Automaton.STATES.format(State.Q0, State.Q1.name + " - F", State.Q2.name + " - F", State.Q3))
        println(Automaton.SYMBOLS_LABEL)
        println(Automaton.SYMBOLS.format("0", "1", "2"))
        println(Automaton.TRANSITIONS_LABEL)
        println(Automaton.TRANSITIONS)
    }

    private fun treatSentence() {

        print("Input your sentence: ")
        val sentence = readLine();

        sentence?.forEach {

            print("\nCurrent state was: $currentState")

            currentState = StateAction().treatInput(currentState, it.toString())

            println(" - Passing symbol $it... Now the Current State is: $currentState")

            if (currentState == State.INVALID) {

                println("\nThe current state is ${State.INVALID}\n" +
                        "That means which your sentence is invalid\n" +
                        "Please insert a valid sentence!\n")

                currentState = State.Q0
                return
            };
        }

        if (StateValidation(currentState).isFinalState()) {

            println("\nSentence is valid!\n")
        } else if (StateValidation(currentState).isInvalidState()) {

            println("\nPlease insert a valid sentence!\n")
        } else {

            println("\nSentence invalid!\n")
        }

        currentState = State.Q0
    }

    fun run() {
        showActions()
    }
}