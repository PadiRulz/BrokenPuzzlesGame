package com.example.manager;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.Engine;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.debug.Debug;

import com.example.brokenpuzzlesgame.GameActivity;

/**
 * @author Prateek Joshi
 * @author Vaibhav Devpura
 * @version 1.0
 */

public class ResourceManager {
	// ---------------------------------------------
	// VARIABLES
	// ---------------------------------------------

	private static final ResourceManager INSTANCE = new ResourceManager();

	public Engine engine;
	public GameActivity activity;
	public Camera camera;
	public VertexBufferObjectManager vbom;
	public Font font;

	// ---------------------------------------------
	// TEXTURES & TEXTURE REGIONS
	// ---------------------------------------------

	public ITextureRegion splash_region;
	public ITextureRegion menu_background_region;
	public ITextureRegion button_region;
	public ITextureRegion oldman;

	// Game Texture
	public BuildableBitmapTextureAtlas gameTextureAtlas;

	// Game Texture Regions
	public ITextureRegion mBackgroundTextrueRegion;
	public ITextureRegion mP1;
	public ITextureRegion mP2;
	public ITextureRegion mP3;

	private BitmapTextureAtlas splashTextureAtlas;
	private BitmapTextureAtlas menuTextureAtlas;

	// Level Complete Window
	// To be implemented

	// ---------------------------------------------
	// CLASS LOGIC
	// ---------------------------------------------

	public void loadMenuResources() {
		loadMenuGraphics();
		loadMenuAudio();
		loadMenuFonts();
	}

	public void loadGameResources() {
		loadGameGraphics();
		loadGameFonts();
		loadGameAudio();
	}

	private void loadMenuFonts() {
		// TODO Auto-generated method stub

	}

	private void loadMenuAudio() {
		// TODO Auto-generated method stub

	}

	private void loadMenuGraphics() {
		// TODO Auto-generated method stub
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		menuTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 320, 460, TextureOptions.BILINEAR);
		menu_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(menuTextureAtlas, activity, "homepage1.png",0,0);
		button_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				menuTextureAtlas, activity, "taptobegin.png",75,260);
		oldman = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				menuTextureAtlas, activity, "old.png",100,200);
		menuTextureAtlas.load();
	}

	private void loadGameAudio() {
		// TODO Auto-generated method stub

	}

	private void loadGameFonts() {
		// TODO Auto-generated method stub

	}

	private void loadGameGraphics() {
		// TODO Auto-generated method stub
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/game/");
		gameTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 320, 460, TextureOptions.BILINEAR);

		mBackgroundTextrueRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(gameTextureAtlas, activity, "background.png");
		mP1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				gameTextureAtlas, activity, "p1.png");
		mP2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				gameTextureAtlas, activity, "p2.png");
		mP3 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				gameTextureAtlas, activity, "p3.png");

		/*
		 * =
		 * BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas
		 * , activity, "levelCompleteWindow.png"); complete_stars_region =
		 * BitmapTextureAtlasTextureRegionFactory
		 * .createTiledFromAsset(gameTextureAtlas, activity, "star.png", 2, 1);
		 */
		try {
			this.gameTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.gameTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			Debug.e(e);
		}

	}

	public void unloadGameTextures() {
		// TODO (Since we did not create any textures for game scene yet)
	}

	public void loadSplashScreen() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		splashTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 320, 460, TextureOptions.BILINEAR);
		splash_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				splashTextureAtlas, activity, "splash.png", 0, 0);
		splashTextureAtlas.load();
	}

	public void unloadSplashScreen() {
		splashTextureAtlas.unload();
		splash_region = null;
	}

	public void unloadMenuTextures() {
		menuTextureAtlas.unload();
	}

	public void loadMenuTextures() {
		menuTextureAtlas.load();
	}

	/**
	 * @param engine
	 * @param activity
	 * @param camera
	 * @param vbom
	 * <br>
	 * <br>
	 *            We use this method at beginning of game loading, to prepare
	 *            Resources Manager properly, setting all needed parameters, so
	 *            we can latter access them from different classes (eg. scenes)
	 */
	public static void prepareManager(Engine engine, GameActivity activity,
			Camera camera, VertexBufferObjectManager vbom) {
		getInstance().engine = engine;
		getInstance().activity = activity;
		getInstance().camera = camera;
		getInstance().vbom = vbom;
	}

	// ---------------------------------------------
	// GETTERS AND SETTERS
	// ---------------------------------------------

	public static ResourceManager getInstance() {
		return INSTANCE;
	}

}
