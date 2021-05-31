package problem1;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class StudentProcessorTest {
  String name = "john";
  String studentID = "1";
  String academicProgram = "cs";
  List<Course> takenCourses = new ArrayList<>();
  Course cs5001 = new Course("CS foundation", "cs5001", LocalDate.of(2020,9,8),4);
  Course cs5002 = new Course("discrete math", "cs5003", LocalDate.of(2020,9,8),3);
  Course cs5008 = new Course("computer system", "cs5008", LocalDate.of(2021,1,8),2);
  Student student1;
  Student student2;
  Student student3;
  StudentProcessor studentProcessor;

  @Before
  public void setUp() throws Exception {
    takenCourses.add(cs5001);
    takenCourses.add(cs5002);
    takenCourses.add(cs5008);
    student1 = new Student(name, studentID,academicProgram,takenCourses);
    student2 = new Student("tom", studentID,academicProgram,takenCourses);
    student3 = new Student("joe", studentID,academicProgram,takenCourses);
    studentProcessor = new StudentProcessor(student1,student2);
  }

  @Test
  public void mysteryMethod() {
    assertTrue(StudentProcessor.mysteryMethod(student1,3) == 2);
  }


  @Test
  public void filterByCourseByGrade() {
    assertTrue(studentProcessor.filterByCourseByGrade("CS foundation",3).size() == 2);
  }


  @Test
  public void checkByCourseByGrade() {
    assertTrue(studentProcessor.checkByCourseByGrade(student1.getTakenCourses(),"CS foundation",3));
  }
}