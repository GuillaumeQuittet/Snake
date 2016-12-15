package com.teamglider.snake.objects;

/**
 * Created by Guillaume Quittet on 15/12/16.
 */
public class Map {

    private int[] abscisses;
    private int[] ordonnees;

    public Map(int width, int size) {
        abscisses = new int[width / size];
        ordonnees = new int[width / size];
        for (int i = 0, j = 30; i < width && j < width + 30; i += 5, j += 5) {
            abscisses[i / 5] = i;
            ordonnees[i / 5] = j;
        }
    }

    public int[] getAbscisses() {
        return abscisses;
    }

    public int[] getOrdonnees() {
        return ordonnees;
    }
}
