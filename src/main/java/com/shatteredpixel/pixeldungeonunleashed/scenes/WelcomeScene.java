/*
 * Unleashed Pixel Dungeon
 * Copyright (C) 2015  David Mitchell
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
package com.shatteredpixel.pixeldungeonunleashed.scenes;

import com.shatteredpixel.pixeldungeonunleashed.Chrome;
import com.shatteredpixel.pixeldungeonunleashed.GoblinsPixelDungeon;
import com.shatteredpixel.pixeldungeonunleashed.ui.Archs;
import com.shatteredpixel.pixeldungeonunleashed.ui.RedButton;
import com.shatteredpixel.pixeldungeonunleashed.ui.ScrollPane;
import com.shatteredpixel.pixeldungeonunleashed.ui.Window;
import com.shatteredpixel.pixeldungeonunleashed.windows.WndMessage;
import com.watabou.noosa.BitmapTextMultiline;
import com.watabou.noosa.Camera;
import com.watabou.noosa.Game;
import com.watabou.noosa.NinePatch;
import com.watabou.noosa.ui.Component;

//TODO: update this class with relevant info as new versions come out.
public class WelcomeScene extends PixelScene {

	private static final String TTL_Welcome = "Welcome!";

	private static final String TTL_Update = "v0.1.5.1: Release";

	private static final String TTL_Future = "Wait What?";

	private static final String TXT_Welcome =
			"Goblins Pixel Dungeon is a rework/expansion of Unleashed Pixel Dungeon.\n\n"+
			"The game is a work in progress, so bear with me in case of bugs. :3\n"+
			"To change difficulty levels click on the Out-of-Game Settings (little gears) in "+
			"the top left corner, difficulty will also change when you load games.\n\n"+
			"Enjoy";

	private static final String TXT_Update =
			"v0.1.5.1: Release\n"+
					"- Bugfix for Klik vulnerabilities.\n"+
					"- Bugfix for phase shift Klik.\n"+
					"- Reworked lock generation.\n"+
					"- Fixed lock picking in hell.\n"+
					"- Added resist and immune sprite info.\n"+
                    "- Slightly nerfed wolves.\n"+
					"- Bugfixed message log flooding.\n"+
					"- Changed font.\n"+
			"v0.1.5: Release\n"+
					"- Added Lock Picking. :)\n"+
					"- Added new Artifact: Hummingtool\n"+
					"- Added Easter Eggs to be hatched.\n"+
					"- Nerfed Metal Klik.\n"+
					"- Revamped Klik immunities.\n"+
					"- Added Klik vulnerabilities.\n"+
					"- Klik damage declines with health.\n"+
					"- Klik exp to level up increased.\n"+
					"- Increased metal klik cooldown.\n"+
			"v0.1.4: Release\n"+
					"- Added Kliks as pets! :D\n"+
					"- Added special healthbar for pet.\n"+
					"- Changed healing when feeding the pet.\n"+
					"- Pets follow the descend if in line of sight.\n"+
					"- Finally fixed the donation freeze. :)\n";

	private static final String TXT_Future =
			"It seems that your current saves are from a future version of Goblins Pixel Dungeon!\n\n"+
			"Either you're messing around with older versions of the app, or something has gone buggy.\n\n"+
			"Regardless, tread with caution! Your saves may contain things which don't exist in this version, "+
			"this could cause some very weird errors to occur.";

	@Override
	public void create() {
		super.create();

		final int gameversion = GoblinsPixelDungeon.version();

		BitmapTextMultiline title;
		BitmapTextMultiline text;

		if (gameversion == 0) {

			text = createMultiline(TXT_Welcome, 9);
			title = createMultiline(TTL_Welcome, 14);

		} else if (gameversion <= Game.versionCode) {

			text = createMultiline(TXT_Update, 6 );
			title = createMultiline(TTL_Update, 9 );

		} else {

			text = createMultiline( TXT_Future, 9 );
			title = createMultiline( TTL_Future, 14 );

		}

		int w = Camera.main.width;
		int h = Camera.main.height;

		int pw = w - 10;
		int ph = h - 50;

		title.maxWidth = pw;
		title.measure();
		title.hardlight(Window.SHPX_COLOR);

		title.x = align( (w - title.width()) / 2 );
		title.y = align( 8 );
		add( title );

		NinePatch panel = Chrome.get(Chrome.Type.WINDOW);
		panel.size( pw, ph );
		panel.x = (w - pw) / 2;
		panel.y = (h - ph) / 2;
		add( panel );

		ScrollPane list = new ScrollPane( new Component() );
		add( list );
		list.setRect(
				panel.x + panel.marginLeft(),
				panel.y + panel.marginTop(),
				panel.innerWidth(),
				panel.innerHeight());
		list.scrollTo( 0, 0 );

		Component content = list.content();
		content.clear();

		text.maxWidth = (int) panel.innerWidth();
		text.measure();

		content.add(text);

		content.setSize( panel.innerWidth(), text.height() );

		RedButton okay = new RedButton("Okay!") {
			@Override
			protected void onClick() {
				GoblinsPixelDungeon.version(Game.versionCode);
				Game.switchScene(TitleScene.class);
			}
		};

		//okay.setRect(text.x, text.y + text.height() + 5, 55, 18);
        okay.setRect(pw - 60, h - 22, 55, 18);
		add(okay);

		RedButton changes = new RedButton("Changes") {
			@Override
			protected void onClick() {
				parent.add(new WndMessage(TXT_Update));
			}
		};

		changes.setRect(((w - pw) / 2) + 10, h - 22, 55, 18);
		add(changes);
/*
		okay.setRect((w - pw) / 2, h - 22, pw, 18);
		add(okay);*/

		Archs archs = new Archs();
		archs.setSize( w, h );
		addToBack( archs );

		fadeIn();
	}
}


