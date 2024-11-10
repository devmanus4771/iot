// Q.2 Write a program to sense the available networks using Arduino

// Solution:
// We will create a Java program that:

// Executes a system command to scan for Wi-Fi networks.
// Parses and displays the available networks.
// Note:
// For Windows: We use netsh wlan show networks to get the Wi-Fi list.
// For macOS/Linux: We use nmcli dev wifi list to scan networks.

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Slip_1_2 {
    
    public static void main(String[] args) {
        try {
            // Detect the OS
            String os = System.getProperty("os.name").toLowerCase();
            String command;
            
            if (os.contains("win")) {
                // Command for Windows
                command = "netsh wlan show networks";
            } else {
                // Command for macOS/Linux
                command = "nmcli dev wifi list";
            }

            // Execute the command
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            
            String line;
            System.out.println("Available Wi-Fi Networks:");
            System.out.println("------------------------------");
            
            // Read and display the output
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            process.waitFor();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
