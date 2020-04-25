package ca.sheridancollege.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.bean.DogContestant;

@Repository
public class DAO {

	@Autowired JdbcTemplate jdbc;
	
	//CREATE
    public void addDogContestant(DogContestant dog) {
        try {
			String q = "insert into contestants (name, ownerName, breed, dog_group, gender, ranking) "
					+ "values (?, ?, ?, ?, ?, ?)";
			
			Object[] params = new Object[] {
					dog.getName(),
					dog.getOwnerName(),
					dog.getBreed(),
					dog.getGroup(),
					dog.getGender(),
					dog.getRanking()
			};
			this.jdbc.update(q, params);
			
        } catch (Exception e) {
            System.out.println("Connection Failed");
            System.out.println(e);
        }
    }
    
    public void addHandledDog(int entryNum, Long userID) {
	       try {
	    	   String q = "insert into handled_dogs values (?, ?)";
				
				Object[] params = new Object[] {
						entryNum,
						userID
				};
				this.jdbc.update(q, params);
	        } catch (Exception e) {
	            System.out.println("Connection Failed");
	            System.out.println(e);
	        }
	}
    
	public void addFri(DogContestant dog) {
		try {
			String q = "insert into fri_show values (?, ?, ?, ?, ?, ?, ?)";

			Object[] params = new Object[] {
					dog.getEntryNum(),
					dog.getName(),
					dog.getOwnerName(),
					dog.getBreed(),
					dog.getGroup(),
					dog.getGender(),
					dog.getRanking()
			};
			this.jdbc.update(q, params);
		} catch (Exception e) {
			System.out.println("Connection Failed");
			System.out.println(e);
		}
	}

	public void addSat(DogContestant dog) {
		try {
			String q = "insert into sat_show values (?, ?, ?, ?, ?, ?, ?)";

			Object[] params = new Object[] {
					dog.getEntryNum(),
					dog.getName(),
					dog.getOwnerName(),
					dog.getBreed(),
					dog.getGroup(),
					dog.getGender(),
					dog.getRanking()
			};
			this.jdbc.update(q, params);
		} catch (Exception e) {
			System.out.println("Connection Failed");
			System.out.println(e);
		}
	}

	public void addFriSat(DogContestant dog) {
		try {
			String q = "insert into fri_show values (?, ?, ?, ?, ?, ?, ?)";

			Object[] params = new Object[] {
					dog.getEntryNum(),
					dog.getName(),
					dog.getOwnerName(),
					dog.getBreed(),
					dog.getGroup(),
					dog.getGender(),
					dog.getRanking()
			};
			this.jdbc.update(q, params);

			q = "insert into sat_show values (?, ?, ?, ?, ?, ?, ?)";

		  params = new Object[] {
					dog.getEntryNum(),
					dog.getName(),
					dog.getOwnerName(),
					dog.getBreed(),
					dog.getGroup(),
					dog.getGender(),
					dog.getRanking()
			};
			this.jdbc.update(q, params);
		} catch (Exception e) {
			System.out.println("Connection Failed");
			System.out.println(e);
		}
	}

	public void addSun(DogContestant dog) {
		try {
			String q = "insert into sun_show values (?, ?, ?, ?, ?, ?, ?)";


			Object[] params = new Object[] {
					dog.getEntryNum(),
					dog.getName(),
					dog.getOwnerName(),
					dog.getBreed(),
					dog.getGroup(),
					dog.getGender(),
					dog.getRanking()
			};
			this.jdbc.update(q, params);
		} catch (Exception e) {
			System.out.println("Connection Failed");
			System.out.println(e);
		}
	}

	public void addFriSun(DogContestant dog) {
		try {
			String q = "insert into fri_show values (?, ?, ?, ?, ?, ?, ?)";

			Object[] params = new Object[] {
					dog.getEntryNum(),
					dog.getName(),
					dog.getOwnerName(),
					dog.getBreed(),
					dog.getGroup(),
					dog.getGender(),
					dog.getRanking()
			};
			this.jdbc.update(q, params);

			q = "insert into sun_show values (?, ?, ?, ?, ?, ?, ?)";


		params = new Object[] {
					dog.getEntryNum(),
					dog.getName(),
					dog.getOwnerName(),
					dog.getBreed(),
					dog.getGroup(),
					dog.getGender(),
					dog.getRanking()
			};
			this.jdbc.update(q, params);
		} catch (Exception e) {
			System.out.println("Connection Failed");
			System.out.println(e);
		}
	}

	public void addSatSun(DogContestant dog) {
		try {
			String q = "insert into sat_show values (?, ?, ?, ?, ?, ?, ?)";

			Object[] params = new Object[] {
					dog.getEntryNum(),
					dog.getName(),
					dog.getOwnerName(),
					dog.getBreed(),
					dog.getGroup(),
					dog.getGender(),
					dog.getRanking()
			};
			this.jdbc.update(q, params);

			q = "insert into sun_show values (?, ?, ?, ?, ?, ?, ?)";

			params = new Object[] {
					dog.getEntryNum(),
					dog.getName(),
					dog.getOwnerName(),
					dog.getBreed(),
					dog.getGroup(),
					dog.getGender(),
					dog.getRanking()
			};
			this.jdbc.update(q, params);
		} catch (Exception e) {
			System.out.println("Connection Failed");
			System.out.println(e);
		}
	}

