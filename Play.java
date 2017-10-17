package nk.makeripples.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Play extends State implements Screen{

    int ExtraScore = 0; int Total = 0, otstupEnd = 0, otstupEndRecord = 0, Record = 0;

    int Ending = 0;

    Viewport viewport;

    TextureAtlas AtlasBird,AtlasBirdG,AtlasBirdR,AtlasBirdP;
    Animation AnimBird, AnimBirdG,AnimBirdR,AnimBirdP;
    float birdfly = 0;
    int speedBird = 2;
    int fallspeed = 0;
    float birdrotation = 0;

    Texture Bg1, Voda,End2, Kamen,Kamend,KamenA, razvod, Bg1Day, Bg2Day, Bg3Day, Bg4Day, Starter,Starter2, Plane, Planed, KK, Ship, Shipd , Shipdd, End1, NewRecord, Fetil, birdD,birdDR,birdDP,birdDG, Ufo, UfoD, PaperPlane, BalB, BalP, BalY;
    Rectangle RectKamen, RectPlane, RectKK, RectShip, RectBird, RectUFO,RectUFOCatch, RectPaperPlane, RectBal;
    Vector2 vodapos1, vodapos2, Bg1pos1, Bg1pos2, Bg2pos1, Bg2pos2, Bg3pos1, Bg3pos2, Bg4pos1, Bg4pos2, position, speed, positionPlane, posKK, posShip, posBird, posUFO, posPaperPlane, posBal;
    BitmapFont font, Numbers, fontbutton;

    double fetilotstup = 0;

    // Money
    int Money = 0;
    int TotalMoney = 0;
    int save = 0;

    // Pancakes
    int Pancakes = 0;

    // Lang
    int flag;

    Sound sball, sbird, sbul, sbulk, scan, scrbird, scrplane, scrufo, sfallkamen, splane, sship, sufo, skk, sbut;
    Music sbg;
    int sballC = 0, sbirdC = 0, sbulC = 0, sbulkC = 0, scrbirdC = 0, scrplaneC = 0, scrufoC = 0, sfallkamenC = 0, splaneC = 0, sshipC = 0, sufoC = 0, skkC = 0, sbutC = 0;

    // 1 - утонул, 2 - пойман Нло
    int DeadAction;
    float Visible = 1;

    int CheckFon;

    int Timer = 0;
    double timer = 4;

    // Рандом для шарика
    int RandomBaloon = MathUtils.random(1,3);

    // Choise
    int ActionChoise = 0;

    // PaperPlane
    int highpoint, lowpoint; double GravityPaperPlane = 2; Vector2 speedPaperPlane; double rotationPP;

    // Bonus  (BonusLife = BonusLifes + 1)
    int BonusSpeed = 0, BonusJump = 0, BonusLife = 1;
    double BonusExtra = 1, BonusScore = 1, BonusGravity = 0;

    int EventPlane = 0, EventShip = 0, EventBird = 0, EventUFO = 0, EventPaperPlane = 0, EventBal = 0;
    double TimeEvent = 0;

    int life = 2, curheight = 0 ,highjump = 0, speedjump = 0,rotationShip = 0, rotation = 0, rotationPlane = 0,checkpoint = 0, checkBg2 = 0, checkBg3 = 0, checkBg4 = 0, lvl = 0, BlockPlane = 0, BlockShip = 0, BlockBird = 0, BlockUFO = 0, BlockPaperPlane = 0;
    int rotationUFO = 0;
    double Gravity = 0.05, GravityPlane = 0;
    private Sprite spriteKamen, spritePlane, spriteKuv, spriteShip, spriteBirdDead, spriteUFO, spritePaperPlane, spriteBal;
    Array<Sprite> krugi;

    int Moving = 1; // 1 - Myself, 2 - by Boat, 3 - by Paper Plane
    int Rand;
    int RandBird = 1;
    int Soundpol;

    Preferences Base;
    String Hero;

    private Stage stage;
    private TextureAtlas buttonsAtlas;
    private Skin buttonSkin;
    private TextButton button;
    private TextureAtlas buttonsAtlas2;
    private Skin buttonSkin2;
    private TextButton button2;
    private TextureAtlas buttonsAtlas3;
    private Skin buttonSkin3;
    private TextButton button3;

    public Play(GameStateManager gam) {
        super(gam);

        // Camera
        viewport = new FillViewport(800,480,camera);
        viewport.apply();

        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        // Textures
        Fetil = new Texture("fetil.png");
        PaperPlane = new Texture("paperplane.png");
        BalB = new Texture("baloonblue.png");
        BalP = new Texture("baloonpink.png");
        BalY = new Texture("baloonyellow.png");
        NewRecord = new Texture("newrecord.png");
        Ship = new Texture("ship1.png");
        Ufo = new Texture("ufoalive.png");
        UfoD = new Texture("ufodead.png");
        Shipd = new Texture("ship1d.png");
        Shipdd = new Texture("ship1dd.png");
        KK = new Texture("kuvshinka.png");
        razvod = new Texture("razvod3.png");
        Plane = new Texture("plane.png");
        Planed = new Texture("plane2.png");
        // Sounds
        scan = Gdx.audio.newSound(Gdx.files.internal("soundcannon.mp3"));
        sbird = Gdx.audio.newSound(Gdx.files.internal("ss1.mp3"));
        scrbird = Gdx.audio.newSound(Gdx.files.internal("soundcrashbird.mp3"));
        sball = Gdx.audio.newSound(Gdx.files.internal("soundball.mp3"));
        sbul = Gdx.audio.newSound(Gdx.files.internal("soundbul.mp3"));
        sbulk = Gdx.audio.newSound(Gdx.files.internal("soundbulk.mp3"));
        splane = Gdx.audio.newSound(Gdx.files.internal("soundplane.mp3"));
        scrplane = Gdx.audio.newSound(Gdx.files.internal("soundcrashplane.mp3"));
        sufo = Gdx.audio.newSound(Gdx.files.internal("soundufo.mp3"));
        scrufo = Gdx.audio.newSound(Gdx.files.internal("soundcrashufo.mp3"));
        sship = Gdx.audio.newSound(Gdx.files.internal("soundship.mp3"));
        Rand = MathUtils.random(1, 2);
        skk = Gdx.audio.newSound(Gdx.files.internal("soundkk.mp3"));
        sbut = Gdx.audio.newSound(Gdx.files.internal("soundbutton.mp3"));
        // Hero Textures
        Base = Gdx.app.getPreferences("GameBase");
        CheckFon = Base.getInteger("Fon");
        if (CheckFon == 1) {
            Bg1 = new Texture("bg111.png");
            Bg1Day = new Texture("fg1111.png");
            Bg2Day = new Texture("fg2222.png");
            Bg3Day = new Texture("fg3333.png");
            Bg4Day = new Texture("fg4444.png");
            KK = new Texture("kuvshinka.png");
            Voda = new Texture("water3.png");
            Starter = new Texture("cannon.png");
            Starter2 = new Texture("cannonbah.png");
        }
        if (CheckFon == 2) {
            Bg1 = new Texture("bg11.png");
            Bg1Day = new Texture("fg1111.png");
            Bg2Day = new Texture("fg2222.png");
            Bg3Day = new Texture("fg3333.png");
            Bg4Day = new Texture("fg4444.png");
            KK = new Texture("kuvshinka.png");
            Voda = new Texture("water3.png");
            Starter = new Texture("cannon.png");
            Starter2 = new Texture("cannonbah.png");
        }
        if (CheckFon == 3) {
            Bg1 = new Texture("bgfon2017.png");
            Bg1Day = new Texture("fg20171.png");
            Bg2Day = new Texture("fg20172.png");
            Bg3Day = new Texture("fg20173.png");
            Bg4Day = new Texture("fg20174.png");
            KK = new Texture("kuvshinka2017.png");
            Voda = new Texture("water2017.png");
            Starter = new Texture("cannon2017.png");
            Starter2 = new Texture("cannonbah2017.png");
        }
        switch (CheckFon) {
            case 1:
              switch (Rand) {
                  case 1:
                      sbg = Gdx.audio.newMusic(Gdx.files.internal("music2.mp3"));
                      break;
                  case 2:
                      sbg = Gdx.audio.newMusic(Gdx.files.internal("music5.mp3"));
                      break;
              }
                break;
            case 2:
                switch (Rand) {
                    case 1:
                        sbg = Gdx.audio.newMusic(Gdx.files.internal("soundfon2.mp3"));
                        break;
                    case 2:
                        sbg = Gdx.audio.newMusic(Gdx.files.internal("music3.mp3"));
                        break;
                }
                break;
            case 3:
                switch (Rand) {
                    case 1:
                        sbg = Gdx.audio.newMusic(Gdx.files.internal("mus2017.mp3"));
                        break;
                    case 2:
                        sbg = Gdx.audio.newMusic(Gdx.files.internal("mus2017.mp3"));
                        break;
                }
                break;

        }
        Hero = Base.getString("Hero");
        flag = Base.getInteger("Language");
        if (flag == 1) {
            End1 = new Texture("ending11.png");
            End2 = new Texture("ending22.png");
        } else {
            End1 = new Texture("ending11ru.png");
            End2 = new Texture("ending22ru.png");
        }
        Soundpol = Base.getInteger("Soundpool");
        TotalMoney = Base.getInteger("Money", 0);
        Record = Base.getInteger("Record", 0);
        switch (Integer.valueOf(Hero)){
            case 1:
                Kamen = new Texture("rock2.png");
                Kamend = new Texture("rock2d.png");
                KamenA = new Texture("rock2A.png");
                sfallkamen = Gdx.audio.newSound(Gdx.files.internal("soundfallkamen.mp3"));
                BonusSpeed = 1;
                BonusJump = 1;
                break;
            case 2:
                Kamen = new Texture("rockaki.png");
                Kamend = new Texture("rockakid.png");
                KamenA = new Texture("rockakiA.png");
                sfallkamen = Gdx.audio.newSound(Gdx.files.internal("soundfallgirl.mp3"));
                BonusGravity = -0.25;
                BonusSpeed = 1;
                BonusJump = 1;
                break;
            case 3:
                Kamen = new Texture("rockracer.png");
                Kamend = new Texture("rockracerd.png");
                KamenA = new Texture("rockracerA.png");
                sfallkamen = Gdx.audio.newSound(Gdx.files.internal("soundfallman.mp3"));
                BonusSpeed = 2;
                BonusJump = 1;
                break;
            case 4:
                Kamen = new Texture("rockfrog.png");
                Kamend = new Texture("rockfrogd.png");
                KamenA = new Texture("rockfrogA.png");
                sfallkamen = Gdx.audio.newSound(Gdx.files.internal("soundfallkamen.mp3"));
                BonusJump = 2;
                BonusSpeed = 1;
                break;
            case 5:
                Kamen = new Texture("rocknavi.png");
                Kamend = new Texture("rocknavid.png");
                KamenA = new Texture("rocknaviA.png");
                sfallkamen = Gdx.audio.newSound(Gdx.files.internal("soundfallkamen.mp3"));
                BonusLife = 2;
                BonusSpeed = 1;
                BonusJump = 1;
                break;
            case 6:
                Kamen = new Texture("rockmark.png");
                Kamend = new Texture("rockmarkd.png");
                KamenA = new Texture("rockmarkA.png");
                sfallkamen = Gdx.audio.newSound(Gdx.files.internal("soundfallman.mp3"));
                BonusExtra = 2;
                BonusSpeed = 1;
                BonusJump = 1;
                break;
            case 7:
                Kamen = new Texture("rock7.png");
                Kamend = new Texture("rock7d.png");
                KamenA = new Texture("rock7A.png");
                sfallkamen = Gdx.audio.newSound(Gdx.files.internal("soundfallkamen.mp3"));
                BonusScore = 1.5;
                BonusSpeed = 1;
                BonusJump = 1;
                break;
            case 8:
                Kamen = new Texture("rock8.png");
                Kamend = new Texture("rock8d.png");
                KamenA = new Texture("rock8A.png");
                sfallkamen = Gdx.audio.newSound(Gdx.files.internal("soundfallman.mp3"));
                BonusLife = 3;
                BonusGravity = 0.25;
                BonusSpeed = 1;
                BonusJump = 1;
                break;
            case 9:
                Kamen = new Texture("rock9.png");
                Kamend = new Texture("rock9d.png");
                KamenA = new Texture("rock9A.png");
                sfallkamen = Gdx.audio.newSound(Gdx.files.internal("soundfallman.mp3"));
                BonusJump = 1;
                BonusSpeed = 1;
                BonusGravity = 0.25;
                BonusScore = 1.2;
                break;
            case 10:
                Kamen = new Texture("rock10.png");
                Kamend = new Texture("rock10d.png");
                KamenA = new Texture("rock10A.png");
                sfallkamen = Gdx.audio.newSound(Gdx.files.internal("soundfallkamen.mp3"));
                BonusJump = 1;
                BonusSpeed = 2;
                break;
            case 11:
                Kamen = new Texture("rock11.png");
                Kamend = new Texture("rock11d.png");
                KamenA = new Texture("rock11A.png");
                sfallkamen = Gdx.audio.newSound(Gdx.files.internal("soundfallkamen.mp3"));
                BonusJump = 1;
                BonusSpeed = 1;
                BonusLife = 3;
                break;
            case 12:
                Kamen = new Texture("rock12.png");
                Kamend = new Texture("rock12d.png");
                KamenA = new Texture("rock12A.png");
                sfallkamen = Gdx.audio.newSound(Gdx.files.internal("soundfallkamen.mp3"));
                BonusExtra = 1.5;
                BonusScore = 1.5;
                BonusSpeed = 1;
                BonusJump = 1;
                break;
            case 13:
                Kamen = new Texture("rock13.png");
                Kamend = new Texture("rock13d.png");
                KamenA = new Texture("rock13A.png");
                sfallkamen = Gdx.audio.newSound(Gdx.files.internal("soundfallman.mp3"));
                BonusJump = 2;
                BonusSpeed = 1;
                BonusScore = 1.5;
                break;
            case 14:
                Kamen = new Texture("stonecat1.png");
                Kamend = new Texture("stonecat1d.png");
                KamenA = new Texture("stonecat1A.png");
                sfallkamen = Gdx.audio.newSound(Gdx.files.internal("soundc3.mp3"));
                BonusGravity = -0.25;
                BonusLife = 8;
                break;
            case 15:
                Kamen = new Texture("stonecat2.png");
                Kamend = new Texture("stonecat2d.png");
                KamenA = new Texture("stonecat2A.png");
                sfallkamen = Gdx.audio.newSound(Gdx.files.internal("soundc1.mp3"));
                BonusJump = 1;
                BonusSpeed = 1;
                BonusGravity = -0.25;
                BonusLife = 4;
                break;
            case 16:
                Kamen = new Texture("stonecat3.png");
                Kamend = new Texture("stonecat3d.png");
                KamenA = new Texture("stonecat3A.png");
                sfallkamen = Gdx.audio.newSound(Gdx.files.internal("soundc2.mp3"));
                BonusJump = 2;
                BonusSpeed = 2;
                BonusLife = 4;
                break;
            case 17:
                Kamen = new Texture("stonecat4.png");
                Kamend = new Texture("stonecat4d.png");
                KamenA = new Texture("stonecat4A.png");
                sfallkamen = Gdx.audio.newSound(Gdx.files.internal("soundc1.mp3"));
                BonusJump = 1;
                BonusSpeed = 1;
                BonusLife = 9;
                break;
            case 18:
                Kamen = new Texture("nystone1.png");
                Kamend = new Texture("nystone1d.png");
                KamenA = new Texture("nystone1A.png");
                sfallkamen = Gdx.audio.newSound(Gdx.files.internal("soundfallkamen.mp3"));
                BonusSpeed = 2;
                break;
            case 19:
                Kamen = new Texture("nystone2.png");
                Kamend = new Texture("nystone2d.png");
                KamenA = new Texture("nystone2A.png");
                sfallkamen = Gdx.audio.newSound(Gdx.files.internal("soundfallkamen.mp3"));
                BonusLife = 3;
                break;
            case 20:
                Kamen = new Texture("nystone3.png");
                Kamend = new Texture("nystone3d.png");
                KamenA = new Texture("nystone3A.png");
                sfallkamen = Gdx.audio.newSound(Gdx.files.internal("soundfallkamen.mp3"));
                BonusJump = 2;
                break;
        }
        // Positions
        position = new Vector2(80,325);
        positionPlane = new Vector2(5000, MathUtils.random(480 + 240, 480 * 2 + 200));
        posKK = new Vector2(2500, 175);
        posPaperPlane = new Vector2(5000, 480);
        posShip = new Vector2(10000, 190);
        posBal = new Vector2(9000, MathUtils.random(480 - 100, 480 * 3));
        posUFO = new Vector2(15000, MathUtils.random(480 * 2 - 100, 480 * 2 + 400));
        // Rock velocity
        speed = new Vector2(15, 0);
        // Atlas
        RandBird = MathUtils.random(1,4);
        AtlasBird = new TextureAtlas(Gdx.files.internal("atlasbird.atlas"));
        AnimBird = new Animation(0.1f, AtlasBird.getRegions());

        AtlasBirdP = new TextureAtlas(Gdx.files.internal("atlasbirdp.atlas"));
        AnimBirdP = new Animation(0.1f, AtlasBirdP.getRegions());

        AtlasBirdR = new TextureAtlas(Gdx.files.internal("atlasbirdr.atlas"));
        AnimBirdR = new Animation(0.1f, AtlasBirdR.getRegions());

        AtlasBirdG = new TextureAtlas(Gdx.files.internal("atlasbirdg.atlas"));
        AnimBirdG = new Animation(0.1f, AtlasBirdG.getRegions());

        birdD = new Texture("b4.png");
        birdDR = new Texture("bdr.png");
        birdDP = new Texture("bdp.png");
        birdDG = new Texture("bdg.png");

        switch (RandBird){
            case 1:
                spriteBirdDead = new Sprite(birdD);
                break;
            case 2:
                spriteBirdDead = new Sprite(birdDR);
                break;
            case 3:
                spriteBirdDead = new Sprite(birdDP);
                break;
            case 4:
                spriteBirdDead = new Sprite(birdDG);
                break;
        }

        // PaperPlane
        speedPaperPlane = new Vector2(10, (float)2);
        // Fon positions
        vodapos1 = new Vector2(camera.position.x - camera.viewportWidth / 2, 0);
        vodapos2 = new Vector2((camera.position.x - camera.viewportWidth / 2) + Voda.getWidth(), 0);
        Bg1pos1 = new Vector2(camera.position.x - camera.viewportWidth / 2, 0);
        Bg1pos2 = new Vector2((camera.position.x - camera.viewportWidth / 2) + Bg1Day.getWidth(), 0);
        Bg2pos1 = new Vector2(Bg1Day.getWidth() * 10, 0);
        Bg2pos2 = new Vector2(Bg1Day.getWidth() * 11, 0);
        Bg3pos1 = new Vector2(Bg1Day.getWidth() * 40, 0);
        Bg3pos2 = new Vector2(Bg1Day.getWidth() * 41, 0);
        Bg4pos1 = new Vector2(Bg1Day.getWidth() * 70, 0);
        Bg4pos2 = new Vector2(Bg1Day.getWidth() * 71, 0);
        posBird = new Vector2(MathUtils.random(1000, 5000), MathUtils.random(360, 680));
        highpoint = (int)posPaperPlane.y + 100;
        lowpoint = (int)posPaperPlane.y - 100;
        // Skills
        highjump = 15;
        speedjump = 15;
        // Rectangles
        RectPlane = new Rectangle(positionPlane.x , positionPlane.y, Plane.getWidth(), Plane.getHeight());
        RectKamen = new Rectangle(position.x, position.y, Kamen.getWidth(), Kamen.getHeight());
        RectKK = new Rectangle(posKK.x, posKK.y, KK.getWidth(), KK.getHeight());
        RectShip = new Rectangle(posShip.x, posShip.y, Ship.getWidth(), Ship.getHeight());
        RectBird = new Rectangle(posBird.x,posBird.y, 80, 80);
        RectBal = new Rectangle(posBal.x, posBal.y + 70, 40, 50);
        RectPaperPlane = new Rectangle(posPaperPlane.x, posPaperPlane.y, PaperPlane.getWidth(), PaperPlane.getHeight());
        RectUFOCatch = new Rectangle(posUFO.x, posUFO.y, Ufo.getWidth(), Ufo.getHeight()/2);
        RectUFO = new Rectangle(posUFO.x, posUFO.y + 66, Ufo.getWidth(), Ufo.getHeight()/2);
        // Fonts
        font = new BitmapFont(Gdx.files.internal("font008.fnt"));
        fontbutton = new BitmapFont(Gdx.files.internal("font007.fnt"));
        Numbers = new BitmapFont(Gdx.files.internal("numbers.fnt"));
        // Array
        krugi = new Array<Sprite>();
        // Sprites
        spriteKamen = new Sprite(Kamen);
        spritePlane = new Sprite(Plane);
        spriteKuv = new Sprite(KK);
        spriteShip = new Sprite(Ship);
        spriteUFO = new Sprite(Ufo);
        spritePaperPlane = new Sprite(PaperPlane);
        switch (RandomBaloon) {
            case 1:
                spriteBal = new Sprite(BalB);
                break;
            case 2:
                spriteBal = new Sprite(BalY);
                break;
            case 3:
                spriteBal = new Sprite(BalP);
                break;
        }

        // Stage
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);

        buttonsAtlas = new TextureAtlas("butexit.pack");
        buttonSkin = new Skin();
        buttonSkin.addRegions(buttonsAtlas);
        buttonsAtlas2 = new TextureAtlas("butrestart.pack");
        buttonSkin2 = new Skin();
        buttonSkin2.addRegions(buttonsAtlas2);
        buttonsAtlas3 = new TextureAtlas("tap.pack");
        buttonSkin3 = new Skin();
        buttonSkin3.addRegions(buttonsAtlas3);

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.up = buttonSkin.getDrawable("butexit");
        style.down = buttonSkin.getDrawable("butexit");
        style.font = fontbutton;

        TextButton.TextButtonStyle style2 = new TextButton.TextButtonStyle();
        style2.up = buttonSkin2.getDrawable("butrestart");
        style2.down = buttonSkin2.getDrawable("butrestart");
        style2.font = fontbutton;

        TextButton.TextButtonStyle style3 = new TextButton.TextButtonStyle();
        style3.up = buttonSkin3.getDrawable("tap");
        style3.down = buttonSkin3.getDrawable("tap");
        style3.font = fontbutton;

        TextButton.TextButtonStyle style3R = new TextButton.TextButtonStyle();
        style3R.up = buttonSkin3.getDrawable("tapRU");
        style3R.down = buttonSkin3.getDrawable("tapRU");
        style3R.font = fontbutton;

        button = new TextButton("", style);
        button.setPosition(camera.position.x, camera.position.y);
        button.setVisible(false);
        button.setSize(70, 70);

        button2 = new TextButton("", style2);
        button2.setPosition(camera.position.x, camera.position.y);
        button2.setVisible(false);
        button2.setSize(70, 70);

        if(flag == 1)
        button3 = new TextButton("", style3);
        else button3 = new TextButton("", style3R);
        button3.setPosition(camera.position.x + 160, camera.position.y - 220);
        button3.setVisible(true);

        button.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (sbutC == 0) {
                    if (Soundpol == 1)
                    sbut.play();
                    sbutC = 1;
                }
                ActionChoise = 1;
            }
        });

        button2.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                if (sbutC == 0) {
                    if (Soundpol == 1)
                    sbut.play();
                    sbutC = 1;
                }
                ActionChoise = 2;
            }

        });

        button3.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                if (sbutC == 0) {
                    if (Soundpol == 1)
                    sbut.play();
                    sbutC = 1;
                }
                Timer = 1;
                button3.setVisible(false);
            }

        });
        Gdx.input.setCatchBackKey(true);
        stage.addActor(button);
        stage.addActor(button2);
        stage.addActor(button3);
        if (Soundpol == 1) {
        sbg.setLooping(true);
        sbg.play();
        }
    }

    public void SoundCannonOn(){
        if (Soundpol == 1)
        scan.play();
    }
    public void SoundBirdOn(){
        if (Soundpol == 1)
        sbird.play();
    }

    @Override
    public void update(float dt) {
        updateWaterandFon();

        boolean backPressed = Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.BACK);
        if (backPressed){
            Base.putInteger("GameStatus", 1);
            Base.flush();
            gam.set(new Start(gam));
        }

        if (ActionChoise == 1) {
            Base.putInteger("GameStatus", 1);
            Base.flush();
            gam.set(new Start(gam));
        }
        if (ActionChoise == 2)
            gam.set(new Play(gam));

        birdfly += Gdx.graphics.getDeltaTime();

        // SOUNDPOOL
        if ((posBird.x > camera.position.x - camera.viewportWidth/2 && posBird.x < camera.position.x + camera.viewportWidth/2) && (posBird.y > camera.position.y - camera.viewportHeight/2 && posBird.y < camera.position.y + camera.viewportHeight/2)){
            if (sbirdC == 0) {
                SoundBirdOn();
            }
            sbirdC = 1;
        }
        if (posBird.x < camera.position.x - camera.viewportWidth/2){
            sbirdC = 0;
        }
        if ((positionPlane.x > camera.position.x - camera.viewportWidth/2 && positionPlane.x < camera.position.x + camera.viewportWidth/2)&&(positionPlane.y > camera.position.y - camera.viewportHeight/2 && positionPlane.y < camera.position.y + camera.viewportHeight/2)){
            if (splaneC == 0) {
                if (Soundpol == 1)
                splane.play();
            }
            splaneC = 1;
        }
        if (positionPlane.x < camera.position.x - camera.viewportWidth/2){
            splaneC = 0;
        }
        if ((posUFO.x > camera.position.x - camera.viewportWidth/2 && posUFO.x < camera.position.x + camera.viewportWidth/2)&&(posUFO.y > camera.position.y - camera.viewportHeight/2 && posUFO.y < camera.position.y + camera.viewportHeight/2)){
            if (sufoC == 0) {
                if (Soundpol == 1)
                sufo.play();
            }
            sufoC = 1;
        }
        if (posUFO.x < camera.position.x - camera.viewportWidth/2){
            sufoC = 0;
        }

        // LIFE 2

        if (life == 2) {
            if(Timer == 1) {
                button3.setPosition(camera.position.x, camera.position.y - 100);
                if (timer == 4){
                    SoundCannonOn();
                }
                timer = timer - 0.02;
                fetilotstup += 0.06;
            }
            if (timer < 0.5){
                life = 1;
                Timer = 0;
            }

            // LIFE 2 END

        } else {

            if (speedjump == 0 || highjump == 0) {
                life = 0;
                DeadAction = 1;
            }

            // LIFE 1

            if (life == 1) {
                if (position.y > 230)
                    camera.position.y = position.y + Kamen.getHeight()/2;

                if (Gdx.input.isTouched()) {
                    if (Moving == 2){
                        BlockShip = 1;
                        speed.y = highjump;
                        Moving = 1;
                    }
                    if (Moving == 3){
                        BlockPaperPlane = 1;
                        Moving = 1;
                        speed.x = speedjump/2;
                        speed.y = highjump/2;
                    }
                    if (position.y <= 220 && position.y >= 193) {
                        Gravity = 1 + BonusGravity;
                        if (position.y <= 220 && position.y >= 210) {
                            speedjump -= 0.5;
                            highjump -= 0.5;
                            speed.x = speedjump;
                            speed.y = highjump;
                        }
                        if (position.y <= 209 && position.y >= 200) {
                            speedjump += 1 + BonusSpeed;
                            highjump += 1 + BonusJump;
                            speed.x = speedjump;
                            speed.y = highjump;
                        }
                        if (position.y <= 199 && position.y >= 193) {
                            speedjump += 2 + BonusSpeed;
                            highjump += 2 + BonusJump;
                            speed.x = speedjump;
                            speed.y = highjump;
                        }
                        Pancakes += 1;
                        kruginavode();
                        if (sbulC == 0){
                            if (Soundpol == 1)
                            sbul.play();
                            sbulC = 1;
                        }
                    } else {
                        sbulC = 0;
                    }
                }

                if (BonusGravity < 0) {
                    if (highjump > 40) {
                        highjump = 40;
                        speed.y = highjump;
                    }
                }

                if (BonusGravity >= 0){
                    if (highjump > 53) {
                        highjump = 53;
                        speed.y = highjump;
                    }
                }

                if (speedjump > 45) {
                    speedjump = 45;
                    speed.x = speedjump;
                }

                curheight = highjump;

                if (Moving == 1) {
                    switch ((int) speed.y) {
                        case -5:
                            rotation = -10;
                            break;
                        case -4:
                            rotation = -7;
                            break;
                        case -3:
                            rotation = -5;
                            break;
                        case -2:
                            rotation = -3;
                            break;
                        case -1:
                            rotation = -1;
                            break;
                        case 0:
                            rotation = 0;
                            break;
                        case 3:
                            rotation = 2;
                            break;
                        case 6:
                            rotation = 4;
                            break;
                        case 9:
                            rotation = 6;
                            break;
                        case 12:
                            rotation = 8;
                            break;
                        case 15:
                            rotation = 10;
                            break;
                    }
                }
            }

            // Paper Plane
            if ((Moving == 1) && (BlockPaperPlane == 0)){
                speedPaperPlane.x = 10;
                posPaperPlane.x += speedPaperPlane.x;
                posPaperPlane.y += speedPaperPlane.y;
                if (posPaperPlane.y >= highpoint)
                    speedPaperPlane.y = speedPaperPlane.y * (-1);
                if (posPaperPlane.y <= lowpoint)
                    speedPaperPlane.y = speedPaperPlane.y * (-1);
            }
            if ((Moving == 3) && (BlockPaperPlane == 0)){
                speedPaperPlane.x = speed.x + 5;
                speedPaperPlane.y = (float)GravityPaperPlane;
                if (GravityPaperPlane >= -1)
                GravityPaperPlane -= 0.1;
                posPaperPlane.x += speedPaperPlane.x;
                posPaperPlane.y += speedPaperPlane.y;
            }

            // LIFE 1 END

            // CHECKPOINTS
            if (position.x > Bg1Day.getWidth() * (90 + checkpoint)) {
                checkpoint = checkpoint + 100;
                lvl++;
            }

            // Collides
            if (RectKamen.overlaps(RectShip)) {
                if ((Moving == 1) && (BlockShip == 0)) {
                    spriteShip.setTexture(Shipd);
                    Moving = 2;
                    EventShip = 1;
                    TimeEvent = 0;
                    speedjump += 4;
                    highjump += 1;
                    if (sshipC == 0){
                        if (Soundpol == 1)
                        sship.play();
                        sshipC = 1;
                    }
                    speed.x = speedjump;
                    ExtraScore += 5;
                }
            }
            if (RectKamen.overlaps(RectBal)) {
                if (Moving == 1) {
                    EventBal = 1;
                    TimeEvent = 0;
                    ExtraScore += 1;
                    if (sballC == 0) {
                        if (Soundpol == 1)
                        sball.play();
                        sballC = 1;
                    }
                    RespawnBal();
                }
            }
            switch (RandomBaloon){
                case 1:
                    spriteBal.setTexture(BalB);
                    break;
                case 2:
                    spriteBal.setTexture(BalY);
                    break;
                case 3:
                    spriteBal.setTexture(BalP);
                    break;
            }
            if (RectKamen.overlaps(RectPaperPlane)) {
                if ((Moving == 1) && (BlockPaperPlane == 0)) {
                    Moving = 3;
                    TimeEvent = 0;
                    EventPaperPlane = 1;
                    ExtraScore += 5;
                }
            }
            if ((RectKamen.overlaps(RectBird)) && BlockBird == 0){
                ExtraScore += 15;
                TimeEvent = 0;
                BlockBird = 1;
                sbird.stop();
                if (scrbirdC == 0) {
                    if (Soundpol == 1)
                    scrbird.play();
                    scrbirdC = 1;
                }
                EventBird = 1;
                speedjump -= 5;
                highjump -= 3;
                speed.x = speedjump;
            }
            if ((RectKamen.overlaps(RectUFO)) && BlockUFO == 0){
                spriteUFO.setTexture(UfoD);
                TimeEvent = 0;
                ExtraScore += 100;
                sufo.stop();
                if (scrufoC == 0) {
                    if (Soundpol == 1)
                    scrufo.play();
                    scrufoC = 1;
                }
                BlockUFO = 1;
                EventUFO = 1;
                speedjump += 2;
                speed.x = speedjump;
            }
            if ((RectKamen.overlaps(RectUFOCatch)) && BlockUFO == 0){
                life = 0;
                DeadAction = 2;
            }
            if ((RectKamen.overlaps(RectPlane)) && BlockPlane == 0){
                spritePlane.setTexture(Planed);
                splane.stop();
                if (scrplaneC == 0) {
                    if (Soundpol == 1)
                    scrplane.play();
                    scrplaneC = 1;
                }
                GravityPlane = 2;
                TimeEvent = 0;
                ExtraScore += 30;
                BlockPlane = 1;
                EventPlane = 1;
            }
            if (EventBird == 1){
                TimeEvent += 0.03;
                EventShip = 0;
                EventPlane = 0;
                EventBal = 0;
                EventUFO = 0;
                EventPaperPlane = 0;
            }
            if (EventPlane == 1){
                TimeEvent += 0.03;
                EventShip = 0;
                EventBird = 0;
                EventBal = 0;
                EventUFO = 0;
                EventPaperPlane = 0;
            }
            if (EventShip == 1){
                TimeEvent += 0.03;
                EventPlane = 0;
                EventBal = 0;
                EventBird = 0;
                EventUFO = 0;
                EventPaperPlane = 0;
            }
            if (EventUFO == 1){
                TimeEvent += 0.03;
                EventPlane = 0;
                EventBird = 0;
                EventShip = 0;
                EventBal = 0;
                EventPaperPlane = 0;
            }
            if (EventPaperPlane == 1){
                TimeEvent += 0.03;
                EventPlane = 0;
                EventBird = 0;
                EventBal = 0;
                EventShip = 0;
                EventUFO = 0;
            }
            if (EventBal == 1){
                TimeEvent += 0.03;
                EventPlane = 0;
                EventPaperPlane = 0;
                EventBird = 0;
                EventShip = 0;
                EventUFO = 0;
            }
            if (TimeEvent >= 3){
                EventPlane = 0;
                EventShip = 0;
                EventBird = 0;
                EventUFO = 0;
                EventBal = 0;
                EventPaperPlane = 0;
                TimeEvent = 0;
            }
            if (RectPlane.x < camera.position.x - 800){
                RespawnPlane();
            }
            if (RectBird.x < camera.position.x - 800){
                RespawnBird();
            }
            if (RectUFO.x < camera.position.x - 800){
                RespawnUFO();
            }
            if (life == 1) {
                if ((RectKamen.overlaps(RectKK) && Moving == 1 && life == 1)) {
                    highjump += 4;
                    speedjump += 2;
                    speed.x = speedjump;
                    speed.y = highjump;
                    if ( skkC == 0){
                        if (Soundpol == 1)
                        skk.play();
                        skkC = 1;
                    }
                }
            }

            if (RectKK.x < position.x - 800) {
                RespawnKK();
                skkC = 0;
            }
            if ((posBal.x < position.x - 800) && Moving == 1){
                RespawnBal();
            }

            if ((posShip.x < position.x - 800) && Moving == 1){
                RespawnShip();
            }
            if ((posPaperPlane.x < position.x - 800) && Moving == 1){
                RespawnPP();
            }

            // MOVINGS
            if ((Moving == 2) && life == 1) {
                spriteKamen.setRotation(0);
                posShip.set(posShip.x + speed.x, (float)(posShip.y - 0.2));
                position.x = posShip.x + spriteShip.getWidth()/2 - Kamen.getWidth()/2;
                position.y = posShip.y + spriteShip.getHeight()/2 - 10;
            }

            if ((Moving == 3) && life == 1){
                spriteKamen.setRotation(0);
                position.x = posPaperPlane.x + spritePaperPlane.getWidth()/2 - Kamen.getWidth()/2;
                position.y = posPaperPlane.y + spritePaperPlane.getHeight()/2;
            }

            if (BlockPaperPlane == 1){
                if (speedPaperPlane.x >= 0)
                speedPaperPlane.x -= 0.5;
                posPaperPlane.x += speedPaperPlane.x;
                posPaperPlane.y -= 5;
                rotationPP -= 0.5;
            }

            if (BlockShip == 1){
                sship.stop();
                spriteShip.setTexture(Shipdd);
                posShip.y -= 5;
                if(posShip.x > 0)
                posShip.x -= 1;
                if(rotationShip > -90)
                rotationShip = rotationShip - 2;
                spriteShip.setRotation(rotationShip);
            }

            // Gravity
            if (Moving == 1 && (life == 1 || (life == 0 && DeadAction == 1))) {
                if (speed.y <= -5) {
                    speed.y = -5;
                } else {
                    speed.y -= Gravity;
                }
            }
            if (life == 0 && DeadAction == 2){
                Gravity = 0;
            }

            if (Moving == 1) {
                position.x = speed.x + position.x;
                position.y = speed.y + position.y;
            }

            // Lose
            if (position.y < 193) {
                Gravity = 1 + BonusGravity;
                if (BonusLife == 1) {
                    BonusLife = 0;
                    life = 0;
                    DeadAction = 1;
                    BlockShip = 1;
                    BlockPaperPlane = 1;
                    Moving = 1;
                }
                if (BonusLife > 1){
                    Pancakes += 1;
                    if (Moving == 2) {
                        BlockShip = 1;
                        Moving = 1;
                    }
                    if (Moving == 3) {
                        BlockPaperPlane = 1;
                        Moving = 1;
                    }
                    position.y = 194;
                    BonusLife -= 1;
                    highjump += 5;
                    speed.y = highjump;
                    speedjump += 5;
                    speed.x = speedjump;
                    if ( skkC == 0){
                        if (Soundpol == 1)
                            skk.play();
                        skkC = 1;
                    }
                }
            }

            positionPlane.x = positionPlane.x + 9;
            positionPlane.y = positionPlane.y - (float)GravityPlane;

            posBird.x = posBird.x - speedBird;
            posBird.y = posBird.y - fallspeed;

            if(BlockPlane == 1) {
                if (rotationPlane > -90)
                    rotationPlane = rotationPlane - 1;
                else rotationPlane = -90;
            }

            if(BlockUFO == 1) {
                if (rotationUFO > -90)
                    rotationUFO = rotationUFO - 2;
                else rotationUFO = -90;
            }

            if(BlockBird == 1){
                fallspeed = 4;
                birdrotation -= 2;
                spriteBirdDead.setPosition(posBird.x, posBird.y);
                spriteBirdDead.setRotation(birdrotation);
            }

            RectUFO.setPosition(posUFO.x, posUFO.y + 66);
            RectUFOCatch.setPosition(posUFO.x, posUFO.y);
            RectPlane.setPosition(positionPlane.x, positionPlane.y);
            if (life == 1)
            RectKamen.setPosition(position.x, position.y);
            RectKK.setPosition(posKK.x, posKK.y);
            RectPaperPlane.setPosition(posPaperPlane.x,posPaperPlane.y);
            RectShip.setPosition(posShip.x, posShip.y);
            RectBird.setPosition(posBird.x,posBird.y);
            RectBal.setPosition(posBal.x, posBal.y + 70);

            // LIFE 0

            if (life == 0) {
                sbutC = 0;
                if (DeadAction == 1) {
                    if (sbulkC == 0) {
                        if (Soundpol == 1)
                            sbulk.play();
                        sbulkC = 1;
                    }
                    if (sfallkamenC == 0) {
                        if (Soundpol == 1)
                        sfallkamen.play();
                        sfallkamenC = 1;
                    }
                    if (speed.x > 0) {
                        speed.x -= 0.5;
                    }
                    if (rotation >= -90)
                        rotation -= 2;
                    if (position.y < 30) {
                        Total = (int) ((position.x / Bg1Day.getWidth()) * BonusScore) + (int) (ExtraScore * BonusExtra);
                        if (Total >= 10) {
                            otstupEnd = 10;
                        }
                        if (Total >= 100) {
                            otstupEnd = 15;
                        }
                        if (Total > Record) {
                            Base.putInteger("Record", Total);
                            Base.flush();
                            Record = Total;
                        }
                        if (Record >= 10) {
                            otstupEndRecord = 10;
                        }
                        if (Record >= 100) {
                            otstupEndRecord = 15;
                        }
                        if (speed.x <= 0) {
                            Ending = 1;
                        }
                    }
                    posBird.x = posBird.x - speedBird;
                    posBird.y = posBird.y - fallspeed;
                }
                if (DeadAction == 2){
                    Gravity = 0;
                    Total = (int)(((position.x / Bg1Day.getWidth()) + ExtraScore*BonusExtra) * BonusScore);
                    RectKamen.setPosition(0,0);
                    speed.x = 0;
                    speed.y = (float)0.05;
                    Visible -= 0.02;
                    if (Visible <= 0) {
                        Visible = 0;
                        Ending = 1;
                    }
                    spriteKamen.setAlpha(Visible);
                }
            }
            // LIFE 0 END
        }
        if (Ending == 1 && save == 0){
            Money = (int)(((position.x / Bg1Day.getWidth() + ExtraScore*BonusExtra)/5 + Pancakes/5) * BonusScore + 10);
            TotalMoney = TotalMoney + Money;
            Base.putInteger("Money", TotalMoney);
            Base.flush();
            save++;
        }

        if (Moving == 1) {
            spriteKamen.setRotation(rotation);
        }
        spriteKamen.setPosition(position.x, position.y);
        spritePlane.setRotation(rotationPlane);
        spritePlane.setPosition(positionPlane.x, positionPlane.y);
        spriteKuv.setPosition(posKK.x, posKK.y);
        spriteShip.setPosition(posShip.x, posShip.y);
        spriteUFO.setPosition(posUFO.x, posUFO.y);
        spritePaperPlane.setPosition(posPaperPlane.x,posPaperPlane.y);
        spritePaperPlane.setRotation((float)rotationPP);
        spriteBal.setPosition(posBal.x, posBal.y);

        if (life < 2 && position.x > 400)
            camera.position.x = position.x;
    }

    private void kruginavode(){
        Sprite krug = new Sprite(razvod);
        krug.setPosition(position.x, 175);
        krugi.add(krug);
    }

    private void RespawnKK() {
        posKK.set(position.x + MathUtils.random(750, 2000), 180);
    }

    private void RespawnBal() {
        posBal.set(position.x + MathUtils.random(1000, 5000), MathUtils.random(480 - 100, 480 * 3));
        RandomBaloon = MathUtils.random(1,3);
        sballC = 0;
    }

    private void RespawnShip() {
        posShip.set(position.x + MathUtils.random(4000, 7000), 190);
        BlockShip = 0;
        spriteShip.setTexture(Ship);
        spriteShip.setRotation(0);
        rotationShip = 0;
        sshipC = 0;
    }

    private void RespawnPP() {
        posPaperPlane.set(position.x + MathUtils.random(5000, 7000), MathUtils.random(480, 680));
        BlockPaperPlane = 0;
        rotationPP = 0;
        GravityPaperPlane = 0.5;
        spritePaperPlane.setRotation(0);
        highpoint = (int)posPaperPlane.y + 100;
        lowpoint = (int)posPaperPlane.y - 100;
    }

    private void RespawnUFO() {
        posUFO.set(position.x + MathUtils.random(7000, 16000),MathUtils.random(480 * 2 - 100, 480 * 2 + 400));
        BlockUFO = 0;
        scrufoC = 0;
        spriteUFO.setTexture(Ufo);
    }

    private void RespawnBird() {
        posBird.set(position.x + MathUtils.random(4000, 12000), MathUtils.random(360, 680));
        BlockBird = 0;
        scrbirdC = 0;
        fallspeed = 0;
        birdrotation = 0;
        birdfly = 0;
    }

    private void RespawnPlane() {
        spritePlane.setTexture(Plane);
        GravityPlane = 0;
        BlockPlane = 0;
        scrplaneC = 0;
        rotationPlane = 0;
        positionPlane.set(position.x + MathUtils.random(3000, 7000), MathUtils.random(480 + 240, 480 * 2 + 200));
    }

    @Override
    public void render(SpriteBatch sb) {
        camera.update();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sb.begin();
        sb.setProjectionMatrix(camera.combined);
        sb.draw(Bg1, camera.position.x - camera.viewportWidth/2, 51);
        sb.draw(Bg1Day, Bg1pos1.x, Bg1pos1.y);
        sb.draw(Bg1Day, Bg1pos2.x, Bg1pos2.y);
        sb.draw(Bg2Day, Bg2pos1.x, Bg2pos1.y);
        sb.draw(Bg2Day, Bg2pos2.x, Bg2pos2.y);
        sb.draw(Bg3Day, Bg3pos1.x, Bg3pos1.y);
        sb.draw(Bg3Day, Bg3pos2.x, Bg3pos2.y);
        sb.draw(Bg4Day, Bg4pos1.x, Bg4pos1.y);
        sb.draw(Bg4Day, Bg4pos2.x, Bg4pos2.y);
        spriteShip.draw(sb);
        if (life == 0){
            spriteKamen.setTexture(Kamend);
        }else {
            if (speed.y > 0){
                spriteKamen.setTexture(KamenA);
            }else {
                spriteKamen.setTexture(Kamen);
            }
        }
        spriteUFO.draw(sb);
        if(BlockBird == 0)
            switch (RandBird) {
                case 1:
                    sb.draw((TextureRegion) AnimBird.getKeyFrame(birdfly, true), posBird.x, posBird.y);
                    break;
                case 2:
                    sb.draw((TextureRegion) AnimBirdR.getKeyFrame(birdfly, true), posBird.x, posBird.y);
                    break;
                case 3:
                    sb.draw((TextureRegion) AnimBirdP.getKeyFrame(birdfly, true), posBird.x, posBird.y);
                    break;
                case 4:
                    sb.draw((TextureRegion) AnimBirdG.getKeyFrame(birdfly, true), posBird.x, posBird.y );
                    break;
            }
        if(BlockBird == 1){
            switch (RandBird) {
                case 1:
                    spriteBirdDead.setTexture(birdD);
                    break;
                case 2:
                    spriteBirdDead.setTexture(birdDR);
                    break;
                case 3:
                    spriteBirdDead.setTexture(birdDP);
                    break;
                case 4:
                    spriteBirdDead.setTexture(birdDG);
                    break;
            }
            spriteBirdDead.draw(sb);
        }
        spritePlane.draw(sb);
        spritePaperPlane.draw(sb);
        spriteBal.draw(sb);
        spriteKamen.draw(sb);
        sb.draw(Voda, vodapos1.x, vodapos1.y);
        sb.draw(Voda, vodapos2.x, vodapos2.y);
        if (life == 2)
            sb.draw(Starter, 0 , 0);
        if (life == 1)
            sb.draw(Starter2, 0 , 0);
        if (Timer == 1)
            sb.draw(Fetil, (int)(50 + fetilotstup*1.5) , (int)(386 - fetilotstup));
        for (Sprite krug: krugi)
        {
            sb.draw(razvod, krug.getX(), krug.getY());
        }
        spriteKuv.draw(sb);
        if (life == 2) {
            if (timer < 3.5)
            Numbers.draw(sb, Integer.toString((int)timer), camera.position.x, camera.position.y + 80);
        }
        if (life == 1) {
            font.draw(sb, "Score: " + Integer.toString((int) (((position.x / Bg1Day.getWidth()) + ExtraScore*BonusExtra) * BonusScore)), camera.position.x + 150, camera.position.y + 200);
            if (EventPlane == 1)
                font.draw(sb, "+ " + Integer.toString((int)(30 * BonusExtra)), camera.position.x + 240, camera.position.y + 160);
            if (EventBal == 1)
                font.draw(sb, "+ " + Integer.toString((int)(1 * BonusExtra)), camera.position.x + 240, camera.position.y + 160);
            if (EventShip == 1)
                font.draw(sb, "+ " + Integer.toString((int)(5 * BonusExtra)), camera.position.x + 240, camera.position.y + 160);
            if (EventBird == 1)
                font.draw(sb, "+ " + Integer.toString((int)(15 * BonusExtra)), camera.position.x + 240, camera.position.y + 160);
            if (EventUFO == 1)
                font.draw(sb, "+ " + Integer.toString((int)(100 * BonusExtra)), camera.position.x + 240, camera.position.y + 160);
            if (EventPaperPlane == 1)
                font.draw(sb, "+ " + Integer.toString((int)(5 * BonusExtra)), camera.position.x + 240, camera.position.y + 160);
            font.draw(sb, "Lifes: " + Integer.toString(BonusLife), camera.position.x - 380, camera.position.y - 135);
            font.draw(sb, "Speed: " + Integer.toString((int) speed.x) + " m/s", camera.position.x - 380, camera.position.y - 160);
            font.draw(sb, "Jump: " + Integer.toString(curheight) + " m", camera.position.x - 380, camera.position.y - 185);
        }
        if (Ending == 1){
            if (DeadAction == 1)
                sb.draw(End1, camera.position.x - 350/2, camera.position.y - 400/2);
            if (DeadAction == 2)
                sb.draw(End2, camera.position.x - 350/2, camera.position.y - 400/2);
            font.draw(sb, Integer.toString(Total), camera.position.x - 350/4 + 135, camera.position.y + 134);
            font.draw(sb, Integer.toString(Record), camera.position.x - 350/4 + 85, camera.position.y + 86);
            font.draw(sb, Integer.toString(Pancakes), camera.position.x + 15, camera.position.y + 40);
            font.draw(sb, Integer.toString(Money), camera.position.x + 30, camera.position.y - 10);
            if (Total == Record)
                sb.draw(NewRecord,camera.position.x + 50, camera.position.y + 48);
            button.setPosition(camera.position.x + 85, camera.position.y - 180);
            button.setVisible(true);
            button2.setPosition(camera.position.x - 155, camera.position.y - 180);
            button2.setVisible(true);
        }
        fontbutton.draw(sb, " ", 0, 0);
            stage.draw();
        sb.end();
    }

    private void updateWaterandFon(){
        if (camera.position.x - (camera.viewportWidth / 2) + speed.x > vodapos1.x + Voda.getWidth())
            vodapos1.add(Voda.getWidth() * 2, 0);

        if (camera.position.x - (camera.viewportWidth / 2) + speed.x > vodapos2.x + Voda.getWidth())
            vodapos2.add(Voda.getWidth() * 2, 0);

        if (camera.position.x - (camera.viewportWidth / 2) + speed.x > Bg1pos1.x + Bg1Day.getWidth())
            Bg1pos1.add(Bg1Day.getWidth() * 2, 0);

        if (camera.position.x - (camera.viewportWidth / 2) + speed.x > Bg1pos2.x + Bg1Day.getWidth())
            Bg1pos2.add(Bg1Day.getWidth() * 2, 0);

        if (position.x + Bg2Day.getWidth() * 3 > Bg2Day.getWidth() * (10 + checkpoint) && position.x < Bg2Day.getWidth() * (30 + checkpoint)) {
            if (checkpoint > 0 && checkBg2 < lvl) {
                Bg2pos1.set(Bg2Day.getWidth() * (9 + checkpoint), 0);
                Bg2pos2.set(Bg2Day.getWidth() * (10 + checkpoint), 0);
                checkBg2++;
            }
            if (camera.position.x - (camera.viewportWidth / 2) + speed.x > Bg2pos1.x + Bg2Day.getWidth())
                Bg2pos1.add(Bg2Day.getWidth() * 2, 0);
            if (camera.position.x - (camera.viewportWidth / 2) + speed.x > Bg2pos2.x + Bg2Day.getWidth())
                Bg2pos2.add(Bg2Day.getWidth() * 2, 0);
        }
        if (position.x + Bg3Day.getWidth() * 3 > Bg3Day.getWidth() * (checkpoint + 40) && position.x < Bg3Day.getWidth() * (checkpoint + 60)) {
            if (checkpoint > 0 && checkBg3 < lvl) {
                Bg3pos1.set(Bg3Day.getWidth() * (41 + checkpoint), 0);
                Bg3pos2.set(Bg3Day.getWidth() * (40 + checkpoint), 0);
                checkBg3++;
            }
            if (camera.position.x - (camera.viewportWidth / 2) + speed.x > Bg3pos1.x + Bg3Day.getWidth())
                Bg3pos1.add(Bg3Day.getWidth() * 2, 0);
            if (camera.position.x - (camera.viewportWidth / 2) + speed.x > Bg3pos2.x + Bg3Day.getWidth())
                Bg3pos2.add(Bg3Day.getWidth() * 2, 0);
        }
        if (position.x + Bg4Day.getWidth() * 3 > Bg4Day.getWidth() * (70 + checkpoint) && position.x < Bg4Day.getWidth() * (90 + checkpoint)) {
            if (checkpoint > 0 && checkBg4 < lvl) {
                Bg4pos1.set(Bg4Day.getWidth() * (69 + checkpoint), 0);
                Bg4pos2.set(Bg4Day.getWidth() * (70 + checkpoint), 0);
                checkBg4++;
            }
            if (camera.position.x - (camera.viewportWidth / 2) + speed.x > Bg4pos1.x + Bg4Day.getWidth())
                Bg4pos1.add(Bg4Day.getWidth() * 2, 0);
            if (camera.position.x - (camera.viewportWidth / 2) + speed.x > Bg4pos2.x + Bg4Day.getWidth())
                Bg4pos2.add(Bg4Day.getWidth() * 2, 0);
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width,height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
        Bg1.dispose();
        razvod.dispose();
        Bg1Day.dispose();
        Plane.dispose();
        Planed.dispose();
        Ship.dispose();
        Bg2Day.dispose();
        Bg3Day.dispose();
        KK.dispose();
        Starter.dispose();
        Starter2.dispose();
        fontbutton.dispose();
        Bg4Day.dispose();
        Ufo.dispose();
        UfoD.dispose();
        End1.dispose();
        Voda.dispose();
        font.dispose();
        BalB.dispose();BalP.dispose();BalY.dispose();
        Kamen.dispose();
        Kamend.dispose();
        buttonsAtlas.dispose();
        buttonsAtlas2.dispose();
        buttonsAtlas3.dispose();
        Shipd.dispose();
        Shipdd.dispose();
        NewRecord.dispose();
        Fetil.dispose();
        PaperPlane.dispose();
        Numbers.dispose();
        birdD.dispose();
        krugi.clear();
        AtlasBird.dispose();
        KamenA.dispose();
        scan.dispose();
        sball.dispose();
        sbird.dispose();
        scrbird.dispose();
        sbul.dispose();
        sbulk.dispose();
        splane.dispose();
        scrplane.dispose();
        scrufo.dispose();
        sufo.dispose();
        sship.dispose();
        sbg.dispose();
        skk.dispose();
        sbut.dispose();
    }
}
