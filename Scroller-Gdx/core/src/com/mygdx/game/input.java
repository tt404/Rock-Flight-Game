package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

// [Taj] Use this class to handle all forms of input.
public class input
{
	rockDodge game;
	public input(rockDodge game)
	{
		this.game = game; // [Taj] You know the drill....
	}
	
	public void update()
	{
		// [Taj] Does whatever is inside the brackets if the up arrow key is pressed.
		if(Gdx.input.isButtonPressed(Input.Keys.UP))
		{
			
		}
		
		// [Taj] Guess what this does :p
		else if(Gdx.input.isButtonPressed(Input.Keys.DOWN))
		{
			
		}
	}
}
