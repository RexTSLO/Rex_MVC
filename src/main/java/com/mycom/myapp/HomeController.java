package com.mycom.myapp;

<<<<<<< HEAD
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/*import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;*/
=======
import java.util.List;

import javax.annotation.Resource;
//import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
>>>>>>> b6ad55eff7444d56314892767b17bd0b6509eb60


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * Handles requests for the application home page.
 */
@RestController
public class HomeController {
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/*@RequestMapping(value = "/home/", method = RequestMethod.GET)
	public String home(Locale locale) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		//DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		//String formattedDate = dateFormat.format(date);
		logger.info("The time is {}",date );
		
		return "homepage";
	}*/
	
	
	
	/*@Resource(name = "innerList")
	private List<String> myList;
	*/
	
	@Resource(name = "innerList")
	private List<Person> myList;
	
	
	
	/*
	 * GET
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
<<<<<<< HEAD
	public List<Person> getDefault() {
		return myList;
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET, produces={"application/json"})
	public Object getSomebody(@PathVariable String name) {
		
=======
	public @ResponseBody List<Person> getDefaultMovie() {
		
		//model.addAttribute("person", myList);
		//return "home";
		
		
		return myList;

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
>>>>>>> b6ad55eff7444d56314892767b17bd0b6509eb60
		/*XmlWebApplicationContext context = new XmlWebApplicationContext();
		context.setConfigLocation("/WEB-INF/spring/appServlet/servlet-context.xml");
		context.setServletContext(event.getServletContext());
        context.refresh();*/
		//ApplicationContext context = new ClassPathXmlApplicationContext("*/servlet-context.xml");
		
<<<<<<< HEAD
		//ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("*/servlet-context.xml");
		
		//怎麼改成相對路徑?
		//ApplicationContext context = new FileSystemXmlApplicationContext("E:/workspace/Rex_MVC/src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
		//ApplicationContext context = new FileSystemXmlApplicationContext("/Rex_MVC/src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
		
		//Object test = context.getBean(name);
		//return test;
		//先用名字搜尋
		for(Person person: myList){
			if(person.getName().equals(name)){
				return person;
			}
		}
=======
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("*/servlet-context.xml");
		
		//怎麼改成相對路徑?
		//ApplicationContext context = new FileSystemXmlApplicationContext("E:/workspace/Rex_MVC/src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
		
		Object test = context.getBean(id);
		
		/*
		if(myList.contains(person))
			return person;
		else*/
			return test;
>>>>>>> b6ad55eff7444d56314892767b17bd0b6509eb60

		return "no this person";
		
	}
	
	
	
	/*
	 * POST
	 */
<<<<<<< HEAD
	//spring 4 可以直接使用List<Person>，spring 3 需要多寫一個PersonWrapper
	@RequestMapping(value = "/", method = RequestMethod.POST, consumes="application/json")
	public String postSomebodies(@RequestBody List<Person> personList){
		if(personList!=null){
			for(Person person: personList){
				myList.add(person);
			}
			return "Post already";
		}
		return "Post fail"; //印不到
	}
	// 習慣上不會傳JSON檔!
	@RequestMapping(value = "/upload/", method = RequestMethod.POST, consumes="multipart/form-data")
	public String postFile(@RequestParam("file") MultipartFile file){
		if(!file.isEmpty()){
			try {
				InputStream inputStream = file.getInputStream();
				JSONParser parser = new JSONParser();
				JSONObject jsonObject = (JSONObject)parser.parse(new InputStreamReader(inputStream));
				
				Person person = new Person((String)jsonObject.get("name"),
										   (String)jsonObject.get("address"),
										   Integer.parseInt(jsonObject.get("age").toString())
										   );
				myList.add(person);
	
				inputStream.close();
				
				return "Post file already";
			} catch (IOException | ParseException e) {
				e.printStackTrace();
				return "throw catch";
			}
		}
		else
			return "File is empty";
=======
	@RequestMapping(value = "/", method = RequestMethod.POST, produces={"application/json"})
	public String postMovie(@RequestParam String name, ModelMap model){
		
		/*myList.add(name);
		model.addAttribute("person", "POST already");*/
		return "home";
>>>>>>> b6ad55eff7444d56314892767b17bd0b6509eb60
	}
	
	/*
	 * PUT
	 */
<<<<<<< HEAD
	@RequestMapping(value = "/{name}", method = RequestMethod.PUT, consumes="application/json")
	public String putSomebody(@PathVariable String name, @RequestBody Person updatePerson){
		for(Person person: myList){
			if(person.getName().equals(name)){
				person.setAddress(updatePerson.getAddress());
				person.setAge(updatePerson.getAge());
				return "PUT Update";
			}
		}
		
		myList.add(updatePerson);
		return "Put Create";
=======
	@RequestMapping(value = "/{name}", method = RequestMethod.PUT, produces={"application/json"})
	public @ResponseBody String putMovie(@PathVariable String name, ModelMap model){
		
		/*myList.add(name);*/
		return "PUT already";
		
>>>>>>> b6ad55eff7444d56314892767b17bd0b6509eb60
	}
	
	
	/*
	 * DELETE
	 */
<<<<<<< HEAD
	@RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
	public String deleteSomebody(@PathVariable String name){
		for(Person person: myList){
			if(person.getName().equals(name)){
				myList.remove(person);
				return "Delete already";
			}
		}
		return "Delete fail";
=======
	@RequestMapping(value = "/{name}", method = RequestMethod.DELETE, produces={"application/json"})
	public @ResponseBody String deleteMovie(@PathVariable String name, ModelMap model){
		
		/*if(myList.contains(name))
			myList.remove(name);
		*/
		return "DELETE done";
>>>>>>> b6ad55eff7444d56314892767b17bd0b6509eb60
			
	}

}
