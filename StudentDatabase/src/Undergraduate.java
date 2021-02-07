/******************************************
 *
 * File Name: Undergraduate
 * Purpose: undergraduate class inherits from Student
 * 
 ******************************************/


public class Undergraduate extends Student {

	//instance variables 
	String gradeLevel;
	
	
	//constructor
	public Undergraduate(String name, int idNum, String gL){
		super (name, idNum);
		this.gradeLevel = gL;
	}
	
	//print methods
	public String print() {
		return super.print() + "\n   Grade Level: " + gradeLevel;
	}
	
	//compares grade
	public boolean equals (String gradeCompare) {
		
		if (gradeLevel.equals(gradeCompare)) {
			return true;
		}else {
			return false;
		}
	}
	



	
	
}
