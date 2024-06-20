package com.example.authandstories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<Article> articles;

    ArticleAdapter(FragmentActivity context, List<Article> articles) {
        this.articles = articles;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleAdapter.ViewHolder holder, int position) {
        Article state = articles.get(position);
        //holder.flagView.setImageResource(state.getFlagResource());
        holder.captionView.setText(state.getTitle());
        holder.textView.setText(state.getText());
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //final ImageView flagView;
        final TextView captionView, textView;
        ViewHolder(View view){
            super(view);
            //flagView = view.findViewById(R.id.flag);
            captionView = view.findViewById(R.id.caption);
            textView = view.findViewById(R.id.text);
        }
    }
}
