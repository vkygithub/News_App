package com.example.newsapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.PojoFile.ArticlesListResponse;
import com.example.newsapp.R;
import com.example.newsapp.Web_View;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class ArticlesListAdapter extends RecyclerView.Adapter<ArticlesListAdapter.mine> {
    private Context context;
    private List<ArticlesListResponse.ArticlesList> ArticleList;
    private boolean check = false;

    public ArticlesListAdapter(Context context, List<ArticlesListResponse.ArticlesList> ArticleList) {
        this.context = context;
        this.ArticleList = ArticleList;
    }

    @NonNull
    @Override
    public ArticlesListAdapter.mine onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_news, parent, false);
        return new mine(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticlesListAdapter.mine holder, int position) {
        String articleimage = ArticleList.get(position).getImage_url();
        String currentItem = ArticleList.get(position).getSummary();

        holder.article_title.setText(ArticleList.get(position).getTitle());
        holder.article_published.setText(changeDateFormatFromAnother(ArticleList.get(position).getPublished_at().substring(0, 10)) + changeTimeFormatFromAnother(ArticleList.get(position).getPublished_at().substring(11, ArticleList.get(position).getPublished_at().length())));
        holder.article_source.setText(currentItem);
        holder.article_url.setText(ArticleList.get(position).getNews_site());
        holder.article_website.setText(ArticleList.get(position).getUrl());

        holder.itemView.setOnClickListener(v -> {
            check = true;
            Intent intent = new Intent(context, Web_View.class).putExtra("website", ArticleList.get(position).getUrl());
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });

        check = false;

        if (holder.article_source.getLineCount() > 3) {
            holder.Read_more.setVisibility(View.VISIBLE);
            holder.Read_more.setOnClickListener(v -> holder.article_source.setMaxLines(Integer.MAX_VALUE));
        } else {
            holder.Read_more.setVisibility(View.GONE);
        }

        Glide.with(context)
                .load(articleimage)
                .into(holder.article_image_view);
    }

    @Override
    public int getItemCount() {
        return ArticleList.size();
    }

    public static class mine extends RecyclerView.ViewHolder {
        TextView article_title, article_source, article_url, Read_more, article_published, article_website;
        ImageView article_image_view;

        public mine(@NonNull View itemView) {
            super(itemView);
            article_title = itemView.findViewById(R.id.article_title);
            article_image_view = itemView.findViewById(R.id.article_image_view);
            article_source = itemView.findViewById(R.id.article_source);
            article_url = itemView.findViewById(R.id.article_url);
            Read_more = itemView.findViewById(R.id.Read_more);
            article_published = itemView.findViewById(R.id.article_published);
            article_website = itemView.findViewById(R.id.article_website);
        }
    }

    private String changeDateFormatFromAnother(String date) {
        DateFormat inputFormat = new SimpleDateFormat("yyy-MMM-dd");
        DateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        String resultDate = "";
        try {
            resultDate = outputFormat.format(inputFormat.parse(date));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultDate;
    }

    private String changeTimeFormatFromAnother(String date) {
        DateFormat inputFormat = new SimpleDateFormat("HH:mm");
        DateFormat outputFormat = new SimpleDateFormat("hh:mm a");
        String resultDate = "";
        try {
            resultDate = outputFormat.format(inputFormat.parse(date));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultDate;
    }
}