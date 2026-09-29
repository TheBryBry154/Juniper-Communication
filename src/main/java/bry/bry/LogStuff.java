package bry.bry;

import bry.bry.windows.WindowMaker;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogStuff {


    public static void putToLogOut(String toLog){

        JTextArea textArea = WindowMaker.logArea;

        textArea.append( "[" +
                "INFO" +
                "] " +
                "("+
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                ")  " +
                toLog +
                "\n");
    }

    public static void putToErrorOut(String toLog){

        JTextArea textArea = WindowMaker.logArea;

        textArea.append( "[" +
                        "ERROR" +
                        "] " +
                "("+
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                ")  " +
                toLog +
                "\n");
    }



}
