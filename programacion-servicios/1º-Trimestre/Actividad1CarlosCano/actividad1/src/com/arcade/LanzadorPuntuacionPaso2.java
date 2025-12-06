package com.arcade;

import java.io.*;
import java.util.*;

public class LanzadorPuntuacionPaso2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Kills: ");
        String kills = sc.nextLine().trim();
        System.out.print("Coins: ");
        String coins = sc.nextLine().trim();
        System.out.print("Time (s): ");
        String time = sc.nextLine().trim();

        String classpath = System.getProperty("java.class.path");
        String javaHome = System.getProperty("java.home");
        String javaBin = javaHome + File.separator + "bin" + File.separator + "java";

        ProcessBuilder pb = new ProcessBuilder( 
        	    javaBin,
        	    "-cp",
        	    new File("bin").getAbsolutePath(),   
        	    "com.arcade.CalculadoraPuntuacion",
        	    kills, coins, time
        	);
        Process proc = pb.start();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

        int exit = proc.waitFor();
        if (exit != 0) {
            try (BufferedReader brErr = new BufferedReader(new InputStreamReader(proc.getErrorStream()))) {
                String line;
                while ((line = brErr.readLine()) != null) {
                    System.err.println(line);
                }
            }
            System.out.println("El proceso terminó con código: " + exit);
        }
    }
}
