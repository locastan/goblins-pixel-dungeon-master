/*
 * Copyright (C) 2012-2015  Oleg Dolya
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
package com.shatteredpixel.pixeldungeonunleashed.actors.buffs;

import com.shatteredpixel.pixeldungeonunleashed.actors.Char;
import com.shatteredpixel.pixeldungeonunleashed.items.rings.RingOfElements.Resistance;
import com.shatteredpixel.pixeldungeonunleashed.ui.BuffIndicator;

public class Euphoria extends FlavourBuff {

	public static final float DURATION	= 8f;

	{
		type = buffType.NEGATIVE;
	}

	@Override
	public int icon() {
		return BuffIndicator.EUPHORIA;
	}

	@Override
	public String toString() {
		return "Euphoria";
	}

	@Override
	public String desc() {
		return "Walking in a straight line can be difficult when the whole world is sooo fluffy!.\n" +
				"\n" +
				"While overwhelmed with euphoria, characters who attempt to move will go in a random direction, " +
				"instead of the one they intended to go in. They also have a tendency to strip \n" +
				"and throw away stuff just to see it fly.\n" +
				"\n" +
				"The Euphoria will last for " + dispTurns() + ".";
	}

	public static float duration( Char ch ) {
		Resistance r = ch.buff( Resistance.class );
		return r != null ? r.durationFactor() * DURATION : DURATION;
	}
}
