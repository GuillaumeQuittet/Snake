package com.teamglider.snake.objects;

/**
 * Created by Guillaume Quittet on 17/12/16.
 */
public class Menu {

    private String[] elements;
    private int currentElement;

    public Menu(String[] elements) {
        this.elements = elements;
        currentElement = 0;
    }

    public String[] getElements() {
        return elements;
    }

    public void setElements(String[] elements) {
        this.elements = elements;
    }

    public int getCurrentElement() {
        return currentElement;
    }

    public void setCurrentElement(int currentElement) {
        this.currentElement = currentElement;
    }
}
