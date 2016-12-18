package com.teamglider.snake.objects;

/**
 * Score class
 * Created by Guillaume Quittet on 14/12/16.
 */
public class Score {

    private int score;
    private int increaseValue;

    public Score(int score, int increaseValue) {
        this.score = score;
        this.increaseValue = increaseValue;
    }

    public Score(int increaseValue) {
        this.score = 0;
        this.increaseValue = increaseValue;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void increaseScore(int x) {
        score += x;
    }

    public void increaseScore() {
        score += increaseValue;
    }

    public int getIncreaseValue() {
        return increaseValue;
    }

    public void setIncreaseValue(int increaseValue) {
        this.increaseValue = increaseValue;
    }

    public String toString() {
        return Integer.toString(score);
    }
}
