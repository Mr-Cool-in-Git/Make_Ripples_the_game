package nk.makeripples.game;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Starter extends ApplicationAdapter {

    GameStateManager gam;
    SpriteBatch batch;

    @Override
    public void create () {
        batch = new SpriteBatch();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        gam = new GameStateManager();
        gam.push(new Start(gam));
    }

    @Override
    public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gam.update(Gdx.graphics.getDeltaTime());
        gam.render(batch);
    }
}
