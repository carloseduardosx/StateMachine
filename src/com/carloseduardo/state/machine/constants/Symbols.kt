package com.carloseduardo.state.machine.constants

class Symbols {

    companion object {

        val STATUS_LABEL = "_____________________________________\n" +
                " ___________________________________\n" +
                "|                                   |\n" +
                "|              STATES               |\n" +
                "|___________________________________|\n" +
                "_____________________________________\n"

        val SYMBOLS_LABEL = "_____________________________________\n" +
                " ___________________________________\n" +
                "|                                   |\n" +
                "|             SYMBOLS               |\n" +
                "|___________________________________|\n" +
                "_____________________________________\n"

        val TRANSITIONS_LABEL = "_____________________________________\n" +
                " ___________________________________\n" +
                "|                                   |\n" +
                "|            TRANSITIONS            |\n" +
                "|___________________________________|\n" +
                "_____________________________________\n"

        val STATES = "___________________________________\n" +
                "|        |        |        |        |\n" +
                "|   %s   |   %s   |   %s   |   %s   |\n" +
                "|________|________|________|________|\n"

        val SYMBOLS = " __________________________\n" +
                "|        |        |        |\n" +
                "|   %s    |   %s    |   %s    |\n" +
                "|________|________|________|\n"

        val TRANSITIONS = " ________________\n" +
                "|                |\n" +
                "|   0: Q0 -> Q0  |\n" +
                "|      Q1 -> Q3  |\n" +
                "|      Q2 -> Q3  |\n" +
                "|      Q3 -> Q3  |\n" +
                "|                |\n" +
                "|   1: Q0 -> Q1  |\n" +
                "|      Q1 -> Q1  |\n" +
                "|      Q2 -> Q3  |\n" +
                "|      Q3 -> Q3  |\n" +
                "|                |\n" +
                "|   2: Q0 -> Q3  |\n" +
                "|      Q1 -> Q2  |\n" +
                "|      Q2 -> Q2  |\n" +
                "|      Q3 -> Q3  |\n" +
                "|________________|\n"
    }
}