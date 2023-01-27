package sdf;

import java.io.Console;

public class Main {

    public static void main(String[] args) {
        
        Integer $last = 0;
        String operator = "";

        Console cons = System.console();

        // display a welcome message
        System.out.println("Welcome.");

        while (!operator.equalsIgnoreCase("exit")) {

            String[] input = cons.readLine("> ").toLowerCase().split(" ");

            if (!(input.length == 3)) {

            } else {

                switch (input[1]) {

                    case Constants.ADD:
                        if (input[0].equals("$last")) {
                            if (input[2].equals("$last")) {
                                $last = 2 * $last;
                            } else {
                                $last = $last + Integer.parseInt(input[2]);
                            }
                        } else if (input[2].equals("$last")) {
                            $last = Integer.parseInt(input[0]) + $last;
                        } else {
                            $last = (Integer.parseInt(input[0]) + Integer.parseInt(input[2]));
                        }
                        System.out.println($last);
                        break;
                    case Constants.MINUS:
                        if (input[0].equals("$last")) {
                            if (input[2].equals("$last")) {
                                $last = 0;
                            } else {
                                $last = $last - Integer.parseInt(input[2]);
                            }
                        } else if (input[2].equals("$last")) {
                            $last = Integer.parseInt(input[0]) - $last;
                        } else {
                            $last = (Integer.parseInt(input[0]) - Integer.parseInt(input[2]));
                        }
                        System.out.println($last);
                        break;
                    case Constants.DIVIDE:
                        if (input[0].equals("$last")) {
                            if (input[2].equals("$last")) {
                                try {
                                    $last = $last / $last;
                                } catch (ArithmeticException e) {
                                    System.out.println("Division by zero");
                                }
                            } else {
                                $last = $last / Integer.parseInt(input[2]);
                            }
                        } else if (input[2].equals("$last")) {
                            $last = Integer.parseInt(input[0]) / $last;
                        } else {
                            $last = (Integer.parseInt(input[0]) / Integer.parseInt(input[2]));
                        }
                        System.out.println($last);
                        break;
                    case Constants.MULTIPLY:
                        if (input[0].equals("$last")) {
                            if (input[2].equals("$last")) {
                                $last = ($last*$last);
                            } else {
                                $last = $last * Integer.parseInt(input[2]);
                            }
                        } else if (input[2].equals("$last")) {
                            $last = Integer.parseInt(input[0]) * $last;
                        } else {
                            $last = (Integer.parseInt(input[0]) * Integer.parseInt(input[2]));
                        }
                        System.out.println($last);
                        break;
                    case Constants.TIMES:
                        if (input[0].equals("$last")) {
                            if (input[2].equals("$last")) {
                                $last = ($last*$last);
                            } else {
                                $last = $last * Integer.parseInt(input[2]);
                            }
                        } else if (input[2].equals("$last")) {
                            $last = Integer.parseInt(input[0]) * $last;
                        } else {
                            $last = (Integer.parseInt(input[0]) * Integer.parseInt(input[2]));
                        }
                        System.out.println($last);
                        break;
                    default: {}
    
                }

            }

            operator = input[0];

        }

        System.out.println("Bye bye");


    }
}