package SolidExercises.models.files;

import SolidExercises.interfaces.File;

public class LogFile implements File {
    private int size;
    private StringBuilder content;

    @Override
    public int getSize() {
        return size;
    }

    public LogFile() {
        this.content = new StringBuilder();
    }

    @Override
    public void write(String text) {
        this.content.append(text);
        this.size += getTextSize(text);
    }

    private int getTextSize(String text) {
        return text.chars().filter(c -> Character.isAlphabetic(c)).sum();
    }


}
