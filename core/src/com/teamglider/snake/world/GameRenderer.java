package com.teamglider.snake.world;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.teamglider.snake.helpers.AssetLoader;
import com.teamglider.snake.helpers.Position;
import com.teamglider.snake.objects.ActionKey;
import com.teamglider.snake.objects.Candy;
import com.teamglider.snake.objects.Snake;

import static com.badlogic.gdx.Gdx.gl;
import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * GameRender class
 * Created by Guillaume Quittet on 11/12/16.
 */
public class GameRenderer {

    private GameWorld gameWorld;

    // Create the camera
    private OrthographicCamera camera;
    private int viewWidth, viewHeight;
    // The drawing tools
    private ShapeRenderer shapeRenderer;
    private SpriteBatch spriteBatch;

    // The objects
    private ActionKey arrowRight;
    private ActionKey arrowDown;
    private ActionKey arrowLeft;
    private ActionKey arrowUp;
    private ActionKey actionButtonA;
    private ActionKey actionButtonB;
    private ActionKey actionButtonMenu;
    private Rectangle gamePad;

    private Snake snake;

    private Candy candy;


    public GameRenderer(GameWorld gameWorld, int viewWidth, int viewHeight) {
        this.gameWorld = gameWorld;
        this.viewWidth = viewWidth;
        this.viewHeight = viewHeight;
        initGameObjects();
        initRendererObjects();
    }

    private void initGameObjects() {
        arrowRight = gameWorld.getGamePad().getArrowRight();
        arrowDown = gameWorld.getGamePad().getArrowDown();
        arrowLeft = gameWorld.getGamePad().getArrowLeft();
        arrowUp = gameWorld.getGamePad().getArrowUp();
        actionButtonA = gameWorld.getGamePad().getActionButtonA();
        actionButtonB = gameWorld.getGamePad().getActionButtonB();
        actionButtonMenu = gameWorld.getGamePad().getActionButtonMenu();
        gamePad = gameWorld.getGamePad().getRectPad();
        snake = gameWorld.getSnake();
        candy = gameWorld.getCandy();
    }

    private void initRendererObjects() {
        camera = new OrthographicCamera();
        camera.setToOrtho(true, viewWidth, viewHeight);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
        spriteBatch = new SpriteBatch();
        spriteBatch.setProjectionMatrix(camera.combined);
    }

    private void renderGameScreen(String pauseText) {
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(127/255f, 127/255f, 127/255f, 1);
        shapeRenderer.rect(0, 0, 180, 30);
        shapeRenderer.end();
        spriteBatch.begin();
        AssetLoader.font.draw(spriteBatch, gameWorld.getScore().toString(), 5, 8);
        AssetLoader.font.draw(spriteBatch, pauseText, 130, 8);
        spriteBatch.end();
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(0, 0, 0, 1);
        shapeRenderer.rect(0, 30, 180, 210);
        shapeRenderer.end();
    }

    private void renderGamePad() {
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(127/255f, 127/255f, 127/255f, 1);
        shapeRenderer.rect(gamePad.getX(), gamePad.getY(), gamePad.getWidth(), gamePad.getHeight());
        shapeRenderer.end();
        shapeRenderer.begin(ShapeType.Line);
        shapeRenderer.setColor(0, 0, 0, 1);
        shapeRenderer.rect(gamePad.getX(), gamePad.getY(), gamePad.getWidth(), gamePad.getHeight());
        shapeRenderer.end();
        spriteBatch.begin();
        spriteBatch.draw(AssetLoader.arrowKey,
                arrowRight.getPosition().getX(), arrowRight.getPosition().getY(),
                arrowRight.getSize()/2, arrowRight.getSize()/2,
                arrowRight.getSize(), arrowRight.getSize(),
                1f, 1f, 90f * arrowRight.getRotation());
        spriteBatch.end();
        spriteBatch.begin();
        spriteBatch.draw(AssetLoader.arrowKey,
                arrowDown.getPosition().getX(), arrowDown.getPosition().getY(),
                arrowDown.getSize()/2, arrowDown.getSize()/2,
                arrowDown.getSize(), arrowDown.getSize(),
                1f, 1f, 90f * arrowDown.getRotation());
        spriteBatch.end();
        spriteBatch.begin();
        spriteBatch.draw(AssetLoader.arrowKey,
                arrowLeft.getPosition().getX(), arrowLeft.getPosition().getY(),
                arrowLeft.getSize()/2, arrowLeft.getSize()/2,
                arrowLeft.getSize(), arrowLeft.getSize(),
                1f, 1f, 90f * arrowLeft.getRotation());
        spriteBatch.end();
        spriteBatch.begin();
        spriteBatch.draw(AssetLoader.arrowKey,
                arrowUp.getPosition().getX(), arrowUp.getPosition().getY(),
                arrowUp.getSize()/2, arrowUp.getSize()/2,
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

    private void renderSnake() {
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(snake.getColor());
        Position position;
        for (int i = 0; i < snake.getLength(); ++i) {
            position = snake.getPositions()[i];
            shapeRenderer.rect(position.getX(), position.getY() + 30,
                    snake.getSize(), snake.getSize());
        }
        shapeRenderer.end();
        shapeRenderer.begin(ShapeType.Line);
        shapeRenderer.setColor(0, 0, 0, 1);
        for (int i = 0; i < snake.getLength(); ++i) {
            position = snake.getPositions()[i];
            shapeRenderer.rect(position.getX(), position.getY() + 30,
                    snake.getSize(), snake.getSize());
        }
        shapeRenderer.end();
    }

    private void renderCandy() {
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(1, 1, 1, 1);
        shapeRenderer.rect(candy.getPosition().getX(), candy.getPosition().getY() + 30,
                candy.getSize(), candy.getSize());
        shapeRenderer.end();
    }

    public void render(String pauseText) {
        //Gdx.app.log("GameRenderer", "Render");
        gl.glClearColor(0, 0, 0, 1);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        renderGameScreen(pauseText);
        renderGamePad();
        renderSnake();
        renderCandy();
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
}
