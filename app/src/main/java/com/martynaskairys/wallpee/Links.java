package com.martynaskairys.wallpee;

import android.graphics.Picture;

import java.util.Random;

public class Links {

	public static String[] IMAGE_URLS = {
			"http://xdsoft.net/images/joomla/mod_nice_carusel/next/so_nice_to_meat_you_by_fennecx.jpg",
			"https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTX6OzYgFf1ywl7vnRhoJ0rauWHqT7V3hcQkPfvwA6t7U3CqB65",
			"https://encrypted-tbn2.gstatic" +
					".com/images?q=tbn:ANd9GcRgNsRRspeRGTccOiyNWlCzPvYshPztWqR3o15X6no1L_GbeYiUTkrD4RQ",
			"http://oi44.tinypic.com/9asbk3.jpg",
			"http://oi42.tinypic.com/n682rm.jpg",
			"https://app.box.com/representation/file_version_54765205333/image_2048/1.png?shared_name=21w4y8kudl138s8q0xyyuer40lxnwvja",
			"https://app.box.com/representation/file_version_55089755065/image_2048_jpg/1.jpg?shared_name=ko3y2zo5wlsu6qvq8q2bx81xwz9bv7o3",
			"http://oi41.tinypic.com/sdfewy.jpg"
	};

	// Method (abilities: things the object can do)
	public String getPicture() {

		String picture = "";

		// Randomly select a picture
		Random randomGenerator = new Random();  // Construct a new Random number generator
		int randomNumber = randomGenerator.nextInt(IMAGE_URLS.length);

		picture = IMAGE_URLS[randomNumber];

		return picture;
	}




}
