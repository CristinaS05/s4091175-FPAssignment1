
public abstract class Course {
    private String courseName;
    private String year;
    private String deliveryMode;
    private String lectureDay;
    private String startTime;      
    private double durationHours; 
    private int currentEnrolments;

    public Course(String courseName, String year, String deliveryMode, String lectureDay, String startTime, double durationHours, int currentEnrolments) {
        this.courseName = courseName;
        this.year = year;
        this.deliveryMode = deliveryMode;
        this.lectureDay = lectureDay;
        this.startTime = startTime;
        this.durationHours = durationHours;
        this.currentEnrolments = currentEnrolments;
    }
    
    /**
     * Checks if the course is at maximum capacity.
     * Must be implemented by subclasses.
     */
    public abstract boolean isFull();

    /**
     * Converts "HH:mm" formatted string to minutes
     * Example: "9:30" -> 9 * 60 + 30 = 570 min
     */
    public int getStartMinutes() {
        String[] parts = this.startTime.split(":");
        int hours = Integer.parseInt(parts[0].trim());
        int minutes = Integer.parseInt(parts[1].trim());
        return (hours * 60) + minutes;
    }

    /**
     * Computes the lecture end time in total minutes
     */
    public int getEndMinutes() {
        int durationMinutes = (int) Math.round(this.durationHours * 60);
        return getStartMinutes() + durationMinutes;
    }

    /**
     * Checks if this course has a time overlap with another course.
     * including edge case where the duration of one course is within the duration of another course.
     */
    public boolean clashesWith(Course other) {
        if (!this.lectureDay.equalsIgnoreCase(other.getLectureDay())) {
            return false;
        }
        return this.getStartMinutes() < other.getEndMinutes() 
            && other.getStartMinutes() < this.getEndMinutes();
    }

    // --- Enrollment Modification ---

    public void incrementEnrolment() {
        this.currentEnrolments++;
    }

    public void decrementEnrolment() {
        if (this.currentEnrolments > 0) {
            this.currentEnrolments--;
        }
    }

    // --- Getters & Setters ---

    public String getCourseName() {
        return courseName;
    }

    public String getYear() {
        return year;
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public String getLectureDay() {
        return lectureDay;
    }

    public String getStartTime() {
        return startTime;
    }

    public double getDurationHours() {
        return durationHours;
    }

    public int getCurrentEnrolments() {
        return currentEnrolments;
    }
}