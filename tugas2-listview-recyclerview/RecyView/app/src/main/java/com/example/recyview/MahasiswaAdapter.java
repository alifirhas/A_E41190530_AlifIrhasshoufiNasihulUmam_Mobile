package com.example.recyview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder> {


    private ArrayList<Mahasiswa> datalist;

    public MahasiswaAdapter(ArrayList<Mahasiswa> datalist){
        this.datalist = datalist;
    }


    @NonNull
    @Override
    public MahasiswaAdapter.MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_list_item, parent, false);
        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaAdapter.MahasiswaViewHolder holder, int position) {
        holder.textNama.setText(datalist.get(position).getNama());
        holder.textNpm.setText(datalist.get(position).getNpm());
        holder.textNoHp.setText(datalist.get(position).getNohp());
    }

    @Override
    public int getItemCount() {

        return (datalist != null) ? datalist.size() : 0;
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder{
        private TextView textNama, textNpm, textNoHp;

        public MahasiswaViewHolder(@NonNull View itemView) {
            super(itemView);
            textNama = (TextView) itemView.findViewById(R.id.txt_nama_mahasiswa);
            textNoHp = (TextView) itemView.findViewById(R.id.txt_nohp_mahasiswa);
            textNpm = (TextView) itemView.findViewById(R.id.txt_npm_mahasiswa);
        }

    }
}
