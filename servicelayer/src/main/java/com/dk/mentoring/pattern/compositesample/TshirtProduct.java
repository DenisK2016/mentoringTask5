package com.dk.mentoring.pattern.compositesample;

public class TshirtProduct implements Product
{
	private final String name;

	public TshirtProduct(final String name)
	{
		super();
		this.name = name;
	}

	@Override
	public void print()
	{
		System.out.println(name);
	}
}
