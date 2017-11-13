package com.example.henig.catanscorecard.Objects;

/**
 * Created by henig on 11/12/2017.
 */

public class ScoreObject {

    private boolean largest = false;
    private int count = 0;
    private int scoreCount = 0;
    private String scoreName = "";

    public ScoreObject(String name, int count, int scoreCount) {
        this.scoreName=name;
        this.count=count;
        this.scoreCount=scoreCount;
    }

    public boolean isLargest() {
        return largest;
    }

    public int getCount() {
        return count;
    }

    public int getScoreCount() {
        return scoreCount;
    }

    public String getScoreName() {
        return scoreName;
    }

    public void setLargest(boolean largest) {
        this.largest = largest;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setScoreCount(int scoreCount) {
        this.scoreCount = scoreCount;
    }

    public void setScoreName(String scoreName) {
        this.scoreName = scoreName;
    }

    public void incCount() {
        this.count++;
    }
}
