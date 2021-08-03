package DesignPatternsLab.BuilderPattern;

public class ComputerBuilder {
    private String RAM;
    private boolean isGraphicsCardEnabled;

    public ComputerBuilder(String ram) {
        this.RAM = ram;
    }

    public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
        this.isGraphicsCardEnabled = isGraphicsCardEnabled;
        return this;
    }

    public Computer build() {
        return new Computer(this.RAM, this.isGraphicsCardEnabled);
    }
}
