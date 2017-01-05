package com.mygdx.game.Locations;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Anatoliy on 20.12.2016.
 */
public class Location {
    char matrix[][]={{0,0,0,0,0,0,0,0,0,0,0,1,1,1,1},
                    {0,0,0,0,0,0,0,0,0,0,1,1,1,1,1},
                    {0,'d',0,0,0,0,0,0,0,0,0,1,1,1,1},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                    {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,1,1,0,0,0,0,0,0,0,0},
                    {1,0,0,0,0,1,1,0,0,0,0,0,0,0,0},
                    {1,1,0,0,0,0,1,1,0,'s',0,0,0,0,1},
                    {1,1,1,0,0,0,0,0,0,0,0,0,0,1,1},
                    {1,1,1,1,0,0,0,0,0,0,0,0,1,1,1},};
    private Texture background;

    public Location() {
        background = new Texture("map.png");
    }

    public void render(SpriteBatch batch) {
        batch.draw(background, 0, 0);
    }
}
