package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

// [Taj] Background related work goes here.
public class background
{
	rockDodge game;
	private int r; // Red
	private int g; // Green
	private int b; // Blue
	private int a; // Alpha (transparency)
	
	public background(rockDodge game)
	{
		this.game = game;
		this.r = 0;
		this.g = 0;
		this.b = 0;
		this.a = 0;
	}
	
	public void setColor(int r, int g, int b, int a)
	{
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	
	
	
	public void update()
	{
		
	}
	
	public void render()
	{
		Gdx.gl.glClearColor(r, g, b, a);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
}
