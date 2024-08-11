package Student;

import java.util.HashMap;
import java.util.Map;

public class StudentDatabase {

   private Map<Integer,Student> studentDatabase;

    public StudentDatabase() {
        studentDatabase = new HashMap<>();
    }

    public void addStudent(Student student){
        studentDatabase.put(student.studentId,student);
    }

    public void removeStudent(int studentId){
        if(studentDatabase.containsKey(studentId)){
            studentDatabase.remove(studentId);
        }
    }
    public Student getStudent(int studentId){
       return studentDatabase.get(studentId);
    }
}
