package com.grunclepug.brainfuckinterpreter;

import java.util.Scanner;

public class Driver
{
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception
    {
        System.out.println("Java BrainFuck Interpreter v1.0");
        System.out.println("-------------------------------");
        System.out.println("Enter File Name:");
        System.out.print("$> ");
        String file = sc.nextLine();
        System.out.println("Output: ");
        BrainFuck.interpret(file);
    }
}
