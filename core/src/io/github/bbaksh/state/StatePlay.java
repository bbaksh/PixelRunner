package io.github.bbaksh.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import io.github.bbaksh.sprites.Obstacle;
import io.github.bbaksh.sprites.Runner;

/**
 * Created by Brandon on 2016-01-15.
 */
public class StatePlay extends State {
    public static final int MIN_OBSTACLE_SPACING = 125;
    public static final int OBSTACLE_COUNT = Gdx.graphics.getWidth() / MIN_OBSTACLE_SPACING;

    private Texture background;
    private Runner runner;
    private Array<Obstacle> obstacles;

    protected StatePlay(GameStateManager gsm) {
        super(gsm);
        background = new Texture("background.png");
        runner = new Runner(0,85);
        obstacles = new Array<Obstacle>();
        for(int i = 1; i<=OBSTACLE_COUNT ; ++i){
            obstacles.add(new Obstacle(i * (MIN_OBSTACLE_SPACING + Obstacle.OBSTACLE_WIDTH)));
        }
        camera.setToOrtho(false, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()*5/8);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            runner.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        runner.update(dt);
        camera.position.x = runner.getPosition().x + 250;
        for(Obstacle obstacle : obstacles){
            if(camera.position.x - (camera.viewportWidth/2)>obstacle.getPosition().x + Obstacle.OBSTACLE_WIDTH){
                obstacle.reposition(obstacle.getPosition().x + (Obstacle.OBSTACLE_WIDTH + MIN_OBSTACLE_SPACING)*OBSTACLE_COUNT);
            }
        }
        camera.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(background,camera.position.x - (camera.viewportWidth/2),0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        sb.draw(runner.getRunner(),runner.getPosition().x,runner.getPosition().y);
        for(Obstacle obstacle: obstacles){
            sb.draw(obstacle.getObstacle(),obstacle.getPosition().x,obstacle.getPosition().y);
        }
        sb.end();
    }

    @Override
    public void dispose() {
        runner.dispose();
    }
}
