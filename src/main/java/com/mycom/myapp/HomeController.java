package com.mycom.myapp;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

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
	
	
	
	@Resource(name = "innerList")
	private List<String> myList;
	
	@Resource(name = "shopList")
	private List<Shop> spList;
	
	/*@Override
	public String toString() {
		return "SP lists=" + spList;
	}*/
	
	/*
	 * GET
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody List<Shop> getDefaultMovie() {
		
		//model.addAttribute("person", myList);
		//return "home";
		
		
		return spList;

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces={"application/json"})
	public @ResponseBody Object getMovie(@PathVariable String id) {
		/*if(myList.contains(name))
			model.addAttribute("person", name);
		else
			model.addAttribute("person", "No this guy");
		
		return "home";*/
		
		/*Shop shop = new Shop();
		shop.setName(name);
		
		return shop;*/
		int index = Integer.parseInt(id);
		
		if(spList.contains(index))
			return spList.get(index);
		else
			return "no this shop";

	}
	
	
	
	/*
	 * POST
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST, produces={"application/json"})
	public String postMovie(@RequestParam String name, ModelMap model){
		
		myList.add(name);
		model.addAttribute("person", "POST already");
		return "home";
	}
	
	/*
	 * PUT
	 */
	@RequestMapping(value = "/{name}", method = RequestMethod.PUT, produces={"application/json"})
	public @ResponseBody String putMovie(@PathVariable String name, ModelMap model){
		
		myList.add(name);
		return "PUT already";
		
	}
	
	/*
	 * DELETE
	 */
	@RequestMapping(value = "/{name}", method = RequestMethod.DELETE, produces={"application/json"})
	public @ResponseBody String deleteMovie(@PathVariable String name, ModelMap model){
		
		if(myList.contains(name))
			myList.remove(name);
		
		return "DELETE done";
			
	}

}
