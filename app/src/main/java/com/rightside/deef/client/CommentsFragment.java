package com.rightside.deef.client;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rightside.deef.R;
import com.rightside.deef.client.adapter.CommentAdapter;
import com.rightside.deef.client.model.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentsFragment extends Fragment {

    private List<Comment> comments = new ArrayList<>();
    private CommentAdapter adapter;
    private RecyclerView recyclerView;

    public static CommentsFragment newInstance() {
        CommentsFragment fragment = new CommentsFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comments, container, false);

        recyclerView = view.findViewById(R.id.recyclerView_comments);

        Comment c1 = new Comment("Ivan Viana", "Muito bom bom mesmo genial muit bom top nota 10", "https://scontent.fitp1-1.fna.fbcdn.net/v/t1.0-9/62599874_1347423122074936_8018115376493625344_n.jpg?_nc_cat=101&_nc_sid=09cbfe&_nc_ohc=wK_jGY8FwKgAX-AHCHO&_nc_ht=scontent.fitp1-1.fna&oh=7f20f88c886e355cd32c17499f912a10&oe=5FA5D514");
        comments.add(c1);
        comments.add(c1);
        comments.add(c1);
        comments.add(c1);
        comments.add(c1);
        comments.add(c1);

        adapter = new CommentAdapter(comments, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}