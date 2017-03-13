package com.dk.mentoring.pattern.decorator;

public class MainClass
{
	public static void main(final String[] args)
	{
		final DecoratorOperator decorator1 = new DecoratorComma(new OperatorImpl());
		decorator1.newOperation();
		decorator1.doOperation();
		decorator1.getOperator().doOperation();

		System.out.println("-----------------------------------------------------------");

		final DecoratorOperator decorator2 = new DecoratorSpace(new OperatorImpl());
		decorator2.newOperation();
		decorator2.doOperation();
		decorator2.getOperator().doOperation();
	}
}
