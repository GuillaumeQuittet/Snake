package com.teamglider.snake.world;

import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by Guillaume Quittet on 15/12/16.
 */
public class MenuRenderer {

    private MenuWorld menuWorld;
    private OrthographicCamera camera;
    private int viewWidth, viewHeight;

    public MenuRenderer(MenuWorld menuWorld, int viewWidth, int viewHeight) {
        this.menuWorld = menuWorld;
        this.viewWidth = viewWidth;
        this.viewHeight = viewHeight;
        initMenuRendererObjects();
    }

    private void initMenuRendererObjects() {
        camera = new OrthographicCamera();
        camera.setToOrtho(true, viewWidth, viewHeight);
    }

    public void render() {

    }

    public OrthographicCamera getCamera() {
        return camera;
    }
}
