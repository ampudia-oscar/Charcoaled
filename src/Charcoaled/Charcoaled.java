/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Charcoaled;
import byui.cit260.Charcoaled.model.Game;
import byui.cit260.Charcoaled.model.Player;
import byui.cit260.Charcoaled.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


/**
 *
 * @author oscar
 */
public class Charcoaled {

    /**
     * @param args the command line arguments
     */
    private static Player player = null;
    private static Game currentGame = null;
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    private static PrintWriter logFile = null;
    private static PrintWriter raquelLogFile = null;

    public static PrintWriter getRaquelLogFile() {
        return raquelLogFile;
    }

    public static void setRaquelLogFile(PrintWriter raquelLogFile) {
        Charcoaled.raquelLogFile = raquelLogFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        Charcoaled.logFile = logFile;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        Charcoaled.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        Charcoaled.inFile = inFile;
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        Charcoaled.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Charcoaled.player = player;
    }

    public static void main(String[] args) {

        StartProgramView spv = null;
        try {
            Charcoaled.inFile = new BufferedReader(new InputStreamReader(System.in));
            Charcoaled.outFile = new PrintWriter(System.out, true);
            String filePath = "log.txt";
            Charcoaled.logFile = new PrintWriter(filePath);
            Charcoaled.raquelLogFile = new PrintWriter("raquelLogFile.txt");
            spv = new StartProgramView();
            spv.startProgram();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            spv.startProgram();
        } finally {
            try {
                if (Charcoaled.inFile != null) {
                    Charcoaled.inFile.close();
                }
                if (Charcoaled.outFile != null) {
                    Charcoaled.outFile.close();
                }
                if (Charcoaled.logFile != null) {
                    Charcoaled.logFile.close();
                }
                if (Charcoaled.raquelLogFile != null) {
                    Charcoaled.raquelLogFile.close();
                }
            } catch (IOException ex) {
                System.out.println("Error closing files");
                return;
            }
        }
    }
}