package com.dk.mentoring.pattern.flyweightsample;

import java.util.HashMap;
import java.util.Map;


public final class FontData
{

	private static final Map<FontEffect, FontData> flyweightData = new HashMap<FontEffect, FontData>();
	private final int pointSize;
	private final String fontFace;
	private final FontEffect effect;
	public static int count = 0;

	private FontData(final int pointSize, final String fontFace, final FontEffect effect)
	{
		count++;
		this.pointSize = pointSize;
		this.fontFace = fontFace;
		this.effect = effect;
	}

	public static FontData create(final FontEffect effect)
	{
		if (!flyweightData.containsKey(effect))
		{
			flyweightData.put(effect, new FontData(effect.getPointSize(), effect.getFontFace(), effect));
		}
		return flyweightData.get(effect);
	}

}
