package DesignPatternsLab.SingletonPattern;

import java.io.Serializable;

public class SerializableSingleton implements Serializable {
    private static SerializableSingleton instance;

    private SerializableSingleton() {}

    public static synchronized SerializableSingleton getInstance() {
        if (instance == null) {
            instance = new SerializableSingleton();
        }

        return instance;
    }
}
