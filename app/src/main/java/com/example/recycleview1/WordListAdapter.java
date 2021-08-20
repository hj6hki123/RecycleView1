package com.example.recycleview1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>
{

    private final LinkedList<HashMap<String,String>> mWordList;
    private LayoutInflater mInflater;

    class WordViewHolder extends RecyclerView.ViewHolder
    {
        private TextView title;
        public WordViewHolder(View itemView, WordListAdapter adapter)
        {
            super(itemView);
            title=itemView.findViewById(R.id.title);
        }
    }


    public WordListAdapter(Context context,
                           LinkedList<HashMap<String,String>> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }



    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
        View mItemView = mInflater.inflate(R.layout.recycle_item,
                parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        holder.title.setText(mWordList.get(position).get("title"));
    }




}

