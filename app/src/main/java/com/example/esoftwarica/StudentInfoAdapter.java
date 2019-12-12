package com.example.esoftwarica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentInfoAdapter extends RecyclerView.Adapter<StudentInfoAdapter.UserInfoViewHolder>  {

    Context mContext;
    List<StudentInfo> studentInfoList;

    public StudentInfoAdapter(List<StudentInfo> studentInfoList) {
        this.studentInfoList = studentInfoList;
    }

    @NonNull
    @Override
    public UserInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.users_layout,parent,false);
        return new UserInfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final UserInfoViewHolder holder, final int position) {
        final StudentInfo studentInfo = studentInfoList.get(position);
        holder.imgProfile.setImageResource(studentInfo.getImageId());
        holder.tvName.setText(studentInfo.getName());
        holder.tvAge.setText(studentInfo.getAge());
        holder.tvLocation.setText(studentInfo.getLocation());
        holder.tvGender.setText(studentInfo.getGender());

        holder.imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Hello this is: " + holder.tvName.getText().toString() , Toast.LENGTH_SHORT).show();
            }
        });

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentInfoList.remove(studentInfo);

                notifyItemRemoved(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return studentInfoList.size();
    }

    public class UserInfoViewHolder extends RecyclerView.ViewHolder{
        ImageView imgProfile,imgDelete;
        TextView tvName, tvAge, tvLocation, tvGender;
        public UserInfoViewHolder(@NonNull View itemView){

            super(itemView);
            imgProfile = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.textView);
            tvAge = itemView.findViewById(R.id.textView2);
            tvLocation = itemView.findViewById(R.id.textView3);
            tvGender = itemView.findViewById(R.id.textView4);
            imgDelete = itemView.findViewById(R.id.imageView2);
        }
    }

}
