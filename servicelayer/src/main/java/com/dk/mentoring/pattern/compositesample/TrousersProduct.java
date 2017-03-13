package com.dk.mentoring.pattern.compositesample;

public class TrousersProduct implements Product
{

	private final String name;

	public TrousersProduct(final String name)
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
