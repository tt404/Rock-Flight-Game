package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

//[Tran] Menu class to handle menu states.
public class Menu {

	private int curState; //Current state of the game
	background back;
	private float xPos;   //Position of menu elements.
	private float yPos;   //Position of menu elements.
	GlyphLayout inputFont; //This and the two below are for sprites/fonts.
	BitmapFont Font;
	SpriteBatch batch;
	
	private String MENUTEXT = "Testing";
	
	public Menu(rockDodge game)
	{
		this.curState = 0;
		this.back = game.getBackground();
		this.xPos = Gdx.graphics.getWidth()/2;
		this.yPos = 0;
		batch = new SpriteBatch();
        inputFont = new GlyphLayout();
		Font = new BitmapFont();
		
	}
	
	public void setState(int gameState)
	{
		curState = gameState;
	}
	
	
	public void update()
	{
		
	}
	
	public void render()
	{
		// [Tran] This xPos and if statement is to scroll the text from the left to right side of the screen.
		xPos += 3;
		if(xPos >= Gdx.graphics.getWidth())
		{
			inputFont.setText(Font, MENUTEXT); //This is for GlyphLayout, to focus on the text to measure.
			xPos = 0 - inputFont.width;
		}
		
		// [Tran] Draw this MENUTEXT to the screen based on screen height and xPos variable.
		batch.begin();
		Font.setColor(Color.WHITE);
		Font.draw(batch, MENUTEXT, xPos, Gdx.graphics.getHeight()/2);	
		batch.end();	
	}
	
}
