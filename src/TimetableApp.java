import java.util.Scanner;

public class TimetableApp {
    private Scanner scanner;

    public TimetableApp() {
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Welcome to MyTimetable!");
        boolean exit = false;
    
        do {
            System.out.println("> Select from main menu:");
            System.out.println("1) Search by keyword to enroll");
            System.out.println("2) Show my enrolled courses");
            System.out.println("3) Withdraw from a course");
            System.out.println("4) Exit");
            System.out.print("Please select: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    search();
                    break;
                case 2:
                    showEnrolledCourses();
                    break;
                case 3:
                    withdrawFromCourse();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting MyTimetable. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (!exit);
    }

    private void search() {
        System.out.print("Please provide a brand: ");
        String keyword = scanner.nextLine();
        // Implement search logic here
        System.out.println("Searching for courses with keyword: " + keyword);
    }

    private void showEnrolledCourses() {
        // Implement logic to display enrolled courses
        System.out.println("You have enrolled in the following course(s):");
    }

    private void withdrawFromCourse() {
        // Implement logic to withdraw from a course
        System.out.println("You have withdrawn from " + courseName + "!");
    }
}