package Test.TasksApp;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TasksApp{
    static Scanner scan = new Scanner(System.in);
    static List<String> array = new ArrayList<>();
    static private final int EXIT = 0;
    static private final int ADD = 1;
    static private final int REMOVE = 2;
    static private final int PRINT = 3;


    public static void main(String[] args) {
        run();
    }

    private static void run() {

        int userChoice = 0;
        boolean error = true;
        do {
            do {
                try {
                    printMenu();
                    userChoice = scan.nextInt();
                    scan.nextLine();
                    action(userChoice);
                    error = false;
                } catch (InputMismatchException e) {
                    System.err.println("Select number!");
                    scan.nextLine();
                } catch (IndexOutOfBoundsException e) {
                    System.err.println("Wrong number, there is no task of this number.");
                }
            } while (error);
        } while (userChoice != EXIT);
        System.out.println("This is the end of program.");
    }

    private static void printMenu() {
        System.out.println("What do you want to do?");
        System.out.println("1 - Add task, 2 - remove task, 3 - print all tasks, 0 - exit");
    }


    private static void action(int userChoice) {
        switch (userChoice) {
            case ADD:
                addTask();
                break;
            case REMOVE:
                removeTask();
                break;
            case PRINT:
                printTasks();
                break;
            case EXIT:
                break;
            default:
                System.out.println("Wrong number, try again.");
        }
    }

    private static void addTask() {
        System.out.println("Wrie task to do:");
        String newTask = scan.nextLine();
        array.add(newTask);
        System.out.println("Ok. I saved new task called: " + newTask );
    }

    private static void removeTask() {
        if (array.isEmpty()) {
            System.out.println("There is no task to remove");
            return;
        }
        System.out.println("Which task do you want to remove?");
        printTasks();
        int removingTask = scan.nextInt()-1;
        System.out.println("I removed task: " + array.get(removingTask));
        array.remove(removingTask);
    }

    private static void printTasks() {
        for (int i = 0; i < array.size(); i++) {
            System.out.println((i+1) + ". " + array.get(i));
        }
    }
}
