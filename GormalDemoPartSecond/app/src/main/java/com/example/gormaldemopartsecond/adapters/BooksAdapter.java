package com.example.gormaldemopartsecond.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gormaldemopartsecond.R;
import com.example.gormaldemopartsecond.models.AvailableBookResultModel;

import java.io.IOException;
import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.customViewHolder> {

    Context context;
    ArrayList<AvailableBookResultModel> bookResultModelArrayList;

    public BooksAdapter(Context context,ArrayList<AvailableBookResultModel> bookResultModelArrayList){
        this.context = context;
        this.bookResultModelArrayList = bookResultModelArrayList;
    }

    @NonNull
    @Override
    public BooksAdapter.customViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_book_list_layout, parent, false);
        return new customViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksAdapter.customViewHolder holder, int position) {
        try{
            Glide
                    .with(context)
                    .load(bookResultModelArrayList.get(position).getBookImgUrl())
                    .into(holder.ivBookImage);
            holder.tvBookTitle.setText(bookResultModelArrayList.get(position).getBookName());
            holder.tvBookDesc.setText(bookResultModelArrayList.get(position).getBookDesc());
            holder.tvBookAuthor.setText(bookResultModelArrayList.get(position).getBookAuthor());
            holder.tvBookPrice.setText(bookResultModelArrayList.get(position).getBookPrice());

        }catch (Exception ex){
            try {
                throw new IOException(ex.toString());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public int getItemCount() {
        return bookResultModelArrayList.size();
    }

    public class customViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivBookImage;
        private TextView tvBookTitle;
        private TextView tvBookAuthor;
        private TextView tvBookDesc;
        private TextView tvBookPrice;

        public customViewHolder(@NonNull View itemView) {
            super(itemView);
            ivBookImage = itemView.findViewById(R.id.iv_bookImage);
            tvBookTitle = itemView.findViewById(R.id.tv_bookTitle);
            tvBookDesc = itemView.findViewById(R.id.tv_bookDesc);
            tvBookPrice = itemView.findViewById(R.id.tv_bookPrice);
            tvBookAuthor = itemView.findViewById(R.id.tv_bookAuthor);

        }
    }
}
