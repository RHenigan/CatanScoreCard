package com.example.henig.catanscorecard;

/**
 * Created by henig on 10/19/2017.
 */

public class ResourceObject {

    private String resourceName = "";
    private int resourceCount = 0;

    ResourceObject(String name) {
        this.resourceName = name;
    }

    public String getResourceName() {
        return resourceName;
    }

    public int getResourceCount() {
        return resourceCount;
    }

    public void incResourceCount() {
        this.resourceCount++;
    }

    public void decResourceCount() {
        if(this.resourceCount > 0) {
            this.resourceCount--;
        }else {
            this.resourceCount = 0;
        }
    }
}
