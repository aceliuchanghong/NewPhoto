package org.liu.Grey.core;


public abstract class ColorDeal {
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private String color = "GRAY";

    /**
     * default gray
     */
    public abstract boolean changeTo();

}
