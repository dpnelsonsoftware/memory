package com.dpn.memory;

import java.util.List;

import android.app.Activity;

public class MemoryGameManager<T> {
	
	private enum EState{
		NOTHING_PRESSED,
		ONE_PRESSED,
		TWO_PRESSED;
	}
	
	private int itemsRemaining;
	
	private EState mState = EState.NOTHING_PRESSED;
	private final int mCols;
	private final int mRows;
	private final List<T> mLetters;
	
	private MemoryButton<T> mButtonOne;
	private MemoryButton<T> mButtonTwo;
	
	public MemoryGameManager(int pCols, int pRows, List<T> pLetters, Activity pActivity) {
		mCols = pCols;
		mRows = pRows;
		mLetters = pLetters;
		itemsRemaining = pLetters.size();
	}

	public int getNumColumns() {
		return mCols;
	}
	
	public int getNumberOfItems(){
		return mCols * mRows;
	}
	public T getItemAtPosition(int pPosition){
		return mLetters.get(pPosition);
	}

	
	public void buttonPressed(MemoryButton<T> pBtn){
		
		switch(mState){
			case TWO_PRESSED:
				checkForMatch();
				//falls through
			case NOTHING_PRESSED:
				mButtonOne = pBtn;
				revealButton(mButtonOne);
				mState = EState.ONE_PRESSED;
				break;
			case ONE_PRESSED:
				mButtonTwo = pBtn;
				revealButton(mButtonTwo);
				mState = EState.TWO_PRESSED;
				if(itemsRemaining == 2){
					checkForMatch();
				}
				break;
			default:
				break;
		}

	}
	
	
	private void checkForMatch() {
		T buttonOnePayload = getItemAtPosition(mButtonOne.getPosition());
		T buttonTwoPayload = getItemAtPosition(mButtonTwo.getPosition());
		if(buttonOnePayload.equals(buttonTwoPayload)){
			removeButton(mButtonOne);
			removeButton(mButtonTwo);
			itemsRemaining -=2;
		}else{
			hideButton(mButtonOne);
			hideButton(mButtonTwo);
		}
		if(itemsRemaining == 0){
			//FIXME: WIN!!!!
		}
	}

	private void revealButton(MemoryButton<T> pBtn){
		pBtn.revealButton();

	}
	private void hideButton(MemoryButton<T> pBtn){
		pBtn.hideButton();
	}
	private void removeButton(MemoryButton<T> pBtn){
		
		
		
		
		
		
		
		
		pBtn.removeButton();
	}
}
