package com.dk.mentoring.pattern.proxysample;

public class MainClass
{
	public static void main(final String[] args) throws Exception
	{
		final Messager messager = new ProxyMessager();

		messager.saveMessage("file.txt", "Some sample text!!!!!");
	}
}
