package ca.sheridancollege.dummy;

public enum Name {
	
	MAX("Max", "male", 1),
	CHARLIE("Charlie", "male", 2),
	COOPER("Cooper", "male", 3),
	BUDDY("Buddy", "male", 4),
	JACK("Jack", "male", 5),
	ROCKY("Rocky", "male", 6),
	OLLY("Olly", "male", 7),
	BEAR("Bear", "male", 8),
	DUKE("Duke", "male", 9),
	BELLA("Bella", "female", 10),
	LUCY("Lucy", "female", 11),
	DAISY("Daisy", "female", 12),
	LUNA("Luna", "female", 13),
	LOLA("Lola", "female", 14),
	SADIE("Sadie", "female", 15),
	MOLLY("Molly", "female", 16),
	MAGGIE("Maggie", "female", 17),
	BAILEY("Bailey", "female", 18);
	
	private final String name;
	private final String gender;
	private final int id;
	
	//constructor
	private Name(String name, String gender, int id) {
		this.name = name;
		this.gender = gender;
		this.id = id;
	}
	
	//other methods
	public String printName() {
		return name;
	}
	
	public String printGender() {
		return gender;
	}
	
	public int getID() {
		return id;
	}
	
}
