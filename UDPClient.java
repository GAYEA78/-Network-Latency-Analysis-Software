// Arona Gaye
package echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.DoubleSummaryStatistics;
import java.util.Scanner;

public class UDPClient {

    public static void main(String[] args) {
        try (
            // Create a DatagramSocket for sending and receiving UDP packets
            var socket = new DatagramSocket();
        ) {

            // Initialize Scanner to read input from the user
            var stdin = new Scanner(System.in);
            System.out.print("Enter a message: ");
            var message = stdin.nextLine(); // Read the user's message

            // Convert the message to a byte array for transmission
            var out_buf = message.getBytes();

            // Specify the destination IP address and port number
            var dest_ip = InetAddress.getByName("74.207.233.127");
            var dest_port = 3363;

            // Create a DatagramPacket to send the message to the server
            var out_packet = new DatagramPacket(out_buf, out_buf.length, dest_ip, dest_port);

            // Create a buffer and DatagramPacket to receive the server's response
            var in_buf = new byte[1400];
            var in_packet = new DatagramPacket(in_buf, in_buf.length);

            // Initialize statistics object and an array to store round-trip times
            DoubleSummaryStatistics stats = new DoubleSummaryStatistics();
            long[] times = new long[10]; 

            // Loop to send the message 10 times and measure round-trip time
            for (int i = 0; i < 10; i++) {
                long Time_it_started = System.nanoTime(); // Record start time
                socket.send(out_packet); // Send the message
                socket.receive(in_packet); // Wait for the server's response
                long endTime = System.nanoTime(); // Record end time

                // Calculate round-trip duration in milliseconds
                long duration = (endTime - Time_it_started) / 1000000; 
                stats.accept(duration); // Add duration to statistics
                times[i] = duration; // Store duration in the array
            }

            // Calculate the mean round-trip time
            double mean = stats.getAverage();
            // Calculate the standard deviation of round-trip times
            double sumSq = 0.0;
            for (long time : times) {
                sumSq += Math.pow(time - mean, 2);
            }
            double stdDev = Math.sqrt(sumSq / times.length);

            // Print out the minimum, mean, maximum, and standard deviation of the times
            System.out.printf("Min: %.3f ms\n", stats.getMin());
            System.out.printf("Mean: %.3f ms\n", stats.getAverage());
            System.out.printf("Max: %.3f ms\n", stats.getMax());
            System.out.printf("Std Dev: %.3f ms\n", stdDev);

        } catch(IOException e) {
            // Handle exceptions related to networking errors
            System.out.println("Network error!");
        }
    }
}
