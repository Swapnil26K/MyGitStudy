package com.frost.pages;

public class StaticCheck 
{
	static int rollNumber;
	String studName;
	
	public void enterStudentInfo(String studName)
	{
		this.studName=studName;
		enterRollNumber();		
	}
	
	public void enterRollNumber()
	{
		rollNumber++;
	}
	
	public String getStudentName()
	{
		return studName;
	}
	
	public int getRollNumber()
	{
		return rollNumber;
	}
	
	public static void main(String args[])
	{
		StaticCheck sc=new StaticCheck();
		StaticCheck sc1=new StaticCheck();
		sc.enterStudentInfo("Swap");
		System.out.println("Name of Student is:"+sc.getStudentName()+"Roll Number of Student is:"+sc.getRollNumber());
		sc1.enterStudentInfo("Swap");
		System.out.println("Name of Student is:"+sc.getStudentName()+"Roll Number of Student is:"+sc1.getRollNumber());
	}
}
