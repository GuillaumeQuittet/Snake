package com.teamglider.snake.objects;

/**
 * Map class
 * Created by Guillaume Quittet on 15/12/16.
 */
public class Map {

    private int[] vertices;

    public Map(int width, int size) {
        vertices = new int[width / size];
        for (int i = 0; i < width; i += 5) {
            vertices[i / 5] = i;
        }
    }

    public int[] getVertices() {
        return vertices;
    }
}
