import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {
    private List<Student> students;
    private Scanner scanner;

    // Constructor
    public StudentManagementSystem() {
        this.students = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Method to add a student
    public void addStudent() {
        System.out.println("Enter student name:");
        String name = scanner.nextLine();

        System.out.println("Enter student roll number:");
        int rollNumber = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter student grade:");
        char grade = scanner.nextLine().charAt(0);

        Student student = new Student(name, rollNumber, grade);
        students.add(student);
        System.out.println("Student added successfully.");
    }

    // Method to remove a student
    public void removeStudent() {
        System.out.println("Enter roll number of student to remove:");
        int rollNumber = Integer.parseInt(scanner.nextLine());

        boolean removed = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNumber() == rollNumber) {
                students.remove(i);
                removed = true;
                System.out.println("Student removed successfully.");
                break;
            }
        }
        if (!removed) {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    }

    // Method to display all students
    public void displayAllStudents() {
        System.out.println("All Students:");
        System.out.println("+------------+----------------------+-------+");
        System.out.println("| Roll Number|         Name         | Grade |");
        System.out.println("+------------+----------------------+-------+");
        for (Student student : students) {
            System.out.printf("| %-11d| %-20s|   %c   |\n", student.getRollNumber(), student.getName(), student.getGrade());
        }
        System.out.println("+------------+----------------------+-------+");
    }

    // Main method
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nOptions:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    sms.addStudent();
                    break;
                case 2:
                    sms.removeStudent();
                    break;
                case 3:
                    sms.displayAllStudents();
                    break;
                case 4:
                    System.out.println("Thank You.");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
        scanner.close();
    }
}
