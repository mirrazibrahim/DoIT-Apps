package com.mirrazdev.doit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mirrazdev.doit.R;
import com.mirrazdev.doit.database.entitas.Todo;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewAdapter> {
    private List<Todo> list;
    private Context context;
    private Dialog dialog;

    public interface Dialog{
        void onClick(int position);
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public TodoAdapter(Context context, List<Todo> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_todo, parent, false);
        return new ViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoAdapter.ViewAdapter holder, int position) {
        holder.aktifitas.setText(list.get(position).aktifitas);
        holder.komentar.setText(list.get(position).keterangan);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewAdapter extends RecyclerView.ViewHolder{
        TextView aktifitas, komentar;

        public ViewAdapter(@NonNull View itemView) {
            super(itemView);
            aktifitas = itemView.findViewById(R.id.aktivitas);
            komentar = itemView.findViewById(R.id.komentar);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (dialog!=null){
                        dialog.onClick(getLayoutPosition());
                    }
                }
            });

        }
    }
}
