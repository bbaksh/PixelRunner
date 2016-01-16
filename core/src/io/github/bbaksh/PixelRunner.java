package io.github.bbaksh;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import io.github.bbaksh.state.GameStateManager;
import io.github.bbaksh.state.StateMenu;

public class PixelRunner extends ApplicationAdapter {
	//Used for Desktop mode...
	public static final int WIDTH = 800;
	public static final int HEIGHT = 480;
	public static final String TITLE = "Pixel Runner";

	//Gameloop variables
	private GameStateManager gsm;
	private SpriteBatch batch;

	@Override
	public void create () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		gsm.push(new StateMenu(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
}
