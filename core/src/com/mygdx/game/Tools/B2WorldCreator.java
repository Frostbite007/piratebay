package com.mygdx.game.Tools;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.PirateBay;
import com.mygdx.game.Screens.PlayScreen;
import com.mygdx.game.Sprite.Coins;
import com.mygdx.game.Sprite.Floor;
import com.mygdx.game.Sprite.Slime;
import com.mygdx.game.Sprite.Stair;

public class B2WorldCreator {
	private Array<Slime> slime;
	
	public B2WorldCreator(PlayScreen screen) {
		TiledMap map = screen.getMap();
		
		for(MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();
			
			new Floor(screen, rect);
		}
		
		for(MapObject object : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();
			
			new Coins(screen, rect);
		}
		
		for(MapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();
			
			new Stair(screen, rect);
		}
		
		slime = new Array<Slime>();
		for(MapObject object : map.getLayers().get(6).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();
			slime.add(new Slime(screen, rect.getX() / PirateBay.PPM, rect.getY() / PirateBay.PPM));
		}
	}
	
	public Array<Slime> getSlime() {
		return slime;
	}
}
