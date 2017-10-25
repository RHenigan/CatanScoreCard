package com.example.henig.catanscorecard;

import android.support.v7.widget.RecyclerView;
import android.test.suitebuilder.TestMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by henig on 10/20/2017.
 */

public class ResourceAdapter extends RecyclerView.Adapter<ResourceAdapter.ResourceViewHolder> {

    private List<ResourceObject> rescourceList;

    public class ResourceViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView count;
        public ImageView inc;
        public ImageView dec;

        public ResourceViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.resourceTextView);
            count = (TextView) itemView.findViewById(R.id.rescCountTextView);
            inc = (ImageView) itemView.findViewById(R.id.rescUpImageView);
            dec = (ImageView) itemView.findViewById(R.id.rescDownImageView);
        }
    }

    public ResourceAdapter(List<ResourceObject> resourceList) {
        this.rescourceList = resourceList;
    }

    @Override
    public ResourceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.resource_layout, parent, false);
        return new ResourceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ResourceViewHolder holder, int position) {
        final ResourceObject resource = rescourceList.get(position);
        holder.name.setText(resource.getResourceName());
        holder.count.setText(resource.getResourceCount() + "");
        holder.inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resource.incResourceCount();
                notifyDataSetChanged();
            }
        });
        holder.dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resource.decResourceCount();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return rescourceList.size();
    }
}
