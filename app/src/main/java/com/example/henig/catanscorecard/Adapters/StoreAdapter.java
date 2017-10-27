package com.example.henig.catanscorecard.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.henig.catanscorecard.Objects.StoreObject;
import com.example.henig.catanscorecard.R;

import java.util.List;

/**
 * Created by henig on 10/26/2017.
 */

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreViewHolder> {

    private List<StoreObject> storeList;
    private ResourceAdapter rescAdapt;

    public class StoreViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public Button buy;

        public StoreViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.storeTextView);
            buy = (Button) itemView.findViewById(R.id.buyButton);
        }
    }

    public StoreAdapter(List<StoreObject> storeList, ResourceAdapter rescAdapt) {
        this.storeList = storeList;
        this.rescAdapt = rescAdapt;
    }

    @Override
    public StoreAdapter.StoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_layout, parent, false);
        return new StoreViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StoreAdapter.StoreViewHolder holder, int position) {
        final StoreObject store = storeList.get(position);
        holder.name.setText(store.getName());
        holder.buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store.purchaseObj();
                notifyDataSetChanged();
                rescAdapt.notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return storeList.size();
    }
}
