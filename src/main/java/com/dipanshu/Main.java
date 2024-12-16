package com.dipanshu;

import java.io.IOException;
import java.util.Arrays;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;

/**
 * Hello world!
 */
public class Main {

    private Main() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     * @throws IOException
     * @throws DatabindException
     * @throws StreamWriteException
     */
    public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
        TaskList.fetchJSON();
        if (args.length == 0) {
            TaskOperations.listOperations();
            return;
        }
        switch (args[0]) {
            case "help":
                if (args.length > 1) {
                    System.out.println("Invalid command!");
                    break;
                }
                TaskOperations.listOperations();
                break;
            case "list":
                if (args.length == 1) {
                    TaskOperations.listAll();
                } else {
                    if (args[1].equals("done")) {
                        TaskOperations.listDone();
                    } else if (args[1].equals("in-progress")) {
                        TaskOperations.listInProgress();
                    } else if (args[1].equals("todo")) {
                        TaskOperations.listTODOD();
                    } else {
                        System.out.println("Enter valid option(done/in-progress/todo)!");
                    }
                }
                break;
            case "add":
                if (args.length == 1) {
                    System.out.println("Enter task description too!");
                    break;
                }
                String description = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
                TaskOperations.add(description);
                break;
            case "update":
                if (args.length <= 1) {
                    System.out.println("Enter task number too!");
                    break;
                }
                try {
                    int number = Integer.parseInt(args[1]);
                    if (args.length <= 2) {
                        System.out.println("Enter task description too!");
                        break;
                    }
                    description = "";
                    for (int i = 2; i < args.length; i++) {
                        description += args[i];
                        if (i == args.length - 1) {
                            continue;
                        } else {
                            description += " ";
                        }
                    }
                    TaskOperations.update(number, description);

                } catch (Exception e) {
                    System.out.println("Give an integer input!");
                }
                break;
            case "delete":
                if (args.length <= 1) {
                    System.out.println("Enter task number too!");
                } else {
                    if (args.length > 2) {
                        System.out.println("Enter valid command!");
                        break;
                    }
                    try {
                        int number = Integer.parseInt(args[1]);
                        TaskOperations.delete(number);

                    } catch (Exception e) {
                        System.out.println("Give an integer input!");
                    }
                }
                break;
            case "mark-in-progress":
                if (args.length <= 1) {
                    System.out.println("Enter task number too!");
                } else {
                    if (args.length > 2) {
                        System.out.println("Enter valid command!");
                        break;
                    }
                    try {
                        int number = Integer.parseInt(args[1]);
                        TaskOperations.markInProgress(number);

                    } catch (Exception e) {
                        System.out.println("Give an integer input!");
                    }
                }
                break;
            case "mark-done":
                if (args.length <= 1) {
                    System.out.println("Enter task number too!");
                } else {
                    if (args.length > 2) {
                        System.out.println("Enter valid command!");
                        break;
                    }
                    try {
                        int number = Integer.parseInt(args[1]);
                        TaskOperations.markDone(number);

                    } catch (Exception e) {
                        System.out.println("Give an integer input!");
                    }
                }
                break;
            case "mark-todo":
                if (args.length <= 1) {
                    System.out.println("Enter task number too!");
                } else {
                    if (args.length > 2) {
                        System.out.println("Enter valid command!");
                        break;
                    }
                    try {
                        int number = Integer.parseInt(args[1]);
                        TaskOperations.markTODO(number);

                    } catch (Exception e) {
                        System.out.println("Give an integer input!");
                    }
                }
                break;
            default:
                TaskOperations.listOperations();
                break;
        }
        TaskList.updateJSON();
    }
}