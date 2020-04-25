package ca.sheridancollege.dummy;

public enum OwnerName {
	
	ADRIAN("Adrian", 1),
	JEFFREY("Jeffrey", 2),
	CHRIS("Chris", 3),
	JOSEPH("Joseph", 4),
	JOHN("John", 5),
	JUSTIN("Justin", 6),
	ADAM("Adam", 7),
	GEORGE("George", 8),
	ANNA("Anna", 9),
	MELODY("Melody", 10),
	FRANCINE("Francine", 11),
	GRETCHEN("Gretchen", 12),
	GHERLYN("Gherlyn", 13),
	VIVIAN("Vivian", 14),
	DORIS("Doris", 15),
	BETTY("Betty", 16);
	
	private final String ownerName;
	private final int id;
	
	//constructor
	private OwnerName(String ownerName, int id) {
		this.ownerName = ownerName;
		this.id = id;
	}
	
	//other methods
	public String printOwnerName() {
		return ownerName;
	}
	
	public int getID() {
		return id;
	}

}
