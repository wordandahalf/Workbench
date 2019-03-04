package io.github.wordanahalf.workbench;

import io.github.wordandahalf.blueprint.Blueprints;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class WorkbenchLoader {
    public static String TEST_STRING = "1";

    public static void main(String[] args) throws Exception {
        URLClassLoader urlClassLoader = new URLClassLoader(
                new URL[] { new File("EquilinoxWindows.jar").toURI().toURL() }
        );

        Blueprints.useClassLoader(urlClassLoader);
        Blueprints.add(MainInjector.class);
        Blueprints.apply();

        Class mainApp = Class.forName("main.MainApp", false, urlClassLoader);

        Method main = mainApp.getDeclaredMethod("main", String[].class);

        System.setProperty("org.lwjgl.librarypath", new File("natives/").getAbsolutePath());

        System.out.println("TEST_STRING='" + TEST_STRING + "'");

        main.invoke(null, new Object[] { args });

        System.out.println("TEST_STRING='" + WorkbenchLoader.TEST_STRING + "'");
    }
}