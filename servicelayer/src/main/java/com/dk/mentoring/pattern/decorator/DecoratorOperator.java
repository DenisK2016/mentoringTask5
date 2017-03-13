package com.dk.mentoring.pattern.decorator;

abstract class DecoratorOperator implements Operator
{

	OperatorImpl operator;

	public DecoratorOperator(final OperatorImpl operator)
	{
		super();
		this.operator = operator;
	}


	@Override
	public void doOperation()
	{
		operator.doOperation();
	}

	public abstract void newOperation();


	public OperatorImpl getOperator()
	{
		return operator;
	}

}
