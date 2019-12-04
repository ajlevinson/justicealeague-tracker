package com.comicbook.superhero.team.tracker.enums;

public enum Publisher {
    DC("DC Comics"),
    MARVEL("Marvel Comics");

    private String name;

    private Publisher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

