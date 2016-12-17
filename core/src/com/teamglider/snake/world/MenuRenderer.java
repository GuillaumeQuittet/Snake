package com.teamglider.snake.world;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.teamglider.snake.helpers.AssetLoader;
import com.teamglider.snake.objects.ActionKey;

import static com.badlogic.gdx.Gdx.gl;

/**
 * Created by Guillaume Quittet on 15/12/16.
 */
public class MenuRenderer {

    private MenuWorld menuWorld;
    private SpriteBatch spriteBatch;
    private ShapeRenderer shapeRenderer;
    private OrthographicCamera camera;
    private int viewWidth, viewHeight;
    private Rectangle gamePad;
    private ActionKey arrowRight;
    private ActionKey arrowDown;
    private ActionKey arrowLeft;
    private ActionKey arrowUp;
    private ActionKey actionButtonA;
    private ActionKey actionButtonB;
    private ActionKey actionButtonMenu;

    public MenuRenderer(MenuWorld menuWorld, int viewWidth, int viewHeight) {
        this.menuWorld = menuWorld;
        this.viewWidth = viewWidth;
        this.viewHeight = viewHeight;
        initMenuRendererObjects();
    }

    private void initMenuRendererObjects() {
        camera = new OrthographicCamera();
        camera.setToOrtho(true, viewWidth, viewHeight);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
        spriteBatch = new SpriteBatch();
        spriteBatch.setProjectionMatrix(camera.combined);
        gamePad = menuWorld.getGamePad().getRectPad();
        arrowRight = menuWorld.getGamePad().getArrowRight();
        arrowDown = menuWorld.getGamePad().getArrowDown();
        arrowLeft = menuWorld.getGamePad().getArrowLeft();
        arrowUp = menuWorld.getGamePad().getArrowUp();
        actionButtonA = menuWorld.getGamePad().getActionButtonA();
        actionButtonB = menuWorld.getGamePad().getActionButtonB();
        actionButtonMenu = menuWorld.getGamePad().getActionButtonMenu();
    }

    private void renderGameScreen() {
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(127 / 255f, 127 / 255f, 127 / 255f, 1);
        shapeRenderer.rect(0, 0, 180, 30);
        shapeRenderer.setColor(0, 0, 0, 1);
        shapeRenderer.rect(0, 30, 180, 210);
        shapeRenderer.end();
        spriteBatch.begin();
        AssetLoader.font.draw(spriteBatch, menuWorld.getScore().toString(), 5, 8);
        spriteBatch.end();
    }

    private void renderGamePad() {
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(127 / 255f, 127 / 255f, 127 / 255f, 1);
        shapeRenderer.rect(gamePad.getX(), gamePad.getY(), gamePad.getWidth(), gamePad.getHeight());
        shapeRenderer.end();
        shapeRenderer.begin(ShapeType.Line);
        shapeRenderer.setColor(0, 0, 0, 1);
        shapeRenderer.rect(gamePad.getX(), gamePad.getY(), gamePad.getWidth(), gamePad.getHeight());
        shapeRenderer.end();
        spriteBatch.begin();
        spriteBatch.draw(AssetLoader.arrowKey,
                arrowRight.getPosition().getX(), arrowRight.getPosition().getY(),
                arrowRight.getSize() / 2, arrowRight.getSize() / 2,
                arrowRight.getSize(), arrowRight.getSize(),
                1f, 1f, 90f * arrowRight.getRotation());
        spriteBatch.end();
        spriteBatch.begin();
        spriteBatch.draw(AssetLoader.arrowKey,
                arrowDown.getPosition().getX(), arrowDown.getPosition().getY(),
                arrowDown.getSize() / 2, arrowDown.getSize() / 2,
                arrowDown.getSize(), arrowDown.getSize(),
                1f, 1f, 90f * arrowDown.getRotation());
        spriteBatch.end();
        spriteBatch.begin();
        spriteBatch.draw(AssetLoader.arrowKey,
                arrowLeft.getPosition().getX(), arrowLeft.getPosition().getY(),
                arrowLeft.getSize() / 2, arrowLeft.getSize() / 2,
                arrowLeft.getSize(), arrowLeft.getSize(),
                1f, 1f, 90f * arrowLeft.getRotation());
        spriteBatch.end();
        spriteBatch.begin();
        spriteBatch.draw(AssetLoader.arrowKey,
                arrowUp.getPosition().getX(), arrowUp.getPosition().getY(),
                arrowUp.getSize() / 2, arrowUp.getSize() / 2,
                arrowUp.getSize(), arrowUp.getSize(),
                1f, 1f, 90f * arrowUp.getRotation());
        spriteBatch.end();
        spriteBatch.begin();
        spriteBatch.draw(AssetLoader.actionButtonA,
                actionButtonA.getPosition().getX(), actionButtonA.getPosition().getY(),
                actionButtonA.getSize(), actionButtonA.getSize());
        spriteBatch.end();
        spriteBatch.begin();
        spriteBatch.draw(AssetLoader.actionButtonB,
                actionButtonB.getPosition().getX(), actionButtonB.getPosition().getY(),
                actionButtonB.getSize(), actionButtonB.getSize());
        spriteBatch.end();
        spriteBatch.begin();
        spriteBatch.draw(AssetLoader.actionButtonMenu,
                actionButtonMenu.getPosition().getX(), actionButtonMenu.getPosition().getY(),
                actionButtonMenu.getSize(), actionButtonMenu.getSize());
        spriteBatch.end();
    }

    private void renderMenu() {

    }

    public void render() {
        //Gdx.app.log("GameRenderer", "Render");
        gl.glClearColor(0, 0, 0, 1);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        renderGameScreen();
        renderGamePad();
        renderMenu();
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
}
