package models;



/**
 * Student_courseId entity. @author MyEclipse Persistence Tools
 */

public class Student_courseId  implements java.io.Serializable {


    // Fields    

     private Student student;
     private Course_teacher course_teacher;


    // Constructors

    /** default constructor */
    public Student_courseId() {
    }

    
    /** full constructor */
    public Student_courseId(Student student, Course_teacher course_teacher) {
        this.student = student;
        this.course_teacher = course_teacher;
    }

   
    // Property accessors

    public Student getStudent() {
        return this.student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }

    public Course_teacher getCourse_teacher() {
        return this.course_teacher;
    }
    
    public void setCourse_teacher(Course_teacher course_teacher) {
        this.course_teacher = course_teacher;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof Student_courseId) ) return false;
		 Student_courseId castOther = ( Student_courseId ) other; 
         
		 return ( (this.getStudent()==castOther.getStudent()) || ( this.getStudent()!=null && castOther.getStudent()!=null && this.getStudent().equals(castOther.getStudent()) ) )
 && ( (this.getCourse_teacher()==castOther.getCourse_teacher()) || ( this.getCourse_teacher()!=null && castOther.getCourse_teacher()!=null && this.getCourse_teacher().equals(castOther.getCourse_teacher()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getStudent() == null ? 0 : this.getStudent().hashCode() );
         result = 37 * result + ( getCourse_teacher() == null ? 0 : this.getCourse_teacher().hashCode() );
         return result;
   }   





}