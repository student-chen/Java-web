package models;

import java.util.HashSet;
import java.util.Set;


/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student  implements java.io.Serializable {


    // Fields    

     private Integer stuId;
     private String stuName;
     private String stuSex;
     private String stuAddress;
     private String stuPhone;
     private String stuSp;
     private String stuClass;
     private String stuEmail;
     private Set student_courses = new HashSet(0);


    // Constructors

    /** default constructor */
    public Student() {
    }

    
    /** full constructor */
    public Student(String stuName, String stuSex, String stuAddress, String stuPhone, String stuSp, String stuClass, String stuEmail, Set student_courses) {
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuAddress = stuAddress;
        this.stuPhone = stuPhone;
        this.stuSp = stuSp;
        this.stuClass = stuClass;
        this.stuEmail = stuEmail;
        this.student_courses = student_courses;
    }

   
    // Property accessors

    public Integer getStuId() {
        return this.stuId;
    }
    
    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return this.stuName;
    }
    
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return this.stuSex;
    }
    
    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuAddress() {
        return this.stuAddress;
    }
    
    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }

    public String getStuPhone() {
        return this.stuPhone;
    }
    
    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    public String getStuSp() {
        return this.stuSp;
    }
    
    public void setStuSp(String stuSp) {
        this.stuSp = stuSp;
    }

    public String getStuClass() {
        return this.stuClass;
    }
    
    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public String getStuEmail() {
        return this.stuEmail;
    }
    
    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    public Set getStudent_courses() {
        return this.student_courses;
    }
    
    public void setStudent_courses(Set student_courses) {
        this.student_courses = student_courses;
    }
   








}