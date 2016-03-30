package com.mycom.myapp;

import java.util.ArrayList;
import java.util.List;

//import java.text.DateFormat;
//import java.util.Date;
//import java.util.Locale;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}*/
	
	/*
	 * GET
	 */
	private List<String> list;
	private HomeController(){
		list = new ArrayList<String>();
		list.add("Tom");
		list.add("John");
		list.add("Ray");
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getDefaultMovie(ModelMap model) {
		
		model.addAttribute("person", list);
		return "home";

	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String getMovie(@PathVariable String name, ModelMap model) {
		if(list.contains(name))
			model.addAttribute("person", name);
		else
			model.addAttribute("person", "No this guy");
		
		return "home";

	}
	
	
	
	/*
	 * POST
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String postMovie(@RequestParam String name, ModelMap model){
		
		list.add(name);
		model.addAttribute("person", "POST already");
		return "home";
	}
	
	/*
	 * PUT
	 */
	@RequestMapping(value = "/{name}", method = RequestMethod.PUT)
	public @ResponseBody String putMovie(@PathVariable String name, ModelMap model){
		
		list.add(name);
		//model.addAttribute("movie", "PUT already");
		return "PUT already";
		
		//model.addAttribute("movie", "HI PUT");
		//return "home";
		/*String str = new String("HI REX");
		String str2 = new String("no put");
		
		if(name.equals("rex"))
			return str;
		else
			return str2;*/
	}
	
	/*
	 * DELETE
	 */
	@RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteMovie(@PathVariable String name, ModelMap model){
		
		//model.addAttribute("movie", "HI DELETE");
		//return "homeless";
		
		if(list.contains(name))
			list.remove(name);
		
		return "DELETE done";
			
	}
	
}
