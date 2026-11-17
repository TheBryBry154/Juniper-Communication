package bry.bry;

import bry.bry.windows.WindowMaker;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogStuff {

    public static void putToLogOut(String toLog){

        JTextArea textArea = WindowMaker.logArea;
        JTextArea aTextArea = WindowMaker.autoLogArea;

        textArea.append(template("Info",toLog));

        aTextArea.append(template("Info",toLog));
        aTextArea.setCaretPosition(aTextArea.getDocument().getLength());
    }

    public static void putToErrorOut(String toLog){

        JTextArea textArea = WindowMaker.logArea;
        JTextArea aTextArea = WindowMaker.autoLogArea;

        textArea.append(template("Error",toLog));

        aTextArea.append(template("Error",toLog));
        aTextArea.setCaretPosition(aTextArea.getDocument().getLength());
    }

    public static void putToWarningOut(String toLog){

        JTextArea textArea = WindowMaker.logArea;
        JTextArea aTextArea = WindowMaker.autoLogArea;

        textArea.append(template("Warn",toLog));

        aTextArea.append(template("Warn",toLog));
        aTextArea.setCaretPosition(aTextArea.getDocument().getLength());
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
