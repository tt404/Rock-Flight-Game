package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

// [Taj] This class will have everything player related, its just skeleton
// code for now.
public class player
{
	// [Taj] The reference of the game.
	rockDodge game;
		
	// [Taj] Just like the ui class, we need a sprite batch to render things.
	SpriteBatch batch; // [Taj] This is for sprites...
	
	// [Taj] Since we don't have any sprites yet we'll draw rectangles to 
	// represent the player. Libgdx comes with something called a 
	// shaperenderer that does most of the work for us. This is used 
	// similarly to sprite batches.
	ShapeRenderer playerBox; // [Taj] We will remove this once we have actual sprites.
	
	// [Taj] These are self explanatory.
	int width;
	int height;
	float x;
	float y;
	
	// [Taj] Initializer.
	public player(rockDodge game)
	{
		this.game = game;
		
		// [Taj] Setup our player...
		this.width = 32;
		this.height = 32;
		this.x = 200.0f; // [Taj] Java is a bit weird, you need to add "f" for 
						 // a number be interpreted as a float. Since x and y
						 // are floats, as we declared above, we need to do this.
		this.y = 100.f;  // [Taj] So now the default coords are (200, 100)
		
		// [Taj] Uncomment this once we use actual sprites.
		//batch = new SpriteBatch();
		
		// [Taj] Initialize our shape renderer
		playerBox = new ShapeRenderer();
	}
	
	// [Taj] This updates things like coordinates.
	public void update()
	{
	}
	
	// [Taj] Render the actual player here.
	public void render()
	{
		playerBox.begin(ShapeType.Filled); // [Taj] Makes a "filled" shape, filled
										   // as in fully colored.
		
		playerBox.setColor(Color.GREEN); // [Taj] Sets anything created by shape
										 // renderer to the color green.
		
		playerBox.rect(x, y, width, height); // [Taj] This part makes the rectangle
		
		playerBox.end(); // [Taj] Because of how libgdx works we need this end part.
						 // It basically accumilates everything we called between
						 // begin() and end(), and then combines all of that into
						 // one big call. Why? Because of how hardware is designed 
						 // This style of rendering is efficient. It is better to
						 // make one BIG call instead of multiple smaller calls.
	}
}
