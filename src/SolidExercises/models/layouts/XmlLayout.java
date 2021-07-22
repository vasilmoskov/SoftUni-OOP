package SolidExercises.models.layouts;

import SolidExercises.interfaces.Layout;

public class XmlLayout implements Layout {

    @Override
    public String getLayout() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("<log>")
                .append(System.lineSeparator())
                .append("<date>%s</date>")
                .append(System.lineSeparator())
                .append("<level>%s</level>")
                .append(System.lineSeparator())
                .append("<message>%s</message>")
                .append(System.lineSeparator())
                .append("</log>");

        return stringBuilder.toString();
    }
}
