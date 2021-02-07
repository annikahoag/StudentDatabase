import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner (System.in);
		Database data = new Database();
		int userInput;
		boolean runAgain = true;
		String gOrMLong, gOrM;
		
		
		//welcome screen
		System.out.println("***********************************");
		System.out.println("*                                 *");
		System.out.println("*            Welcome:             *");
		System.out.println("*             to the              *");
		System.out.println("*        Student Database         *");
		System.out.println("*                                 *");
		System.out.println("***********************************");
		
		while (runAgain) {
			try {
				System.out.println("\nWhat would you like to do? Please type:"
						+ "\n1 if you would like to add a name to the database."
						+ "\n2 if you would like to print all persons."
						+ "\n3 if you would like to print all students."
						+ "\n4 if you would like to print all undergraduates."
						+ "\n5 if you would like to print all graduate students."
						+ "\n6 if you would like to search for a grade level, major, or name."
						+ "\n7 if you would like to remove a person."
						+ "\n8 if you would like to end the program.");
				userInput = scn.nextInt();
				
				
				switch(userInput){
					//add name to database
					case 1: userInput=1;
						data.addName();
						runAgain=true;
						break;
					
					//print all persons 
					case 2: userInput=2;
						data.printPerson();
						runAgain=true;
						break;
						
					//print all students 
					case 3: userInput=3;
						data.printStudent();
						runAgain=true;
						break;
					
					//print all undergraduates
					case 4: userInput=4;
						data.printUnder();
						runAgain=true;
						break;
					
					//print all grad. students 
					case 5: userInput=5;
						data.printGrad();
						runAgain=true;
						break;
					
					//input grade level/major
					//EXTRA CREDIT: search for name or partial name
					case 6: userInput=6;
						scn = new Scanner(System.in);
						System.out.println("Would you like to enter a grade level, major, or name?"
								+ "\nPlease type g for grade level, m for major, n for name");
						gOrMLong = scn.nextLine();
						
						gOrM = gOrMLong.trim();
						
						if (gOrM.equals("g")) {
							data.printGrades();
			
						} else if (gOrM.equals("m")) {
							data.printMajor();
							
						} else if (gOrM.equals("n")) {
							data.printName();
						}else {
							System.out.println("Invalid input. Program will run again.");
						}
						
						runAgain=true;
						break;
						
					//EXTRA CREDIT: remove a person	
					case 7: userInput=7;
						data.removePerson();
						runAgain=true;
						break;
					
					//end program 
					case 8: userInput=8;
						System.out.println("Program is ending.");
						runAgain=false;
						break;
					
					default:
						System.out.println("Invalid input program is restarting.");
						runAgain=true;
						break;
						
				}
			}catch (java.util.InputMismatchException e) {
				System.out.println("Please only enter numbers. Program is ending.");
				runAgain = false;
			}
		}//end of while
		
		scn.close();
	}

}
