/*Student id: 2015268  Name : Ernesto Prado Villalobos  CCT 3rd Year*/

/* SettingData class is going to help to fill the Person Object  and start to pass the information through 
 * the linkedList  with the following details , name , surname, passportNumber, arrivalDate, 
 * if the person has kids more or less than 1 year */

import java.util.Scanner;
import java.util.Vector;
import LinkedList.*;

import people.Person;

public class SettingData {
	private Scanner data = new Scanner(System.in);
	private String name;
	private String surname;
	private String passportNumber;
	private String arrivalDate;
	private Person person = new Person(name, surname, arrivalDate, passportNumber);
	private boolean value = true;
	private String withKids;
	MyLinkedList<Object> people = new MyLinkedList<Object>();
	private int id = 0;

	public void askingData() { // this method is going to be declared public to be used in another class
		aData(); // is going to start to fill the LinkedList
	}

	private void aData() { // this method aData() is going to start to ask for the proper Information
		boolean datas = true; // to the user.
		while (datas) {
			System.out.println("Insert Name ");
			name = data.nextLine();
			person.setName(name);
			System.out.println("Insert Surname");
			surname = data.nextLine();
			person.setSurname(surname);
			System.out.println("Insert Date of Arrival ");
			arrivalDate = data.nextLine();
			person.setArrivalDate(arrivalDate);
			System.out.println(
					"Insert PassportNumber Withcountry Abreviation at the end: (example: x:x:x:x:x:x:x:x:x:U:S (9digits + Country Initials)..)");
			passportNumber = data.nextLine();
			person.setPassportNumber(passportNumber);
			System.out.println("Is it with kids (yes or no) ? ");
			withKids = data.nextLine();
			withKids = withKids.toUpperCase();
			id = id + 1;
			String theId = "GNIB" + id;
			askingKids(withKids, theId);
			System.out.println("The following ID was succesfully generated :" + theId); // the id generations is
																						// confirmed
			datas = false;
		}

	}

	/*
	 * askingKids((answer_yes_no, personal_id)) answer yes or no of do you have
	 * kids??? and personal_Id
	 */
	private void askingKids(String kids, String ide) { // this method is asking about the kids situation
		value = true;
		while (value) {
			if (withKids.contains("YES")) { // if is yes is going to ask if the kid is more than 1 year
				person.setWithChildren("true");
				String persona = ide + "," + "  Name:" + person.getName() + "," + " Surname:" + person.getSurname()
						+ " " + "," + "Arrival Date : " + person.getArrivalDate() + " " + "," + "PassportNo.: "
						+ person.getPassportNumber() + " , " + "Kids ?: " + person.getWithChildren();
				System.out.println("are the kids more than 1 year ?? ");
				String answer = data.nextLine();
				answer = answer.toUpperCase();
				askingAgePriorityKids(answer, persona, ide); // if the kids is more or lees than one year
				value = false; // another method called askingPriorityKids (answer, person, id)
								// to determine the priority on kid
			} else if (withKids.contains("NO")) { // if the person has no kids is going to be add Last to the Queue
				person.setWithChildren("false");
				String persona = ide + "," + "  Name:" + person.getName() + "," + " Surname:" + person.getSurname()
						+ " " + "," + "Arrival Date : " + person.getArrivalDate() + " " + "," + "PassportNo.: "
						+ person.getPassportNumber() + " , " + "Kids ?: " + person.getWithChildren();
				if ((person.getWithChildren().endsWith("false"))) {
					people.addLast(persona); // ANSWER NO.2
				}
				value = false;
			} else {
				System.out.println("Try again insert yes or no "); // a filter is add for the user to make right is
																	// decision
				System.out.println("is it with kids (yes or no) ? ");// of only inserting yes or no
				withKids = data.nextLine();
				withKids = withKids.toUpperCase();
				value = true;
			}
		}
	}

	// ANSWER NO.5
	/* addFirsifNOKids(people_list, persona_object) */
	private void addFirstIfKids(MyLinkedList<Object> person, String persona) {
		Vector<String> v = new Vector<String>(); // the person with kid which is under one year
		int ind = 0; // is always on priority with this method
		for (int n = 0; n < person.size(); n++) {
			v.add((String) person.get(n));
			String[] dato = v.get(n).split(":");
			for (String ide : dato) {
				if (!ide.endsWith("true0")) { // true0 means that the kids is under 1 year
					ind = ind + 1;

				}
			}

		}
		if (ind == 0) {
			person.addFirst(persona); // adding first // ANSWER NO.5
		}
	}

