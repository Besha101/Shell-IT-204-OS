package org.example;
import java.io.IOException;

public class BasicSystemCalls {
    public static void main(String[] args) {

        try {
            System.out.println("Executing fork()");
            int pid = Runtime.getRuntime().exec("fork").waitFor();
            System.out.println("Fork returned: " + pid);

            System.out.println("Executing wait()");
            int status = Runtime.getRuntime().exec("wait").waitFor();
            System.out.println("Wait returned: " + status);

            System.out.println("Executing exec()");
            Process process = Runtime.getRuntime().exec("ls -l");
            process.waitFor();
            System.out.println("Exec completed");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

