package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class AppController {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private ItemRepository itemRepo;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/shop")
	public String viewShopPage(Model model) {
		List<Item> items = itemRepo.findByUser(null);
		model.addAttribute("items", items);
		return "shop";
	}
	
	@GetMapping("/owner")
	public String viewOwnerPage(Authentication authentication, Model model) {
		String email = authentication.getName();
		User user = repo.findByEmail(email);
		List<Item> items = itemRepo.findByUser(user);
		model.addAttribute("items", items);
		return "owner";
	}
	
	@GetMapping("/confirm/{id}")
	public String confirmPage(@PathVariable long id, Authentication authentication, Model model) {
		String email = authentication.getName();
		User user = repo.findByEmail(email);
		Item item = itemRepo.findById(id).get();
		item.setUser(user);
		model.addAttribute("item", item);
		return "confirm";
	}
	
	@GetMapping("/save/{id}")
	public RedirectView confirmPagePost(@PathVariable long id, Authentication authentication, Model model) {
		String email = authentication.getName();
		User user = repo.findByEmail(email);
		Item item = itemRepo.findById(id).get();
		item.setUser(user);
		itemRepo.save(item);
		return new RedirectView("/owner");
	}
	
	@GetMapping("/refund/{id}")
	public RedirectView refundPagePost(@PathVariable long id, Authentication authentication, Model model) {
		Item item = itemRepo.findById(id).get();
		item.setUser(null);
		itemRepo.save(item);
		return new RedirectView("/owner");
	}
	
	@GetMapping("/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("user", new User());
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegistration(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		repo.save(user);
		return "register_success";
	}
	
	@GetMapping("/list_users")
	public String viewUserList(Model model) {
		List<User> listUsers = repo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "users";
	}
	
	
}
