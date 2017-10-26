package com.example.henig.catanscorecard;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by henig on 10/25/2017.
 */

public class storeObject {
    private String storeName = "";
    private ResourceObject[] resc;
    private int[] rescCount;
    private Context context;

    public storeObject(Context context, String name, ResourceObject[] rList, int[] countList) {
        storeName = name;
        resc = rList;
        rescCount = countList;
        this.context = context;
    }

    public void purchaseObj() {
        int i = 0;
        for (ResourceObject r : resc) {
            if(r.getResourceCount() >= rescCount[i]) {
                for(int j = 0; j < rescCount[i]; j++) {
                    r.decResourceCount();
                }
            }else {
                Toast.makeText(this.context, "You Need More Resources!", Toast.LENGTH_LONG).show();
            }
            i++;
        }
    }

}
