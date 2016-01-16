package io.github.bbaksh.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Brandon on 2016-01-15.
 */
public class Runner {
    private static final float GRAVITY = -10;
    private static int MOVEMENT = 100;
    private Vector2 position;
    private Vector2 velocity;
    private Texture runner;

    public Runner(int x, int y){
        position = new Vector2(x,y);
        velocity = new Vector2(0,0);
        runner = new Texture("runner.png");
    }

    public void jump(){
        velocity.y = 450;
    }

    public void update(float dt){
        if(position.y >= 85) {
            velocity.add(0, GRAVITY);
            velocity.scl(dt);
            position.add(MOVEMENT*dt, velocity.y);
            velocity.scl(1 / dt);
            if (position.y < 85) {
                position.y = 85;
            }
        }
    }


    public Vector2 getPosition(){
        return position;
    }

    public Texture getRunner(){
        return runner;
    }

    public void dispose(){
        runner.dispose();
    }
}
