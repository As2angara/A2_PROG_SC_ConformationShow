package ca.sheridancollege.logic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import ca.sheridancollege.bean.DogBreed;
import ca.sheridancollege.bean.DogContestant;
import ca.sheridancollege.dao.DAO;

public class GroupOrganizer {

	@Autowired DAO dao;
	
	public ArrayList<DogBreed> organizeGroup(ArrayList<DogContestant> list) {

		ArrayList<String> breeds = new ArrayList<String>();
		ArrayList<DogBreed> dbList = new ArrayList<DogBreed>();

		//Add the first entry into the breeds list
		if(breeds.size() == 0) {
			breeds.add(list.get(0).getBreed());
		}
		
		//Adds distinct breeds into breeds list
		for(DogContestant d : list) {
			int count = 0;
			
			for(int i = 0; i < breeds.size(); i++) {
				if(d.getBreed().equalsIgnoreCase(breeds.get(i))) {
					count++;
				}
			}
			
			if(count == 0) breeds.add(d.getBreed());
		} 
		
		//Counts number for each breed, as well as the gender/ranking pairs
		for(String b : breeds) {
			int num = 0;
			int mc = 0;
			int fc = 0;
			int ms = 0;
			int fs = 0;
			
			for(int i = 0; i < list.size(); i++) {
				if(b.equalsIgnoreCase(list.get(i).getBreed())) {
					num++;
					
					if(list.get(i).getGender().equalsIgnoreCase("male")) {
						if(list.get(i).getRanking().equalsIgnoreCase("class")) {
							mc++;
						}else {
							ms++;
						}
					}else {
						if(list.get(i).getRanking().equalsIgnoreCase("class")) {
							fc++;
						}else {
							fs++;
						}
					}	
				}
			}
			
			DogBreed db = new DogBreed(b, num, mc, fc, ms, fs);
			dbList.add(db);
		}
		return dbList;

	}
}
