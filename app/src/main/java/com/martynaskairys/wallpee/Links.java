package com.martynaskairys.wallpee;

import java.util.Random;

public class Links {

    public static String[] IMAGE_URLS_A = {
            "http://xdsoft.net/images/joomla/mod_nice_carusel/next/so_nice_to_meat_you_by_fennecx.jpg",
            "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTX6OzYgFf1ywl7vnRhoJ0rauWHqT7V3hcQkPfvwA6t7U3CqB65",
            "https://encrypted-tbn2.gstatic" +
                    ".com/images?q=tbn:ANd9GcRgNsRRspeRGTccOiyNWlCzPvYshPztWqR3o15X6no1L_GbeYiUTkrD4RQ"
    };

    public static String[] IMAGE_URLS_B = {

            "http://oi44.tinypic.com/9asbk3.jpg",
            "http://oi42.tinypic.com/n682rm.jpg"
    };

    public static String[] IMAGE_URLS_C = {

            "https://app.box.com/representation/file_version_54765205333/image_2048/1.png?shared_name=21w4y8kudl138s8q0xyyuer40lxnwvja",
            "https://app.box.com/representation/file_version_55089755065/image_2048_jpg/1.jpg?shared_name=ko3y2zo5wlsu6qvq8q2bx81xwz9bv7o3",
            "http://oi41.tinypic.com/sdfewy.jpg"
    };

    public String getRandomPictureUrlA() {

        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(IMAGE_URLS_A.length);

        return IMAGE_URLS_A[randomNumber];
    }

    public String getRandomPictureUrlB() {

        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(IMAGE_URLS_B.length);

        return IMAGE_URLS_B[randomNumber];
    }

    public String getRandomPictureUrlC() {

        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(IMAGE_URLS_C.length);

        return IMAGE_URLS_C[randomNumber];
    }

}
