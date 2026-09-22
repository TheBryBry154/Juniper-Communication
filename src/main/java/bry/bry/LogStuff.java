package bry.bry;

import bry.bry.windows.WindowMaker;

import javax.swing.*;
import java.time.LocalDateTime;

public class LogStuff {


    public static void putToLogOut(String toLog){

        JTextArea textArea = WindowMaker.logArea;

        textArea.append( "["+
                LocalDateTime.now().toLocalDate() +
                " | " +
                LocalDateTime.now().toLocalTime().minusNanos(LocalDateTime.now().toLocalTime().getNano()) +
                "]  " +
                toLog +
                "\n");
    }



}
