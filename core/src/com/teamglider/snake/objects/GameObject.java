package com.teamglider.snake.objects;

import com.badlogic.gdx.graphics.Color;
import com.teamglider.snake.helpers.Position;

/**
 * GameObject class
 * Created by Guillaume Quittet on 18/12/16.
 */
public class GameObject {

    private Position position;
    private int size;
    private Color color;
    private int viewWidth;
    private Map map;

    GameObject(int size) {
        this.size = size;
    }

    public void initMap(int viewWidth) {
        this.viewWidth = viewWidth;
        map = new Map(viewWidth, size);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    void setColor(Color color) {
        this.color = color;
    }

    Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    int getViewWidth() {
        return viewWidth;
    }
}
