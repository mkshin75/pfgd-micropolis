// This file is part of MicropolisJ.
// Copyright (C) 2013 Jason Long
// Portions Copyright (C) 1989-2007 Electronic Arts Inc.
//
// MicropolisJ is free software; you can redistribute it and/or modify
// it under the terms of the GNU GPLv3, with additional terms.
// See the README file, included in this distribution, for details.

package micropolisj.engine;

import static micropolisj.engine.TileConstants.*;

/**
 * Implements an explosion.
 * An explosion occurs when certain sprites collide,
 * or when a zone is demolished by fire.
 */
public class CrimeSprite extends Sprite
{
	int count;
	int soundCount;
	int destX;
	int destY;
	int origX;
	int origY;
	int step;
	boolean flag; 


	static int [] Gx = { 2, 2, -2, -2, 0 };
	static int [] Gy = { -2, 2, 2, -2, 0 };

	static int [] ND1 = {  0, 1, 2, 3 };
	static int [] ND2 = {  1, 2, 3, 0 };
	static int [] nn1 = {  2, 5, 8, 11 };
	static int [] nn2 = { 11, 2, 5,  8 };

	public CrimeSprite(Micropolis engine, int xpos, int ypos)
	{
		super(engine, SpriteKind.EXP);
		this.x = xpos * 16 + 8;
		this.y = ypos * 16 + 8;
		this.width = 48;
		this.height = 48;
		this.offx = -24;
		this.offy = -24;

		this.origX = x;
		this.origY = y;

		this.frame = 1;
		this.count = 80;
	}

	@Override
	public void moveImpl()
	{
		if (this.frame == 0) {
			return;
		}

		if (soundCount > 0) {
			soundCount--;
		}


		assert this.frame >= 1 && this.frame <= 16;

		if (this.count > 0) {
			this.count--;
		}

		if (this.count == 0) {
			this.frame = 0; 
		}


	}
}
