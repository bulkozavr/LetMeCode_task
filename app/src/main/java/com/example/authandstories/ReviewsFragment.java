package com.example.authandstories;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ReviewsFragment extends Fragment {

    ArrayList<Article> articles = new ArrayList<Article>();

    public ReviewsFragment() {
    // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // create object of MyAsyncTasks class and execute it
        MyAsyncTasks myAsyncTasks = new MyAsyncTasks();
        myAsyncTasks.execute();
        setInitialData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reviews, container, false);

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.list);
        // создаем адаптер
        ArticleAdapter adapter = new ArticleAdapter(getActivity(), articles);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void setInitialData(){
        articles.add(new Article ("Бразилия", "Бразилиа", 1));
        articles.add(new Article ("Аргентина", "Буэнос-Айрес", 2));
        articles.add(new Article ("Колумбия", "Богота", 3));
        articles.add(new Article ("Уругвай", "Монтевидео", 4));
        articles.add(new Article ("Чили", "Сантьяго", 5));
    }
}