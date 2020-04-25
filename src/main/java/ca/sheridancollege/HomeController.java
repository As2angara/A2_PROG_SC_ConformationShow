package ca.sheridancollege;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.bean.DogBreed;
import ca.sheridancollege.bean.DogContestant;
import ca.sheridancollege.bean.Mail;
import ca.sheridancollege.bean.User;
import ca.sheridancollege.dao.DAO;
import ca.sheridancollege.dao.DAOSec;
import ca.sheridancollege.logic.GenerateData;
import ca.sheridancollege.logic.GroupOrganizer;

@Controller
public class HomeController {

	@Autowired DAO dao;
	@Autowired private EmailService emailService; 

	@GetMapping("/")
	public String getHomePage( Model model, Authentication auth) {
		
		model.addAttribute("login", auth != null);
		
		return "home.html";
	}
	
	@GetMapping("/addDog")
	public String getAddContestantPage(Model model) {
		
		model.addAttribute("dog", new DogContestant());
		return "addDog.html";
	}
	
	@GetMapping("/addContestant")
	public String addContestant(@ModelAttribute DogContestant dog, Model model,
			@RequestParam String frishow, @RequestParam String satshow, @RequestParam String sunshow,
			@RequestParam String email) {
		
		dao.addDogContestant(dog);
		
		String friconf = "";
		String satconf = "";
		String sunconf = "";
		
		if ("fri".equals(frishow)) {
			dao.addFri(dog);
			friconf = "Friday, January 3 2020\n";
		}
		if ("sat".equals(satshow)) {
			dao.addSat(dog);
			satconf = "Saturday, January 4 2020\n";
		}
		if ("sun".equals(sunshow)) {
			dao.addSun(dog);
			sunconf = "Sunday, January 5 2020\n";
		}
		
		String daysconf = friconf+satconf+sunconf;
		
		if (email != null) {
			Mail mail = new Mail();
			mail.setFrom("korolyksheridan@gmail.com");
			mail.setTo(email);
			mail.setSubject("TGCDS Registration Confirmation");
			mail.setContent(dog.getName() + " has been registered!\n\n"+
			"Owner: " + dog.getOwnerName() +"\n"+
			"Breed: " + dog.getBreed() +"\n"+
			"Group: " + dog.getGroup() +"\n"+
			"Gender: " + dog.getGender() +"\n"+
			"Ranking: " + dog.getRanking() +"\n\n"+
			"Days:\n" + daysconf +"\n\nGood Luck!");

			emailService.sendSimpleMessage(mail);
		}
		
		model.addAttribute("dog", new DogContestant());

		return "redirect:/addDog";
	}
	
	@GetMapping("/showTable")
	public String getTablePage(Model model) {
		ArrayList<DogContestant> list = dao.getDogContestants();
		model.addAttribute("list", list);
		return "table.html";
	}
	
	@GetMapping("/breeds")
	public String getGroupListPage(Model model) {
		GroupOrganizer g = new GroupOrganizer();
		
		dao.getGroup("Group 1, Sporting Dogs");
		
		
		  ArrayList<DogBreed> g1 = g.organizeGroup(dao.getGroup("Group 1, Sporting Dogs"));
		  ArrayList<DogBreed> g2 = g.organizeGroup(dao.getGroup("Group 2, Hounds"));
		  ArrayList<DogBreed> g3 = g.organizeGroup(dao.getGroup("Group 3, Working Dogs"));
		  ArrayList<DogBreed> g4 = g.organizeGroup(dao.getGroup("Group 4, Terriers"));
		  ArrayList<DogBreed> g5 = g.organizeGroup(dao.getGroup("Group 5, Toys"));
		  ArrayList<DogBreed> g6 = g.organizeGroup(dao.getGroup("Group 6, Non-Sporting"));
		  ArrayList<DogBreed> g7 = g.organizeGroup(dao.getGroup("Group 7, Herding"));
		  
		  model.addAttribute("g1", g1); model.addAttribute("g2", g2);
		  model.addAttribute("g3", g3); model.addAttribute("g4", g4);
		  model.addAttribute("g5", g5); model.addAttribute("g6", g6);
		  model.addAttribute("g7", g7);
		 
		
		return "breedList.html";
	}

