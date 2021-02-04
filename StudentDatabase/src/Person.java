
public class Person {
	
	//instance variables
	private String name;
	
	//constructor
	public Person(String n) {
		this.name = n;
	}

	//print method 
	public String print() {
		return "Name: " + name;
	}

	
	//equals method so persList can find it 
	public boolean equals(String gradeCompare) {
		return true;
	}
	
	
	//EXTRA CREDIT: returns whether or not given String equals name 
	public boolean nameEquals(String nameCompare) {
		if (name.equals(nameCompare)) {
			return true;
		}else if (name.contains(nameCompare)){
			return true;
		}else {
			return false;
		}
	}
	
}
