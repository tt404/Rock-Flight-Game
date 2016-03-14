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
	private boolean isMousePress;   //Checked if we can click mouse or not.
	private boolean isClickedButton;//Checked if a button was successfully clicked.
	public input(rockDodge game)
	{
		this.game = game; // [Taj] You know the drill....
		this.text = "No input";
		this.back = game.getBackground();
		this.menu = game.getMenu();
		this.isMousePress = false;
	}
	
	public void update()
	{
		// [Taj] Does whatever is inside the brackets if the up arrow key is pressed.
		if(Gdx.input.isKeyPressed(Input.Keys.UP))
		{
			// [Alex] Don't need
			//text = "up";
			
			// [Tran] Test to change menu state.
				   
				
			// [Alex] calling moveUp function
				game.curPlayer.moveUp();
		}
		
		// [Taj] Guess what this does :p
		else if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
		{
			// [Taj] This is just an example, we will draw text that says "down"
			//text = "down";
			
			// [Alex] calling moveDown function
			game.curPlayer.moveDown();
		}
		//else if(Gdx.input.isButtonPressed(Input.Key)
		else
		{
			// [Alex] Don't need
			//text = "No input";
		}
		
		// [Tran] A mouse click for buttons, only reacts once, AND only after the mouse is released inside the button.
		// [Tran] Mouse click. First check if the left mouse button was clicked or not, secondary check (isMousePress): only click once (explained below)
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT) && isMousePress == false)
		{
			isClickedButton = game.button.isClickedOn(Gdx.input.getX(), Gdx.input.getY()); //Recieve if the first initial click is within a button range.
			System.out.println("click");
			isMousePress = true;  //Now make it so that the button cannot be refired again (the Gdx.input fires process step, so this is necessary to prevent multiple clicks in one click)
		}
		else if(isClickedButton == true)  //If our initial click is within a range of a button...
		{
				if(game.button.isInRange(Gdx.input.getX(), Gdx.input.getY()) == true) //Check if the mouse is still in RANGE of the button
				{
					if(!Gdx.input.isButtonPressed(Input.Buttons.LEFT))     //If the mouse at this point is released, then accept and do the following.
					{
						System.out.println(game.button.text); //Insert some event here.
						game.button.buttonEvent(game.menu.getState());
						game.button.setClickedOn(false);     //Button sucessfully clicked.
						isMousePress = false;                //Allow button pressing again.
						isClickedButton = false;             //Allow for a different button to be pressed.
					}
					
				}
				else                  //Else if the button is not in range, the mouse press is considered to have failed, so reset
				{
					isMousePress = false;
					isClickedButton = false;
					
				}
		}
		else if(isClickedButton == false)  //If we don't click on any button, then just reset things
		{
			if(!Gdx.input.isButtonPressed(Input.Buttons.LEFT))
			{
				isMousePress = false;
			}
		} 
		
		game.button.isInRange(Gdx.input.getX(), Gdx.input.getY()); //[Tran] Always call this to check if the mouse is in range of any buttons.
			
		
		
		
		
		// [Alex] Because Talha TOLD ME TO!
		//game.curPlayer.renderText(text);			
	}
}
