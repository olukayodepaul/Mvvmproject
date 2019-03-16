package com.leventisfoods.paul.mvvmproject.model.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leventisfoods.paul.mvvmproject.R;
import com.leventisfoods.paul.mvvmproject.model.dbtables.Register;

import java.util.List;

public class NoteAdapers extends RecyclerView.Adapter<NoteAdapers.ContentHoder> {

    private Context context;
    List<Register> registerList;

    public NoteAdapers(Context context) {
        this.context = context;
    }

    @Override
    public ContentHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);
        return new ContentHoder(view);
    }

    @Override
    public void onBindViewHolder(ContentHoder holder, int position) {

        if(registerList != null){
            Register rs = registerList.get(position);
            holder.mContent.setText(rs.getFirstname()+" "+rs.getId());
        }
    }

    @Override
    public int getItemCount() {
        if(registerList!=null){
            return registerList.size();
        }else{
            return 0;
        }
    }

    public void SetNotes(List<Register> notes) {
        registerList = notes;
        notifyDataSetChanged();
    }

    class ContentHoder extends RecyclerView.ViewHolder {

        private TextView mContent;
        private int mPosition;

        public ContentHoder(View itemView) {
            super(itemView);
            mContent = itemView.findViewById(R.id.content);
        }
    }

}
