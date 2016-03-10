#!/usr/bin/env bash

kotlinc ../Main.kt \
../action/StateAction.kt \
../constants/State.kt \
../constants/Symbols.kt \
../run/Runner.kt \
../validation/StateValidation.kt \
-include-runtime -d State.jar

java -jar State.jar