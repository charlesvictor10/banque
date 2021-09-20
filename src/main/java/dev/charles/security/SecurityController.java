package dev.charles.security;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dev.charles.entities.Users;
import dev.charles.metier.IBanqueMetier;

@Controller
public class SecurityController {
	@Autowired
	private IBanqueMetier banqueMetier;
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("user", new Users());
		return "register";
	}
	
	@RequestMapping(value="/saveUser", method=RequestMethod.POST)
	public String saveUtilisateur(@Valid Users u, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "register";
		}
		
        u.setUsername(u.getUsername());
        u.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));
        banqueMetier.saveUser(u);
		return "redirect:/login";
	}

	@RequestMapping(value="/")
	public String home() {
		return "redirect:/operations";
	}
	
	@RequestMapping(value="/403")
	public String accessDenied() {
		return "403";
	}
}
