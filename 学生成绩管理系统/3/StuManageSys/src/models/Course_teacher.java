package models;

import java.util.HashSet;
import java.util.Set;


/**
 * Course_teacher entity. @author MyEclipse Persistence Tools
 */

public class Course_teacher  implements java.io.Serializable {


    // Fields    

     private Integer CTId;
     private Teacher teacher;
     private Course course;
     private Set student_courses = new HashSet(0);


    // Constructors

    /** default constructor */
    public Course_teacher() {
    }

    
    /** full constructor */
    public Course_teacher(Teacher teacher, Course course, Set student_courses) {
        this.teacher = teacher;
        this.course = course;
        this.student_courses = student_courses;
    }

   
    // Property accessors

    public Integer getCTId() {
        return this.CTId;
    }
    
    public void setCTId(Integer CTId) {
        this.CTId = CTId;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }
    
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Course getCourse() {
        return this.course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }

    public Set getStudent_courses() {
        return this.student_courses;
    }
    
    public void setStudent_courses(Set student_courses) {
        this.student_courses = student_courses;
    }
   








}