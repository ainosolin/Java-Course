package com.example.viikko9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Callback;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Show> showsList = new ArrayList<Show>();
    ArrayList<String> imgList = new ArrayList<String>();
    Context context;

    public MyAdapter(Context ct, ArrayList arrList, ArrayList arrList2){
        context = ct;
        showsList = arrList;
        imgList = arrList2;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.movieTitle.setText(showsList.get(position).getTitle());
        holder.movieStart.setText(showsList.get(position).getStart());
        holder.movieYear.setText(showsList.get(position).getYear());
        String imgUrl = imgList.get(position);
        Picasso.get().load(imgUrl).into(holder.myIMG);
    }

    @Override
    public int getItemCount() {
        return showsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView movieTitle;
        TextView movieStart;
        TextView movieYear;
        ImageView myIMG;

        public MyViewHolder (@NonNull View itemView){
            super(itemView);
            movieTitle = itemView.findViewById(R.id.titleMovie);
            movieStart = itemView.findViewById(R.id.startTime);
            movieYear = itemView.findViewById(R.id.movieYear);
            myIMG = itemView.findViewById(R.id.imageView);
        }
    }
}
