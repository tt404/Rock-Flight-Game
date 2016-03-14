package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

//[Tran] Menu class to handle menu states.
public class Menu {

	private String curState; //Current state of the game
	background back;
	private float xPos;   //Position of menu elements.
	private float yPos;   //Position of menu elements.
	GlyphLayout inputFont; //This and the two below are for sprites/fonts.
	BitmapFont Font;
	SpriteBatch batch;
	
	private float screenHeight;
	private float screenWidth;

	
	
	private Skin skin;
	private Stage stage;
	
	private static String MENU = "Rock Dodger";
	private static String INSTRUCTIONS = "Instructions";
	
	public Menu(rockDodge game)
	{
		this.curState = MENU;
		this.back = game.getBackground();
		this.xPos = Gdx.graphics.getWidth()/2;
		this.yPos = 0;
		batch = new SpriteBatch();
        inputFont = new GlyphLayout();
		Font = new BitmapFont();
		
		/*
		FileHandle handle = Gdx.files.internal("master/uiskin.json");
		if(handle.exists())
		{

			System.out.println("yes");
			//skin = new Skin(Gdx.files.internal("master/uiskin.json"));

		}
		else
			
		{
			System.out.println("no");
		}
		 */
      
		
        
        
	}
	
	public String getState()
	{
		return curState;
		
	}
	public void setState(String gameState)
	{
		curState = gameState;
	}
	
	
	public void update()
	{
		screenHeight = Gdx.graphics.getHeight();  //Added this so values are called a frame before render.
		screenWidth = Gdx.graphics.getWidth();    //Use these values instead of calling the function.
	}
	
	public void render()
	{
		
		
		// [Tran] This xPos and if statement is to scroll the text from the left to right side of the screen.
		xPos += 3;
		if(xPos >= Gdx.graphics.getWidth())
		{
			inputFont.setText(Font, MENU); //This is for GlyphLayout, to focus on the text to measure.
			xPos = 0 - inputFont.width;
		}
		
		if(curState.equals(MENU))
		{
			// [Tran] Draw this MENUTEXT to the screen based on screen height and xPos variable.
			batch.begin();
			Font.setColor(Color.WHITE);
			Font.draw(batch, MENU, xPos, 3*screenHeight/4 + (float)Math.sin(xPos/50)*screenHeight/8);	
			batch.end();	
		}
		else if(curState.equals(INSTRUCTIONS))
		{
			batch.begin();
			Font.setColor(Color.WHITE);
			Font.draw(batch, INSTRUCTIONS, xPos, 3*screenHeight/4);	
			Font.draw(batch, "Welcome to this \"Rock Dodger\" game dude. Press up or down to dodge things till you die, glhf.", 0, 3*screenHeight/5);	
			batch.end();	
		}
		
	}
	
}
