package net.enderboy500.netherandend.util.icon;

public enum Icon {
    WARPED("warped", '\uE001'),
    CRIMSON("crimson", '\uE002');

    private String id;
    private char aChar;

    Icon(String id, char ch) {
        this.id = id;
        this.aChar = ch;
    }

    public String getId() {
        return id;
    }
    public char getChar() {
        return aChar;
    }
}
