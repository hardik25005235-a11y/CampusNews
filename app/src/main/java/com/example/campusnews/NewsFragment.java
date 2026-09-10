package com.example.campusnews;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NewsFragment extends Fragment {

    private String category;

    public NewsFragment(String category) {
        this.category = category;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(
                R.layout.fragment_news,
                container,
                false
        );

        TextView categoryTitle =
                view.findViewById(R.id.categoryTitle);

        TextView newsTitle =
                view.findViewById(R.id.newsTitle);

        TextView newsDescription =
                view.findViewById(R.id.newsDescription);

        Button readMoreButton =
                view.findViewById(R.id.readMoreButton);

        categoryTitle.setText(category);

        if (category.equals("Academic")) {

            newsTitle.setText("Semester Examination Update");

            newsDescription.setText(
                    "Important information regarding upcoming semester examinations."
            );

        } else if (category.equals("Events")) {

            newsTitle.setText("Annual College Fest");

            newsDescription.setText(
                    "The annual college fest will be conducted with various activities and competitions."
            );

        } else if (category.equals("Placements")) {

            newsTitle.setText("Campus Placement Drive");

            newsDescription.setText(
                    "A new campus placement drive is being conducted for eligible students."
            );
        }

        readMoreButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    getActivity(),
                    ArticleActivity.class
            );

            intent.putExtra(
                    "category",
                    category
            );

            intent.putExtra(
                    "title",
                    newsTitle.getText().toString()
            );

            startActivity(intent);
        });

        return view;
    }
}
