package com.mygdx.game.Heroes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import static java.lang.Thread.sleep;

/**
 * Created by Anatoliy on 20.12.2016.
 */
public class Hero {
    private Texture sHero;

    private Vector2 position;
    private Vector2 targetTile;

    public Hero() {
        sHero = new Texture("Warrior.png");
        position = new Vector2(128, 64);
        targetTile = new Vector2(0, 0);
    }

    /**
     *
     * @param direction
     * @throws InterruptedException
     */
    public void move(int direction) throws InterruptedException {
        switch(direction){
            case Input.Keys.UP:
                if (canMove(Input.Keys.UP)) {
                    position.y += 32;
                }
                break;
            case Input.Keys.DOWN:
                if (canMove(Input.Keys.DOWN)) {
                    position.y -= 32;
                }
                break;
            case Input.Keys.LEFT:
                if (canMove(Input.Keys.LEFT)) {
                    position.x -= 32;
                }
                break;
            case Input.Keys.RIGHT:
                if (canMove(Input.Keys.RIGHT)) {
                    position.x += 32;
                }
                break;
        }
    }

    /**
     * Character Control
     * @throws InterruptedException
     */
    public void update() throws InterruptedException {
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            setTargetTile(targetTile, 0, targetTile.y + 32);
            move(Input.Keys.UP);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            setTargetTile(targetTile, 0, targetTile.y - 32);
            move(Input.Keys.DOWN);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            setTargetTile(targetTile, targetTile.x - 32, 0);
            move(Input.Keys.LEFT);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            setTargetTile(targetTile, targetTile.x + 32, 0);
            move(Input.Keys.RIGHT);
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(sHero, position.x, position.y);
    }
    public boolean canMove(int direction) {
        if (direction == Input.Keys.UP) {
            if (position.y == 320)
                return false;
        } else if (direction == Input.Keys.DOWN) {
            if (position.y == 0)
                return false;
        } else if (direction == Input.Keys.RIGHT) {
            if (position.x == 480)
                return false;
        } else if (direction == Input.Keys.LEFT) {
            if (position.x == 0)
                return false;
        }
        return true;
    }

    public void setTargetTile(Vector2 targetTile, float x, float y) {
        targetTile.x = x;
        targetTile.y = y;
    }

    public Vector2 getTargetTile() {
        return targetTile;
    }

    public Vector2 getPosition() {
        return position;
    }

}
