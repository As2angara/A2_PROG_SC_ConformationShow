package ca.sheridancollege.bean;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DogContestant {

	//Field Variables
	public int entryNum;
	public String name;
	public String ownerName;
	public String breed;
	public String group;
	public String gender;
	public String ranking;
	
	//Constructors
	public DogContestant(String name, String ownerName, String breed, String group, String gender, String ranking) {
		this.name = name;
		this.ownerName = ownerName;
		this.breed = breed;
		this.group = group;
		this.gender = gender;
		this.ranking = ranking;
	}
	
	
	
}
