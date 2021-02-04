
public class Student extends Person {

	//instance variables
	private int idNum;
	
	
	//constructor
	public Student(String n, int id) {
		super(n);
		this.idNum = id;
	}

	//print method
	public String print() {
		return super.print() + "\n   Id Num: " + idNum;
	}
	
	

	

	
}
