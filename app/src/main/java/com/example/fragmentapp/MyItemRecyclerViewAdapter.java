package com.example.fragmentapp;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragmentapp.placeholder.PlaceholderContent;
import com.example.fragmentapp.placeholder.PlaceholderContent.PlaceholderVersion;
import com.example.fragmentapp.databinding.FragmentItemBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderVersion}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<PlaceholderVersion> mValues;
    private final OnTouchListener<PlaceholderVersion> mListener;

    public MyItemRecyclerViewAdapter(List<PlaceholderContent.PlaceholderVersion> items, ItemFragment listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        FragmentItemBinding binding = FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding, mListener);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).getName());
        holder.mVersion.setText(mValues.get(position).getVersionNumber());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView mContentView;
        public final TextView mVersion;
        public PlaceholderVersion mItem;
        private OnTouchListener<PlaceholderVersion> mListener;

        public ViewHolder(FragmentItemBinding binding, OnTouchListener<PlaceholderVersion> listener) {
            super(binding.getRoot());
            mContentView = binding.content;
            mVersion = binding.version;
            mListener = listener;
            binding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onClick(mItem);
        }
    }
}