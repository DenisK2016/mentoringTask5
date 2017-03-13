package com.dk.mentoring.pattern.singleton;

public final class SampleSingleton
{
	private static volatile SampleSingleton instance = null;
	private static int count = 0;

	private SampleSingleton()
	{
		super();
		count++;
	}

	public static synchronized SampleSingleton getInstance()
	{
		if (null == instance)
		{
			synchronized (SampleSingleton.class)
			{
				if (null == instance)
				{
					instance = new SampleSingleton();
				}
			}
		}
		return instance;
	}

	@Override
	public int hashCode()
	{
		return count;
	}
}
