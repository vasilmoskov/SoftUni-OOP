package DesignPatternsLab.BuilderPattern;

public class Computer {
    private String RAM;
    private boolean isGraphicsCardEnabled;

    public String getRAM() {
        return RAM;
    }

    public boolean isGraphicsCardEnabled() {
        return isGraphicsCardEnabled;
    }

    public Computer (String ram, boolean isGraphicsCardEnabled) {
        this.RAM = ram;
        this.isGraphicsCardEnabled = isGraphicsCardEnabled;
    }
}
