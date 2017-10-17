package nk.makeripples.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Start extends State implements Screen {

	Viewport viewport;
	Texture Fon, Fon2, FonRU, Fon2RU,Fon3, Fon3RU, Loading, LoadingR;
	int ChooseFon, zapret = 0, GameStatus = 0;

	int Choise = 1;
	int helping = 0;
	// Blocks
	int B10, B11, B12, B13, B14, B15, B16, B17;
	int Lessons = 1;
	int flag;

	float TimeLoading, TimePlus, Alpha = 0, TimeA = 0;

	private Stage stage;
	private TextureAtlas buttonsAtlas, butAtlaslesson, SoundAtlas, FlagAtlas;
	private Skin buttonSkin, butskinles, SoundSkin, FlagSkin;
	private TextButton button, buttonhelp, butleft, butright, butOK, butbuy, butlesL, butlesR, butzvuk, butfonleft, butfonright, butflag;

	// Sounds
	Music music;
	Sound sound;
	int soundC = 0;
	int Soundpol;

	// Money
	int Money = 0;

	// Act 1 - start, 2 help, 3 left, 4 right 5 return 6 buy
	int Act;

	BitmapFont font, b;
	Sprite sprite, name, spisok, preS;
	Texture S1, S2,S3,S4, rock18, rock19, preT, rock20,S5,S6,S7,S8,S9,S10,S11,S12,S13,S14,S15,S16,S17,S18,S19,S20,S1RU, S2RU,S3RU,S4RU,S5RU,S6RU,S7RU,S8RU,S9RU,S10RU,S11RU,S12RU,S13RU,S14RU,S15RU,S16RU,S17RU, S18RU, S19RU, S20RU,LES1, LES2, LES3, LES4,LES1R, LES2R, LES3R, LES4R, monetka,rock1, rock2, rock3, rock4, rock5, rock6, rock7, rock8, rock9,rock10,rock11,rock12,rock13,rock14,rock15,rock16,rock17,rock10u,rock11u,rock12u,rock13u,rock14u,rock15u,rock16u,rock17u, name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14,name15,name16,name17;
	Texture name1RU, name2RU, name3RU, name4RU, name5RU, name6RU, name7RU, name8RU, name9RU, name10RU, name11RU, name12RU, name13RU, name14RU, name15RU, name16RU, name17RU, name18RU, name19RU, name20RU,name18, name19, name20;

	Preferences Base;
	String Hero;

	public Start(GameStateManager gam){
		super(gam);

		viewport = new FillViewport(800,480,camera);
		viewport.apply();

		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);

		b = new BitmapFont();
		Base = Gdx.app.getPreferences("GameBase");
		Hero = Base.getString("Hero", "1");
		flag = Base.getInteger("Language", 1);
		GameStatus = Base.getInteger("GameStatus", 0);
		Soundpol = Base.getInteger("Soundpool", 1);
		if (Integer.valueOf(Hero) != 1){
			Hero = Integer.toString(1);
		}
		Money = Base.getInteger("Money", 0);
		B10 = Base.getInteger("B10", 1);
		B11 = Base.getInteger("B11", 1);
		B12 = Base.getInteger("B12", 1);
		B13 = Base.getInteger("B13", 1);
		B12 = Base.getInteger("B12", 1);
		B13 = Base.getInteger("B13", 1);
		B14 = Base.getInteger("B14", 1);
		B15 = Base.getInteger("B15", 1);
		B16 = Base.getInteger("B16", 1);
		B17 = Base.getInteger("B17", 1);
		ChooseFon = Base.getInteger("Fon", 1);
		Choise = Integer.parseInt(Hero);
		Base.putInteger("GameStatus", 0);
		Base.flush();

		sound = Gdx.audio.newSound(Gdx.files.internal("soundbutton.mp3"));
		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));

		font = new BitmapFont(Gdx.files.internal("font007.fnt"));
		Fon = new Texture("altfon1.png");
		Fon2 = new Texture("altfon22.png");
		FonRU = new Texture("altfon1ru.png");
		Fon2RU = new Texture("altfon2ru.png");
		Fon3 = new Texture("altfon3.png");
		Fon3RU = new Texture("altfon3ru.png");
		preT = new Texture("pre1.png");
		preS = new Sprite(preT);
		preS.setAlpha(Alpha);
		preS.setPosition(0,0);
		S1 = new Texture("ss1.png");
		S2 = new Texture("s2.png");
		S3 = new Texture("s3.png");
		S4 = new Texture("s4.png");
		S5 = new Texture("s5.png");
		S6 = new Texture("s6.png");
		S7 = new Texture("s7.png");
		S8 = new Texture("s8.png");
		S9 = new Texture("s9.png");
		S10 = new Texture("s10.png");
		S11 = new Texture("s11.png");
		S12 = new Texture("s12.png");
		S13 = new Texture("s13.png");
		S14 = new Texture("s14.png");
		S15 = new Texture("s15.png");
		S16 = new Texture("s16.png");
		S17 = new Texture("s17.png");
		S18 = new Texture("s18.png");
		S19 = new Texture("s19.png");
		S20 = new Texture("s20.png");
		S1RU = new Texture("ss1RU.png");
		S2RU = new Texture("s2RU.png");
		S3RU = new Texture("s3RU.png");
		S4RU = new Texture("s4RU.png");
		S5RU = new Texture("s5RU.png");
		S6RU = new Texture("s6RU.png");
		S7RU = new Texture("s7RU.png");
		S8RU = new Texture("s8RU.png");
		S9RU = new Texture("s9RU.png");
		S10RU = new Texture("s10RU.png");
		S11RU = new Texture("s11RU.png");
		S12RU = new Texture("s12RU.png");
		S13RU = new Texture("s13RU.png");
		S14RU = new Texture("s14RU.png");
		S15RU = new Texture("s15RU.png");
		S16RU = new Texture("s16RU.png");
		S17RU = new Texture("s17RU.png");
		S18RU = new Texture("s18RU.png");
		S19RU = new Texture("s19RU.png");
		S20RU = new Texture("s20RU.png");
		monetka = new Texture("monetka.png");
		rock1 = new Texture("rock2.png");
		rock2 = new Texture("rockaki.png");
		rock3 = new Texture("rockracer.png");
		rock4 = new Texture("rockfrog.png");
		rock5 = new Texture("rocknavi.png");
		rock6 = new Texture("rockmark.png");
		rock7 = new Texture("rock7.png");
		rock8 = new Texture("rock8.png");
		rock9 = new Texture("rock9.png");
		rock10 = new Texture("rock10.png");
		rock11 = new Texture("rock11.png");
		rock12 = new Texture("rock12.png");
		rock13 = new Texture("rock13.png");
		rock14 = new Texture("stonecat1.png");
		rock15 = new Texture("stonecat2.png");
		rock16 = new Texture("stonecat3.png");
		rock17 = new Texture("stonecat4.png");
		rock10u = new Texture("rock10u.png");
		rock11u = new Texture("rock11u.png");
		rock12u = new Texture("rock12u.png");
		rock13u = new Texture("rock13u.png");
		rock14u = new Texture("stonecat1un.png");
		rock15u = new Texture("stonecat2un.png");
		rock16u = new Texture("stonecat3u.png");
		rock17u = new Texture("stonecat4un.png");
		rock18 = new Texture("nystone1.png");
		rock19 = new Texture("nystone2.png");
		rock20 = new Texture("nystone3.png");
		LES1 = new Texture("lesson1.png");
		LES2 = new Texture("lesson2.png");
		LES3 = new Texture("lesson3.png");
		LES4 = new Texture("lesson4.png");
		LES1R = new Texture("lesson1RU.png");
		LES2R = new Texture("lesson2RU.png");
		LES3R = new Texture("lesson3RU.png");
		LES4R = new Texture("lesson4RU.png");
		sprite = new Sprite(rock1);
		spisok = new Sprite(S1);
		Loading = new Texture("loading.png");
		LoadingR = new Texture("loadingRU.png");
		name1 = new Texture("tobi.png");
		name2 = new Texture("yuki.png");
		name3 = new Texture("stuard.png");
		name4 = new Texture("froggy.png");
		name5 = new Texture("steve.png");
		name6 = new Texture("murfik.png");
		name7 = new Texture("klod.png");
		name8 = new Texture("fredy.png");
		name9 = new Texture("kiyang.png");
		name10 = new Texture("marti.png");
		name11 = new Texture("necro1.png");
		name12 = new Texture("robert.png");
		name13 = new Texture("kreck.png");
		name14 = new Texture("sam1.png");
		name15 = new Texture("tuador1.png");
		name16 = new Texture("jack1.png");
		name17 = new Texture("vincent1.png");
		name18 = new Texture("santa.png");
		name19 = new Texture("bim.png");
		name20 = new Texture("rud.png");
		name1RU = new Texture("tobiRU.png");
		name2RU = new Texture("yukiRU.png");
		name3RU = new Texture("stuardRU.png");
		name4RU = new Texture("froggyRU.png");
		name5RU = new Texture("steveRU.png");
		name6RU = new Texture("murfikRU.png");
		name7RU = new Texture("klodRU.png");
		name8RU = new Texture("fredyRU.png");
		name9RU = new Texture("kiyangRU.png");
		name10RU = new Texture("martiRU.png");
		name11RU = new Texture("necro1RU.png");
		name12RU = new Texture("robertRU.png");
		name13RU = new Texture("kreckRU.png");
		name14RU = new Texture("samRU1.png");
		name15RU = new Texture("tuadorRU1.png");
		name16RU = new Texture("jackRU1.png");
		name17RU = new Texture("vincentRU1.png");
		name18RU = new Texture("santaRU.png");
		name19RU = new Texture("bimRU.png");
		name20RU = new Texture("rudRU.png");
		name = new Sprite(name1);

		buttonsAtlas = new TextureAtlas("mainmenubutton.pack");
		buttonSkin = new Skin();
		buttonSkin.addRegions(buttonsAtlas);
		butAtlaslesson = new TextureAtlas("butlesson.pack");
		butskinles = new Skin();
		butskinles.addRegions(butAtlaslesson);
		SoundAtlas = new TextureAtlas("zvuki.pack");
		SoundSkin = new Skin();
		SoundSkin.addRegions(SoundAtlas);
		FlagAtlas = new TextureAtlas("flag.pack");
		FlagSkin = new Skin();
		FlagSkin.addRegions(FlagAtlas);

		stage = new Stage(viewport);
		stage.clear();

		TextButton.TextButtonStyle stylestart = new TextButton.TextButtonStyle();
		stylestart.up = buttonSkin.getDrawable("butstart");
		stylestart.down = buttonSkin.getDrawable("butstart");
		stylestart.font = font;
		TextButton.TextButtonStyle stylehelp = new TextButton.TextButtonStyle();
		stylehelp.up = buttonSkin.getDrawable("help1");
		stylehelp.down = buttonSkin.getDrawable("help1");
		stylehelp.font = font;
		TextButton.TextButtonStyle styleleft = new TextButton.TextButtonStyle();
		styleleft.up = buttonSkin.getDrawable("left");
		styleleft.down = buttonSkin.getDrawable("left");
		styleleft.font = font;
		TextButton.TextButtonStyle styleright = new TextButton.TextButtonStyle();
		styleright.up = buttonSkin.getDrawable("right");
		styleright.down = buttonSkin.getDrawable("right");
		styleright.font = font;
		TextButton.TextButtonStyle styleok = new TextButton.TextButtonStyle();
		styleok.up = buttonSkin.getDrawable("ok2");
		styleok.down = buttonSkin.getDrawable("ok2");
		styleok.font = font;
		TextButton.TextButtonStyle stylebuy = new TextButton.TextButtonStyle();
		stylebuy.up = buttonSkin.getDrawable("buy");
		stylebuy.down = buttonSkin.getDrawable("buy");
		stylebuy.font = font;
		TextButton.TextButtonStyle stylebuyR = new TextButton.TextButtonStyle();
		stylebuyR.up = buttonSkin.getDrawable("buyRU");
		stylebuyR.down = buttonSkin.getDrawable("buyRU");
		stylebuyR.font = font;
		TextButton.TextButtonStyle stylestartR = new TextButton.TextButtonStyle();
		stylestartR.up = buttonSkin.getDrawable("butstartRU");
		stylestartR.down = buttonSkin.getDrawable("butstartRU");
		stylestartR.font = font;
		TextButton.TextButtonStyle styleLL = new TextButton.TextButtonStyle();
		styleLL.up = butskinles.getDrawable("bl");
		styleLL.down = butskinles.getDrawable("bl");
		styleLL.font = font;
		TextButton.TextButtonStyle styleLR = new TextButton.TextButtonStyle();
		styleLR.up = butskinles.getDrawable("br");
		styleLR.down = butskinles.getDrawable("br");
		styleLR.font = font;
		TextButton.TextButtonStyle soundOn = new TextButton.TextButtonStyle();
		soundOn.up = SoundSkin.getDrawable("zvuk");
		soundOn.down = SoundSkin.getDrawable("zvuk");
		soundOn.font = font;
		TextButton.TextButtonStyle soundOff = new TextButton.TextButtonStyle();
		soundOff.up = SoundSkin.getDrawable("zvuknot");
		soundOff.down = SoundSkin.getDrawable("zvuknot");
		soundOff.font = font;
		TextButton.TextButtonStyle flagrus = new TextButton.TextButtonStyle();
		flagrus.up = FlagSkin.getDrawable("russiaflag");
		flagrus.down = FlagSkin.getDrawable("russiaflag");
		flagrus.font = font;
		TextButton.TextButtonStyle flageng = new TextButton.TextButtonStyle();
		flageng.up = FlagSkin.getDrawable("englandflag");
		flageng.down = FlagSkin.getDrawable("englandflag");
		flageng.font = font;
		if (flag == 1)
		button = new TextButton("", stylestart);
		else button = new TextButton("", stylestartR);
		button.setPosition(270, 12);
		butleft = new TextButton("", styleleft);
		butleft.setPosition(450, 160);
		butleft.setSize(62, 63);
		butright = new TextButton("", styleright);
		butright.setPosition(539, 160);
		butright.setSize(62, 63);
		buttonhelp = new TextButton("", stylehelp);
		buttonhelp.setPosition(10, 6);
		buttonhelp.setSize(72, 66);
		butOK = new TextButton("", styleok);
		butOK.setPosition(camera.position.x - 33, 33);
		butOK.setSize(72, 66);
		if (flag == 1)
		butbuy = new TextButton("", stylebuy);
		else butbuy = new TextButton("", stylebuyR);
		butbuy.setPosition(630, 265);
		butbuy.setSize(72, 66);
		butbuy.setVisible(false);
		butlesL = new TextButton("", styleLL);
		butlesL.setPosition(43, 33);
		butlesL.setSize(79, 77);
		butlesR = new TextButton("", styleLR);
		butlesR.setPosition(679, 33);
		butlesR.setSize(79, 77);
		butfonleft = new TextButton("", styleleft);
		butfonleft.setPosition(20, 250);
		butfonleft.setSize(62, 63);
		butfonright = new TextButton("", styleright);
		butfonright.setPosition(718, 250);
		butfonright.setSize(62, 63);
		if (Soundpol == 1)
		butzvuk = new TextButton("", soundOn);
		else
			butzvuk = new TextButton("", soundOff);
		butzvuk.setPosition(83, 6);
		butzvuk.setSize(72, 66);
		if(flag == 1)
		    butflag = new TextButton("", flageng);
		if(flag == 2)
			butflag = new TextButton("", flagrus);
		butflag.setPosition(160, 3);
		butflag.setSize(72, 70);
		butflag.setVisible(false);

		Gdx.input.setInputProcessor(stage);

		button.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				if (zapret == 0) {
					if (Soundpol == 1) {
						if (soundC == 0) {
							sound.play();
							soundC = 1;
						}
					}
					Act = 1;
				}
			}
		});
		butleft.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				if (zapret == 0) {
					if (Soundpol == 1) {
						if (soundC == 0) {
							sound.play();
							soundC = 1;
						}
					}
					Act = 3;
				}
			}
		});
		butright.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				if (zapret == 0) {
					if (Soundpol == 1) {
						if (soundC == 0) {
							sound.play();
							soundC = 1;
						}
					}
					Act = 4;
				}
			}
		});
		buttonhelp.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				if (zapret == 0) {
					if (Soundpol == 1) {
						if (soundC == 0) {
							sound.play();
							soundC = 1;
						}
					}
					Act = 2;
				}
			}
		});
		butOK.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				if (zapret == 0) {
					if (Soundpol == 1) {
						if (soundC == 0) {
							sound.play();
							soundC = 1;
						}
					}
					Act = 5;
				}
			}
		});
		butbuy.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				if (zapret == 0) {
					if (Soundpol == 1) {
						if (soundC == 0) {
							sound.play();
							soundC = 1;
						}
					}
					Act = 6;
				}
			}
		});
		butlesL.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				if (zapret == 0) {
					if (Soundpol == 1) {
						if (soundC == 0) {
							sound.play();
							soundC = 1;
						}
					}
					Act = 7;
				}
			}
		});
		butlesR.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				if (zapret == 0) {
					if (Soundpol == 1) {
						if (soundC == 0) {
							sound.play();
							soundC = 1;
						}
					}
					Act = 8;
				}
			}
		});
		butfonleft.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				if (zapret == 0) {
					if (Soundpol == 1) {
						if (soundC == 0) {
							sound.play();
							soundC = 1;
						}
					}
					Act = 9;
				}
			}
		});
		butfonright.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				if (zapret == 0) {
					if (Soundpol == 1) {
						if (soundC == 0) {
							sound.play();
							soundC = 1;
						}
					}
					Act = 10;
				}
			}
		});
		butflag.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				if (Soundpol == 1) {
					if (soundC == 0) {
						sound.play();
						soundC = 1;
					}
				}
				if (flag == 1) {
					  flag = 2;
				}
				else flag = 1;
					Act = 11;
				}
		});
		butzvuk.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Sound();
			}
		});
		stage.addActor(button);
		stage.addActor(buttonhelp);
		stage.addActor(butleft);
		stage.addActor(butright);
		stage.addActor(butOK);
		stage.addActor(butbuy);
		stage.addActor(butzvuk);
		stage.addActor(butlesL);
		stage.addActor(butlesR);
		stage.addActor(butfonleft);
		stage.addActor(butfonright);
		stage.addActor(butflag);
		if (Soundpol == 1) {
			music.setLooping(true);
			music.play();
		}
	}

	public void Sound(){
		TextButton.TextButtonStyle soundOn = new TextButton.TextButtonStyle();
		soundOn.up = SoundSkin.getDrawable("zvuk");
		soundOn.down = SoundSkin.getDrawable("zvuk");
		soundOn.font = font;
		TextButton.TextButtonStyle soundOff = new TextButton.TextButtonStyle();
		soundOff.up = SoundSkin.getDrawable("zvuknot");
		soundOff.down = SoundSkin.getDrawable("zvuknot");
		soundOff.font = font;
		if (Soundpol == 1) {
			Soundpol = 0;
			music.stop();
			butzvuk.setStyle(soundOff);
		}
		else{
			Soundpol = 1;
			music.stop();
			music.play();
			butzvuk.setStyle(soundOn);
		}
	}

	@Override
	public void update(float dt) {

		camera.update();

		if (GameStatus == 0){
			if (Alpha < 0.95)
			Alpha = (float)(Alpha + 0.005);
			preS.setAlpha(Alpha);
			TimeA += Gdx.graphics.getDeltaTime();
			if (TimeA > 5){
				GameStatus = 1;
			}
		}
		if (GameStatus == 1) {
			TimeLoading = TimeLoading + TimePlus;
			if (TimeLoading > 1)
				gam.set(new Play(gam));

			switch (Act) {
				case 1:
					switch (Choise) {
						case 1:
							Base.putString("Hero", Integer.toString(Choise));
							Base.putInteger("Soundpool", Soundpol);
							Base.putInteger("Fon", ChooseFon);
							Base.putInteger("Language", flag);
							Base.flush();
							TimePlus = Gdx.graphics.getDeltaTime();
							zapret = 1;
							break;
						case 2:
							Base.putString("Hero", Integer.toString(Choise));
							Base.putInteger("Soundpool", Soundpol);
							Base.putInteger("Fon", ChooseFon);
							Base.putInteger("Language", flag);
							Base.flush();
							TimePlus = Gdx.graphics.getDeltaTime();
							zapret = 1;
							break;
						case 3:
							Base.putString("Hero", Integer.toString(Choise));
							Base.putInteger("Soundpool", Soundpol);
							Base.putInteger("Fon", ChooseFon);
							Base.putInteger("Language", flag);
							Base.flush();
							TimePlus = Gdx.graphics.getDeltaTime();
							zapret = 1;
							break;
						case 4:
							Base.putString("Hero", Integer.toString(Choise));
							Base.putInteger("Soundpool", Soundpol);
							Base.putInteger("Fon", ChooseFon);
							Base.putInteger("Language", flag);
							Base.flush();
							TimePlus = Gdx.graphics.getDeltaTime();
							zapret = 1;
							break;
						case 5:
							Base.putString("Hero", Integer.toString(Choise));
							Base.putInteger("Soundpool", Soundpol);
							Base.putInteger("Fon", ChooseFon);
							Base.putInteger("Language", flag);
							Base.flush();
							TimePlus = Gdx.graphics.getDeltaTime();
							zapret = 1;
							break;
						case 6:
							Base.putString("Hero", Integer.toString(Choise));
							Base.putInteger("Soundpool", Soundpol);
							Base.putInteger("Fon", ChooseFon);
							Base.putInteger("Language", flag);
							Base.flush();
							TimePlus = Gdx.graphics.getDeltaTime();
							zapret = 1;
							break;
						case 7:
							Base.putString("Hero", Integer.toString(Choise));
							Base.putInteger("Soundpool", Soundpol);
							Base.putInteger("Fon", ChooseFon);
							Base.putInteger("Language", flag);
							Base.flush();
							TimePlus = Gdx.graphics.getDeltaTime();
							zapret = 1;
							break;
						case 8:
							Base.putString("Hero", Integer.toString(Choise));
							Base.putInteger("Soundpool", Soundpol);
							Base.putInteger("Fon", ChooseFon);
							Base.putInteger("Language", flag);
							Base.flush();
							TimePlus = Gdx.graphics.getDeltaTime();
							zapret = 1;
							break;
						case 9:
							Base.putString("Hero", Integer.toString(Choise));
							Base.putInteger("Soundpool", Soundpol);
							Base.putInteger("Fon", ChooseFon);
							Base.putInteger("Language", flag);
							Base.flush();
							TimePlus = Gdx.graphics.getDeltaTime();
							zapret = 1;
							break;
						case 10:
							if (B10 == 0) {
								Base.putString("Hero", Integer.toString(Choise));
								Base.putInteger("Soundpool", Soundpol);
								Base.putInteger("Fon", ChooseFon);
								Base.putInteger("Language", flag);
								Base.flush();
								TimePlus = Gdx.graphics.getDeltaTime();
								zapret = 1;
							}
							break;
						case 11:
							if (B11 == 0) {
								Base.putString("Hero", Integer.toString(Choise));
								Base.putInteger("Soundpool", Soundpol);
								Base.putInteger("Fon", ChooseFon);
								Base.putInteger("Language", flag);
								Base.flush();
								TimePlus = Gdx.graphics.getDeltaTime();
								zapret = 1;
							}
							break;
						case 12:
							if (B12 == 0) {
								Base.putString("Hero", Integer.toString(Choise));
								Base.putInteger("Soundpool", Soundpol);
								Base.putInteger("Fon", ChooseFon);
								Base.putInteger("Language", flag);
								Base.flush();
								TimePlus = Gdx.graphics.getDeltaTime();
								zapret = 1;
							}
							break;
						case 13:
							if (B13 == 0) {
								Base.putString("Hero", Integer.toString(Choise));
								Base.putInteger("Soundpool", Soundpol);
								Base.putInteger("Fon", ChooseFon);
								Base.putInteger("Language", flag);
								Base.flush();
								TimePlus = Gdx.graphics.getDeltaTime();
								zapret = 1;
							}
							break;
						case 14:
							if (B14 == 0) {
								Base.putString("Hero", Integer.toString(Choise));
								Base.putInteger("Soundpool", Soundpol);
								Base.putInteger("Fon", ChooseFon);
								Base.putInteger("Language", flag);
								Base.flush();
								TimePlus = Gdx.graphics.getDeltaTime();
								zapret = 1;
							}
							break;
						case 15:
							if (B15 == 0) {
								Base.putString("Hero", Integer.toString(Choise));
								Base.putInteger("Soundpool", Soundpol);
								Base.putInteger("Fon", ChooseFon);
								Base.putInteger("Language", flag);
								Base.flush();
								TimePlus = Gdx.graphics.getDeltaTime();
								zapret = 1;
							}
							break;
						case 16:
							if (B16 == 0) {
								Base.putString("Hero", Integer.toString(Choise));
								Base.putInteger("Soundpool", Soundpol);
								Base.putInteger("Fon", ChooseFon);
								Base.putInteger("Language", flag);
								Base.flush();
								TimePlus = Gdx.graphics.getDeltaTime();
								zapret = 1;
							}
							break;
						case 17:
							if (B17 == 0) {
								Base.putString("Hero", Integer.toString(Choise));
								Base.putInteger("Soundpool", Soundpol);
								Base.putInteger("Fon", ChooseFon);
								Base.putInteger("Language", flag);
								Base.flush();
								TimePlus = Gdx.graphics.getDeltaTime();
								zapret = 1;
							}
							break;
						case 18:
							Base.putString("Hero", Integer.toString(Choise));
							Base.putInteger("Soundpool", Soundpol);
							Base.putInteger("Fon", ChooseFon);
							Base.putInteger("Language", flag);
							Base.flush();
							TimePlus = Gdx.graphics.getDeltaTime();
							zapret = 1;
							break;
						case 19:
							Base.putString("Hero", Integer.toString(Choise));
							Base.putInteger("Soundpool", Soundpol);
							Base.putInteger("Fon", ChooseFon);
							Base.putInteger("Language", flag);
							Base.flush();
							TimePlus = Gdx.graphics.getDeltaTime();
							zapret = 1;
							break;
						case 20:
							Base.putString("Hero", Integer.toString(Choise));
							Base.putInteger("Soundpool", Soundpol);
							Base.putInteger("Fon", ChooseFon);
							Base.putInteger("Language", flag);
							Base.flush();
							TimePlus = Gdx.graphics.getDeltaTime();
							zapret = 1;
							break;

					}
					Act = 0;
					break;
				case 2:
					helping = 1;
					Act = 0;
					break;
				case 3:
					Choise -= 1;
					if (Choise < 1)
						Choise = 20;
					Act = 0;
					break;
				case 4:
					Choise += 1;
					if (Choise > 20)
						Choise = 1;
					Act = 0;
					break;
				case 5:
					helping = 0;
					Act = 0;
					break;
				case 6:
					switch (Choise) {
						case 10:
							if (Money >= 100) {
								Money = Money - 100;
								Base.putInteger("Money", Money);
								Base.flush();
								B10 = 0;
								Base.putInteger("B10", B10);
								Base.flush();
							}
							break;
						case 11:
							if (Money >= 500) {
								Money = Money - 500;
								Base.putInteger("Money", Money);
								Base.flush();
								B11 = 0;
								Base.putInteger("B11", B11);
								Base.flush();
							}
							break;
						case 12:
							if (Money >= 500) {
								Money = Money - 500;
								Base.putInteger("Money", Money);
								Base.flush();
								B12 = 0;
								Base.putInteger("B12", B12);
								Base.flush();
							}
							break;
						case 13:
							if (Money >= 1000) {
								Money = Money - 1000;
								Base.putInteger("Money", Money);
								Base.flush();
								B13 = 0;
								Base.putInteger("B13", B13);
								Base.flush();
							}
							break;
						case 14:
							if (Money >= 1000) {
								Money = Money - 1000;
								Base.putInteger("Money", Money);
								Base.flush();
								B14 = 0;
								Base.putInteger("B14", B14);
								Base.flush();
							}
							break;
						case 15:
							if (Money >= 1000) {
								Money = Money - 1000;
								Base.putInteger("Money", Money);
								Base.flush();
								B15 = 0;
								Base.putInteger("B15", B15);
								Base.flush();
							}
							break;
						case 16:
							if (Money >= 1000) {
								Money = Money - 1000;
								Base.putInteger("Money", Money);
								Base.flush();
								B16 = 0;
								Base.putInteger("B16", B16);
								Base.flush();
							}
							break;
						case 17:
							if (Money >= 1000) {
								Money = Money - 1000;
								Base.putInteger("Money", Money);
								Base.flush();
								B17 = 0;
								Base.putInteger("B17", B17);
								Base.flush();
							}
							break;
					}
					Act = 0;
					break;
				case 7:
					if (Lessons > 1) {
						Lessons -= 1;
					}
					Act = 0;
					break;
				case 8:
					if (Lessons < 4) {
						Lessons += 1;
					}
					Act = 0;
					break;
				case 9:
					ChooseFon--;
					if (ChooseFon < 1)
						ChooseFon = 3;
					Act = 0;
					break;
				case 10:
					ChooseFon++;
					if (ChooseFon > 3)
						ChooseFon = 1;
					Act = 0;
					break;
				case 11:
					TextButton.TextButtonStyle flagrus = new TextButton.TextButtonStyle();
					flagrus.up = FlagSkin.getDrawable("russiaflag");
					flagrus.down = FlagSkin.getDrawable("russiaflag");
					flagrus.font = font;
					TextButton.TextButtonStyle flageng = new TextButton.TextButtonStyle();
					flageng.up = FlagSkin.getDrawable("englandflag");
					flageng.down = FlagSkin.getDrawable("englandflag");
					flageng.font = font;
					TextButton.TextButtonStyle stylebuyR = new TextButton.TextButtonStyle();
					stylebuyR.up = buttonSkin.getDrawable("buyRU");
					stylebuyR.down = buttonSkin.getDrawable("buyRU");
					stylebuyR.font = font;
					TextButton.TextButtonStyle stylestartR = new TextButton.TextButtonStyle();
					stylestartR.up = buttonSkin.getDrawable("butstartRU");
					stylestartR.down = buttonSkin.getDrawable("butstartRU");
					stylestartR.font = font;
					TextButton.TextButtonStyle stylebuy = new TextButton.TextButtonStyle();
					stylebuy.up = buttonSkin.getDrawable("buy");
					stylebuy.down = buttonSkin.getDrawable("buy");
					stylebuy.font = font;
					TextButton.TextButtonStyle stylestart = new TextButton.TextButtonStyle();
					stylestart.up = buttonSkin.getDrawable("butstart");
					stylestart.down = buttonSkin.getDrawable("butstart");
					stylestart.font = font;
					if (flag == 1) {
						butflag.setStyle(flageng);
						butbuy.setStyle(stylebuy);
						button.setStyle(stylestart);
					} else {
						butflag.setStyle(flagrus);
						butbuy.setStyle(stylebuyR);
						button.setStyle(stylestartR);
					}
					Act = 0;
					break;
			}

			if (Act == 0) {
				soundC = 0;
			}

			switch (Choise) {
				case 1:
					sprite.setTexture(rock1);
					sprite.setSize(rock1.getWidth(), rock1.getHeight());
					if (flag == 1) {
						spisok.setTexture(S1);
						name.setTexture(name1);
						name.setSize(name1.getWidth(), name1.getHeight());
					} else {
						spisok.setTexture(S1RU);
						name.setTexture(name1RU);
						name.setSize(name1RU.getWidth(), name1RU.getHeight());
					}
					butbuy.setVisible(false);
					break;
				case 2:
					sprite.setTexture(rock2);
					sprite.setSize(rock2.getWidth(), rock2.getHeight());
					if (flag == 1) {
						spisok.setTexture(S2);
						name.setTexture(name2);
						name.setSize(name2.getWidth(), name2.getHeight());
					} else {
						spisok.setTexture(S2RU);
						name.setTexture(name2RU);
						name.setSize(name2RU.getWidth(), name2RU.getHeight());
					}
					butbuy.setVisible(false);
					break;
				case 3:
					sprite.setTexture(rock3);
					sprite.setSize(rock3.getWidth(), rock3.getHeight());
					if (flag == 1) {
						spisok.setTexture(S3);
						name.setTexture(name3);
						name.setSize(name3.getWidth(), name3.getHeight());
					} else {
						spisok.setTexture(S3RU);
						name.setTexture(name3RU);
						name.setSize(name3RU.getWidth(), name3RU.getHeight());
					}
					butbuy.setVisible(false);
					break;
				case 4:
					sprite.setTexture(rock4);
					sprite.setSize(rock4.getWidth(), rock4.getHeight());
					if (flag == 1) {
						spisok.setTexture(S4);
						name.setTexture(name4);
						name.setSize(name4.getWidth(), name4.getHeight());
					} else {
						spisok.setTexture(S4RU);
						name.setTexture(name4RU);
						name.setSize(name4RU.getWidth(), name4RU.getHeight());
					}
					butbuy.setVisible(false);
					break;
				case 5:
					sprite.setTexture(rock5);
					sprite.setSize(rock5.getWidth(), rock5.getHeight());
					if (flag == 1) {
						spisok.setTexture(S5);
						name.setTexture(name5);
						name.setSize(name5.getWidth(), name5.getHeight());
					} else {
						spisok.setTexture(S5RU);
						name.setTexture(name5RU);
						name.setSize(name5RU.getWidth(), name5RU.getHeight());
					}
					butbuy.setVisible(false);
					break;
				case 6:
					sprite.setTexture(rock6);
					sprite.setSize(rock6.getWidth(), rock6.getHeight());
					if (flag == 1) {
						spisok.setTexture(S6);
						name.setTexture(name6);
						name.setSize(name6.getWidth(), name6.getHeight());
					} else {
						spisok.setTexture(S6RU);
						name.setTexture(name6RU);
						name.setSize(name6RU.getWidth(), name6RU.getHeight());
					}
					butbuy.setVisible(false);
					break;
				case 7:
					sprite.setTexture(rock7);
					sprite.setSize(rock7.getWidth(), rock7.getHeight());
					if (flag == 1) {
						spisok.setTexture(S7);
						name.setTexture(name7);
						name.setSize(name7.getWidth(), name7.getHeight());
					} else {
						spisok.setTexture(S7RU);
						name.setTexture(name7RU);
						name.setSize(name7RU.getWidth(), name7RU.getHeight());
					}
					butbuy.setVisible(false);
					break;
				case 8:
					sprite.setTexture(rock8);
					sprite.setSize(rock8.getWidth(), rock8.getHeight());
					if (flag == 1) {
						spisok.setTexture(S8);
						name.setTexture(name8);
						name.setSize(name8.getWidth(), name8.getHeight());
					} else {
						spisok.setTexture(S8RU);
						name.setTexture(name8RU);
						name.setSize(name8RU.getWidth(), name8RU.getHeight());
					}
					butbuy.setVisible(false);
					break;
				case 9:
					sprite.setTexture(rock9);
					sprite.setSize(rock9.getWidth(), rock9.getHeight());
					if (flag == 1) {
						spisok.setTexture(S9);
						name.setTexture(name9);
						name.setSize(name9.getWidth(), name9.getHeight());
					} else {
						spisok.setTexture(S9RU);
						name.setTexture(name9RU);
						name.setSize(name9RU.getWidth(), name9RU.getHeight());
					}
					butbuy.setVisible(false);
					break;
				case 10:
					if (B10 == 1) {
						sprite.setTexture(rock10u);
						butbuy.setVisible(true);
					} else {
						sprite.setTexture(rock10);
						butbuy.setVisible(false);
					}
					sprite.setSize(rock10.getWidth(), rock10.getHeight());
					if (flag == 1) {
						name.setTexture(name10);
						spisok.setTexture(S10);
						name.setSize(name10.getWidth(), name10.getHeight());
					} else {
						name.setTexture(name10RU);
						spisok.setTexture(S10RU);
						name.setSize(name10RU.getWidth(), name10RU.getHeight());
					}
					break;
				case 11:
					if (B11 == 1) {
						sprite.setTexture(rock11u);
						butbuy.setVisible(true);
					} else {
						sprite.setTexture(rock11);
						butbuy.setVisible(false);
					}
					sprite.setSize(rock11.getWidth(), rock11.getHeight());
					if (flag == 1) {
						name.setTexture(name11);
						spisok.setTexture(S11);
						name.setSize(name11.getWidth(), name11.getHeight());
					} else {
						name.setTexture(name11RU);
						spisok.setTexture(S11RU);
						name.setSize(name11RU.getWidth(), name11RU.getHeight());
					}
					break;
				case 12:
					if (B12 == 1) {
						sprite.setTexture(rock12u);
						butbuy.setVisible(true);
					} else {
						sprite.setTexture(rock12);
						butbuy.setVisible(false);
					}
					sprite.setSize(rock12.getWidth(), rock12.getHeight());
					if (flag == 1) {
						name.setTexture(name12);
						spisok.setTexture(S12);
						name.setSize(name12.getWidth(), name12.getHeight());
					} else {
						name.setTexture(name12RU);
						spisok.setTexture(S12RU);
						name.setSize(name12RU.getWidth(), name12RU.getHeight());
					}
					break;
				case 13:
					if (B13 == 1) {
						sprite.setTexture(rock13u);
						butbuy.setVisible(true);
					} else {
						sprite.setTexture(rock13);
						butbuy.setVisible(false);
					}
					sprite.setSize(rock13.getWidth(), rock13.getHeight());
					if (flag == 1) {
						name.setTexture(name13);
						spisok.setTexture(S13);
						name.setSize(name13.getWidth(), name13.getHeight());
					} else {
						name.setTexture(name13RU);
						spisok.setTexture(S13RU);
						name.setSize(name13RU.getWidth(), name13RU.getHeight());
					}
					break;
				case 14:
					if (B14 == 1) {
						sprite.setTexture(rock14u);
						butbuy.setVisible(true);
					} else {
						sprite.setTexture(rock14);
						butbuy.setVisible(false);
					}
					sprite.setSize(rock14.getWidth(), rock14.getHeight());
					if (flag == 1) {
						name.setTexture(name14);
						spisok.setTexture(S14);
						name.setSize(name14.getWidth(), name14.getHeight());
					} else {
						name.setTexture(name14RU);
						spisok.setTexture(S14RU);
						name.setSize(name14RU.getWidth(), name14RU.getHeight());
					}
					break;
				case 15:
					if (B15 == 1) {
						sprite.setTexture(rock15u);
						butbuy.setVisible(true);
					} else {
						sprite.setTexture(rock15);
						butbuy.setVisible(false);
					}
					sprite.setSize(rock15.getWidth(), rock15.getHeight());
					if (flag == 1) {
						name.setTexture(name15);
						spisok.setTexture(S15);
						name.setSize(name15.getWidth(), name15.getHeight());
					} else {
						name.setTexture(name15RU);
						spisok.setTexture(S15RU);
						name.setSize(name15RU.getWidth(), name15RU.getHeight());
					}
					break;
				case 16:
					if (B16 == 1) {
						sprite.setTexture(rock16u);
						butbuy.setVisible(true);
					} else {
						sprite.setTexture(rock16);
						butbuy.setVisible(false);
					}
					sprite.setSize(rock16.getWidth(), rock16.getHeight());
					if (flag == 1) {
						name.setTexture(name16);
						spisok.setTexture(S16);
						name.setSize(name16.getWidth(), name16.getHeight());
					} else {
						name.setTexture(name16RU);
						spisok.setTexture(S16RU);
						name.setSize(name16RU.getWidth(), name16RU.getHeight());
					}
					break;
				case 17:
					if (B17 == 1) {
						sprite.setTexture(rock17u);
						butbuy.setVisible(true);
					} else {
						sprite.setTexture(rock17);
						butbuy.setVisible(false);
					}
					sprite.setSize(rock17.getWidth(), rock17.getHeight());
					if (flag == 1) {
						name.setTexture(name17);
						spisok.setTexture(S17);
						name.setSize(name17.getWidth(), name17.getHeight());
					} else {
						name.setTexture(name17RU);
						spisok.setTexture(S17RU);
						name.setSize(name17RU.getWidth(), name17RU.getHeight());
					}
					break;
				case 18:
					sprite.setTexture(rock18);
					sprite.setSize(rock18.getWidth(), rock18.getHeight());
					if (flag == 1) {
						spisok.setTexture(S18);
						name.setTexture(name18);
						name.setSize(name18.getWidth(), name18.getHeight());
					} else {
						spisok.setTexture(S18RU);
						name.setTexture(name18RU);
						name.setSize(name18RU.getWidth(), name18RU.getHeight());
					}
					butbuy.setVisible(false);
					break;
				case 19:
					sprite.setTexture(rock19);
					sprite.setSize(rock19.getWidth(), rock19.getHeight());
					if (flag == 1) {
						spisok.setTexture(S19);
						name.setTexture(name19);
						name.setSize(name19.getWidth(), name19.getHeight());
					} else {
						spisok.setTexture(S19RU);
						name.setTexture(name19RU);
						name.setSize(name19RU.getWidth(), name19RU.getHeight());
					}
					butbuy.setVisible(false);
					break;
				case 20:
					sprite.setTexture(rock20);
					sprite.setSize(rock20.getWidth(), rock20.getHeight());
					if (flag == 1) {
						spisok.setTexture(S20);
						name.setTexture(name20);
						name.setSize(name20.getWidth(), name20.getHeight());
					} else {
						spisok.setTexture(S20RU);
						name.setTexture(name20RU);
						name.setSize(name20RU.getWidth(), name20RU.getHeight());
					}
					butbuy.setVisible(false);
					break;
			}

			if (helping == 1) {
				button.setVisible(false);
				buttonhelp.setVisible(false);
				butleft.setVisible(false);
				butfonright.setVisible(false);
				butfonleft.setVisible(false);
				butright.setVisible(false);
				butOK.setVisible(true);
				butbuy.setVisible(false);
				butzvuk.setVisible(false);
				butflag.setVisible(false);
				if (Lessons == 1) {
					butlesL.setVisible(false);
				} else butlesL.setVisible(true);
				if (Lessons == 4) {
					butlesR.setVisible(false);
				} else butlesR.setVisible(true);
			} else {
				Lessons = 1;
				button.setVisible(true);
				buttonhelp.setVisible(true);
				butleft.setVisible(true);
				butright.setVisible(true);
				butOK.setVisible(false);
				butlesL.setVisible(false);
				butlesR.setVisible(false);
				butfonright.setVisible(true);
				butflag.setVisible(true);
				butfonleft.setVisible(true);
				butzvuk.setVisible(true);
			}

			sprite.setPosition(447 + 156 / 2 - sprite.getWidth() / 2, 270);
			name.setPosition(447 + 156 / 2 - name.getWidth() / 2, 356);
			spisok.setPosition(198, 165);
		}

	}

	@Override
	public void render(SpriteBatch sb) {

		sb.setProjectionMatrix(camera.combined);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sb.begin();
		if (GameStatus == 1) {
			if (ChooseFon == 1) {
				if (flag == 1) {
					sb.draw(Fon, 0, 0);
				} else sb.draw(FonRU, 0, 0);
			}
			if (ChooseFon == 2) {
				if (flag == 1) {
					sb.draw(Fon2, 0, 0);
				} else sb.draw(Fon2RU, 0, 0);
			}
			if (ChooseFon == 3) {
				if (flag == 1) {
					sb.draw(Fon3, 0, 0);
				} else sb.draw(Fon3RU, 0, 0);
			}
			sprite.draw(sb);
			name.draw(sb);
			spisok.draw(sb);
			if (helping == 1) {
				switch (Lessons) {
					case 1:
						if (flag == 1)
							sb.draw(LES1, 0, 0);
						else sb.draw(LES1R, 0, 0);
						break;
					case 2:
						if (flag == 1)
							sb.draw(LES2, 0, 0);
						else sb.draw(LES2R, 0, 0);
						break;
					case 3:
						if (flag == 1)
							sb.draw(LES3, 0, 0);
						else sb.draw(LES3R, 0, 0);
						break;
					case 4:
						if (flag == 1)
							sb.draw(LES4, 0, 0);
						else sb.draw(LES4R, 0, 0);
						break;
				}
			}
			if (helping == 0) {
				sb.draw(monetka, 610, 50);
				font.draw(sb, Integer.toString(Money), 680, 90);
			}
			b.draw(sb, " ", 0, 0);
		}
		sb.end();
		if (GameStatus == 1)
		stage.draw();
		sb.begin();
		if (GameStatus == 1) {
			if (TimeLoading > 0.1) {
				if (flag == 1)
					sb.draw(Loading, 0, 0);
				else sb.draw(LoadingR, 0, 0);
			}
		}
		if (GameStatus == 0){
			preS.draw(sb);
		}
		sb.end();
	}

	@Override
	public void show() {
	}

	@Override
	public void render(float delta) {
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height);
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
		Fon.dispose();Fon2.dispose();Fon3.dispose();Fon3RU.dispose();preT.dispose();FonRU.dispose();Fon2RU.dispose();Loading.dispose();stage.dispose();SoundAtlas.dispose();SoundSkin.dispose();FlagSkin.dispose();FlagAtlas.dispose();
		rock1.dispose();rock2.dispose();rock3.dispose();rock4.dispose();rock5.dispose();rock6.dispose();rock19.dispose();rock18.dispose();rock20.dispose();name20.dispose();name19.dispose();name18.dispose();
		rock7.dispose();rock8.dispose();rock9.dispose();rock10.dispose();rock11.dispose();rock12.dispose();rock13.dispose();rock17.dispose();rock16.dispose();rock15.dispose();rock14.dispose();
		name1.dispose();name2.dispose();name3.dispose();name4.dispose();name5.dispose();name6.dispose();name7.dispose();name8.dispose();name9.dispose();name10.dispose();name11.dispose();name12.dispose();name13.dispose();name14.dispose();name15.dispose();name16.dispose();name17.dispose();
		font.dispose();monetka.dispose();music.dispose();sound.dispose();S1.dispose();S2.dispose();S3.dispose();S4.dispose();S5.dispose();S6.dispose();S7.dispose();S8.dispose();S9.dispose();S10.dispose();S11.dispose();S12.dispose();S13.dispose();S14.dispose();S15.dispose();S16.dispose();S17.dispose();
		buttonsAtlas.dispose();b.dispose();butAtlaslesson.dispose();butskinles.dispose();buttonSkin.dispose();LES1.dispose();LES2.dispose();LES3.dispose();LES4.dispose();LES1R.dispose();LES2R.dispose();LES3R.dispose();LES4R.dispose();
		S1RU.dispose();name20RU.dispose();name19RU.dispose();name18RU.dispose();S18RU.dispose();S19RU.dispose();S20RU.dispose();S18.dispose();S19.dispose();S20.dispose();
		S2RU.dispose();S3RU.dispose();S4RU.dispose();S5RU.dispose();S6RU.dispose();S7RU.dispose();S8RU.dispose();S9RU.dispose();S10RU.dispose();S11RU.dispose();S12RU.dispose();S13RU.dispose();S14RU.dispose();S15RU.dispose();S16RU.dispose();S17RU.dispose();
		name1RU.dispose();name2RU.dispose();name3RU.dispose();name4RU.dispose();name5RU.dispose();name6RU.dispose();name7RU.dispose();name8RU.dispose();name9RU.dispose();name10RU.dispose();name11RU.dispose();name12RU.dispose();name13RU.dispose();name14RU.dispose();name15RU.dispose();name16RU.dispose();name17RU.dispose();
	}
}
