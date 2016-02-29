package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class rockDodge extends ApplicationAdapter
{
	SpriteBatch batch;
	Texture img;

	@Override
	public void create()
	{
		batch = new SpriteBatch();
		// [Alex] Commented next line because errors
		//img = new Texture("badlogic.jpg");
	}

	@Override
	public void render()
	{
		// [Alex] Changed background to black
		Gdx.gl.glClearColor(1, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		// [Alex] Commented next line because no image is being rendered
		//batch.draw(img, 0, 0);
		batch.end();
	}
}
