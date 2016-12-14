package com.teamglider.snake.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Load the assets
 * Created by Guillaume Quittet on 11/12/16.
 */
public class AssetLoader {

    public static Texture texture;
    public static TextureRegion arrowKey;
    public static TextureRegion actionButtonA;
    public static TextureRegion actionButtonB;
    public static TextureRegion actionButtonMenu;

    /**
     * Load the assets
     */
    public static void load() {
        Gdx.app.log("AssetLoader", "Load the assets");
        texture = new Texture(Gdx.files.internal("Images-Pack/textures.png"));
        texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        arrowKey = new TextureRegion(texture, 1, 1, 128, 128);
        actionButtonA = new TextureRegion(texture, 131, 1, 128, 128);
        actionButtonB = new TextureRegion(texture, 261, 1, 128, 128);
        actionButtonMenu = new TextureRegion(texture, 391, 1, 128, 128);
        arrowKey.flip(false, true);
        actionButtonA.flip(false, true);
        actionButtonB.flip(false, true);
        actionButtonMenu.flip(false, true);
    }

    /**
     * Dispose the assets
     */
    public static void dispose() {
        Gdx.app.log("AssetLoader", "Dispose the assets");
        texture.dispose();
    }

}
