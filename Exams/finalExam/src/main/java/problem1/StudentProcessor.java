package problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StudentProcessor {

  List<Student> studentList = new ArrayList<>();

  public StudentProcessor(List<Student> studentList) {
    this.studentList = studentList;
  }

  public StudentProcessor(Student student1, Student student2) {
    this.studentList.add(student1);
    this.studentList.add(student2);
  }

  /**
   * Gets the number of courses that the student takes and are less or equal than grade.
   * @param student The student
   * @param grade The threshold grade used to be compared.
   * @return count number of the courses that the student takes and are less or equal than the
   * threshold grade.
   */
  public static Long mysteryMethod(Student student, Integer grade) {
    return student.getTakenCourses().stream()
        .filter(x -> x.getGrade() <= grade).count();
  }

  /**
   * Gets a list of all students who have taken the course and have gotten a grade equal to or
   * higher than the threshold grade.
   * @param courseName The course name to be examined.
   * @param grade The threshold grade of the course.
   * @return a list students who meet the requirements.
   */
  public List<Student> filterByCourseByGrade(String courseName, Integer grade){
    //YOUR CODE HERE
    return this.studentList.stream().filter(n -> checkByCourseByGrade(n.getTakenCourses(),courseName,grade)).collect(
        Collectors.toList());
  }

  /**
   * Helper method to check if the course that is equal to or greater than the threshold grade is
   * in the course list.
   * @param courses the course list.
   * @param courseName a course name to be examined.
   * @param grade the threshold grade.
   * @return true if the course is in the list. Otherwise, false.
   */
  public boolean checkByCourseByGrade(List<Course> courses, String courseName, Integer grade){
    return courses.stream().anyMatch(n -> n.getCourseName().equals(courseName) && n.getGrade() >= grade);
  }
}
