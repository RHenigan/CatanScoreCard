package com.example.henig.catanscorecard;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.henig.catanscorecard.Adapters.ResourceAdapter;
import com.example.henig.catanscorecard.Adapters.ScoreAdapter;
import com.example.henig.catanscorecard.Adapters.StoreAdapter;
import com.example.henig.catanscorecard.Objects.ResourceObject;
import com.example.henig.catanscorecard.Objects.ScoreObject;
import com.example.henig.catanscorecard.Objects.ScoreTotalObject;
import com.example.henig.catanscorecard.Objects.StoreObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView scoreTextView;
    private TabHost tabHost;
    private RecyclerView mResourceRecyclerView;
    private RecyclerView mScoreRecyclerView;
    private RecyclerView mStoreRecyclerView;
    private ResourceAdapter mResourceAdapter;
    private RecyclerView.Adapter mScoreAdapter;
    private RecyclerView.Adapter mStoreAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<ResourceObject> resourceList = new ArrayList<>();
    private List<StoreObject> storeList = new ArrayList<>();
    private List<ScoreObject> scoreList = new ArrayList<>();
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this.getApplicationContext();

        ScoreTotalObject score = new ScoreTotalObject();
        score.setVictoryPoints();

        scoreTextView = (TextView) findViewById(R.id.vpScoreTextView);
        scoreTextView.setText(score.getVictoryPoints() + "");

        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        //Tab1
        TabHost.TabSpec spec = tabHost.newTabSpec("Score");
        spec.setContent(R.id.scoreTab);
        spec.setIndicator("Score");
        tabHost.addTab(spec);

        //Tab2
        spec = tabHost.newTabSpec("Resources");
        spec.setContent(R.id.resourceTab);
        spec.setIndicator("Resources");
        tabHost.addTab(spec);

        //Tab3
        spec = tabHost.newTabSpec("Store");
        spec.setContent(R.id.storeTab);
        spec.setIndicator("Store");
        tabHost.addTab(spec);

        mResourceRecyclerView = (RecyclerView) findViewById(R.id.resourceRecyclerView);
        mScoreRecyclerView = (RecyclerView) findViewById(R.id.scoreRecyclerView);
        mStoreRecyclerView = (RecyclerView) findViewById(R.id.storeRecyclerView);

        mResourceAdapter = new ResourceAdapter(resourceList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mResourceRecyclerView.setLayoutManager(mLayoutManager);
        mResourceRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mResourceRecyclerView.setAdapter(mResourceAdapter);

        mScoreAdapter = new ScoreAdapter(scoreList);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mScoreRecyclerView.setLayoutManager(mLayoutManager);
        mScoreRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mScoreRecyclerView.setAdapter(mScoreAdapter);

        mStoreAdapter = new StoreAdapter(storeList, mResourceAdapter,(ScoreAdapter) mScoreAdapter, mContext, findViewById(R.id.main_root));
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mStoreRecyclerView.setLayoutManager(mLayoutManager);
        mStoreRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mStoreRecyclerView.setAdapter(mStoreAdapter);


        prepare();
    }

    private void prepare() {
        ResourceObject resource = new ResourceObject("Wood");
        resourceList.add(resource);
        resource = new ResourceObject("Stone");
        resourceList.add(resource);
        resource = new ResourceObject("Crop");
        resourceList.add(resource);
        resource = new ResourceObject("Live Stock");
        resourceList.add(resource);
        resource = new ResourceObject("Brick");
        resourceList.add(resource);
        ScoreObject score = new ScoreObject("Road", 2, 0);
        scoreList.add(score);
        score = new ScoreObject("Settlement", 2, 2);
        scoreList.add(score);
        score = new ScoreObject("City", 0, 0);
        scoreList.add(score);
        score = new ScoreObject("Soldiers", 0, 0);
        scoreList.add(score);
        score = new ScoreObject("Dev Card", 0, 0);
        scoreList.add(score);
        StoreObject store = new StoreObject(this, "Road", new ResourceObject[] {resourceList.get(4), resourceList.get(0)}, new int[] {1, 1});
        storeList.add(store);
        store = new StoreObject(this, "Settlement", new ResourceObject[] {resourceList.get(4), resourceList.get(0), resourceList.get(2), resourceList.get(3)}, new int[] {1, 1, 1, 1});
        storeList.add(store);
        store = new StoreObject(this, "City", new ResourceObject[] {resourceList.get(2), resourceList.get(1)}, new int[] {2, 3});
        storeList.add(store);
        store = new StoreObject(this, "Development Card", new ResourceObject[] {resourceList.get(3), resourceList.get(2), resourceList.get(1)}, new int[] {1, 1, 1});
        storeList.add(store);

        mResourceAdapter.notifyDataSetChanged();
        mStoreAdapter.notifyDataSetChanged();
        mScoreAdapter.notifyDataSetChanged();
    }
}
