/*Student id: 2015268  Name : Ernesto Prado Villalobos  CCT 3rd Year*/

/*Show list is going to have the next functionalities on these public methods;  showList, findPerson ,
 *  removePerson, remove N last Person,  Update Person Information,  */

import LinkedList.MyLinkedList;
import java.util.Scanner;
import java.util.Vector;

public class ShowList { // display content of the list if the list is empty is going to display a
						// message saying LIST IS EMPTY
	private Scanner data = new Scanner(System.in);

	public void ShowingList(MyLinkedList<Object> persona) { // ANSWER NO.1
		if (persona.isEmpty()) {
			System.out.println(
					"........................................................LIST IS EMPTY............................................................ ");
		} else {
			for (int n = 0; n < persona.size(); n++) {
				if (n == 0) {
					System.out.println(
							"Id: " + persona.get(n) + "  In progress with the imigration officer" + "," + " Turn:" + n);
				} else {
					System.out.println("Id: " + persona.get(n) + " Queue" + "," + " Turn :" + n);
				}
			}
		}
	}

	/* findPerson (people, personal_ID) */
	public boolean findPerson(MyLinkedList<Object> person, String id) {
		Vector<String> v = new Vector<String>(); // this method is going to help us to find a person on the list
		boolean found = false; // Looking by id the method is going to display the person founded
		if (id.isEmpty()) {
			System.out.println("Sorry Introduce ID, try again ");
		} else {
			for (int n = 0; n < person.size(); n++) {
				v.add((String) person.get(n)); // a vector was needed to cut the string that was inside the LinkedList
				String[] dato = v.get(n).split(",");
				for (String ide : dato) {
					if (ide.endsWith(id)) { // in this section is getting the id to display the person founded
						System.out.println(person.get(n));
						found = true; // if found is false a message is going to displayed saying "not found"
					}
				}
			}
		}
		System.out.println();
		return found;

	}

	// ANSWER NO.4
	/*
	 * removePerson(people(LinkedList) , personal_id) personal filters where added
	 * like if the id is not typed the method cannot proceed
	 */
	public boolean removePerson(MyLinkedList<Object> person, String id) {
		Vector<String> v = new Vector<String>(); // a similar procedure like findPerson was used but in this case
		boolean found = false; // is removing person by typing id
		if (id.isEmpty()) {
			System.out.println("Sorry Introduce ID, try again ");
		} else {
			for (int n = 0; n < person.size(); n++) {
				v.add((String) person.get(n));
				String[] dato = v.get(n).split(",");
				for (String ide : dato) {
					if (ide.endsWith(id)) {
						person.remove(n);
						found = true; // if found is false a message is going to displayed saying "not found"
					}
				}
			}
		}
		System.out.println();
		return found;
	}

	// ANSWER NO.7
	/* Remove n people from the last in the linkedList */
	/* RemoveNLastData(People_Linkedlist, n_people_to_remove) */
	public void RemoveNLastData(MyLinkedList<Object> person, int NtimesEraser) {
		if (person.size() < NtimesEraser) {
			System.out.println("Sorry the value is too big for this list!! the are only : " + person.size()
					+ " Persons on list,  try a minor number!!");
		} else {
			for (int n = NtimesEraser; n > 0; n--) {
				person.removeLast();// ANSWER NO.7
			}
		}

	}

	// ANSWER NO.8
	/*
	 * updatePersonInformation (people_Linkedlist, personalI_d) and extra method to
	 * deploy updatepersonInformation was used to update information (make changes
	 * to a person) when personal id is introduced
	 */
	public boolean updatePersonInformation(MyLinkedList<Object> person, String id) {
		Vector<String> v = new Vector<String>();
		boolean found = false;
		int number = 0;
		if (id.isEmpty()) {
			System.out.println("Sorry Introduce ID, try again ");
		} else {
			for (int n = 0; n < person.size(); n++) {
				v.add((String) person.get(n));
				String[] dato = v.get(n).split(",");
				for (String ide : dato) {
					if (ide.endsWith(id)) {
						number = n;
						found = true; // if found is false a message is going to displayed saying "not found"
					}
				}
			}
		} // ANSWER NO.8

		doingUpdate(person, number); // this method is going to help to deploy the changes
		return found;
	}

	/*
	 * doingUpdate(people_list, position_int_the_list) this methods helps to modify
	 * name, surname, arrival date and passportNumber they are organized in a list
	 * of options to make able to the user to pick exactly to modify ,
	 */
	private void doingUpdate(MyLinkedList<Object> person, int number) {

		boolean verifica = true;
		String persona = (String) person.get(number);
		String[] cutting = persona.split(",");
		while (verifica) {
			System.out.println("------------------------------------------");
			System.out.println("   Wich option would you like to Modify ?|");
			System.out.println("------------------------------------------");
			System.out.println("    a)name                               |");
			System.out.println("    b)Surname                            |");
			System.out.println("    c)Arrival date                       |");
			System.out.println("    d)Passport Number                    |");
			System.out.println("------------------------------------------");
			String ans = data.nextLine();
			ans = ans.toUpperCase();
			switch (ans) {
			case "A": // by getting the position from the linkedList to find the person to modify
						// where able to extract the information
				System.out.println("Please insert new Name to Modify :");// and make some splits and see the positions 1
																			// to 4 where is the information
				String newName = data.nextLine(); // that we want to modify
				cutting[1] = "  Name: " + newName;
				person.set(number, cutting[0] + ", " + cutting[1] + ", " + cutting[2] + ", " + cutting[3] + ", "
						+ cutting[4] + ", " + cutting[5]);
				verifica = false;
				break;
			case "B":
				System.out.println("Please insert new SurName to Modify :");
				String newSurname = data.nextLine();
				cutting[2] = "  Surname: " + newSurname;
				person.set(number, cutting[0] + ", " + cutting[1] + ", " + cutting[2] + ", " + cutting[3] + ", "
						+ cutting[4] + ", " + cutting[5]);
				verifica = false;
				break;
			case "C":
				System.out.println("Please insert new ArrivalDate to Modify :");
				String newArrivalDate = data.nextLine();
				cutting[3] = "  ArrivalDate: " + newArrivalDate;
				person.set(number, cutting[0] + ", " + cutting[1] + ", " + cutting[2] + ", " + cutting[3] + ", "
						+ cutting[4] + ", " + cutting[5]);
				verifica = false;
				break;
			case "D":
				System.out.println("Please insert new PassportNumber to Modify ");
				String newPassportN = data.nextLine();
				cutting[4] = "  Name: " + newPassportN;
				person.set(number, cutting[0] + ", " + cutting[1] + ", " + cutting[2] + ", " + cutting[3] + ", "
						+ cutting[4] + ", " + cutting[5]);

				verifica = false;
				break;
			default:
				System.out.println("Sorry option invalid try again!  ");
				verifica = true;
				break;
			}
		}

	}

}
