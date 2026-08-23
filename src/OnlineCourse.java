public class OnlineCourse extends Course {

    public OnlineCourse(String courseName, String year, String deliveryMode, String lectureDay, String startTime, double durationHours, int currentEnrolments) {
        super(courseName, year, deliveryMode, lectureDay, startTime, durationHours, currentEnrolments);
    }

    @Override
    public boolean isFull() {
        return false; // Online courses have no capacity limit
    }
}