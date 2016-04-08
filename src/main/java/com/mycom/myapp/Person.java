package com.mycom.myapp;

<<<<<<< HEAD:src/main/java/com/mycom/myapp/Person.java
//改成註解寫法?

=======

//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
>>>>>>> b6ad55eff7444d56314892767b17bd0b6509eb60:src/main/java/com/mycom/myapp/Person.java
public class Person {
	private String name;
	private String address; 
	private int age;
	
	public Person(){
		
	}
	
	public Person(String name,String address,int age){
		this.name = name;
		this.address = address;
		this.age = age;
	}

	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public void setAge(int age){
		this.age = age;
	}
}
