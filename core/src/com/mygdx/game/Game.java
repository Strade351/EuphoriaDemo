package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Heroes.Hero;
import com.mygdx.game.Locations.Location;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Location location;
	Hero hero;
	int steps;
	Vector2 tpos;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		location = new Location();
		hero = new Hero();
	}

	@Override
	public void render () {
		try {
			update();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		location.render(batch);
		hero.render(batch);
		batch.end();
	}

	public void update() throws InterruptedException {
		if (!(hero.getPosition().equals(tpos))) {
			steps += 1;
			System.out.println(steps);
		}
		hero.update();
		tpos = hero.getPosition();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
