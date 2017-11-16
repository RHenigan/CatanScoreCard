package com.example.henig.catanscorecard.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.henig.catanscorecard.MainActivity;
import com.example.henig.catanscorecard.Objects.StoreObject;
import com.example.henig.catanscorecard.R;

import java.util.List;

/**
 * Created by henig on 10/26/2017.
 */

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreViewHolder> {

    private List<StoreObject> storeList;
    private ResourceAdapter rescAdapt;
    private final ScoreAdapter scoreAdapt;
    private Context mContext;
    private View mParent;

    public class StoreViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public Button buy;

        public StoreViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.storeTextView);
            buy = (Button) itemView.findViewById(R.id.buyButton);
        }
    }

    public StoreAdapter(List<StoreObject> storeList, ResourceAdapter rescAdapt, ScoreAdapter scoreAdapt, Context context, View view) {
        this.storeList = storeList;
        this.rescAdapt = rescAdapt;
        this.scoreAdapt = scoreAdapt;
        this.mContext = context;
        this.mParent = view;
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
                boolean check = store.purchaseObj();
                notifyDataSetChanged();

                if (store.getName() == "Development Card") {
                    if (check) {
                        LayoutInflater inflater = LayoutInflater.from(mContext);
                        View popUpView = inflater.inflate(R.layout.card_bought_popup, null);

                        final PopupWindow mPopUpWindow = new PopupWindow(popUpView,
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT);

                        popUpView.setBackgroundColor(Color.WHITE);

                        Button knightButton = (Button) popUpView.findViewById(R.id.knightButton);
                        Button vpButton = (Button) popUpView.findViewById(R.id.vpButton);
                        Button roadButton = (Button) popUpView.findViewById(R.id.roadButton);
                        Button yearButton = (Button) popUpView.findViewById(R.id.yearsButton);

                        knightButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mPopUpWindow.dismiss();
                            }
                        });

                        vpButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mPopUpWindow.dismiss();
                            }
                        });

                        roadButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mPopUpWindow.dismiss();
                            }
                        });

                        yearButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mPopUpWindow.dismiss();
                            }
                        });

                        mPopUpWindow.showAtLocation(mParent, Gravity.CENTER, 0, 0);
                    }
                }

                rescAdapt.notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return storeList.size();
    }
}
