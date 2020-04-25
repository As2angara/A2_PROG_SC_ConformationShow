package ca.sheridancollege.dummy;

public enum Breed {
	BULLDOG("Bulldog",1),
	LABRADOR("Labrador Retriever",2),
	POODLE("Poodle",3),
	PUG("Pug",4),
	GERMANSHEPHERD("German Shepherd",5),
	GREYHOUND("Greyhound",6),
	BEAGLE("Beagle",7),
	CHIHUAHUA("Chihuahua",8),
	GOLDEN("Golden Retriever",9),
	YORKSHIRETERRIER("Yorkshire Terrier",10),
	SIBERIANHUSKY("Siberian Husky",11),
	GREATDANE("Great Dane",12),
	BOXER("Boxer",13);
	
	private final String breed;
	private final int id;
	
	//Constructor
	private Breed(String breed, int id) {
		this.breed = breed;
		this.id = id;
	}
	
	//other methods
	public String printBreed() {
		return breed;
	}
	
	public int getID() {
		return id;
	}
}
