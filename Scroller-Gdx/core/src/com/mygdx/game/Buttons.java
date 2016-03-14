package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class Buttons {
	String text;
	BitmapFont font;
	SpriteBatch batch;
	float x;
	float y;
	float scale;

	float width;
	float height;
	float screenHeight;

	boolean stringText; // [Taj] True means this is a string button.
						// False means this is an image button.

	boolean isClickedOn;//If the button has been clicked onto.
	boolean isMouseOver;//If the button has a mouse over it.
	
	String imgDirectory;

	ShapeRenderer buttonBox;

	// [Taj] This constructor makes basic text buttons
	public Buttons(String text, float x, float y, float scale) {
		stringText = true;

		this.text = text;
		this.x = x;
		this.y = y;
		this.scale = scale;
		font = new BitmapFont();
		batch = new SpriteBatch();
		buttonBox = new ShapeRenderer();
		this.isClickedOn = false;
		
	}

	public Buttons(String imgDirectory, float x, float y) {
		stringText = false;
	}

	public void update() {
		// [Taj] String buttons and image buttons have separate update and
		// render
		// functions.

		if (stringText == true)
			updateTextButton();

		
		screenHeight = Gdx.graphics.getHeight();
		// [Taj] Todo, get it working with images.
	}

	public void updateTextButton() {

	}

	public void render() {
		if (stringText == true)
			renderTextButton();

		//[Tran] These if's below are for the button color: due to if mouse is clicking, mousing or not on the button.
		buttonBox.begin(ShapeType.Filled);

        if(isClickedOn == false && isMouseOver == false)
        {
        	buttonBox.setColor(Color.WHITE); 
        	buttonBox.rect(x, y, width, height); //Button x,y,width and height
        }
        else if(isClickedOn == false && isMouseOver == true)
        {
        	buttonBox.setColor(Color.GREEN);
        	buttonBox.rect(x-(100*width/95 - width)/2, y-(100*height/95 - height)/2, 100*width/95, 100*height/95); //Button x,y,width and height
        }
        else if(isClickedOn == true)
        { 	
        	buttonBox.setColor(Color.BLUE);
        	setButtonSize(width, height);
        	buttonBox.rect(x-(100*width/105 - width)/2, y-(100*height/105 - height)/2, 100*width/105, 100*height/105); //Button x,y,width and height
        }
		
		
		buttonBox.end(); 


		batch.begin();
		font.setColor(Color.BLACK);
		font.draw(batch, text, x + width/4, y + height/2); // Draw the text to the button	
		batch.end();	

	}
	
	public void renderTextButton()
	{
		
	}
	
	
	
	public void setButtonSize(float width, float height)
	{
		this.width = width;
		this.height = height;
	}
	
	
	public void setClickedOn(boolean isStillInRange)
	{
		this.isClickedOn = isStillInRange;
	}
	
	//[Tran] Used to detect if our click on the screen, was on a button (called from input class).
	public boolean isClickedOn(float x, float y)
	{
		if(x >= this.x && x <= this.x + width) //Boundary check for button location and width to mouse positions.
		{
			if(y >= screenHeight - this.y - height && y <= screenHeight - this.y) //Since libgdx is annoying, we need to flip the detection y-boundaries cause it starts at top left instead of bottom left (we're moving it to bottom left)
			{
				this.isClickedOn = true; //Respond true to the click.
				return true;
			}
		}
		this.isClickedOn = false; //Click was not on a button.
		return false;
	}
	
	//[Tran] Used to detect if our mouse on the screen, is also over a button(called from input class).
	public boolean isInRange(float x, float y)
	{
		if(x >= this.x && x <= this.x + width) //Refer to duplicate if statement above in isClickedOn
		{
			if(y >= screenHeight - this.y - height && y <= screenHeight - this.y)
			{
				this.isMouseOver = true;
				return true;
			}
		}
		this.isMouseOver = false;
		return false;
	}
	
}
