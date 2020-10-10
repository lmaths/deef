package com.rightside.deef.client.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rightside.deef.R;
import com.rightside.deef.client.model.Comment;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {

    List<Comment> comments;
    Context context;

    public CommentAdapter(List<Comment> comments, Context context) {
        this.comments = comments;
        this.context = context;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_comment, parent, false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        Comment comment = comments.get(position);

        Glide.with(context).load(comment.getUrlPhoto()).circleCrop().into(holder.imageViewProfilePicture);
        holder.textViewComment.setText(comment.getText());
        holder.textViewName.setText(comment.getName());

    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewProfilePicture;
        private TextView textViewName;
        private TextView textViewComment;

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewProfilePicture = itemView.findViewById(R.id.imageView_profile_picture);
            textViewName = itemView.findViewById(R.id.textView_name);
            textViewComment = itemView.findViewById(R.id.textView_comment);
        }
    }
}
