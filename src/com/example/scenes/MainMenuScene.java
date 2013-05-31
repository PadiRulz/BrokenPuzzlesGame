package com.example.scenes;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.util.GLState;

import com.example.base.BaseScene;
import com.example.manager.SceneManager;
import com.example.manager.SceneManager.SceneType;

public class MainMenuScene extends BaseScene {

	@Override
	public void createScene() {
		// TODO Auto-generated method stub
		createbackground();
		createplayscene();
		createoldman();
	}

	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return SceneType.SCENE_MENU;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub

	}

	private void createplayscene() {
		// TODO Auto-generated method stub
		final Sprite mButton = new Sprite(75, 260,
				resourcesManager.button_region, vbom) {

			@Override
			protected void onManagedUpdate(final float pSecondsElapsed) {
				super.onManagedUpdate(pSecondsElapsed);

			}

			@Override
			public boolean onAreaTouched(TouchEvent pSceneTouchEvent,
					float pTouchAreaLocalX, float pTouchAreaLocalY) {

				switch (pSceneTouchEvent.getAction()) {

				case TouchEvent.ACTION_DOWN:

					break;

				case TouchEvent.ACTION_UP:
					SceneManager.getInstance().loadGameScene(engine);
					break;

				case TouchEvent.ACTION_MOVE:

					break;

				}
				return true;
			}
		};
		attachChild(mButton);
		registerTouchArea(mButton);
		setTouchAreaBindingOnActionDownEnabled(true);
	}

	private void createbackground() {
		// TODO Auto-generated method stub
		attachChild(new Sprite(0, 0, resourcesManager.menu_background_region,
				vbom) {

			@Override
			protected void preDraw(GLState pGLState, Camera pCamera) {
				// TODO Auto-generated method stub
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}

		});
	}

	private void createoldman() {
		// TODO Auto-generated method stub
		attachChild(new Sprite(100, 200, resourcesManager.oldman, vbom) {

			@Override
			protected void preDraw(GLState pGLState, Camera pCamera) {
				// TODO Auto-generated method stub
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}

		});
	}
}
