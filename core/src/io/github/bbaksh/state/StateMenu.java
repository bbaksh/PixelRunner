package io.github.bbaksh.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Brandon on 2016-01-15.
 */
public class StateMenu extends State {
    private Texture background;
    private Texture playButton;

    public StateMenu(GameStateManager gsm) {
        super(gsm);
        background = new Texture("background.png");
        playButton = new Texture("play.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new StatePlay(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background,0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        sb.draw(playButton, Gdx.graphics.getWidth()/2 - playButton.getWidth()/2,Gdx.graphics.getHeight()/2 - playButton.getHeight()/2);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
    }
}
