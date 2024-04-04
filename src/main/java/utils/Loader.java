package utils;

import java.util.Random;

public class Loader {
   private static final String[] loadingTexts = new String[]{
            "Teaching robots to dream...",
            "Charging creativity batteries...",
            "Asking the crystal ball...",
            "Warming up the quantum computer...",
            "Calibrating the neural networks...",
            "Consulting with the digital oracle...",
            "Brewing some digital coffee...",
            "Counting electric sheep...",
            "Looking through the telescope...",
            "Feeding the data hamsters...",
            "Spinning up the hamster wheel...",
            "Sharpening pencils for the AI...",
            "Reticulating splines...",
            "Chasing the bytes...",
            "Generating witty dialogues...",
            "Bending the laws of physics...",
            "Distilling the essence of AI...",
            "Harmonizing the data symphony...",
            "Predicting the future...",
            "Deciphering the enigma...",
            "Aligning the stars...",
            "Summoning digital spirits...",
            "Whispering to the satellites...",
            "Polishing the pixels...",
            "Decrypting the secrets of the universe...",
            "Harnessing the power of the sun...",
            "Composing a digital masterpiece...",
            "Navigating the maze of code...",
            "Gathering the cloud's wisdom...",
            "Casting a computational spell...",
            "Building sandcastles in the cloud...",
            "Winding the clockwork of the internet...",
            "Sailing the digital seas...",
            "Exploring the data jungle...",
            "Conducting the electricity orchestra...",
            "Beaming up the bytes...",
            "Crafting digital dreams...",
            "Weaving the web...",
            "Fishing for compliments...",
            "Counting stars...",
            "Tuning the strings of the universe...",
            "Talking to the moon...",
            "Painting the clouds...",
            "Reading tea leaves...",
            "Planting digital seeds...",
            "Growing binary trees...",
            "Baking cookies in the oven...",
            "Solving the world's problems...",
            "Learning new tricks...",
            "Chasing rainbows...",
            "Finding the end of the internet...",
            "Crossing the digital divide...",
            "Making the donuts...",
            "Converting coffee into code...",
            "Unraveling the mysteries of AI...",
            "Exploring parallel universes...",
            "Balancing the scales of data...",
            "Sculpting in zeros and ones...",
            "Unlocking the secrets of the matrix...",
            "Charging the flux capacitor...",
            "Greasing the gears of progress...",
            "Stirring the pixel pot...",
            "Dusting off the old archives...",
            "Orchestrating a symphony of bits...",
            "Juggling with data...",
            "Packing parachutes for cloud jumping...",
            "Mixing the potion of performance...",
            "Setting the stage for magic...",
            "Fluffing the clouds...",
            "Ticking the tock...",
            "Lacing up the boots for a data hike...",
            "Turning the pages of history...",
            "Sharpening the bits...",
            "Illuminating the dark web...",
            "Knitting the fabric of the internet...",
            "Charging lasers...",
            "Engaging hyperdrive...",
            "Cracking the code...",
            "Brewing storms in teacups...",
            "Navigating the streams of data...",
            "Folding space and time...",
            "Uncorking the bottle of possibilities...",
            "Journeying through the code forest...",
            "Drawing the digital curtains...",
            "Laying the cables of connection...",
            "Connecting the dots...",
            "Firing up the rockets...",
            "Diving into the data lake...",
            "Sharpening the algorithms...",
            "Warping through code dimensions...",
            "Taming the digital beasts...",
            "Unlocking the digital treasures...",
            "Embarking on a pixel adventure...",
            "Decoding the mysteries...",
            "Recharging imagination...",
            "Assembling the avatars...",
            "Piloting the digital ship...",
            "Plotting the course through cyberspace...",
            "Navigating the silicon pathways...",
            "Crafting stories from bits...",
            "Climbing the data mountain...",
            "Charting the unknown territories of AI..."
    };
    private static final Random random = new Random();
    public static String getRandomLoadingText() {
        int index = random.nextInt(loadingTexts.length);
        return loadingTexts[index];
    }
}