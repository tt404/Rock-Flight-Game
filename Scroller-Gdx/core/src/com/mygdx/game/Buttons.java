package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class Buttons
{
	String text;
	BitmapFont font;
	SpriteBatch batch;
	float x;
	float y;
	float scale;
	
	float width;
	float height;

	boolean stringText; // [Taj] True means this is a string button.
						// False means this is an image button.
	
	String imgDirectory;
	
	// [Taj] This constructor makes basic text buttons
	public Buttons(String text, float x, float y, float scale)
	{
		stringText = true;
		
		this.text = text;
		this.x = x;
		this.y = y;
		this.scale = scale;
		font = new BitmapFont();
		batch = new SpriteBatch();
	}

	public Buttons(String imgDirectory, float x, float y)
	{
		stringText = false;
	}
	
	public void update()
	{
		// [Taj] String buttons and image buttons have separate update and render
		// functions.
		
		if(stringText == true)
			updateTextButton();
		
		// [Taj] Todo, get it working with images.
	}
	
	public void updateTextButton()
	{
		
	}
	
	public void render()
	{
		if(stringText == true)
			renderTextButton();
	}
	
	public void renderTextButton()
	{
		
	}
}
