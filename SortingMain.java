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
            System.out.println("Processing line: " + dataLine); // Debugging output
            StringTokenizer studentToken = new StringTokenizer(dataLine.trim(), ",");
            if (studentToken.countTokens() >= 3) {
                studentToken.nextToken();
                String sid = studentToken.nextToken().trim();
                String firstName = studentToken.nextToken().trim();
                String lastName = studentToken.nextToken().trim();
                studentInfo.add(new StudentsName(sid, firstName, lastName));
            } else {
                System.out.println("Skipping malformed line: " + dataLine);
            }
        }

        return studentInfo;
    }

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length < 2) {
            System.out.println("Usage: <option> <filename>");
            return;
        }

        String option = args[0];
        String filePath = args[1];

        Vector<StudentsName> students = fileReading(filePath);

        if (!option.equals("-n") && !option.equals("-f") && !option.equals("-l") && !option.equals("-s")) {
            System.out.println("Invalid choice. Exiting program.");
            return;
        }

        if ("-s".equals(option)) {
            if (args.length < 3) {
                System.out.println("Usage: -s <name>");
                return;
            }
            String searchName = args[2];
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


