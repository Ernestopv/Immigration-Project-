/*Student id: 2015268  Name : Ernesto Prado Villalobos  CCT 3rd Year*/
/*This class is going to help us to set the person information and introduce it to the LinkedList */
package people;

public class Person {
	private String name;             /*name, surname, arrivalDate,passportNumber,if has kids*/
	private String surname;
	private String arrivalDate;
	private String passportNumber;
	private String withChildren;

	
	
	public Person(String name,String surname, String arrivalDate, String passportNumber) {
		this.name = name;
		this.surname = surname;
		this.arrivalDate = arrivalDate;
		this.passportNumber = passportNumber;
	}
	
	
	public Person() {
			
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getArrivalDate() {
		return arrivalDate;
	}


	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}


	public String getPassportNumber() {
		return passportNumber;
	}


	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getWithChildren() {
		return withChildren;
	}


	public void setWithChildren(String withChildren) {
		this.withChildren = withChildren;
	}


}
