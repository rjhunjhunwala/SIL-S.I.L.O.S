/*
 *Feel free to modify and distribute the code and all relevant documentation
* This code is provided as is and the author
 */
package rohan;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * S.I.L.O.S interpeter
 *
 * @author rohan
 */
public class Silos {

    /**
     * This integer[] represents the heap of memory which can be addressed
     */
    static int[] mem;

    /**
     * Prints out the prompt and then returns the string user types
     *
     * @param prompt the prompt for the user
     * @return the string typed into the console
     */
    public static String getStringFromUser(String prompt) {
        System.out.println(prompt);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     * The main interpretation code
     *
     * @param args the command line arguments which should never be used
     */
    static int[] vars;
    public static void main(String[] args) {
       Stack<Integer> stack = new Stack<>();
        String[] program = getWordsFromFile(getStringFromUser("FileName?"));
        int ptr = 0;
        int length = program.length;
        String line = null;
        try {
            mem = new int[Integer.parseInt(program[0])];
        }//allocates the memory on the first line of code
        catch (Exception ex) {
            mem = new int[8192];//default size if there is no allocation specified
        }
        while (ptr < length) {
            try {
                line = program[ptr];
                String[] tokens = line.split(" ");
                if (line.startsWith("GOTO ")) {
                    for (int i = 0; i < length; i++) {
                        if (program[i].startsWith("lbl")) {
                            if (program[i].substring(3).equals(tokens[1])) {
                                ptr = i - 1;//we increment it later
                            }
                        }
                    }
                }else if(line.startsWith ("GOSUB ")){
                stack.add(ptr);
                    for (int i = 0; i < length; i++) {
                        if (program[i].startsWith("func")) {
                            if (program[i].substring(4).equals(tokens[1])) {
                                ptr = i - 1;//we increment it later
                            }
                        }
                    }             
            }
                else if(line.startsWith("return")){
                    ptr=stack.pop();
                }
                else if (line.startsWith("printLine ")) {
                    System.out.println(line.substring(10));
                }
               else if (line.startsWith("printChar ")) {
                    System.out.print((char) evalToken(tokens[1]));
                }
                else if (line.startsWith("print ")) {
                    System.out.print(line.substring(6));
                } else if (line.startsWith("printInt ")) {
                    System.out.println(mem[tokens[1].charAt(0)]);
                } else if (tokens[0].length() == 1) {
                    if (tokens[1].equals("=")) {
                        mem[tokens[0].charAt(0)] = evalGetStatement(tokens);
                    } else if ("*/-+%^|".contains(tokens[1])) {
                        switch (tokens[1]) {
                            case "*":
                                mem[tokens[0].charAt(0)] *= evalToken(tokens[2]);
                                break;
                            case "/":
                                mem[tokens[0].charAt(0)] /= evalToken(tokens[2]);
                                break;
                            case "-":
                                mem[tokens[0].charAt(0)] -= evalToken(tokens[2]);
                                break;
                            case "+":
                                mem[tokens[0].charAt(0)] += evalToken(tokens[2]);
                                break;
                            case "%":
                                mem[tokens[0].charAt(0)] %= evalToken(tokens[2]);
                                break;
                            case "^":
                                mem[tokens[0].charAt(0)] = (int) Math.pow(mem[tokens[0].charAt(0)], evalToken(tokens[2]));
                                break;
                            case "|":
                                mem[tokens[0].charAt(0)] = (int) Math.abs(evalToken(tokens[0]));
                                break;
                        }
                    }
                } else if (tokens[0].equals("set")) {
                    mem[evalToken(tokens[1])] = evalToken(tokens[2]);
                } else if (tokens[0].equals("if")) {
                    if (evalToken(tokens[1]) > 0) {
                        for (int i = 0; i < program.length; i++) {
         try{
                            if (program[i].substring(3).equals(tokens[2])) {
                                ptr = i - 1;//we increment it later
                            }
         }catch(Exception ex){
         //my apologies for the kludge 
         }    
         }

                    }
                } else if (tokens[0].equals("readIO")) {
                    mem['i'] = getIntFromUser(line.substring(7));
                } else if (tokens[0].equals("rand")) {
                    mem['r'] = (int) (Math.random() * evalToken(tokens[1]));
                }
                ptr++;
            } catch (Exception ex) {
                //ex.printStackTrace();
                //to enable warnings uncomment this warning
                System.err.println("Some error on line: " + ptr + " \"" + line + "\"");
                //praise vb "on error resume next"!
                ptr++;
            }
        }
        System.exit(0);
    }

    /**
     *
     * @param fileName is the path to the file or just the name if it is local
     * @return an array of Strings where each string is one line from the file
     * fileName.
     */
    public static String[] getWordsFromFile(String fileName) {
        int lengthOfFile = getLengthOfFile(fileName);
        String[] wordBank = new String[lengthOfFile];
        int i = 0;
        try {
            File textFile = new File(fileName);
            Scanner sc = new Scanner(textFile);
            for (i = 0; i < lengthOfFile; i++) {
                wordBank[i] = sc.nextLine();
            }
            return wordBank;
        } catch (Exception e) {
            System.err.println(e);
            System.exit(55);
        }
        return null;
    }

    /**
     *
     * @param fileName is the path to the file or just the name if it is local
     * @return the number of lines in fileName
     */
    public static int getLengthOfFile(String fileName) {
        int length = 0;
        try {
            File textFile = new File(fileName);
            Scanner sc = new Scanner(textFile);
            while (sc.hasNextLine()) {
                sc.nextLine();
                length++;
            }
        } catch (Exception e) {
        }
        return length;
    }

    /**
     * gets an int from the user after printing prompt
     *
     * @param prompt the prompt for input
     * @return an integer typed in by the user Note we do not check input
     * validity here
     */
    public static int getIntFromUser(String prompt) {
        System.out.println(prompt);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    /**
     * Evaluates a token by figuring out wether it is an integer literal or a
     * variable
     *
     * @param token to evaluate
     * @return the value of the token
     */
    private static int evalToken(String token) {
        try {
            return Integer.parseInt(token);

        } catch (Exception e) {
            return mem[token.charAt(0)];
        }

    }

    /**
     * Evaluates a get statement for array access
     *
     * @param tokens the list of tokens on the line
     * @return the value located at the respective location in memory
     */
    private static int evalGetStatement(String[] tokens) {
        try {
            return Integer.parseInt(tokens[2]);
        } catch (Exception e) {
            try {
                return mem[evalToken(tokens[3])];
            } catch (Exception ex) {
                return mem[tokens[2].charAt(0)];
            }
        }
    }

}