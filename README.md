# Workbench

This repository contains an example of how to use Blueprint to inject code into the indie game Equilinox.

It assumes that its compiled binary is placed in the installation directory for Equilinox.

Simply run it with `java -jar Workbench.jar` and it should output the value of `TEST_STRING` before `MainApp#main` is invoked, during the execution of `MainApp#main`, and after the game is closed.
