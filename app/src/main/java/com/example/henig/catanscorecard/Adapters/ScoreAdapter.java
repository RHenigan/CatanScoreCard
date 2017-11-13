package com.example.henig.catanscorecard.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.henig.catanscorecard.Objects.ResourceObject;
import com.example.henig.catanscorecard.Objects.ScoreObject;
import com.example.henig.catanscorecard.R;

import java.util.List;

/**
 * Created by henig on 11/12/2017.
 */

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ScoreViewHolder> {

    private List<ScoreObject> scoreList;

    public class ScoreViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView count;

        public ScoreViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.scoreTitle);
            count = (TextView) itemView.findViewById(R.id.scoreCount);
        }
    }

    public ScoreAdapter(List<ScoreObject> scoreList) {
        this.scoreList = scoreList;
    }

    @Override
    public ScoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.score_layout, parent, false);
        return new ScoreViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ScoreViewHolder holder, int position) {
        final ScoreObject score = scoreList.get(position);
        holder.name.setText(score.getScoreName());
        holder.count.setText(score.getCount() + "");
    }

    @Override
    public int getItemCount() {
        return scoreList.size();
    }
}
