package com.example.project8;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

     private Context context;
     private List<DataClass>dataList;

     public void setSearchList(List<DataClass>dataSearchList){
         this.dataList = dataSearchList;
         notifyDataSetChanged();
     }
     public MyAdapter(Context context,List<DataClass>dataList){
         this.context = context;
         this.dataList = dataList;

     }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bloodrecycler_item,parent,false);
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_eyerecycler_item,parent,false);
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.skinrecyclerview_item,parent,false);
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.organrecyclerview_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
         holder.recImage.setImageResource(dataList.get(position).getDataImage());
        holder.recTittle.setText(dataList.get(position).getDataTitle());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,kaminenihospitalsprivatelimitedbloodbank.class);
                intent.putExtra("Image",dataList.get(holder.getAdapterPosition()).getDataImage());
                intent.putExtra("Title",dataList.get(holder.getAdapterPosition()).getDataTitle());
                intent.putExtra("Desc",dataList.get(holder.getAdapterPosition()).getDataDesc());

                context.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
 class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView recImage;
    TextView recTittle;
    CardView recCard;


     public MyViewHolder(@NonNull View itemView) {
         super(itemView);

         recImage = itemView.findViewById(R.id.recImage);
         recTittle = itemView.findViewById(R.id.recTitle);
         recCard= itemView.findViewById(R.id.recCard);
     }
 }