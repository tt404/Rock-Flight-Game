package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class Menu {

	private int curState; //Current state of the game
	background back;
	
	public Menu(rockDodge game)
	{
		this.curState = 0;
		this.back = game.getBackground();
	}
	
	public void setState(int gameState)
	{
		curState = gameState;
	}
	
	
	public void update()
	{
		if(curState == 1)
		{
			back.setColor(1, 0, 0, 0);
		}
		else
		{
			back.setColor(0, 0, 0, 0);
		}
	}
	
	public void render()
	{
		
	}
	
}
