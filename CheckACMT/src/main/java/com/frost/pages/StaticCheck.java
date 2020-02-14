package com.frost.pages;

public class StaticCheck 
{
	static int rollNumber;
	String studentName;
	
	public void enterStudentInfo(String studName)
	{
		this.studentName=studName;
		enterRollNumber();		
	}
	
	public static void enterRollNumber()
	{
		rollNumber++;
	}
	
	public String getStudentName()
	{
		return studentName;
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
