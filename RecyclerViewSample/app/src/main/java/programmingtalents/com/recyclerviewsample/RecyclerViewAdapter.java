package programmingtalents.com.recyclerviewsample;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Amit on 04-11-2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<String> mList;


    public RecyclerViewAdapter(Context context, ArrayList<String> mItemList) {
        mContext=context;
        mList=mItemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.row,null);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.lItemText.setText(mList.get(position));
        holder.lItemText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                Snackbar.make(v,mList.get(position),Snackbar.LENGTH_SHORT).setAction("Retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(mContext,Main2Activity.class);
                        mContext.startActivity(intent);
                    }
                }).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView lItemText;
        public ImageView lItemImage;
        public ViewHolder(View itemView) {
            super(itemView);
            lItemImage= (ImageView) itemView.findViewById(R.id.itemImage);
            lItemText= (TextView) itemView.findViewById(R.id.itemText);
        }
    }
}
