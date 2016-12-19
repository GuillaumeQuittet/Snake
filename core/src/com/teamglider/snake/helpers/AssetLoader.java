package com.teamglider.snake.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Load the assets
 * Created by Guillaume Quittet on 11/12/16.
 */
public class AssetLoader {

    public static TextureRegion arrowKey;
    public static TextureRegion buttonA;
    public static TextureRegion buttonB;
    public static TextureRegion buttonMenu;
    public static BitmapFont font;
    private static Texture texture;

    /**
     * Load the assets
     */
    public static void load() {
        Gdx.app.log("AssetLoader", "Load the assets");
        texture = new Texture(Gdx.files.internal("Images-Pack/textures.png"));
        texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        arrowKey = new TextureRegion(texture, 1, 1, 128, 128);
        arrowKey.flip(false, true);
        buttonA = new TextureRegion(texture, 131, 1, 128, 128);
        buttonA.flip(false, true);
        buttonB = new TextureRegion(texture, 261, 1, 128, 128);
        buttonB.flip(false, true);
        buttonMenu = new TextureRegion(texture, 391, 1, 128, 128);
        buttonMenu.flip(false, true);
        font = new BitmapFont(Gdx.files.internal("Fonts/arial.fnt"));
        font.getData().setScale(0.5f, -0.5f);
    }

    /**
     * Dispose the assets
     */
    public static void dispose() {
        Gdx.app.log("AssetLoader", "Dispose the assets");
        texture.dispose();
        font.dispose();
    }

}
