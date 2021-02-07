import java.util.ArrayList; 
import java.util.Scanner;

public class Database {

	//instance variables
	ArrayList <Person> persList = new ArrayList<Person>();
	Scanner scn = new Scanner (System.in);
	int idNum = 1;
	String print;
	
	//constructor 
	public Database(){
		
	}
	
	//add students to persList
	public void addName() {
		if (persList.size()<10) {
			String nameLong, name;
			String isStuLong, isStu, isUnderGradLong, isUnderGrad;
			String gradeLong, gradeLevel, majLong, major;
			
			System.out.println("Please enter the name of the person:");
			nameLong = scn.nextLine();
			name = nameLong.trim();
			
			
			System.out.println("Is the person a student? "
					+ "\nPlease type yes or no in lowercase letters.");
			isStuLong = scn.nextLine();
			isStu = isStuLong.trim();
			
			if (isStu.equals("yes")) {
				
				
				System.out.println("Is the student an undergraduate or graduate student? "
						+ "\nPlease type u for undergraduate and g for graduate.");
				isUnderGradLong = scn.nextLine();
				isUnderGrad = isUnderGradLong.trim();
				
				if(isUnderGrad.equals("u")) {
					System.out.println("Please enter the student's grade level:");
					gradeLong = scn.nextLine();
					gradeLevel = gradeLong.trim();
					
					Undergraduate undergrad = new Undergraduate(name, idNum, gradeLevel);
					persList.add(undergrad);
					idNum ++;
					
				}else if (isUnderGrad.equals("g")) {
					System.out.println("Please enter the student's major:");
					majLong = scn.nextLine();
					major = majLong.trim();
					
					Graduate grad = new Graduate(name, idNum, major);
					persList.add(grad);
					idNum++;
					
				}else {
					System.out.println("Error. Please only type u or g.");
				}
				
			}else if (isStu.equals("no")){
			
				Person per = new Person(name);
				persList.add(per);
			}else {
				System.out.println("Error, please only type yes or no.");
			}
		
		}else {
			System.out.println("Error. There are already 10 people in the database.");
		}
	}
	
	
	//print all persons
	public void printPerson() {
		
		for (int i=0; i<persList.size(); i++) {
			
			print = persList.get(i).print();
			System.out.println(print);	
		}
		
	}
	
	//print students
	public void printStudent() {
		
		for (int i=0; i<persList.size(); i++) {
			if (persList.get(i) instanceof Student|| persList.get(i) instanceof Undergraduate
					|| persList.get(i) instanceof Graduate) {
				
				print = persList.get(i).print();
				System.out.println(print);
			}
		}
	
	}
	
	//print undergrads
	public void printUnder() {

		for (int i=0; i<persList.size(); i++) {
			if (persList.get(i) instanceof Undergraduate) {
				print = persList.get(i).print();
				System.out.println(print);
			}
		}
	}
	
	//print grads
	public void printGrad() {
		
		for (int i=0; i<persList.size(); i++) {
			if (persList.get(i) instanceof Graduate) {
				print = persList.get(i).print();
				System.out.println(print);
			}
		}
	}
	
	//print all people with specified grade level
	public void printGrades() {
		String gradeLong, inputGrade;
		boolean isSame; 
		scn = new Scanner(System.in);
		
		System.out.println("Please enter the grade level: ");
		gradeLong = scn.nextLine();
		inputGrade = gradeLong.trim();
		System.out.println();
		
			
		for (int i=0; i<persList.size(); i++) {
		
			if( persList.get(i) instanceof Undergraduate) { 
				
				isSame = persList.get(i).equals(inputGrade);
				
				if (isSame) {
					print = persList.get(i).print();
					System.out.println(print);
				} 
				
			}
		}
		
		
	}
	
	//print all people with specified major 
	public void printMajor() {
		String majorLong, inputMajor;
		boolean isSame; 
		scn = new Scanner(System.in);
		
		System.out.println("Please enter the major: ");
		majorLong = scn.nextLine();
		inputMajor = majorLong.trim();
		System.out.println();
		
	
		for (int i=0; i<persList.size(); i++) {
		
			if(persList.get(i) instanceof Graduate) { 
				
				isSame = persList.get(i).equals(inputMajor);
				
				if (isSame) {
					print = persList.get(i).print();
					System.out.println(print);
				} 
			}
		}
	}
	
	
	//EXTRA CREDIT: print all information about given name
	public void printName() {
		String nameLong, inputName;
		boolean isSame;
		scn = new Scanner(System.in);
		
		System.out.println("Please enter the name:");
		nameLong = scn.nextLine();
		inputName = nameLong.trim();
		System.out.println();
		
		for (int i=0; i<persList.size(); i++) {
			isSame = persList.get(i).nameEquals(inputName);
			
			if (isSame) {
				print = persList.get(i).print();
				System.out.println(print);
				
			} 
		
		}
	}
	
	
	//EXTRA CREDIT: remove a person
	public void removePerson() {
		String nameEntered;
		int foundCount=0;
		int foundIndex=0;
		String isPerson;
		
		System.out.println("Please enter the name of the person you would like to remove.");
		nameEntered = scn.nextLine();
		
		for (int i=0; i<persList.size(); i++) {
			if (persList.get(i).nameEquals(nameEntered)) {
				System.out.println();
				foundCount++;
				
				if (foundCount >= 1) {
					System.out.println(persList.get(foundIndex).print());
					System.out.println();
					System.out.println("Is this the person you want to remove? "
							+ "\nPlease type yes or no in lowercase letters.");
					isPerson = scn.nextLine();
						
					if (isPerson.equals("yes")) {
						foundCount=1;
						foundIndex=i;
						break;
					}else {
						foundIndex++;
						continue;
					}
				}
	
			}else if (!persList.get(i).nameEquals(nameEntered) && i != persList.size()-1){
				foundIndex++;
			}else {
				foundCount=0;
			}
		}
		
		//if there's an out of bounds exception that means they said no to all the people with given name
		try {
			if (foundCount==0) {
				System.out.println("Sorry, that person is not in the system.");
				
			}else if (foundCount==1) {
				persList.remove(foundIndex);
				System.out.println("They have been removed.");
			}
	
		}catch(IndexOutOfBoundsException e) {
			System.out.println("Sorry, there is no one else by that name in the system");
		}
		
	}
	
	
	
	
}//end of class
