

/* Project Description : Create a maven project that do the following:
 * Read the data stored at the following URL or file 
 * Create a class called Student that stores the information above.
 * Please As you see, there are multiple students information. 
 * You need to store them as array of students.
 * Provide a search functionality by name or by gender.
 * Author : Ayalew Abera
 * Date :10/17/2021
 */
public class Student {
	private String first_name;  	// Variable holding first name  
	private double gpa;				// Variable holding gpa  
	private String email;			// Variable holding email 
	private String gender;			// Variable holding gender 

	/** This constructor initializes the id, first name, gpa, email, and gender    
    @param id The student id.      
    @param first_name The student first name.      
    @param gpa The student gpa.   
    @param email The student email.      
    @param gender The student gender.   
	 */
	
	public Student(int id, String first_name, double gpa, String email, String gender) {
		this.id = id;
		this.first_name = first_name;
		this.gpa =gpa;
		this.email= email;
		this.gender= gender;
	}

	/** This constructor initializes the first name and gender    
     @param first_name The student first name.      
     @param gender The student gender.   
	 */
	public Student(String first_name, String gender) {
		this.first_name = first_name;
		this.gender= gender;
	}

	private int id;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * @return the gpa
	 */
	public double getGpa() {
		return gpa;
	}
	/**
	 * @param gpa the gpa to set
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
    toString method      
	@return A string containing the student information.   
	 */
	public String toString()   
	{      
		// Create a string representing the object.      
		String str =  getFirst_name() + " : " + getGender();      
		// Return the string.      
		return str;  
	}
	/**
	 * hashCode Method
	 * @return A hash code for this student first Name
	 */
	public int hashCode() {
		return first_name.hashCode();
	}
		
	public boolean equals(Object obj) {

		//make sure the other object is a Student too
		if (obj == null|| !(obj instanceof Student)) {
			return false;
		}
		else
		{
			/*
			 * Both Student: Get a reference to other object 
			 * as a Student and check if their firstname are equal
			 */
			Student tempStudent = (Student) obj;
			return first_name.equalsIgnoreCase(tempStudent.first_name);

		}
	}
}
