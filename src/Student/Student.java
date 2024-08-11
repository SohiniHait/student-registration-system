package Student;

import course.Course;

import java.util.ArrayList;
import java.util.List;

public class Student {

    int studentId;
    String studentName;

    List<String> courseList;

    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        courseList = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<String> getCourseList() {
        return courseList;
    }

    public void setNewCourse(String course) {
        this.courseList.add(course);
    }

    public void setCourseList(List<String> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", courseList=" + courseList +
                '}';
    }
}
