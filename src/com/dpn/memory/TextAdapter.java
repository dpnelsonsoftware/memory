package com.dpn.memory;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class TextAdapter extends BaseAdapter {
    private List<MemoryButton<ELetters>> mButtons;

    public TextAdapter(List<MemoryButton<ELetters>> pButtons) {
        mButtons = pButtons;
    }

    @Override
    public int getCount() {
        return mButtons.size();
    }

    @Override
    public Object getItem(int position) {
        return mButtons.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	
        return mButtons.get(position);
    }
}