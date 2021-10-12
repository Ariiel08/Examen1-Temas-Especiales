package com.example.fragmentapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.example.fragmentapp.placeholder.PlaceholderContent;

public class ItemDetailFragment extends Fragment {

    private PlaceholderContent.PlaceholderVersion element;
    public ItemDetailFragment(){}
    public static ItemDetailFragment newInstance(PlaceholderContent.PlaceholderVersion element) {
        ItemDetailFragment fragment = new ItemDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable("element", element);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            element = (PlaceholderContent.PlaceholderVersion) getArguments().getSerializable("element");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_detail, container, false);

        TextView details = view.findViewById(R.id.details);
        TextView name = view.findViewById(R.id.tvName);
        TextView version = view.findViewById(R.id.tvVersion);
        TextView releaseDate = view.findViewById(R.id.tvReleaseDate);
        TextView supported = view.findViewById(R.id.tvSupported);
        TextView internalCode = view.findViewById(R.id.tvInternalCode);

        details.setText(element.getDetails());
        name.setText("Name: "+element.getName());
        version.setText("Version: "+element.getVersionNumber());
        internalCode.setText("Internal Code: "+element.getInternalCodeName());

        Button btnLink = view.findViewById(R.id.button);

        btnLink.setOnClickListener(v -> {
            Uri uri = Uri.parse(element.getLink());
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        return view;
    }
}
