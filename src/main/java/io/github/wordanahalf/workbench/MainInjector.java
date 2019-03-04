package io.github.wordanahalf.workbench;

import io.github.wordandahalf.blueprint.annotations.At;
import io.github.wordandahalf.blueprint.annotations.Blueprint;
import io.github.wordandahalf.blueprint.annotations.Inject;

@Blueprint(target = "main.MainApp")
public class MainInjector {
    @Inject(target = "main", at = @At(location = At.Location.HEAD))
    public static void main(String[] args) {
        WorkbenchLoader.TEST_STRING = "2";

        System.out.println("TEST_STRING='" + WorkbenchLoader.TEST_STRING + "'");

        WorkbenchLoader.TEST_STRING = "3";
    }
}