	public void addFriSatSun(DogContestant dog) {
		try {
			String q = "insert into fri_show values (?, ?, ?, ?, ?, ?, ?)";

			Object[] params = new Object[] {
					dog.getEntryNum(),
					dog.getName(),
					dog.getOwnerName(),
					dog.getBreed(),
					dog.getGroup(),
					dog.getGender(),
					dog.getRanking()
			};
			this.jdbc.update(q, params);

			q = "insert into sat_show values (?, ?, ?, ?, ?, ?, ?)";

			params = new Object[] {
					dog.getEntryNum(),
					dog.getName(),
					dog.getOwnerName(),
					dog.getBreed(),
					dog.getGroup(),
					dog.getGender(),
					dog.getRanking()
			};
			this.jdbc.update(q, params);

			q = "insert into sun_show values (?, ?, ?, ?, ?, ?, ?)";

			params = new Object[] {
					dog.getEntryNum(),
					dog.getName(),
					dog.getOwnerName(),
					dog.getBreed(),
					dog.getGroup(),
					dog.getGender(),
					dog.getRanking()
			};
			this.jdbc.update(q, params);
		} catch (Exception e) {
			System.out.println("Connection Failed");
			System.out.println(e);
		}
	}


    //READ
    public ArrayList<DogContestant> getDogContestants() {
		ArrayList<DogContestant> list = new ArrayList<DogContestant>();
		
		try {
			String q = "select * from contestants";
			
			List<Map<String, Object>> rows = jdbc.queryForList(q);
			
			for(Map<String, Object> r : rows) {
				DogContestant dog = new DogContestant(
						(Integer) r.get("entry_num"),
						(String) r.get("name"),
						(String) r.get("ownerName"),
						(String) r.get("breed"),
						(String) r.get("dog_group"),
						(String) r.get("gender"),
						(String) r.get("ranking")
						);
				list.add(dog);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
    }

    public ArrayList<DogContestant> getGroup(String groupName) {

		ArrayList<DogContestant> list = new ArrayList<DogContestant>();
		
		try {
			String q = "select * from contestants where dog_group like '" + groupName + "';";
			
			List<Map<String, Object>> rows = jdbc.queryForList(q);
			 
			if (rows ==  null) System.out.println("Null List");
			for(Map<String, Object> r : rows) {
				DogContestant dog = new DogContestant(
						(Integer) r.get("entry_num"),
						(String) r.get("name"),
						(String) r.get("ownerName"),
						(String) r.get("breed"),
						(String) r.get("dog_group"),
						(String) r.get("gender"),
						(String) r.get("ranking")
						);
				list.add(dog);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
    }

    public ArrayList<DogContestant> searchByNumber(int num) {
    	ArrayList<DogContestant> list = new ArrayList<DogContestant>();
    	
    	try {
			String q = "select * from contestants where entry_num = " + num + ";";
			
			List<Map<String, Object>> rows = jdbc.queryForList(q);
			
			for(Map<String, Object> r : rows) {
				DogContestant dog = new DogContestant(
						(Integer) r.get("entry_num"),
						(String) r.get("name"),
						(String) r.get("ownerName"),
						(String) r.get("breed"),
						(String) r.get("dog_group"),
						(String) r.get("gender"),
						(String) r.get("ranking")
						);
				list.add(dog);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
    	
    	return list;
    }
    
	public ArrayList<DogContestant> searchByFilter(String filter, String s) {
		  ArrayList<DogContestant> list = new ArrayList<DogContestant>();
	  
		  try { 
		  		String q = "select * from contestants where "+ filter +" like '" + s + "';";
	  
		 		List<Map<String, Object>> rows = jdbc.queryForList(q);
				
				for(Map<String, Object> r : rows) {
					DogContestant dog = new DogContestant(
							(Integer) r.get("entry_num"),
							(String) r.get("name"),
							(String) r.get("ownerName"),
							(String) r.get("breed"),
							(String) r.get("dog_group"),
							(String) r.get("gender"),
							(String) r.get("ranking")
							);
					list.add(dog);
				}
		  } catch (Exception e) { 
			  System.out.println(e); 
		  }
	  
		  return list; 
	  }
	 
	public ArrayList<DogContestant> getHandlerDogs(Long userID) {
		ArrayList<DogContestant> list = new ArrayList<DogContestant>();
		
		try {
			String q = "select hd.entry_num, c.name, c.ownerName, c.breed, c.dog_group, c.gender, c.ranking "
					+ "from handled_dogs hd, contestants c "
					+ "where hd.entry_num = c.entry_num "
					+ "and hd.user_id = " + userID;
			
			List<Map<String, Object>> rows = jdbc.queryForList(q);
			
			for(Map<String, Object> r : rows) {
				DogContestant dog = new DogContestant(
						(Integer) r.get("entry_num"),
						(String) r.get("name"),
						(String) r.get("ownerName"),
						(String) r.get("breed"),
						(String) r.get("dog_group"),
						(String) r.get("gender"),
						(String) r.get("ranking")
						);
				list.add(dog);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}
	
	public ArrayList<DogContestant> searchShows(String filter) {
		ArrayList<DogContestant> list = new ArrayList<DogContestant>();

		try {
			String q = "select * from " +filter;

			List<Map<String, Object>> rows = jdbc.queryForList(q);
			
			for(Map<String, Object> r : rows) {
				DogContestant dog = new DogContestant(
						(Integer) r.get("entry_num"),
						(String) r.get("name"),
						(String) r.get("ownerName"),
						(String) r.get("breed"),
						(String) r.get("dog_group"),
						(String) r.get("gender"),
						(String) r.get("ranking")
						);
				list.add(dog);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}

	//UPDATE
	public DogContestant getDogContestantByEntryNum(int entryNum) {

		  ArrayList<DogContestant> list = new ArrayList<DogContestant>();
		  String q = "SELECT * FROM contestants where entry_num=" + entryNum;
		  
		  List<Map<String, Object>> rows = jdbc.queryForList(q);
			
			for(Map<String, Object> r : rows) {
				DogContestant dog = new DogContestant(
						(Integer) r.get("entry_num"),
						(String) r.get("name"),
						(String) r.get("ownerName"),
						(String) r.get("breed"),
						(String) r.get("dog_group"),
						(String) r.get("gender"),
						(String) r.get("ranking")
						);
				list.add(dog);
			}

		  if (list.size() > 0) {
		   return list.get(0);
		  }
		  else {
		   return null;
		  }
		 }
		  
	public void editDogContestant(DogContestant d) {
		  try {

		   String q = "UPDATE contestants SET name=?, ownerName=?, breed=?, dog_group=?, gender=?, ranking=? WHERE entry_num=?;";
		   Object[] params = new Object[] {
				   d.getName(),
				   d.getOwnerName(),
				   d.getBreed(),
				   d.getGroup(),
				   d.getGender(),
				   d.getRanking(),
				   d.getEntryNum()
		   };
		   this.jdbc.update(q, params);
		   
		   q = "UPDATE fri_show SET name=?, ownerName=?, breed=?, dog_group=?, gender=?, ranking=? WHERE entry_num=?;";
		   params = new Object[] {
				   d.getName(),
				   d.getOwnerName(),
				   d.getBreed(),
				   d.getGroup(),
				   d.getGender(),
				   d.getRanking(),
				   d.getEntryNum()
		   };
		   this.jdbc.update(q, params);
		   
		   q = "UPDATE sat_show SET name=?, ownerName=?, breed=?, dog_group=?, gender=?, ranking=? WHERE entry_num=?;";
		   params = new Object[] {
				   d.getName(),
				   d.getOwnerName(),
				   d.getBreed(),
				   d.getGroup(),
				   d.getGender(),
				   d.getRanking(),
				   d.getEntryNum()
		   };
		   this.jdbc.update(q, params);
		   
		   q = "UPDATE sun_show SET name=?, ownerName=?, breed=?, dog_group=?, gender=?, ranking=? WHERE entry_num=?;";
		   params = new Object[] {
				   d.getName(),
				   d.getOwnerName(),
				   d.getBreed(),
				   d.getGroup(),
				   d.getGender(),
				   d.getRanking(),
				   d.getEntryNum()
		   };
		   this.jdbc.update(q, params);
		   
		  } catch (Exception e) {
		   System.out.println("Connection Failed");
		   System.out.println(e);
		  }
	}

	 
	//DELETE
	 public void deleteDogContestant(int entryNum) {
		  try {
		   String q = "DELETE FROM contestants WHERE entry_num=" + entryNum;
		   this.jdbc.update(q);
		   
		   q = "DELETE FROM fri_show WHERE entry_num=" + entryNum;
		   this.jdbc.update(q);
		   
		   q = "DELETE FROM sat_show WHERE entry_num=" + entryNum;
		   this.jdbc.update(q);
		   
		   q = "DELETE FROM sun_show WHERE entry_num=" + entryNum;
		   this.jdbc.update(q);
		   
		  } catch (Exception e) {
		   System.out.println("Connection Failed");
		   System.out.println(e);
		  }
		 }
	
	 public void removeHandledDog(int id) {
		 try {
			   String q = "DELETE FROM handled_dogs WHERE entry_num=" + id;
			   
			   this.jdbc.update(q);
			   
			  } catch (Exception e) {
			   System.out.println("Connection Failed");
			   System.out.println(e);
			  }
	}
	 
	 
}
