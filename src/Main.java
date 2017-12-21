

/*Student id: 2015268  Name : Ernesto Prado Villalobos  CCT 3rd Year*/

/*This is the Main class where the program  is starting to executes initializing  the class DisplayMenu calling
 * one of its methods called display */

public class Main {

	public static void main(String[] args) {		
	DisplayMenu menu = new DisplayMenu();
	menu.display();	
	
	}
}

//  ********************* ANSWERS **********************************************************************************
/* ********************* Scheme Summary *************************************************************************
 * 
 * 1- Can check to see what number in a linked list a person currently is.
 * 	ANSWER IS IN SHOWLIST CLASS IN SHOWLIST METHOD WHICH IS DISPLAYING THE FULL LIST 
 * 
 * 2.- Can add a new person to end of the linked list 
 * ANSWER IS IN SETTINGDATA CLASS IN  askingKids((answer_yes_no, personal_id)) WHEN THE USER ANSWER NO ,
 *  IF THEY HAVE KIDS , THE DATA IS GOING TO BE STORED AT THE END OF THE LINKEDLIST 
 *  
 * 
 * 
 * 3.- A method should exit to insert a position into a specific position into the linked list
 * ANSWER IS IN SETTINGDATA CLASS IN askingAgePriorityKids((answer_yes_no, persona_object, personal_id)) METHOD 
 * askinPriorityKids is going to help to select a position  if the kid is over  1 year or under 
	 * if is over is going to relocate by inserting position  if is under  is going to  relocate always 
	 * in priority mode, this method also as a filter only to type yes or not to go on with the tasK.
 * 
 * 
 * 4.- A person can be deleted from the linked list, connecting the person who was in front 
 * of them to the person who was behind them.
 * ANSWER IS IN SHOWLIST CLASS IN removePerson(people(LinkedList) , personal_id) METHOD
 * 
 * 
 * 5.- A person can be added to the top of the linked list, moving the first person who was 
 * there to the second position in the list.
 * ANSER IS IN SETTINGDATA CLASS IN  addFirsifNOKids(people_list, persona_object) IF SOMEONE ARRIVES WITH A KID UNDER ONE
 * YEAR.
 * 
 * 6.- Individual methods exist for each of the functionality available to the linked list, encapsulating the 
 * process
 * SEE ALL THE CLASSES , INDIVIDUAL METHODS EXIST FOR EACH FUNCTIONALITY AVAILABLE TO THE LINKED LIST
 * 
 * 
 * 7.- Ability to delete N number of records from the end of the linked List.
 * ANSER IS IN SHOWLIST CLASS IN RemoveNLastData(People_Linkedlist, n_people_to_remove) METHOD. REMOVES N NUMBER OF RECORDS
 * FROM THE END OF THE LINKED LIST.
 * 
 * 8.- Can update information for a single person, without impacting their position in the list.
 * ANSWER IS IN SHOWlIST CLASS IN  updatePersonInformation (people_Linkedlist, personalI_d) METHOD, 
 * UPDATE INFORMATION FOR A SINGLE PERSON WTHOUT IMPACTING.
 * 
 * 9.- Overall code quality and Structure.
 * CHECK THE QUALITY EVERYTHING RUNNING, WORKING AND TESTED AND WAS DEVELOPED ON 
 * ECLIPSE VERSION: OXYGEN. 1A RELEASE(4.7.1.A)
 * 
 * 
 * Student id: 2015268  Name : Ernesto Prado Villalobos  CCT 3rd Year
 * 
 * 
 * 
 *///***********************************************************************************************************
