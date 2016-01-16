package io.github.bbaksh.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by Brandon on 2016-01-15.
 */
public class Obstacle {
    public static final int OBSTACLE_WIDTH = 80;
    private static final int FLUCTUATION = 300;
    private static final int LOWEST_POSITION = 85;

    private Texture obstacle;
    private Vector2 position;
    private Random rand;

    public Obstacle(float x){
        rand = new Random();
        obstacle = new Texture("badlogic.jpg");
        position = new Vector2(x,rand.nextInt(FLUCTUATION) + LOWEST_POSITION);
    }

    public Texture getObstacle(){
        return obstacle;
    }

    public Vector2 getPosition(){
        return position;
    }

    public void dispose(){
        obstacle.dispose();
    }

    public void reposition(float x){
        position.set(x,rand.nextInt(FLUCTUATION) + LOWEST_POSITION);
    }
}

