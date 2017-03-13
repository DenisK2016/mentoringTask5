package com.dk.mentoring.pattern.flyweightsample;

public class MainClass
{
	public static void main(final String[] args)
	{
		final FontData fontData1 = FontData.create(FontEffect.SUPERSCRIPT);

		System.out.println(FontData.count);

		final FontData fontData2 = FontData.create(FontEffect.SUPERSCRIPT);

		System.out.println(FontData.count);

		final FontData fontData3 = FontData.create(FontEffect.BOLD);

		System.out.println(FontData.count);
	}
}
