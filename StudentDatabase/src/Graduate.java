/*****************************************
 *
 * File Name: Graduate
 * Purpose: graduate student class, inherits from Student 
 * 
 ******************************************/


public class Graduate extends Student{

	//instance variables
	String major;
	
	//constructor 
	public Graduate(String name, int idNum, String maj) {
		super(name, idNum);
		this.major = maj;
	}
	
	//print method
	public String print() {
		return super.print() + "\n   Major: " + major;
	}
	
	
	//compares major
	public boolean equals (String majorCompare) {
			
		if (major.equals(majorCompare)) {
			return true;
		}else {
			return false;
		}
	}
	
	
}
