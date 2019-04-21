package models;

import java.util.HashSet;
import java.util.Set;


/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course  implements java.io.Serializable {


    // Fields    

     private Integer CId;
     private String CName;
     private Integer CHour;
     private Set course_teachers = new HashSet(0);


    // Constructors

    /** default constructor */
    public Course() {
    }

    
    /** full constructor */
    public Course(String CName, Integer CHour, Set course_teachers) {
        this.CName = CName;
        this.CHour = CHour;
        this.course_teachers = course_teachers;
    }

   
    // Property accessors

    public Integer getCId() {
        return this.CId;
    }
    
    public void setCId(Integer CId) {
        this.CId = CId;
    }

    public String getCName() {
        return this.CName;
    }
    
    public void setCName(String CName) {
        this.CName = CName;
    }

    public Integer getCHour() {
        return this.CHour;
    }
    
    public void setCHour(Integer CHour) {
        this.CHour = CHour;
    }

    public Set getCourse_teachers() {
        return this.course_teachers;
    }
    
    public void setCourse_teachers(Set course_teachers) {
        this.course_teachers = course_teachers;
    }
   








}