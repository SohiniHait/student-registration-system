package course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseDatabase {

   private Map<String,Course> courseDatabase = new HashMap<>();

    public void addNewCourse(Course course){
        this.courseDatabase.put(course.getTitle() , course);
    }

    public void removeCourse(String title){
        this.courseDatabase.remove(title);
    }

    public Course getCourse(String title){
      return this.courseDatabase.get(title);
    }

    public List<Course> availableCourses(){
        List<Course> paper = new ArrayList<>();

        for(Map.Entry<String,Course> entry : this.courseDatabase.entrySet()){
//            if(entry.getValue().getCapacity()>entry.getValue().getCurrentStength()){
//                paper.add(entry.getValue());
//            }
            paper.add(entry.getValue());
        }

        return  paper;
    }

    public Map<String,Course> displayDatabase(){
        return  this.courseDatabase;
    }
}
