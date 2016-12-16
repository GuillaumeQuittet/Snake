package com.teamglider.snake.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.teamglider.snake.Snake;

public class HtmlLauncher extends GwtApplication {

    private int width = 360;
    private int height = 640;

        @Override
        public GwtApplicationConfiguration getConfig () {
            return new GwtApplicationConfiguration(width, height);
        }

        @Override
        public ApplicationListener createApplicationListener () {
            return new Snake(width, height);
        }
}