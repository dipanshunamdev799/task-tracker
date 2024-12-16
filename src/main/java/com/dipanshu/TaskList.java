package com.dipanshu;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TaskList {
    private static ArrayList<Task> list = null;
    private static final String filePath = "tasks.json";
    static{
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            objectMapper.readValue(new File(TaskList.filePath), new TypeReference<ArrayList<Task>>() {
            });
        }catch(Exception e){
            try {
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), list);
            } catch (StreamWriteException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (DatabindException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    public static void fetchJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read JSON from file and convert to List<Employee>
            list = objectMapper.readValue(new File(filePath), new TypeReference<ArrayList<Task>>() {
            });
            if (list == null)
                list = new ArrayList<Task>();
        } catch (IOException e) {
            System.err.println("Error reading JSON file: " + e.getMessage());
            System.out.println("New file will be created.");
            list = new ArrayList<Task>();
        }
    }

    public static int getTaskCount() {
        return list.size();
    }

    public static ArrayList<Task> getALlTasks() {
        return list;
    }

    public static Task getTask(int number) {
        number--; // get the index
        if (number >= 0 && number < list.size()) {
            return list.get(number);
        }
        throw new IllegalArgumentException("Invalid task number: " + (number + 1));
    }

    public static void deleteTask(int number) {
        number--;
        if (number >= 0 && number < list.size()) {
            list.remove(number);
        } else {
            System.out.println("Enter valid task number!");
            System.exit(0);
        }
    }

    public static void addTask(Task task) {
        list.add(task);
    }

    public static void updateJSON() throws StreamWriteException, DatabindException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), list);
        } catch (IOException e) {
            System.err.println("Error writing to JSON file: " + e.getMessage());
        }
    }
}
