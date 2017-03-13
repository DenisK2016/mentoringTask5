package com.dk.mentoring.pattern.flyweightsample;

public enum FontEffect
{
	BOLD, ITALIC, SUPERSCRIPT;

	public int getPointSize()
	{
		if (this == BOLD)
		{
			return 10;
		}
		else if (this == ITALIC)
		{
			return 20;
		}
		else if (this == SUPERSCRIPT)
		{
			return 30;
		}
		else
		{
			return 0;
		}
	}

	public String getFontFace()
	{
		if (this == BOLD)
		{
			return "font-family: Pamp";
		}
		else if (this == ITALIC)
		{
			return "font-family: Tamp";
		}
		else if (this == SUPERSCRIPT)
		{
			return "font-family: Mamp";
		}
		else
		{
			return "";
		}
	}
}
