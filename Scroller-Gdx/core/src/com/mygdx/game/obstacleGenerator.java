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

	float initSpeed = 8.0f;
	float curSpeed = 8.0f;
	float speedIncreaseVal = 6.0f;
	int curSpeedStage = 1;
	int maxSpeedIncreases = 8;

	float curTime = 0.0f;
	float breakTime = 3.0f;
	float timePerStage = 15.0f; // [Taj] 15 seconds

	float curGapSize = 196.0f;
	float maxGapSize = 196.0f;
	float minGapSize = 48.0f;
	float gapDecreaseAmount;
	int gapDecreaseStart = 4;
	int curGapStage = 1;
	int maxGapDecreases = 8;
	
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
		Timer.schedule(new Task()
		{
			public void run()
			{
				updateValues();
				System.out.println("test");
				rockGenerationLoop();
			} 
			

		}, 5.0f);

	}
}
