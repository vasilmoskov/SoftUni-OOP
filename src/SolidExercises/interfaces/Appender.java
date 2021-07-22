package SolidExercises.interfaces;

import SolidExercises.enums.ReportLevel;

public interface Appender {
    void appendMessage(String dateTime, ReportLevel reportLevel, String message);

    void setFile(File file);

    void setReportLevel(ReportLevel reportLevel);
}
