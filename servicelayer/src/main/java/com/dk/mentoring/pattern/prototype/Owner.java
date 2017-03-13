package com.dk.mentoring.pattern.prototype;

public class Owner
{
	private static int count = 0;
	private final String uniqueCode;
	private String name;

	public Owner()
	{
		super();
		this.uniqueCode = String.format("%s%d", "ABC", count);
		count++;
	}

	public String getUniqueCode()
	{
		return uniqueCode;
	}

	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "Owner [uniqueCode=" + uniqueCode + ", name=" + name + "]";
	}

}
