import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private List<Course> courses;

    public CSVReader() {
        this.courses = new ArrayList<>();
    }

    /**
     * Reads and parses courses.csv into Course objects.
     */
    public void loadCourses(String filePath) {
        courses.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine(); // Skip header row

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");

                String courseName = data[0].trim();
                String capacityStr = data[1].trim();
                String year = data[2].trim();
                String deliveryMode = data[3].trim();
                String lectureDay = data[4].trim();
                String startTime = data[5].trim();
                double durationHours = Double.parseDouble(data[6].trim());
                int currentEnrolments = Integer.parseInt(data[7].trim());

                if (deliveryMode.equalsIgnoreCase("Face-to-face")) {
                    int capacity = Integer.parseInt(capacityStr);
                    courses.add(new FaceToFaceCourse(
                        courseName, capacity, year, deliveryMode,
                        lectureDay, startTime, durationHours, currentEnrolments
                    ));
                } else {
                    courses.add(new OnlineCourse(
                        courseName, year, deliveryMode,
                        lectureDay, startTime, durationHours, currentEnrolments
                    ));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading course file: " + e.getMessage());
        }
    }

    public List<Course> getCourses() {
        return courses;
    }
}