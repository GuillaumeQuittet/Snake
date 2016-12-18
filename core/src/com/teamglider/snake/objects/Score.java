package com.teamglider.snake.objects;

/**
 * Score class
 * Created by Guillaume Quittet on 14/12/16.
 */
public class Score {

    private int score;
    private int increaseValue;

    private int initIncreaseValue;

    public Score(int score, int increaseValue) {
        this.score = score;
        this.increaseValue = increaseValue;
        initIncreaseValue = increaseValue;
    }

    public Score(int increaseValue) {
        this.score = 0;
        this.increaseValue = increaseValue;
        initIncreaseValue = increaseValue;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    void increaseScore(int x) {
        score += x;
    }

    void increaseScore() {
        score += increaseValue;
    }

    int getIncreaseValue() {
        return increaseValue;
    }

    public void setIncreaseValue(int increaseValue) {
        this.increaseValue = increaseValue;
    }

    public void reset() {
        score = 0;
        increaseValue = initIncreaseValue;
    }

    public String toString() {
        return Integer.toString(score);
    }
}
