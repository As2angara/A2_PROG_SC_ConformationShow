package ca.sheridancollege.logic;

import org.springframework.beans.factory.annotation.Autowired;

import ca.sheridancollege.bean.DogContestant;
import ca.sheridancollege.dao.DAO;
import ca.sheridancollege.dummy.Breed;
import ca.sheridancollege.dummy.Group;
import ca.sheridancollege.dummy.Name;
import ca.sheridancollege.dummy.OwnerName;

public class GenerateData {

	public DogContestant generateData() {
		
			//Set the parameters
			String name = "";
			String ownerName = "";
			String breed = "";
			String group = "";
			String gender = "";
			String ranking = "";
			
			//Generate Random Name
			int rn1 = (int)Math.floor(Math.random() * 18) + 1;
			for(Name n: Name.values()) {
				if(rn1 == n.getID()) {
					name = n.printName();
					gender = n.printGender();
					break;
				}
			}
			
			//Generate Random OwnerName
			int rn2 = (int)Math.floor(Math.random() * 16) + 1;
			for(OwnerName on: OwnerName.values()) {
				if(rn2 == on.getID()) {
					ownerName = on.printOwnerName();
					break;
				}
			}
			
			//Generate Random Breed
			int rn3 = (int)Math.floor(Math.random() * 13) + 1;
			for(Breed n: Breed.values()) {
				if(rn3 == n.getID()) {
					breed = n.printBreed();
					break;
				}
			}
			
			//Generate Random Group
			int rn4 = (int)Math.floor(Math.random() * 7) + 1;
			for(Group n: Group.values()) {
				if(rn4 == n.getID()) {
					group = n.printGroup();
					break;
				}
			}
			
			//Generate Random Ranking
			if(Math.random() < 0.5) {
				ranking = "Specialty";
			}else {
				ranking = "Class";
			}
			
			DogContestant dog = new DogContestant(name, ownerName, breed, group, gender, ranking);
			return dog;
	}
}
