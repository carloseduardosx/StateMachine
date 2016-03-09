package com.carloseduardo.state.machine.action

import com.carloseduardo.state.machine.constants.State

class StateAction {

    private val zero = "0";
    private val one = "1";
    private val two = "2";

    fun treatInput(currentState: State, input: String): State {

        when (input) {

            zero -> {

                if (currentState == State.Q0) return State.Q0

                else if (currentState == State.Q1) return State.Q3

                else if (currentState == State.Q2) return State.Q3

                else if (currentState == State.Q3) return State.Q3
            }

            one -> {

                if (currentState == State.Q0) return State.Q1

                else if (currentState == State.Q1) return State.Q1

                else if (currentState == State.Q2) return State.Q3

                else if (currentState == State.Q3) return State.Q3
            }

            two -> {

                if (currentState == State.Q0) return State.Q3

                else if (currentState == State.Q1) return State.Q2

                else if (currentState == State.Q2) return State.Q2

                else if (currentState == State.Q3) return State.Q3
            }
        }

        return State.INVALID
    }
}