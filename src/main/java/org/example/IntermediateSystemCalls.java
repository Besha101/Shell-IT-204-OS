package org.example;
import java.io.IOException;

public class IntermediateSystemCalls {
    public static void main(String[] args) {

        try {
            System.out.println("Executing execlp()");
            Process process = Runtime.getRuntime().exec("ls -a");
            process.waitFor();
            System.out.println("Execlp completed");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
