import Student.Student;
import Student.StudentDatabase;
import course.Course;
import course.CourseDatabase;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Client {

    private static CourseDatabase  MCKVIE_Course_Database = new CourseDatabase();
    private static StudentDatabase studentDatabase = new StudentDatabase();
    static boolean flag = false;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        initializeCollegeCourseDatabase();

        while (!flag){
            System.out.println("");
            System.out.println("");
            System.out.println("1. Display Available Seats");
            System.out.println("2. Register Student / Admission");
            System.out.println("3. Edit course");
            System.out.println("4. View student details");

            int userInput = sc.nextInt();

            switch (userInput){
                case 1: {
                    displayAvailableCourse(MCKVIE_Course_Database);
                    break;
                }
                case 2: {
                    admissionForm();
                    break;
                }
                case 3: {
                    editCourse();
                    break;
                }
                case 4:{
                    getStudentDetails();
                    break;
                }
            }

            sc.nextLine();
            System.out.println("Do you want to exit yes/no?");

            String userinput2 = sc.nextLine();
            if(userinput2.equals("yes")){
                flag= true;
            }
        }

    }

    static void editCourse(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student id to edit course...");
        int studentId = sc.nextInt();
        Student student = studentDatabase.getStudent(studentId);
        System.out.print("registered courses - > ");
        for(String courseName:student.getCourseList()){
            System.out.println(courseName);
        }

        System.out.println("1. Add course");
        System.out.println("2. Remove Course");

        int userInput = sc.nextInt();
        switch (userInput){
            case 1: {
                    addCourse(student);
                    break;
                    }

            case 2: {
                    removeCourse(student);
                    break;
                    }
            }
        }

     private static void removeCourse(Student student){
         Scanner sc = new Scanner(System.in);
         List<String> courseList = student.getCourseList();
         System.out.println("Enter course to remove..");
         String courseName = sc.nextLine();
         courseList.remove(courseName);
         student.setCourseList(courseList);
         Course currentCourse  =  MCKVIE_Course_Database.getCourse(courseName);
         currentCourse.setCurrentStength(currentCourse.getCurrentStength()-1);
         MCKVIE_Course_Database.addNewCourse(currentCourse);

     }

    private static void addCourse(Student student) {
        Scanner sc = new Scanner(System.in);
        List<String> courseList = student.getCourseList();
        System.out.println("Enter course to add");
        String courseName = sc.nextLine();
        courseList.add(courseName);
        student.setCourseList(courseList);
        System.out.println(courseName+" Course is successfully Added");
        Course currentCourse  =  MCKVIE_Course_Database.getCourse(courseName);
        currentCourse.setCurrentStength(currentCourse.getCurrentStength()+1);
        MCKVIE_Course_Database.addNewCourse(currentCourse);

}


    static void admissionForm(){
        Scanner sc = new Scanner(System.in);
            System.out.println("");
            System.out.println("");
            System.out.println("Enter Student Name: ");
            String name = sc.nextLine();
            System.out.println("Enter student id ");
            int id = sc.nextInt();
            System.out.println("Enter desired course");
            sc.nextLine();
            String courseName = sc.nextLine();

            Student newStudent  = new Student(id,name);
            newStudent.setNewCourse(courseName);

            addNewStudent(newStudent);

            System.out.println(name + " is registered successfully");
            System.out.println("");
            System.out.println("");
            System.out.println("Dou you want to add a new Student y/n");
            String flagInput = sc.nextLine();

    }
    static void getStudentDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.println(" Enter your id");
        int studentId = sc.nextInt();
        Student student = studentDatabase.getStudent(studentId);
        System.out.println(student);

    }

    static void addNewStudent( Student student){
        List<String> studentCourseList = student.getCourseList();
        for(String s:studentCourseList){
          Course currentCourse  =  MCKVIE_Course_Database.getCourse(s);
          currentCourse.setCurrentStength(currentCourse.getCurrentStength()+1);
          MCKVIE_Course_Database.addNewCourse(currentCourse);
        }
        studentDatabase.addStudent(student);
    }


    static  void displayAvailableCourse(CourseDatabase MCKVIE_Course_Database){
        //COUNSELLING
        //To Check available courses with seat left
        List<Course> paper = MCKVIE_Course_Database.availableCourses();
        System.out.println("AVAILABLE COURSES");
        System.out.println("-----------------------------------------------------");
        for(Course course:paper){
            if((course.getCapacity()== course.getCurrentStength()))
                System.out.println(course.getTitle()+" --> "+"FULL");
            else
                System.out.println(course.getTitle()+" --> "+ (course.getCapacity()- course.getCurrentStength()));
        }
        System.out.println("-------------------------------------------------------");
    }


    static CourseDatabase initializeCollegeCourseDatabase(){
        // Object of Courses
        Course mechanical = new Course();
        mechanical.setCapacity(5);
        mechanical.setCurrentStength(0);
        mechanical.setTitle("Mechanical");
        mechanical.setCourseCode(001);
        mechanical.setDescription("Mechanics and Instrumentation");
        mechanical.setSchedule("9AM - 10AM");

        Course cse = new Course();
        cse.setCapacity(5);
        cse.setCurrentStength(0);
        cse.setTitle("Computer Science and Engineering");
        cse.setCourseCode(002);
        cse.setDescription("Information and Technology");
        cse.setSchedule("10AM - 11AM");

        Course ece = new Course();
        ece.setCapacity(5);
        ece.setCurrentStength(0);
        ece.setTitle("Electronic and Telecommunication");
        ece.setCourseCode(003);
        ece.setDescription("Electronic and Telecommunication");
        ece.setSchedule("11AM - 12AM");

        //Admission

        //Object of database

        MCKVIE_Course_Database.addNewCourse(mechanical);
        MCKVIE_Course_Database.addNewCourse(cse);
        MCKVIE_Course_Database.addNewCourse(ece);

        return MCKVIE_Course_Database;
    }
    return true;
}
