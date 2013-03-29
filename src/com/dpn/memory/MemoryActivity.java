package com.dpn.memory;

import com.dpn.memory.MemoryGameManager.IMemoryGameManagerListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

public class MemoryActivity extends Activity implements IMemoryGameManagerListener {
    /** Called when the activity is first created. */
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
    	gridView.setAdapter(new TextAdapter(this, mManager));
    	
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
}