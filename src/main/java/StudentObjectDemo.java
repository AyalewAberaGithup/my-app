

/* Project Description : Create a maven project that do the following:
 * Read the data stored at the following URL or file 
 * Create a class called Student that stores the information above.
 * Please As you see, there are multiple students information. 
 * You need to store them as array of students.
 * Provide a search functionality by name or by gender.
 * Author : Ayalew Abera
 * Date :10/17/2021
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class StudentObjectDemo {

	List <Student> students = new ArrayList <Student> ();

	public void loadStudent() throws IOException {
		//read file 
		//Creating FileReader objects and passing the file name or file path"
		String fileName =  "C:\\Users\\Ayalew Abera\\eclipse-workspace\\INEW2438AdvancedJava\\my-app\\src\\main\\resources\\student.txt";
		FileReader fReader = new FileReader(fileName);		 //Open and make a connection with the file
		BufferedReader bReader = new BufferedReader(fReader);	 //Creating BufferedReader objects and passing fileSource

		// read the first line 
		String line = bReader.readLine();

		// read each line from student
		while (line != null) {

			String [] tokens = line.split( ","); 		 //split the line to token 
			int id = Integer.parseInt(tokens[0]);  		 //parse the first token and assign to id
			String  first_name = tokens[1]; 		 	 //assign the second value to first name 
			double gpa = Double.parseDouble(tokens[2]);  //parse the third token  to double and assign to GPA
			String  email = tokens[3]; 					//assign the fourth token or value to email
			String  gender = tokens[4];					//assign the fifth token or value to gender

			//create an object of a class or Student
			Student studentOne = new Student(id, first_name,gpa, email, gender); // object creation
			students.add(studentOne);					//add each object of Student to the list array

			line =bReader.readLine();//read the next line
		}
		bReader.close();

	}
	private void display() {
		System.out.println("===============================Report===============================================");
		System.out.println("\n id \t first Name \t  Score\t\t Email\t\t\t Gender");
		System.out.println("-------------------------------------------------------------------------------------");
		for (Student student: students) {
			System.out.println(" " +student.getId() + ".|\t|" + student.getFirst_name() + "\t\t"
					+ " |" + student.getGpa() + "\t\t|"+ student.getEmail() + "|\t\t|"+ student.getGender());
			//	System.out.println("-------------------------------------------------------------------------------------");

		}
		System.out.println("-------------------------------------------------------------------------------------");

	}
	public static void main(String[] args) throws IOException {
		StudentObjectDemo studentManger = new StudentObjectDemo();
		studentManger.loadStudent();
		studentManger.display();

		//create a hasSet to store  student objects and for search purpose 
		Set <Student> studentSet = new HashSet<Student> ();

		studentSet.add(new Student("Caleb","female"));
		studentSet.add(new Student("Aida", "female"));
		studentSet.add(new Student("Alex","male"));
		studentSet.add(new Student("Meba","male"));

		//Display the element in the HashSet
		System.out.println("\nHere are the Sample student name and gender in the set");
		System.out.println("----------------first name and gender--------------------");
		for (Student stud: studentSet) {
			System.out.println(stud);
		}


		System.out.println();
		System.out.println("-------------Searching existing Student object--Hard coded-------------");
		// Search for a existing Student with hard code
		Student Caleb = new Student("Caleb", "female");
		System.out.println("Searching for " +  Caleb + " in the HashSet?");
		if (studentSet.contains(Caleb)) {
			System.out.println( Caleb + " is in the HashSet");
		}
		else {
			System.out.println( Caleb + " is  NOT in the HashSet");

		}

		System.out.println("\n-------------Searching any student object-----Hard coded---------------");
		// Search for Student with hard code which is not in the Set
		Student ayalew = new Student("ayalew", "male");
		System.out.println("Searching for " +  ayalew + " in the HashSet?");
		if (studentSet.contains(ayalew)) {
			System.out.println( ayalew + " is in the HashSet");
		}
		else {
			System.out.println( ayalew + " is Not in the HashSet");
		}


		// Create a Scanner Object 
		Scanner scan = new Scanner (System.in);
		String input; 		//variable to hold user preference

		do {  //create a do -while loop to search for student objects
			System.out.println("-------------------------------------------------");
			System.out.println("Please enter Student first name and gender ");

			System.out.print("First enter first name:"); 			//Prompt user to enter student first name
			String fName = scan.nextLine(); 						//assign the student first name to variable 
			System.out.print("Second enter gender:");		     	//Prompt user to enter student gender
			String gender = scan.next(); 							//assign the student gender to variable 

			//create instructor object for user input
			Student studentObject = new Student(fName,gender);
			System.out.println("\n-------------Your Search result-------------");//for reporting or visualization
			if (studentSet.contains(studentObject)) { 		          			//checking new input with the existing student info
				System.out.println( studentObject + " Exist in the HashSet");   //Display the if it is exist.

			}
			else {
				System.out.println( studentObject + " is Not Exist in the HashSet");//Display the if it is NOT exist.
			}
			//Consume the remaining newline 
			scan.nextLine();

			//Does user want to search again? or requesting user for additional search
			System.out.println("\n--------Do you want to search again?-----------------");//for reporting or visualization

			System.out.println("Please, enter \"Yes\" or \"Y or y\" to continue searching or any value to exit): "); //give options
			input = scan.nextLine(); //assign user preference  to input variable 
		}
		while(input.equalsIgnoreCase("Yes")|| input.charAt(0) == 'y' || input.charAt(0)== 'Y');//condition to keep the loop iterate 
		scan.close(); // close the scanner 

		System.exit(0); //exit
	}
}
