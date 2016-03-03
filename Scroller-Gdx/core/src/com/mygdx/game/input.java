package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

// [Taj] Use this class to handle all forms of input.
public class input
{
	rockDodge game;
	background back;
	String text;
	public input(rockDodge game)
	{
		this.game = game; // [Taj] You know the drill....
		this.text = "No input";
		this.back = game.getBackground();
	}
	
	public void update()
	{
		// [Taj] Does whatever is inside the brackets if the up arrow key is pressed.
		if(Gdx.input.isKeyPressed(Input.Keys.UP))
		{
			// [Taj] This is just an example, we will draw text that says "up"
			text = "up";
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
		
		// [Taj] Actually renders the text
		game.curPlayer.renderText(text);			
	}
}
