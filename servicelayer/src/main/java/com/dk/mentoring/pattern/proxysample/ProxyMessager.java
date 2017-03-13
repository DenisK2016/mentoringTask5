package com.dk.mentoring.pattern.proxysample;

public class ProxyMessager implements Messager
{

	private MessagerImpl messager;

	@Override
	public void saveMessage(final String nameOfFile, final String string) throws Exception
	{
		System.err.println("The name of new file - " + nameOfFile);
		System.out.println("The text - " + string);
		if (null == messager)
		{
			messager = new MessagerImpl();
		}
		messager.saveMessage(nameOfFile, string);
	}

}
