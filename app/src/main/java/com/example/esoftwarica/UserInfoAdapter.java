package com.example.esoftwarica;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.UserInfoViewHolder>  {

    Context mContext;
    List<UserInfo> userInfoList;


    public UserInfoAdapter(Context mContext, List<UserInfo> userInfoList){
        this.mContext = mContext;
        this.userInfoList = userInfoList;
    }

    @NonNull
    @Override
    public UserInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.users_layout,parent,false);
        return new UserInfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final UserInfoViewHolder holder, int position) {
        final UserInfo userInfo = userInfoList.get(position);
        holder.imgProfile.setImageResource(userInfo.getImageId());
        holder.tvName.setText(userInfo.getName());
        holder.tvAge.setText(userInfo.getAge());
        holder.tvLocation.setText(userInfo.getLocation());
        holder.tvGender.setText(userInfo.getGender());


        holder.imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Hello this is: " + holder.tvName.getText().toString() , Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return userInfoList.size();
    }

    public class UserInfoViewHolder extends RecyclerView.ViewHolder{
        ImageView imgProfile;
        TextView tvName, tvAge, tvLocation, tvGender;
        public UserInfoViewHolder(@NonNull View itemView){

            super(itemView);
            imgProfile = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.textView);
            tvAge = itemView.findViewById(R.id.textView2);
            tvLocation = itemView.findViewById(R.id.textView3);
            tvGender = itemView.findViewById(R.id.textView4);
        }
    }

}
