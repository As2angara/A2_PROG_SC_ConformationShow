package ca.sheridancollege.dummy;

public enum Group {

	G1("Group 1, Sporting Dogs", 1),
	G2("Group 2, Hounds", 2),
	G3("Group 3, Working Dogs", 3),
	G4("Group 4, Terriers", 4),
	G5("Group 5, Toys", 5),
	G6("Group 6, Non-Sporting", 6),
	G7("Group 7, Herding", 7);
	
	private final String group;
	private final int id;
	
	//constructor
	private Group(String group, int id) {
		this.group = group;
		this.id = id;
	}
	
	//other methods
	public String printGroup() {
		return group;
	}
	
	public int getID() {
		return id;
	}
}
