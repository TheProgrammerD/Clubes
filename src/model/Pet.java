package model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Pet implements Serializable, Comparable<Pet>,Comparator<Pet> {
	
	/**
	 * Attributtes
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String petName;
	private String petBirthDay;
	private String gender;
	private String type;
	//Constructor
	public Pet(String id, String petName,String petBirthDay,String gender,String type){ 
		this.id = id;
		this.petName = petName;
		this.petBirthDay = petBirthDay;
		this.gender = gender;
		this.type = type;
	}
	// _________________________________________________________________________________________________________//

	public String getId() {
		return id;
	}

	public String getPetName() {
		return petName;
	}

	public String getPetBirthDay() {
		return petBirthDay;
	}

	public String getGender() {
		return gender;
	}

	public String getType() {
		return type;
	}
	// _________________________________________________________________________________________________________//
	@Override
	public String toString() {
		return "Pet"+" |id=" + id + "| petName=" + String.format("%1$-13s",petName) + "| petBirthDay=" + String.format("%1$-13s",petBirthDay) + "| gender=" + String.format("%1$-13s",gender)
				+ "| type=" + String.format("%1$-13s",type);
	}
	// _________________________________________________________________________________________________________//
	@Override
	public int compareTo(Pet o) {
		return id.compareTo(o.getId());
	}
	// _________________________________________________________________________________________________________//
	@Override
	public int compare(Pet o1, Pet o2) {
		return o1.getPetName().compareTo(o2.getPetName());
	}
	// _________________________________________________________________________________________________________//
	/**
	 * This method allows turn a String into a Date
	 * 
	 * @param format A date with the format "dd-mm-yyyy"
	 * @return A Date type object
	 */
	public Date formatDate(String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = null;
		try {
			date = dateFormat.parse(format);
		} catch (ParseException e) {
			e.getStackTrace();
		}
		return date;
	}
	// _________________________________________________________________________________________________________//
	public int compareByDate(Pet o) {
		return petBirthDay.compareTo(o.getPetBirthDay());
	}
	// _________________________________________________________________________________________________________//
	public int compareByType(Pet o) {
		return type.compareTo(o.getType());
	}
	// _________________________________________________________________________________________________________//
	public int compareByIdBS(String o) {
		return id.compareTo(o);
	}
	// _________________________________________________________________________________________________________//
	public int compareByNameBS(String o) {
		return petName.compareTo(o);
	}
	// _________________________________________________________________________________________________________//
	public int compareByDateBS(String o) {
		int date =-1;
		try {
			date = formatDate(petBirthDay).compareTo(formatDate(o));
		}catch(NullPointerException e) {
			e.getMessage();
		}
		return date;
	}
	// _________________________________________________________________________________________________________//
	public int compareByPetBS(String o) {
		return type.compareTo(o);
	}

}
 