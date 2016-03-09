package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
	// shaperenderer that does most of the work for us. This works similarly 
	// like sprite batches.
	ShapeRenderer playerBox; // [Taj] We will remove this once we have actual sprites.
	
	// [Taj] These are self explanatory.
	int width;
	int height;
	float x;
	float y;
	float moveSpeed;
	String inputText;
	
	// [Taj] This is to render text. This is used to show input as an example, dont worry
	// about this too much.
	BitmapFont inputFont;
	
	// [Taj] Initializer.
	public player(rockDodge game)
	{
		this.game = game;
		
		// [Taj] Setup our player...
		this.width = 32;
		this.height = 32;
		this.x = 200.0f;	// [Taj] Java is a bit weird, you need to add "f" for 
							// a number be interpreted as a float. Since x and y
							// are floats, as we declared above, we need to do this.
		this.y = 100.f;		// [Taj] So now the default coords are (200, 100)

		this.moveSpeed = 12.0f; // [Taj] This is how fast the player moves up and down
		
		// [Taj] Renders sprites, and also fonts
		batch = new SpriteBatch();
		
		// [Taj] Initialize our shape renderer
		playerBox = new ShapeRenderer();
		
		// [Taj] well you get the idea now...
		inputFont = new BitmapFont();
		
		inputText = "No Input";
	}
	
	// [Taj] This updates things like coordinates.
	public void update()
	{
	}
	
	
	// [Taj] Todo
	public void moveUp()
	{
		// [Alex] moves playerBox up by incrementing Y coordinate, Now with Boundaries
		if(this.y >= Gdx.graphics.getHeight() - 32)
		{
			this.y = Gdx.graphics.getHeight() - 32;
		}
		else 
		{
			this.y += moveSpeed;
		}
	}
	
	// [Taj] Todo
	public void moveDown()
	{
		// [Alex] moves playerBox down by decrementing Y coordinate, Now with Boundaries
		if(this.y <= 0)
		{
			this.y = 0;
		}
		else 
		{
			this.y -= moveSpeed;
		}
	}
	
	// [Taj] Render the actual player here.
	public void render()
	{
		playerBox.begin(ShapeType.Filled); // [Taj] Makes a "filled" shape, filled
										   // as in fully colored.
		
		playerBox.setColor(Color.GREEN); // [Taj] Sets anything created by shape
										 // renderer to the color green.
		
		playerBox.rect(x, y, width, height); // [Taj] This part makes the rectangle
		
		playerBox.end();	// [Taj] Because of how libgdx works we need this end part.
							// It basically accumulates everything we called between
							// begin() and end(), and then combines all of that into
							// one big call. Why? Because of how hardware is designed 
							// This style of rendering is efficient. It is better to
							// make one BIG call instead of multiple smaller calls.

		// [Taj] Lets render the text we get.
		batch.begin();
		inputFont.setColor(Color.WHITE);
		inputFont.draw(batch, inputText, 100, 100); // [Taj] Draw.		
		batch.end();	
	}

	// [Alex] exemplary class not needed
	/*
	public void renderText(String text)
	{						
		inputText = text;
	}
	*/
}
