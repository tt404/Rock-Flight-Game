package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

// [Taj] Use this class to handle all forms of input.
public class input
{
	rockDodge game;
	background back;
	String text;
	Menu menu;
	public input(rockDodge game)
	{
		this.game = game; // [Taj] You know the drill....
		this.text = "No input";
		this.back = game.getBackground();
		this.menu = game.getMenu();
	}
	
	public void update()
	{
		// [Taj] Does whatever is inside the brackets if the up arrow key is pressed.
		if(Gdx.input.isKeyPressed(Input.Keys.UP))
		{
			// [Taj] This is just an example, we will draw text that says "up"
			text = "up";
			
			// [Tran] Test to change menu state.
				menu.setState(1);    
		}
		
		// [Taj] Guess what this does :p
		else if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
		{
			// [Taj] This is just an example, we will draw text that says "down"
			text = "down";
			
		}
		//else if(Gdx.input.isButtonPressed(Input.Key)
		else
		{
			text = "No input";
		}
		
		
		// [Tran] Test to change color, this also functions as key not pressed.
		if(!Gdx.input.isKeyPressed(Input.Keys.UP))
		{
			menu.setState(0);
		
		}
		
		// [Taj] Actually renders the text
		game.curPlayer.renderText(text);			
	}
}
