package bry.bry;

import bry.bry.windows.WindowMaker;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogStuff {

    public static void putToLogOut(String toLog){

        JTextArea textArea = WindowMaker.logArea;

        textArea.append(template("Info",toLog));
    }

    public static void putToErrorOut(String toLog){

        JTextArea textArea = WindowMaker.logArea;

        textArea.append(template("Error",toLog));
    }

    public static void putToWarningOut(String toLog){

        JTextArea textArea = WindowMaker.logArea;

        textArea.append(template("Warn",toLog));
    }


    private static String template(String type, String string) {

       return  "[" +
                type +
                "] " +
                "(" +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                ")  " +
                string +
                "\n";


    }
}
