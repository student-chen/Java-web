package models;



/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Admin  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String adminId;
     private String adminName;
     private String adminPs;


    // Constructors

    /** default constructor */
    public Admin() {
    }

    
    /** full constructor */
    public Admin(String adminId, String adminName, String adminPs) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPs = adminPs;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminId() {
        return this.adminId;
    }
    
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return this.adminName;
    }
    
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPs() {
        return this.adminPs;
    }
    
    public void setAdminPs(String adminPs) {
        this.adminPs = adminPs;
    }
   








}