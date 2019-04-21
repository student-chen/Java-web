package models;



/**
 * Student_course entity. @author MyEclipse Persistence Tools
 */

public class Student_course  implements java.io.Serializable {


    // Fields    

     private Student_courseId id;
     private Integer grade;


    // Constructors

    /** default constructor */
    public Student_course() {
    }

	/** minimal constructor */
    public Student_course(Student_courseId id) {
        this.id = id;
    }
    
    /** full constructor */
    public Student_course(Student_courseId id, Integer grade) {
        this.id = id;
        this.grade = grade;
    }

   
    // Property accessors

    public Student_courseId getId() {
        return this.id;
    }
    
    public void setId(Student_courseId id) {
        this.id = id;
    }

    public Integer getGrade() {
        return this.grade;
    }
    
    public void setGrade(Integer grade) {
        this.grade = grade;
    }
   








}