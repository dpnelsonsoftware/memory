package com.dpn.memory;

import java.util.List;

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
	private final IMemoryGameManagerListener mView;
	private int mPlayCount;
	
	private int mButtonOne;
	private int mButtonTwo;
	
	public MemoryGameManager(int pCols, int pRows, List<T> pLetters, IMemoryGameManagerListener pActivity) {
		mCols = pCols;
		mRows = pRows;
		mLetters = pLetters;
		itemsRemaining = pLetters.size();
		mView = pActivity;
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

	
	public void buttonPressed(int pBtn){
		
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
				mView.playCountChanged(++mPlayCount);
				if(itemsRemaining == 2){
					checkForMatch();
				}
				break;
			default:
				break;
		}

	}
	
	
	private void checkForMatch() {
		T buttonOnePayload = mLetters.get(mButtonOne);
		T buttonTwoPayload = mLetters.get(mButtonTwo);
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

	private void revealButton(int pBtn){
		mView.revealButton(pBtn);
	}
	private void hideButton(int pBtn){
		mView.hideButton(pBtn);
	}
	private void removeButton(int pBtn){
		mView.removeButton(pBtn);
	}
	
	public interface IMemoryGameManagerListener{
		void playCountChanged(int pPlayCount);
		void revealButton(int pIndex);
		void hideButton(int pIndex);
		void removeButton(int pIndex);
	}
}
