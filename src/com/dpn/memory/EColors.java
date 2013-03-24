package com.dpn.memory;

import android.graphics.Color;

public enum EColors {
	RED(Color.rgb(255,0,0)),
	ORANGE(Color.rgb(255, 127, 0)),
	YELLOW(Color.YELLOW),
	GREEN(Color.rgb(0, 127, 0)),
	BLUE(Color.BLUE),
	PURPLE(Color.rgb(127, 0, 255)),
	DKRED(Color.rgb(127, 0, 0)),
	LIGHT_GREEN(Color.rgb(0, 255, 0)),
	CYAN(Color.CYAN),
	MAGENTA(Color.MAGENTA),
	GRAY(Color.GRAY),
	DKGRAY(Color.DKGRAY),
	LTGRAY(Color.LTGRAY),
	BROWN(Color.rgb(150, 75, 0)),
	BLACK(Color.BLACK),
	DKBROWN(Color.rgb(75, 37, 0)),
	WHITE(Color.WHITE),
	DKBLUE(Color.rgb(0, 0, 63));
	
	public final int mColor;
	
	private EColors(int pColor){
		mColor = pColor;
	}
	private EColors(){
		this(Color.BLUE);
	}
}
