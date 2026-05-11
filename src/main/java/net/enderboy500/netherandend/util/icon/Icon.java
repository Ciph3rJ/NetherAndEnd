package net.enderboy500.netherandend.util.icon;

public enum Icon {
    WARPED("warped"),
    CRIMSON("crimson");

    private String id;

    Icon(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
