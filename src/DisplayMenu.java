/*Student id: 2015268  Name : Ernesto Prado Villalobos  CCT 3rd Year*/

/*In DisplayMenu class is helping  as the name says to display to the user  the available option which are 
 * add a new Person , show People turns,  update personal Informations from an user in case of mistake, remove person 
 * find person , and delete the n last records from the end of the list , and the last option is end, which would be 
 * the exit to kill the operation from this app , EVERY OPTION ARE READY TO EXECUTE WHEN THE USER SELECT*/

import java.util.Scanner;

public class DisplayMenu {

	private Scanner data = new Scanner(System.in);
	private String option;
	private Boolean value = true;
	private SettingData information = new SettingData();
	private ShowList list = new ShowList();
	private String identification;
	private String ide;
	private boolean valor;

	public void display() {
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"                         Welcome to Imigration Office                                                                                |");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"                           a) add new Person                                                                                         |");
		System.out.println(
				"                           b) Show People  and turns                                                                                 |");
		System.out.println(
				"                           u) Update Person Info                                                                                     |");
		System.out.println(
				"                           r) Remove Person                                                                                          |");
		System.out.println(
				"                           f) Find Person                                                                                            |");
		System.out.println(
				"                           g) Delete N number of records from the End                                                                |");
		System.out.println(
				"                           d) Exit                                                                                                   |");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(" Insert your Option ");
		option = data.nextLine();
		option = option.toUpperCase();
		options(option);
	}

	private void options(String opt) {
		option = opt;
		while (value) {
			switch (option) {
			case "A":

				information.askingData();
				display();
				value = false;
				break;
			case "B":

				list.ShowingList(information.people);
				display();
				value = false;
				break;

			case "U":
				if (!information.people.isEmpty()) {
					System.out.println("Insert Unique Id to Update information from person");
					identification = data.nextLine();
					identification = identification.toUpperCase();
					ide = identification.substring(0);
					valor = list.updatePersonInformation(information.people, ide);
					if (valor == true) {
						System.out.println("Person is in the list !");
					} else {
						System.out.println("Person Not found");
					}
					display();
				} else {
					System.out.println("Sorry the database is empty, PLEASE Insert names to start the shift....");
					display();
				}
				value = false;
				break;
			case "R":

				System.out.println("Insert Unique Id to Remove Person :");
				identification = data.nextLine();
				identification = identification.toUpperCase();
				ide = identification.substring(0);
				valor = list.removePerson(information.people, ide);
				if (valor == true) {
					System.out.println("Person removed from the list !");
				} else {
					System.out.println("Person Not found");
				}

				display();
				value = false;
				break;
			case "F":

				System.out.println("Insert Unique Id to find Person :");
				identification = data.nextLine();
				identification = identification.toUpperCase();
				ide = identification.substring(0);
				valor = list.findPerson(information.people, ide);
				if (valor == true) {
					System.out.println("Its on the list!");
				} else {
					System.out.println("Person Not found");
				}

				display();
				value = false;
				break;

			case "G":
				if (!information.people.isEmpty()) {
					System.out.println("Insert how many people do you want to Erase from the last ?");
					String theMagicNo = data.nextLine();
					try {
						int theNumber = Integer.parseInt(theMagicNo);
						list.RemoveNLastData(information.people, theNumber);
					} catch (NumberFormatException e) {
						System.out.println("The input is not a valid Integer ...try again");
					}
				} else {
					System.out.println("sorry the list Is empty you are not able to erase ....");
				}
				display();
				value = false;
				break;

			case "D":
				System.exit(0);
				break;

			default:

				System.out.println("wrong option Try again please :");
				System.out.println(" Insert your Option ");
				option = data.nextLine();
				option = option.toUpperCase();
				options(option);
				value = true;
				break;
			}
		}
	}
}
