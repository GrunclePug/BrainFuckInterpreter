package com.grunclepug.brainfuckinterpreter;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * BrainFuck Interpreter
 * Used to interpret and run brainfuck code
 * @author Chad Humphries
 * @version 1.0
 * Date Created: Nov 15, 2019
 */
public class BrainFuck
{
    public static final int MAX_MEMORY_SIZE = 65535;
    private static byte[] memory = new byte[MAX_MEMORY_SIZE];
    private static int pointer;
    private static String content;

    /**
     * Parse the BrainFuck file for interpretation
     * @param fileName Name of the input file
     * @throws Exception
     */
    public static void readFile(String fileName) throws Exception
    {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        content = "";
        String line = "";
        while((line = br.readLine()) != null)
        {
            content += line;
        }
    }
    /**
     * Interpret and run BrainFuck from a file
     * @param fileName Name of the input file
     * @throws Exception
     */
    public static void interpret(String fileName) throws Exception
    {
        readFile(fileName);
        int counter = 0;

        for(int i = 0; i < content.length(); i++)
        {
            // Move pointer to the next memory cell
            if(content.charAt(i) == '>')
            {
                // If pointer is at end of memory, return to beginning.
                if(pointer == MAX_MEMORY_SIZE - 1)
                {
                    pointer = 0;
                }
                else
                {
                    pointer++;
                }
            }

            // Move pointer to the previous memory cell
            else if(content.charAt(i) == '<')
            {
                // If pointer is at beginning of memory, move to end.
                if(pointer == 0)
                {
                    pointer = MAX_MEMORY_SIZE - 1;
                }
                else
                {
                    pointer--;
                }
            }

            // Increment value of memory cell
            else if(content.charAt(i) == '+')
            {
                memory[pointer]++;
            }

            // Decrement value of memory cell
            else if(content.charAt(i) == '-')
            {
                memory[pointer]--;
            }

            // Output char signified by the memory cell at the pointer
            else if(content.charAt(i) == '.')
            {
                System.out.print((char) memory[pointer]);
            }

            // Input char and store it in the memory cell at the pointer
            else if(content.charAt(i) == ',')
            {
                memory[pointer] = (byte) Driver.sc.next().charAt(0);
            }

            // If the byte at the data pointer is zero, then instead of moving the instruction pointer forward to the next command, jump it forward to the command after the matching ].
            else if(content.charAt(i) == '[')
            {
                if(memory[pointer] == 0)
                {
                    i++;
                    while(counter > 0 || content.charAt(i) != ']')
                    {
                        if(content.charAt(i) == '[')
                        {
                            counter++;
                        }
                        else if(content.charAt(i) == ']')
                        {
                            counter--;
                        }
                        i++;
                    }
                }
            }

            // If the byte at the data pointer is nonzero, then instead of moving the instruction pointer forward to the next command, jump it back to the command after the matching [command.
            else if(content.charAt(i) == ']')
            {
                if(memory[pointer] != 0)
                {
                    i--;
                    while(counter > 0 || content.charAt(i) != '[')
                    {
                        if(content.charAt(i) == ']')
                        {
                            counter++;
                        }
                        else if(content.charAt(i) == '[')
                        {
                            counter--;
                        }
                        i--;
                    }
                    i--;
                }
            }
        }
    }
}
