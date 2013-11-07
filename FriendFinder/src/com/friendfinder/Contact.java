package com.friendfinder;

public class Contact 
{
	private String name;
	private String number;
	
	public Contact(String na, String num)
	{
		name = na;
		number = num;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getNumber()
	{
		return number;
	}
}
