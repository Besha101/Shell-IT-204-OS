package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class basicShell {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {

                String prompt = getColoredPrompt();
                System.out.print(prompt);


                String userInput = reader.readLine();
                if (userInput == null) {
                    break;
                }


                String[] tokens = userInput.trim().split("\\s+");
                List<String> commands = new ArrayList<>();
                List<String> arguments = new ArrayList<>();
                boolean isPipe = false;


                for (String token : tokens) {
                    if (token.equals("|")) {
                        isPipe = true;
                    } else if (!isPipe) {
                        commands.add(token);
                    } else {
                        arguments.add(token);
                    }
                }


                executeCommand(commands, arguments);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getColoredPrompt() {
        try {
            String machineName = InetAddress.getLocalHost().getHostName();
            String userName = System.getProperty("user.name");
            String prompt = String.format("\u001B[32m%s@%s\u001B[0m", userName, machineName);
            return prompt + ":~$ ";
        } catch (IOException e) {
            e.printStackTrace();
            return "prompt$ ";
        }
    }

    private static void executeCommand(List<String> commands, List<String> arguments) {
        try {
            ProcessBuilder[] builders = new ProcessBuilder[commands.size()];
            Process[] processes = new Process[commands.size()];
            BufferedReader[] readers = new BufferedReader[commands.size()];


            for (int i = 0; i < commands.size(); i++) {
                String command = commands.get(i);
                List<String> commandAndArgs = new ArrayList<>();
                commandAndArgs.add(command);
                commandAndArgs.addAll(arguments);

                builders[i] = new ProcessBuilder(commandAndArgs);
                if (i > 0) {
                    builders[i].redirectInput(ProcessBuilder.Redirect.PIPE);
                }
            }


            for (int i = 0; i < commands.size(); i++) {
                processes[i] = builders[i].start();
                if (i > 0) {
                    readers[i] = new BufferedReader(new InputStreamReader(processes[i - 1].getInputStream()));
                }
            }


            processes[commands.size() - 1].waitFor();


            BufferedReader lastOutput = new BufferedReader(new InputStreamReader(processes[commands.size() - 1].getInputStream()));
            String line;
            while ((line = lastOutput.readLine()) != null) {
                System.out.println(line);
            }


            for (Process process : processes) {
                process.destroy();
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error executing command: " + e.getMessage());
        }
    }

    private static void executeCommand(String command) {
        String[] tokens = command.trim().split("\\s+");
        String commandName = tokens[0];
        List<String> args = new ArrayList<>(Arrays.asList(tokens));
        args.remove(0);

        switch (commandName) {
            case "basic_system_calls":
                BasicSystemCalls.main(args.toArray(new String[0]));
                break;
            case "intermediate_system_calls":
                IntermediateSystemCalls.main(args.toArray(new String[0]));
                break;
            case "forkbomb":
                ForkBomb.main(args.toArray(new String[0]));
                break;
            default:

                break;
        }
    }
}