	/* addNextWkids(people_list, persona_object) */
	private void addNextWKids(MyLinkedList<Object> person, String persona) {
		Vector<String> v = new Vector<String>(); // this method addNextWKids if one person arrives with another kid
													// under 1 year
		int ind = 0; // the person is going to be queued next to the person who arrived
		for (int n = 0; n < person.size(); n++) { // before with a kid under one year
			v.add((String) person.get(n));
			String[] dato = v.get(n).split(":");
			for (String ide : dato) {
				if (ide.endsWith("true0")) {
					ind = ind + 1;
				}
			}

		}
		person.add(ind, persona);
	}

	/* deniedPriorityOverOneYear(People_list) */
	private int deniedPriorityOverOneYear(MyLinkedList<Object> person) {
		Vector<String> v = new Vector<String>(); // This method deniedPriorityBelowOneYear,is if one person who is
		int ind = 0; // with one kid over one year , who is being relocated to a position
		for (int n = 0; n < person.size(); n++) {// where a person with a kid under one year is, It is going to be
			v.add((String) person.get(n)); // denied because is on turn and remember a person with a kid under
			String[] dato = v.get(n).split(":");// one year is a priority
			for (String ide : dato) {
				if (ide.endsWith("true0")) {
					ind = n;
				}
			}

		}
		return ind;
	}

	/*
	 * the method below askinPriorityKids is going to help to select a position if
	 * the kid is over 1 year or under if is over is going to relocate by inserting
	 * position if is under is going to relocate always in priority mode, this
	 * method also as a filter only to type yes or not to go on with the task
	 */
	/*
	 * askingAgePriorityKids((answer_yes_no, persona_object, personal_id)) do you
	 * have kids more than one year????
	 */
	private void askingAgePriorityKids(String answer, String persona, String ide) {
		boolean confirmation = true;
		boolean confirmation2 = true;
		int no = 0;
		while (confirmation) {
			switch (answer) {
			case "YES":
				if (!people.isEmpty()) {
					person.setWithChildren("true");
					persona = ide + "," + "  Name:" + person.getName() + "," + " Surname:" + person.getSurname() + " "
							+ "," + "Arrival Date : " + person.getArrivalDate() + " " + "," + "PassportNo.: "
							+ person.getPassportNumber() + " , " + "Kids ?: " + person.getWithChildren();
					System.out.println("showing display to pick a preferencial  turn for a person with kid ");
					ShowList list = new ShowList();
					list.ShowingList(people);
					int turn = 0;
					String turno = " ";
					System.out.println("Insert next turn to colocate person with kid : ?");// ANSWER NO.3
					turno = data.nextLine();
					turn = Integer.parseInt(turno);
					no = deniedPriorityOverOneYear(people);
					while (confirmation2) {
						if (no == turn) {
							System.out.println("Sorry that turn has a priority value  is on process");
							System.out.println("Insert again turn to colocate Person with kid : ?");
							turno = data.nextLine();
							turn = Integer.parseInt(turno);
							confirmation2 = true;
						} else {
							people.add(turn, persona); // ANSWER NO.3
							confirmation2 = false;
						}
					}
				} else {
					people.addFirst(persona);
				}
				confirmation = false;

				break;
			case "NO":
				person.setWithChildren("true0");
				persona = ide + "," + "  Name:" + person.getName() + "," + " Surname:" + person.getSurname() + " " + ","
						+ "Arrival Date : " + person.getArrivalDate() + " " + "," + "PassportNo.: "
						+ person.getPassportNumber() + " , " + "Kids ?: " + person.getWithChildren();

				if ((people.size() == 0) && (person.getWithChildren().endsWith("true0"))) {
					people.addFirst(persona);
				} else if (person.getWithChildren().endsWith("true0")) {
					addFirstIfKids(people, persona);
					addNextWKids(people, persona);
				}
				confirmation = false;

				break;
			default:
				System.out.println("wrong answer type (YES) or (NO) if the kids are more than one year ");
				answer = data.nextLine();
				answer = answer.toUpperCase();
				confirmation = true;
				break;

			}
		}
	}

}
