package com.mygdx.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class obstacleGenerator
{
	public ArrayList<obstacle> obstacles = new ArrayList<obstacle>();

	float initSpeed = 11.0f;
	float curSpeed = initSpeed;
	float speedIncreaseVal = 1.0f;
	int curSpeedStage = 1;
	int maxSpeedIncreases = 12;

	float curTime = 0.0f;
	float breakTime = 3.0f;
	float timePerStage = 3.0f; // [Taj] 3 seconds

	float curGapSize = 196.0f;
	float maxGapSize = 196.0f;
	float minGapSize = 48.0f;
	float gapDecreaseAmount;
	int gapDecreaseStart = 12;
	int curGapStage = 1;
	int maxGapDecreases = 7;
	float timePerGapStage = 8.0f; // [Taj] 15 seconds
	
	boolean spawnNew = false;

	public obstacleGenerator()
	{
		gapDecreaseAmount = (maxGapSize - minGapSize) / maxGapDecreases;
		rockGenerationLoop();
		generateRocks();
	}

	public void generateRocks()
	{
		Random rand = new Random();
		int y = rand.nextInt(Gdx.graphics.getHeight()-((int) curGapSize));
		

		obstacle top = new obstacle(Gdx.graphics.getWidth(), y+curGapSize, 64,
				Gdx.graphics.getHeight(), curSpeed);
		obstacle bottom = new obstacle(Gdx.graphics.getWidth(), y - Gdx.graphics.getHeight(), 64, Gdx.graphics.getHeight(), curSpeed);

		obstacles.add(top);
		obstacles.add(bottom);
	}

	public void update()
	{
		if(obstacles.size() == 0) return;
		
		
		
		for(int i = 0; i < obstacles.size(); i++)
		{
			obstacles.get(i).update();
			if(obstacles.get(i).x < 0 - obstacles.get(i).width)
			{
				obstacles.get(i).die();
				spawnNew = true;
			}
		}		
				
		if(spawnNew == true)
		{

			Iterator<obstacle> i = obstacles.iterator();
			while(i.hasNext())
			{
				obstacle x = i.next();
				
				if(x.isDead() == true)
				{
					i.remove();
				}
			}


			spawnNew = false;
			generateRocks();
		}
		
	}

	public void render()
	{
		for(obstacle s : obstacles)
			s.render();
	}
	
	public void updateValues()
	{
		if (curSpeedStage < maxSpeedIncreases)
			updateSpeed();
		if (curSpeedStage >= gapDecreaseStart && curGapStage < maxGapDecreases)
			updateGap();
	}

	public void updateSpeed()
	{
		curSpeedStage++;
		curSpeed += speedIncreaseVal;
	}

	public void updateGap()
	{
		curGapStage++;
		curGapSize -= gapDecreaseAmount;
	}

	public void rockGenerationLoop()
	{
		if(curSpeedStage < maxSpeedIncreases)
		Timer.schedule(new Task()
		{
			public void run()
			{
				updateValues();
				rockGenerationLoop();
			} 
			

		}, timePerStage);
		else
			Timer.schedule(new Task()
			{
				public void run()
				{
					updateValues();
					rockGenerationLoop();
				} 
				

			}, timePerGapStage);

	}
}
