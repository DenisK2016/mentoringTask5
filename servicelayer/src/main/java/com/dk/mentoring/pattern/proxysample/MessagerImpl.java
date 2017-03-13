package com.dk.mentoring.pattern.proxysample;

import java.io.FileOutputStream;


public class MessagerImpl implements Messager
{

	@Override
	public void saveMessage(final String nameOfFile, final String string) throws Exception
	{
		final FileOutputStream outputStream = new FileOutputStream(nameOfFile);
		outputStream.write(string.getBytes());
		outputStream.close();
	}

}
