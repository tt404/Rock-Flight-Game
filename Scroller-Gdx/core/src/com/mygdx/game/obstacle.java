package com.mygdx.game;

import java.awt.geom.Rectangle2D;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

//[Taj] This class will have everything obstacle related, its just skeleton
//code for now.
public class obstacle
{
	
	float x;
	float y;
	float width;
	float height;
	float movementSpeed;
	
	Rectangle hitbox;
	ShapeRenderer obstacleRender;
	
	boolean dead = false;
	
	// [Taj] Initializer.
	public obstacle(float x, float y, float width, float height, float speed)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.movementSpeed = speed;
		
		hitbox = new Rectangle();
		obstacleRender = new ShapeRenderer();
		
		hitbox.set(x, y, width, height);
	}
	
	// [Taj] This updates things like coordinates.
	public void update()
	{
		// [Taj] Make it go left.
		this.x -= movementSpeed;
	}
	
	// [Taj] Render the actual obstacle here.
	public void render()
	{
		// [Taj] For debugging...
		//System.out.println("x: " + x + " y: " + y + " width: " + width + " height: " + height);
		obstacleRender.begin(ShapeType.Filled);
		obstacleRender.setColor(Color.GREEN);
		obstacleRender.rect(x, y, width, height);
		obstacleRender.end();
	}

	public void die()
	{
		dead = true;
	}
	
	public boolean isDead()
	{
		return dead;
	}
}
