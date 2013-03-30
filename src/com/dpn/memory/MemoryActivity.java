package com.dpn.memory;

import java.util.ArrayList;
import java.util.List;

import com.dpn.memory.MemoryGameManager.IMemoryGameManagerListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

public class MemoryActivity extends Activity implements IMemoryGameManagerListener {
    /** Called when the activity is first created. */
	
	List<MemoryButton<ELetters>> mButtons;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        startNewGame(4,4);
    }
    
    private void populateGrid(){
    	GridView gridView = (GridView)this.findViewById(R.id.gridView1);
    	gridView.setNumColumns(mManager.getNumColumns());
    	gridView.setVerticalSpacing(5);
    	gridView.setHorizontalSpacing(5);
    	
    	
    	mButtons = new ArrayList<MemoryButton<ELetters>>();
    	for(int i=0; i<mManager.getNumberOfItems(); i++){
    		mButtons.add(new MemoryButton<ELetters>(this, i, mManager));
    	}
    	
    	gridView.setAdapter(new TextAdapter(mButtons));
    }
    
    public void button_onClick(View view) {
		int buttonID = view.getId();
		
		
		switch (buttonID){
		case R.id.fourByFour:
			startNewGame(4,4);
			break;
		case R.id.fourByFive:
			startNewGame(4,5);
			break;
		case R.id.fiveBySix:
			startNewGame(5,6);
			break;
		case R.id.sixBySix:
			startNewGame(6,6);
			break;
		}
		
	}
    private void startNewGame(int pCols, int pRows) {
    	playCountChanged(0);
    	mManager = new MemoryGameManager<ELetters>(pCols, pRows,ELetters.getRandomList(pCols*pRows), this);
    	populateGrid();
	}
	
	private MemoryGameManager<ELetters> mManager;
	
	@Override
	public void playCountChanged(int pPlayCount) {
		TextView playCounter = (TextView)this.findViewById(R.id.playCounter);
		playCounter.setText("Play Count: " + Integer.toString(pPlayCount));
	}

	@Override
	public void revealButton(int pIndex) {
		mButtons.get(pIndex).revealButton();
	}

	@Override
	public void hideButton(int pIndex) {
		mButtons.get(pIndex).hideButton();
	}

	@Override
	public void removeButton(int pIndex) {
		mButtons.get(pIndex).removeButton();
	}
}