package com.dpn.memory;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class TextAdapter extends BaseAdapter {
    private Context mContext;
    private MemoryGameManager<?> mManager;

    public TextAdapter(Context c, MemoryGameManager<ELetters> pManager) {
        mContext = c;
        mManager = pManager;
    }

    @Override
    public int getCount() {
        return mManager.getNumberOfItems();
    }

    public Object getItem(int position) {
        return mManager.getItemAtPosition(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	
    	MemoryButton<ELetters> btn;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
        	btn = new MemoryButton(mContext,position, mManager.getItemAtPosition(position), mManager);
        } else {
        	btn = (MemoryButton) convertView;
        }
        System.out.println("Returning View "+position);
        return btn;
    }
}