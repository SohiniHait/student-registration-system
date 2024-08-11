package course;

public class Course {
    private int courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;

    private int currentStength;



    public Course(){

    }


    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getCurrentStength() {
        return currentStength;
    }

    public void setCurrentStength(int currentStength) {
        this.currentStength = currentStength;
    }


    @Override
    public String toString() {
        return "Course{" +
                "courseCode=" + courseCode +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", capacity=" + capacity +
                ", schedule='" + schedule + '\'' +
                ", currentStength=" + currentStength +
                '}';
    }
}
