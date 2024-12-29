/*Tat Putjorn 672115024 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class SortingMain {
    public static Vector<StudentsName> fileReading(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner readFile = new Scanner(file);
        Vector<StudentsName> studentInfo = new Vector<>();

        for (int i = 0; i < 7 && readFile.hasNextLine(); i++) {
            readFile.nextLine();
        }

        while (readFile.hasNextLine()) {
            String dataLine = readFile.nextLine();
            StringTokenizer studentToken = new StringTokenizer(dataLine.trim(), ",");
            if (studentToken.countTokens() >= 3) {
                studentToken.nextToken();
                String sid = studentToken.nextToken().trim();
                String firstName = studentToken.nextToken().trim();
                String lastName = studentToken.nextToken().trim();
                studentInfo.add(new StudentsName(sid, firstName, lastName));
            }
        }

        return studentInfo;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        Vector<StudentsName> students;
        try {
            students = fileReading(fileName);
            System.out.println("File successfully loaded!");
        } catch (FileNotFoundException e) {
            System.out.println("Error: The specified file could not be found. Please check the file path and try again.");
            return;
        }

        System.out.print("Enter the sorting/search option (-n, -f, -l, -s): ");
        String option = scanner.nextLine();

        if (!option.equals("-n") && !option.equals("-f") && !option.equals("-l") && !option.equals("-s")) {
            System.out.println("Invalid choice. Exiting program.");
            return;
        }

        if ("-s".equals(option)) {
            System.out.print("Enter the first name to search: ");
            String searchName = scanner.nextLine();
            int index = searchStudent(students, searchName);
            if (index != -1) {
                System.out.println("The name " + searchName + " was found at index " + index);
            } else {
                System.out.println("The name " + searchName + " is not in the file.");
            }
            return;
        }

        int sortChoice = switch (option) {
            case "-n" -> 1;
            case "-f" -> 2;
            case "-l" -> 3;
            default -> throw new IllegalStateException("Unexpected value: " + option);
        };

        bubbleSort(students, sortChoice);

        System.out.println("\nSorted Students:");
        for (StudentsName student : students) {
            System.out.println(student);
        }
    }

    public static void bubbleSort(Vector<StudentsName> students, int choice) {
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = 0; j < students.size() - 1 - i; j++) {
                boolean swap = false;

                if (choice == 1 && students.get(j).getSID().compareTo(students.get(j + 1).getSID()) > 0) {
                    swap = true;
                } else if (choice == 2 && students.get(j).getFirstName().compareTo(students.get(j + 1).getFirstName()) > 0) {
                    swap = true;
                } else if (choice == 3 && students.get(j).getLastName().compareTo(students.get(j + 1).getLastName()) > 0) {
                    swap = true;
                }

                if (swap) {
                    StudentsName temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
    }

    public static int searchStudent(Vector<StudentsName> students, String name) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getFirstName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }
}
