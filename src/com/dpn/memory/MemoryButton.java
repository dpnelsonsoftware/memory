package com.dpn.memory;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewAnimator;

public class MemoryButton<T> extends ViewAnimator {

	private final int mPosition;
	private final MemoryGameManager<T> mManager;
	private final Button mHiddenButton;
	private final Button mResultButton;
	
	public MemoryButton(Context context, int pPosition, T pItem, MemoryGameManager<T> pGameManager) {
		super(context);
		mPosition = pPosition;
		mManager = pGameManager;
		setInAnimation( AnimationUtils.loadAnimation(context, R.anim.flip_from_side));
		setOutAnimation(AnimationUtils.loadAnimation(context, R.anim.flip_to_side));
		
		mHiddenButton = new Button(context);
		mHiddenButton.setText("?");
		mHiddenButton.setTextColor(Color.LTGRAY);
		mHiddenButton.setTextSize(32);
		mHiddenButton.setBackgroundColor(Color.BLUE);
		mHiddenButton.setPadding(0, mHiddenButton.getPaddingTop()-10, 0,mHiddenButton.getPaddingBottom()-10);
		mHiddenButton.setBackgroundResource(R.drawable.button_shape);
		mHiddenButton.setOnClickListener(new ButtonPressed());
		 mResultButton = new Button(context);
		mResultButton.setText(pItem.toString());
		mResultButton.setTextColor(Color.LTGRAY);
		mResultButton.setTextSize(32);
		mResultButton.setBackgroundColor(Color.BLUE);
		mResultButton.setPadding(0, mResultButton.getPaddingTop()-10, 0,mResultButton.getPaddingBottom()-10);
        mResultButton.setBackgroundResource(R.drawable.button_shape);
		addView(mHiddenButton);
		addView(mResultButton);
	}
	public int getPosition() {
		return mPosition;
	}
	
	public void revealButton(){
		setDisplayedChild(1);
	}
	public void hideButton(){
		setDisplayedChild(0);
	}
	public void removeButton(){
		mHiddenButton.setBackgroundColor(Color.BLACK);
		mHiddenButton.setText("");
		mHiddenButton.setClickable(false);
		
		mResultButton.setBackgroundColor(Color.BLACK);
		mResultButton.setText("");
	}
    private class ButtonPressed implements OnClickListener{
    	
		@Override
		public void onClick(View v) {
			System.out.println("BUTTON PRESSED");
			mManager.buttonPressed(MemoryButton.this);
		}
    }
    
}
