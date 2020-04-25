package ca.sheridancollege.lists;

import java.util.ArrayList;

import ca.sheridancollege.bean.DogContestant;

public class HandlerList {
	
	private ArrayList<DogContestant> NonHandlerList;
	
	//Methods
	public ArrayList<DogContestant> getNonHandlerList() {
		return this.NonHandlerList;
	}
	
	public void setNonHandlerList(ArrayList<DogContestant> list) {
		this.NonHandlerList.addAll(list);
	}
}
