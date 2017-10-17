package nk.makeripples.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class State {

    protected GameStateManager gam;
    protected OrthographicCamera camera;

    public State(GameStateManager gam){
        this.gam = gam;
        camera = new OrthographicCamera();
    }

    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();
}
