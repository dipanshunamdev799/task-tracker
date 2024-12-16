# Task Tracker CLI Application

## Overview

Task Tracker is a lightweight, command-line task management application built with Java. It allows you to create, update, delete, and track tasks with different statuses (TODO, In Progress, Done).

## Features

- Add new tasks
- List all tasks
- Filter tasks by status (TODO, In Progress, Done)
- Update task descriptions
- Mark tasks as TODO, In Progress, or Done
- Delete tasks
- Persistent storage using JSON

## Prerequisites

- Java Development Kit (JDK) 11 or higher
- Apache Maven 3.6+

## Installation

### 1. Clone the Repository

```bash
git clone https://github.com/dipanshunamdev799/task-tracker.git
cd task-tracker
```

### 2. Build the Project

```bash
# Clean and package the project
mvn clean package

```

This will generate an executable JAR file in the `target/` directory.

## Usage

### Basic Commands

```bash
# General help and command list
java -jar target/task-tracker.jar help

# Add a new task
java -jar target/task-tracker.jar add "Buy groceries"

# List all tasks
java -jar target/task-tracker.jar list

# List tasks by status
java -jar target/task-tracker.jar list todo
java -jar target/task-tracker.jar list in-progress
java -jar target/task-tracker.jar list done

# Update a task description
java -jar target/task-tracker.jar update 1 "Buy groceries on Monday"

# Mark task status
java -jar target/task-tracker.jar mark-todo 1
java -jar target/task-tracker.jar mark-in-progress 1
java -jar target/task-tracker.jar mark-done 1

# Delete a task
java -jar target/task-tracker.jar delete 1
```

## Command Reference

| Command | Usage | Description |
|---------|-------|-------------|
| `help` | `java -jar task-tracker.jar help` | Show all available commands |
| `add` | `java -jar task-tracker.jar add "Task description"` | Add a new task |
| `list` | `java -jar task-tracker.jar list [status]` | List all tasks or filter by status (todo/in-progress/done) |
| `update` | `java -jar task-tracker.jar update <task_number> "New description"` | Update a task's description |
| `delete` | `java -jar task-tracker.jar delete <task_number>` | Delete a specific task |
| `mark-todo` | `java -jar task-tracker.jar mark-todo <task_number>` | Mark task as TODO |
| `mark-in-progress` | `java -jar task-tracker.jar mark-in-progress <task_number>` | Mark task as In Progress |
| `mark-done` | `java -jar task-tracker.jar mark-done <task_number>` | Mark task as Done |

## Data Persistence

Tasks are stored in a `tasks.json` file in the same directory as the JAR. This file is automatically created and updated when you add, modify, or delete tasks.

## Project Structure

- `src/main/java/com/dipanshu/Main.java`: Entry point of the application
- `src/main/java/com/dipanshu/Task.java`: Task data model
- `src/main/java/com/dipanshu/TaskList.java`: Task list management
- `src/main/java/com/dipanshu/TaskOperations.java`: Task-related operations
- `src/main/java/com/dipanshu/TaskStatus.java`: Enum for task statuses

## Dependencies

- Jackson Databind (2.13.0): JSON processing

## Troubleshooting

- Ensure you have Java 11+ installed
- Verify Maven is correctly configured
- Check that you're running the command from the project root
- Confirm the JAR file exists in the `target/` directory

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

Distributed under the MIT License. See `LICENSE` for more information.

## Contact

dipanshunamdev799@gmail.com

Project Link: [https://github.com/dipanshunamdev799/task-tracker](https://github.com/dipanshunamdev799/task-tracker)