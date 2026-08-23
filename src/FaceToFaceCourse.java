public class FaceToFaceCourse extends Course {
    private int capacity;

    public FaceToFaceCourse(String courseName, int capacity, String year, String deliveryMode, String lectureDay, String startTime, double durationHours, int currentEnrolments) {
        super(courseName, year, deliveryMode, lectureDay, startTime, durationHours, currentEnrolments);
        this.capacity = capacity;
    }

    @Override
    public boolean isFull() {
        return this.getCurrentEnrolments() >= this.capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}