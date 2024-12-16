package com.dipanshu;

public class TaskOperations {
    public static void listOperations() {
        System.out.println("How to use: ");
        System.out.println("java -jar <task_tracker>.jar <options>");
        System.out.println("Options :");
        System.out.println("1. add <task_description>");
        System.out.println("2. update <task_id> <new_task_description>");
        System.out.println("3. delete <task_id>");
        System.out.println("4. mark-done <task_id>");
        System.out.println("5. mark-in-progress <task_id>");
        System.out.println("6. mark-todo <task_id>");
        System.out.println("7. list");
        System.out.println("8. list <status : done / in-progress / todo>");
    }

    public static void listAll() {
        System.out.println("Task_Number  Task_Status  Task_Description");
        Integer count = 0;
        for (Task task : TaskList.getALlTasks()) {
            count++;
            System.out.print(count);
            for (int i = 0; i < 12 - count.toString().length(); i++)
                System.out.print(" ");
            System.out.print(" ");
            System.out.print(task.getStatus());
            for (int i = 0; i < 12 - task.getStatus().toString().length(); i++)
                System.out.print(" ");
            System.out.print(" ");
            System.out.print(task.getDescription());
            System.out.println();
        }
    }

    public static void add(String description) {
        if (description == null || description.trim().isEmpty()) {
            System.out.println("Task description cannot be empty!");
            return;
        }
        TaskList.addTask(new Task(description));
        System.out.println("Task added!");
    }

    public static void update(int number, String description) {
        TaskList.getTask(number).setDescription(description);
        System.out.println("Description updated!");
    }

    public static void delete(int number) {
        TaskList.deleteTask(number);
        System.out.println("Task deleted");
    }

    public static void markInProgress(int number) {
        TaskList.getTask(number).setStatus(TaskStatus.IN_PROGRESS);
        System.out.println("Task Updated!");
    }

    public static void markDone(int number) {
        TaskList.getTask(number).setStatus(TaskStatus.DONE);
        System.out.println("Task Updated!");
    }

    public static void markTODO(int number) {
        TaskList.getTask(number).setStatus(TaskStatus.TODO);
        System.out.println("Task Updated!");
    }

    public static void listDone() {
        if (TaskList.getTaskCount() == 0) {
            System.out.println("No tasks found!");
            return;
        }
        System.out.println("Task_Number  Task_Status  Task_Description");
        Integer count = 0;
        for (Task task : TaskList.getALlTasks()) {
            count++;
            if (task.getStatus() != TaskStatus.DONE)
                continue;
            System.out.print(count);
            for (int i = 0; i < 12 - count.toString().length(); i++)
                System.out.print(" ");
            System.out.print(" ");
            System.out.print(task.getStatus());
            for (int i = 0; i < 12 - task.getStatus().toString().length(); i++)
                System.out.print(" ");
            System.out.print(" ");
            System.out.print(task.getDescription());
            System.out.println();
        }
    }

    public static void listInProgress() {
        if (TaskList.getTaskCount() == 0) {
            System.out.println("No tasks found!");
            return;
        }
        System.out.println("Task_Number  Task_Status  Task_Description");
        Integer count = 0;
        for (Task task : TaskList.getALlTasks()) {
            count++;
            if (task.getStatus() != TaskStatus.IN_PROGRESS)
                continue;
            System.out.print(count);
            for (int i = 0; i < 12 - count.toString().length(); i++)
                System.out.print(" ");
            System.out.print(" ");
            System.out.print(task.getStatus());
            for (int i = 0; i < 12 - task.getStatus().toString().length(); i++)
                System.out.print(" ");
            System.out.print(" ");
            System.out.print(task.getDescription());
            System.out.println();
        }
    }

    public static void listTODOD() {
        if (TaskList.getTaskCount() == 0) {
            System.out.println("No tasks found!");
            return;
        }
        System.out.println("Task_Number  Task_Status  Task_Description");
        Integer count = 0;
        for (Task task : TaskList.getALlTasks()) {
            count++;
            if (task.getStatus() != TaskStatus.TODO)
                continue;
            System.out.print(count);
            for (int i = 0; i < 12 - count.toString().length(); i++)
                System.out.print(" ");
            System.out.print(" ");
            System.out.print(task.getStatus());
            for (int i = 0; i < 12 - task.getStatus().toString().length(); i++)
                System.out.print(" ");
            System.out.print(" ");
            System.out.print(task.getDescription());
            System.out.println();
        }
    }
}
