package com.dk.mentoring.pattern.decorator;

public class DecoratorSpace extends DecoratorOperator
{

	public DecoratorSpace(final OperatorImpl operator)
	{
		super(operator);
	}

	@Override
	public void doOperation()
	{
		System.out.println(" ");
		super.doOperation();
	}

	@Override
	public void newOperation()
	{
		System.out.println("Decorator adds a space to a default operator");
	}

}
