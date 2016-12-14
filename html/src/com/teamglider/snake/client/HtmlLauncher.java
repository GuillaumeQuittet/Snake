package com.teamglider.snake.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.teamglider.snake.Snake;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                return new GwtApplicationConfiguration(360, 640);
        }

        @Override
        public ApplicationListener createApplicationListener () {
                return new Snake();
        }
}