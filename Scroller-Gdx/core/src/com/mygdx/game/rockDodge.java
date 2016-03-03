package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class rockDodge extends ApplicationAdapter
{
	// [Taj] Setup our classes
	SpriteBatch batch;
	player curPlayer;
	background curBackground;
	ui UI;
	input playerInput;
	
	Menu menu;
	
	

	@Override
	public void create()
	{
		// [Taj] Setting up the classes
		
		batch = new SpriteBatch();
		curPlayer = new player(this);
		curBackground = new background(this);
		UI = new ui(this);
		menu = new Menu(this); //[Tran] This has to be before some of these calls.
		playerInput = new input(this); // [Taj] This as in, the rockDodge game itself.
		
		
		// [Alex] Commented next line because errors
		// img = new Texture("badlogic.jpg");
	}

	@Override
	public void render()
	{
		// [Taj] Organizing code, update and render are separated now.
		update();
		doRender();
	}

	// [Taj] This is where we're gonna do calculations, no graphics stuff.
	// Things like the game loop go here.
	public void update()
	{
		// [Taj] Calls the "update" method on each of these.
		curPlayer.update();
		curBackground.update();
		UI.update();
		playerInput.update();
		menu.update();
	}

	// [Taj] All graphics related things goes here.
	public void doRender()
	{
		// [Tran] Changed background color control to background class.
		curBackground.render();
		menu.render();
		

		// [Taj] Calls the "render" method on each of these.
		curPlayer.render();

		batch.begin();
		
		// [Alex] Commented next line because no image is being rendered
		// batch.draw(img, 0, 0);
		batch.end();
		
		curPlayer.render();
	}
	
	// [Tran] Returns the background, playerInput and menu.
	public background getBackground()
	{
		return curBackground;
	}
	
	public input getInput()
	{
		return playerInput;
	}
	
	public Menu getMenu()
	{
		return menu;
	}
}
