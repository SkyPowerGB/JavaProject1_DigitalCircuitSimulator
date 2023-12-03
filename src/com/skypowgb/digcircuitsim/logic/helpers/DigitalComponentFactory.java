package com.skypowgb.digcircuitsim.logic.helpers;

import com.skypowgb.digcircuitsim.model.DigitalComponent;
import com.skypowgb.digcircuitsim.model.setup.setup;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DigitalComponentFactory {


    public static <T extends DigitalComponent> T createDigitalComponent(String className) {
        try {
            className=setup.componentsLocation+className;
            Class<?> clazz = Class.forName(className);

            Constructor<?> constructor = clazz.getConstructor();

            return (T) constructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
