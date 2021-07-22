package SolidExercises.models.loggers;

import SolidExercises.enums.ReportLevel;
import SolidExercises.interfaces.Appender;
import SolidExercises.interfaces.Logger;

public class MessageLogger implements Logger {
    private Appender[] appenders;

    public MessageLogger(Appender... appenders) {
        this.appenders = appenders;
    }

    @Override
    public void logInfo(String dateTime, String message) {
        logMessage(dateTime, ReportLevel.INFO, message);
    }

    @Override
    public void logWarning(String dateTime, String message) {
        logMessage(dateTime, ReportLevel.WARNING, message);
    }

    @Override
    public void logError(String dateTime, String message) {
        logMessage(dateTime, ReportLevel.ERROR, message);
    }

    @Override
    public void logCritical(String dateTime, String message) {
        logMessage(dateTime, ReportLevel.CRITICAL, message);
    }

    @Override
    public void logFatal(String dateTime, String message) {
        logMessage(dateTime, ReportLevel.FATAL, message);
    }

    private void logMessage(String dateTime, ReportLevel reportLevel, String message) {
        for (Appender appender : appenders) {
            appender.appendMessage(dateTime, reportLevel, message);
        }
    }

    @Override
    public String getLogInfo() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Logger info");

        for (Appender appender : appenders) {
            stringBuilder.append(System.lineSeparator()).append(appender);
        }

        return stringBuilder.toString();
    }
}
