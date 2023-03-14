package com.techpalle.model;

public class Customer 
{
	
	private String name;
	private String gen;
	private String email;
	private String pwd;
	private long mob;
	private String state;
	
	public Customer(String name, String gen, String email, String pwd, long mob, String state)
	{
		
		this.name = name;
		this.gen = gen;
		this.email = email;
		this.pwd = pwd;
		this.mob = mob;
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGen() {
		return gen;
	}

	public void setGen(String gen) {
		this.gen = gen;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public long getMob() {
		return mob;
	}

	public void setMob(long mob) {
		this.mob = mob;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
