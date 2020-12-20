package com.packt.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.packt.springsecurity.hibernate.entity.HorrorMovieEntity;
import com.packt.springsecurity.service.HorrorMovieManager;

@Controller
public class AddHorrorMovieController {

	@Autowired
	private HorrorMovieManager horrorMovieManager;
	
	public void setHorrorMovieManager(HorrorMovieManager horrorMovieManager) {
		this.horrorMovieManager = horrorMovieManager;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String defaultPage(ModelMap map) {
		return "redirect:/list";
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listHorrorMovies(ModelMap map) {
		
		map.addAttribute("horrorMovie", new HorrorMovieEntity());
		map.addAttribute("HorrorMovieList", horrorMovieManager.getAllHorrorMovies());

		return "horrormovieList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addHorrorMovie(
			@ModelAttribute(value = "horrorMovie") HorrorMovieEntity horrorMovie,
			BindingResult result) {
		horrorMovieManager.addHorrorMovie(horrorMovie);
		return "redirect:/list";
	}

	@RequestMapping("/delete/{horrormovie_id}")
	public String deleteHorrorMovie(@PathVariable("horrormovie_id") Integer horrorMovieId) {
		horrorMovieManager.deleteHorrorMovie(horrorMovieId);
		return "redirect:/list";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "denied";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "logout";
	}
}