	@GetMapping("/searchPage") 
	public String getSearchPage( Model model) {

		return "search.html";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam String filter, @RequestParam String search, Model model) {

		if(filter.equals("entry_num")) {
			int num = Integer.parseInt(search);
			ArrayList<DogContestant> list = dao.searchByNumber(num);
			model.addAttribute("search", list);
			
		} else { 
			
			ArrayList<DogContestant> list = dao.searchByFilter(filter, search);
			model.addAttribute("search", list);	  
		}
			 
		return "searchResults.html";
	}
	
	 @GetMapping("/showsPage")
	 public String goShowPage() {
	  return "shows.html";
	 }
	 
	 @GetMapping("/shows")
	 public String shows(@RequestParam String filter, Model model) {

	  ArrayList<DogContestant> list = dao.searchShows(filter);
	  System.out.println(list);

	  model.addAttribute("search", list);
	  
	  if (filter.equals("fri_show")) {
	   model.addAttribute("show", "Friday, January 3 2020");
	  }
	  if (filter.equals("sat_show")) {
	   model.addAttribute("show", "Saturday, January 4 2020");
	  }
	  if (filter.equals("sun_show")) {
	   model.addAttribute("show", "Sunday, January 5 2020");
	  }

	  return "showsResults.html";
	 }
	
	@GetMapping("/generateData")
	public String generateData() {
		GenerateData g = new GenerateData();
		DogContestant dog  = new DogContestant();
		
		for (int i = 0; i < 100; i++) {
			dog = g.generateData();
			dao.addDogContestant(dog);
			
			// Generate random date (1-7)
						int showID = (int) ((Math.random() * 7) + 1);
						if (showID == 1) {
							dao.addFri(dog);
						}
						if (showID == 2) {
							dao.addSat(dog);
						}
						if (showID == 3) {
							dao.addFriSat(dog);
						}
						if (showID == 4) {
							dao.addSun(dog);
						}
						if (showID == 5) {
							dao.addFriSun(dog);
						}
						if (showID == 6) {
							dao.addSatSun(dog);
						}
						if (showID == 7) {
							dao.addFriSatSun(dog);
						}
		}
		
		return "redirect:/";
	}

	@GetMapping("/login")
	public String getLoginPage() {
		return "login.html";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "home.html";
	}
	
	@GetMapping("/user")
	public String getHandlersPage(Model model, Authentication auth) {
		DAOSec d = new DAOSec();
		User user = d.findUserAccount(auth.getName());
		
		model.addAttribute("list", dao.getHandlerDogs(user.getUserId()));
		
		return "/users/handlers.html";
	}

	@GetMapping("/addHandlerDogPage")
	public String getAddHandlerDogPage(Model model) {
		model.addAttribute("search", dao.getDogContestants());
		return "/users/addHandlerDog.html";
	}
	
	@GetMapping("/addHandlerDog/{id}")
	public String addHandlerDog(@PathVariable int id, Model model, Authentication auth) {
		//Get the dog that was selected and pass into handled_dogs table
		DAOSec d = new DAOSec();
		User user = d.findUserAccount(auth.getName());
		dao.addHandledDog(id, user.getUserId());
		
		model.addAttribute("search", dao.getDogContestants());
		return "/users/addHandlerDog.html";
	}
	
	@GetMapping("/removeHandledDog/{id}")
	public String handledDog(@PathVariable int id, Model model, Authentication auth) {
		 DAOSec d = new DAOSec();
		 User user = d.findUserAccount(auth.getName());
		 dao.removeHandledDog(id);
		 model.addAttribute("list", dao.getHandlerDogs(user.getUserId()));
		 return ("/users/handlers.html");
	 }

	 @GetMapping("/delete/{entryNum}")
	 public String deleteDogContestant(@PathVariable int entryNum, Model model) {
		 dao.deleteDogContestant(entryNum);
		 model.addAttribute("list", dao.getDogContestants());
		 return ("table.html");
	 }

	 @GetMapping("/edit/{entryNum}")
	 public String editDogContestant(@PathVariable int entryNum, Model model) {
		 DogContestant d = dao.getDogContestantByEntryNum(entryNum);
		 model.addAttribute("dog", d);
		 return ("editDog.html");
	 }

	 @GetMapping("/modify")
	 public String modifyDog(Model model, @ModelAttribute DogContestant dog) {
		 
		 dao.editDogContestant(dog);
		 model.addAttribute("list", dao.getDogContestants());
		 return ("table.html");

	 }
}
