package com.dpn.memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum ELetters {
	A,
	B,
	C,
	D,
	E,
	F,
	G,
	H,
	I,
	J,
	K,
	L,
	M,
	N,
	O,
	P,
	Q,
	R;
	
	static List<ELetters> getRandomList(int pNumToReturn){
		
		ArrayList<ELetters> letters = new ArrayList<ELetters>(pNumToReturn);
		
		int i=0;
		while(letters.size()<pNumToReturn){
				letters.add(values()[i]);
				letters.add(values()[i++]);
		}
		Collections.shuffle(letters, new Random(System.currentTimeMillis()));
		return letters;
	}
}
