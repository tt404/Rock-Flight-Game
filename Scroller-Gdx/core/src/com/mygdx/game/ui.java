package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

// [Taj] Do all user interface related stuff.
public class ui
{
	// [Taj] This is a reference of the game that this class can use.
	rockDodge game;
	
	// [Taj] This is our font class, we need this to render text.
	private BitmapFont font;
	
	// [Taj] This is the sprite batch we need this to render stuff.
	private SpriteBatch batch;
	
	// [Taj] Initializer.
	public ui(rockDodge game)
	{
		// [Taj] References the main game to this class.
		this.game = game;
		
		// [Taj] Now we initialize memory for our fonts and batch
		font = new BitmapFont();
		batch = new SpriteBatch();
	}
	
	// [Taj] This updates things like coordinates.
	public void update()
	{
		
	}
	
	// [Taj] Render the actual player here.
	public void render()
	{
		// [Taj] Rendering in libgdx works a bit differently, you need to surround
		// your rendering stuff with batch.begin and batch.end
		
		batch.begin();
		font.setColor(Color.WHITE);
		font.draw(batch, "Hello", 100, 100); // [Taj] Draw.
		batch.end();
	}
}
