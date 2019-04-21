package models;

import java.util.HashSet;
import java.util.Set;


/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher  implements java.io.Serializable {


    // Fields    

     private Integer TId;
     private String TName;
     private String TPhone;
     private Set course_teachers = new HashSet(0);


    // Constructors

    /** default constructor */
    public Teacher() {
    }

    
    /** full constructor */
    public Teacher(String TName, String TPhone, Set course_teachers) {
        this.TName = TName;
        this.TPhone = TPhone;
        this.course_teachers = course_teachers;
    }

   
    // Property accessors

    public Integer getTId() {
        return this.TId;
    }
    
    public void setTId(Integer TId) {
        this.TId = TId;
    }

    public String getTName() {
        return this.TName;
    }
    
    public void setTName(String TName) {
        this.TName = TName;
    }

    public String getTPhone() {
        return this.TPhone;
    }
    
    public void setTPhone(String TPhone) {
        this.TPhone = TPhone;
    }

    public Set getCourse_teachers() {
        return this.course_teachers;
    }
    
    public void setCourse_teachers(Set course_teachers) {
        this.course_teachers = course_teachers;
    }
   








}