package prjpro.com.daynote.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import prjpro.com.daynote.R;
import prjpro.com.daynote.entity.NoteEty;

/**
 * 日记RecyclerView适配
 * <p/>
 * Created by lsd on 15/6/14.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    List<NoteEty> list;

    public void setData(List<NoteEty> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_note_item, null));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        ViewHolder holder = (RecyclerViewAdapter.ViewHolder) viewHolder;

        NoteEty ety = (NoteEty) getItem(i);
        if(ety != null){
            holder.tv_content.setText(ety.content);
        }
    }


    public Object getItem(int position) {
        return list == null ? null : list.get(position);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_content;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_content = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }
}
