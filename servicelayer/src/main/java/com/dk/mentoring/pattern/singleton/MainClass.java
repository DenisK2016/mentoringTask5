package com.dk.mentoring.pattern.singleton;

public class MainClass
{
	public static void main(final String[] args)
	{
		final SampleSingleton sample1 = SampleSingleton.getInstance();
		System.out.println("sample1 hashCode method = " + sample1.hashCode());
		final SampleSingleton sample2 = SampleSingleton.getInstance();
		System.out.println("sample2 hashCode method = " + sample2.hashCode());
		final SampleSingleton sample3 = SampleSingleton.getInstance();
		System.out.println("sample3 hashCode method = " + sample3.hashCode());
		final SampleSingleton sample4 = SampleSingleton.getInstance();
		System.out.println("sample4 hashCode method = " + sample4.hashCode());
	}
}
