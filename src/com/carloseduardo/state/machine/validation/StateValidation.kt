package com.carloseduardo.state.machine.validation

import com.carloseduardo.state.machine.constants.State

class StateValidation(val currentState: State) {

    fun isFinalState(): Boolean = currentState == State.Q1 || currentState == State.Q2;
}