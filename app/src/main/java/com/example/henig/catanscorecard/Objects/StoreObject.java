package com.example.henig.catanscorecard.Objects;

import android.content.Context;
import android.widget.Toast;

import com.example.henig.catanscorecard.Adapters.ResourceAdapter;

/**
 * Created by henig on 10/25/2017.
 */

public class StoreObject {
    private String storeName = "";
    private ResourceObject[] resc;
    private int[] rescCount;
    private Context context;

    public StoreObject(Context context, String name, ResourceObject[] rList, int[] countList) {
        storeName = name;
        resc = rList;
        rescCount = countList;
        this.context = context;
    }

    public boolean purchaseObj() {
        int i = 0;
        boolean rescCheck = true;
        for (ResourceObject r : resc) {
            if(r.getResourceCount() < rescCount[i]) {
                rescCheck = false;
                Toast.makeText(this.context, "You Need More Resources!", Toast.LENGTH_SHORT).show();
                return false;
            }
            i++;
        }
        i=0;
        if (rescCheck) {
            for (ResourceObject r : resc) {
                for (int j = 0; j < rescCount[i]; j++) {
                    r.decResourceCount();
                }
                i++;
            }
        }
        return true;
    }

    public String getName() {
        return storeName;
    }

}
