/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015  Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2015 Evan Debenham
 *
 * Goblins Pixel Dungeon
 * Copyright (C) 2016 Mario Braun
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.shatteredpixel.pixeldungeonunleashed.items.food;

import com.shatteredpixel.pixeldungeonunleashed.actors.buffs.Hunger;
import com.shatteredpixel.pixeldungeonunleashed.sprites.ItemSpriteSheet;

public class OverpricedRation extends Food {

	{
		name = "compressed food ration";
		image = ItemSpriteSheet.OVERPRICED;
		energy = Hunger.HUNGRY;
		message = "That food tasted ok. Could use some garlic, though.";
		hornValue = 1;
	}
	
	@Override
	public String info() {
		return "An ancient dwarven formula makes this small package as nourishing and filling as the best meal. Use condiments.";
	}
	
	@Override
	public int price() {
		return 20 * quantity;
	}
}
