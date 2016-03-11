package com.carloseduardo.state.machine.constants

class Automaton {

    companion object {

        val STATUS_LABEL = "_____________________________________\n" +
                " ___________________________________\n" +
                "|                                   |\n" +
                "|              STATES               |\n" +
                "|___________________________________|"

        val SYMBOLS_LABEL = "_____________________________________\n" +
                " ___________________________________\n" +
                "|                                   |\n" +
                "|             SYMBOLS               |\n" +
                "|___________________________________|"

        val TRANSITIONS_LABEL = "_____________________________________\n" +
                " ___________________________________\n" +
                "|                                   |\n" +
                "|            TRANSITIONS            |\n" +
                "|___________________________________|"

        val STATES = " ___________________________________\n" +
                "|        |        |        |        |\n" +
                "|   %s   | %s | %s |   %s   |\n" +
                "|________|________|________|________|\n\n"

        val SYMBOLS = " __________________________\n" +
                "|        |        |        |\n" +
                "|   %s    |   %s    |   %s    |\n" +
                "|________|________|________|\n\n"

        val TRANSITIONS = " __________________________________________________\n" +
                "|                |               |                 |\n" +
                "|   0: Q0 -> Q0  |  1: Q0 -> Q1  |  2: Q0 -> Q3    |\n" +
                "|      Q1 -> Q3  |     Q1 -> Q1  |     Q1 -> Q2    |\n" +
                "|      Q2 -> Q3  |     Q2 -> Q3  |     Q2 -> Q2    |\n" +
                "|      Q3 -> Q3  |     Q3 -> Q3  |     Q3 -> Q3    |\n" +
                " --------------------------------------------------\n"
    }
}