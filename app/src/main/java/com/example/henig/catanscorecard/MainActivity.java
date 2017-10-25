package com.example.henig.catanscorecard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView scoreTextView;
    private TabHost tabHost;
    private RecyclerView mResourceRecyclerView;
    private RecyclerView mScoreRecyclerView;
    private RecyclerView mStoreRecyclerView;
    private RecyclerView.Adapter mResourceAdapter;
    private RecyclerView.Adapter mScoreAdapter;
    private RecyclerView.Adapter mStoreAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<ResourceObject> resourceList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ScoreObject score = new ScoreObject();
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
        spec.setContent(R.id.resourceTab);
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

        prepareResources();
    }

    private void prepareResources() {
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
        mResourceAdapter.notifyDataSetChanged();
    }
}
