package com.dk.mentoring.pattern.decorator;

public class DecoratorComma extends DecoratorOperator
{

	public DecoratorComma(final OperatorImpl operator)
	{
		super(operator);
	}

	@Override
	public void doOperation()
	{
		System.out.println(",");
		super.doOperation();
	}

	@Override
	public void newOperation()
	{
		System.out.println("Decorator adds a comma to a default operator");

	}

}
