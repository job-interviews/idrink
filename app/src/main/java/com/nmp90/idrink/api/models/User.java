package com.nmp90.idrink.api.models;

/**
 * Created by joro on 05.08.16.
 */

public class User {
    String name = "Joro";

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
