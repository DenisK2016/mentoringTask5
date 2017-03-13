package com.dk.mentoring.pattern.prototype;

public class MainClass
{

	public static void main(final String[] args) throws CloneNotSupportedException
	{
		final Owner garry = new Owner();
		garry.setName("Garry");
		final SampleCarPrototype carGarry1 = new SampleCarPrototype("Michelin", "BMW", "Audi", "GeneralMotors", garry);

		final SampleCarPrototype carGarry2 = (SampleCarPrototype) carGarry1.clone();

		System.out.println(carGarry1);
		System.out.println(carGarry2);
	}
}
