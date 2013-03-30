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
	private final Button mMatchedButton;
	
	public MemoryButton(Context context, int pPosition, MemoryGameManager<T> pGameManager) {
		super(context);
		mPosition = pPosition;
		mManager = pGameManager;
		setInAnimation(AnimationUtils.loadAnimation(context, R.anim.flip_from_side));
		setOutAnimation(AnimationUtils.loadAnimation(context, R.anim.flip_to_side));
		
		mHiddenButton = new Button(context);
		mHiddenButton.setText("?");
		mHiddenButton.setTextColor(Color.LTGRAY);
		mHiddenButton.setTextSize(32);
		mHiddenButton.setBackgroundColor(Color.BLUE);
		mHiddenButton.setPadding(0, mHiddenButton.getPaddingTop()-10, 0,mHiddenButton.getPaddingBottom()-10);
		mHiddenButton.setBackgroundResource(R.drawable.button_shape);
		mHiddenButton.setOnClickListener(new ButtonPressed());
		addView(mHiddenButton);
		
		mResultButton = new Button(context);
		mResultButton.setText(pGameManager.getItemAtPosition(pPosition).toString());
		mResultButton.setTextColor(Color.LTGRAY);
		mResultButton.setTextSize(32);
		mResultButton.setBackgroundColor(Color.BLUE);
		mResultButton.setPadding(0, mResultButton.getPaddingTop()-10, 0,mResultButton.getPaddingBottom()-10);
        mResultButton.setBackgroundResource(R.drawable.button_shape);
		addView(mResultButton);
		
		mMatchedButton = new Button(context);
		mMatchedButton.setText("");
		mMatchedButton.setTextColor(Color.BLACK);
		mMatchedButton.setTextSize(32);
		mMatchedButton.setBackgroundResource(R.drawable.button_shape);
		mMatchedButton.setBackgroundColor(Color.BLACK);
		mMatchedButton.setPadding(0, mMatchedButton.getPaddingTop()-10, 0,mMatchedButton.getPaddingBottom()-10);
		mMatchedButton.setClickable(false);
		addView(mMatchedButton);
		
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
		setDisplayedChild(2);
	}
    private class ButtonPressed implements OnClickListener{
    	
		@Override
		public void onClick(View v) {
			mManager.buttonPressed(mPosition);
		}
    }
    
}
