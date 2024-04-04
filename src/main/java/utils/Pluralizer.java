package utils;

import java.util.HashMap;
import java.util.Map;

public class Pluralizer {

    private static final Map<String, String> irregularNouns = new HashMap<>();

    static {
        String[][] irregularPlurals = {
                {"man", "men"},
                {"woman", "women"},
                {"child", "children"},
                {"tooth", "teeth"},
                {"foot", "feet"},
                {"person", "people"},
                {"leaf", "leaves"},
                {"mouse", "mice"},
                {"goose", "geese"},
                {"half", "halves"},
                {"knife", "knives"},
                {"wife", "wives"},
                {"life", "lives"},
                {"elf", "elves"},
                {"loaf", "loaves"},
                {"potato", "potatoes"},
                {"tomato", "tomatoes"},
                {"cactus", "cacti"},
                {"focus", "foci"},
                {"fungus", "fungi"},
                {"nucleus", "nuclei"},
                {"syllabus", "syllabi"},
                {"analysis", "analyses"},
                {"diagnosis", "diagnoses"},
                {"oasis", "oases"},
                {"thesis", "theses"},
                {"crisis", "crises"},
                {"phenomenon", "phenomena"},
                {"criterion", "criteria"},
                {"datum", "data"},
                {"medium", "media"},
                {"alumnus", "alumni"},
                {"alumna", "alumnae"},
                {"index", "indices"},
                {"appendix", "appendices"},
                {"bacterium", "bacteria"},
                {"curriculum", "curricula"},
                {"referendum", "referenda"},
                {"spectrum", "spectra"},
                {"quorum", "quora"},
                {"ox", "oxen"},
                {"child", "children"},
                {"foot", "feet"},
                {"tooth", "teeth"},
                {"goose", "geese"},
                {"louse", "lice"},
                {"man", "men"},
                {"woman", "women"},
                {"mouse", "mice"},
                {"breath", "breaths"},
                {"chef", "chefs"},
                {"chief", "chiefs"},
                {"belief", "beliefs"},
                {"canvas", "canvases"},
                {"cliff", "cliffs"},
                {"proof", "proofs"},
                {"roof", "roofs"},
                {"safe", "safes"},
                {"scarf", "scarves"},
                {"wharf", "wharves"},
                {"echo", "echoes"},
                {"embargo", "embargoes"},
                {"hero", "heroes"},
                {"potato", "potatoes"},
                {"torpedo", "torpedoes"},
                {"veto", "vetoes"},
                {"cargo", "cargoes"},
                {"motto", "mottoes"},
                {"volcano", "volcanoes"},
                {"zero", "zeroes"},
                {"dwarf", "dwarves"},
                {"hoof", "hooves"},
                {"knife", "knives"},
                {"leaf", "leaves"},
                {"life", "lives"},
                {"self", "selves"},
                {"sheaf", "sheaves"},
                {"shelf", "shelves"},
                {"thief", "thieves"},
                {"wife", "wives"},
                {"wolf", "wolves"},
                {"foot", "feet"},
                {"goose", "geese"},
                {"tooth", "teeth"},
                {"antenna", "antennae"},
                {"formula", "formulae"},
                {"nebula", "nebulae"},
                {"vertebra", "vertebrae"},
                {"vita", "vitae"},
                {"millennium", "millennia"},
                {"memorandum", "memoranda"},
                {"criterion", "criteria"},
                {"phenomenon", "phenomena"},
                {"automaton", "automata"},
                {"stadium", "stadia"}
        };
        for (String[] exception : irregularPlurals) {
            irregularNouns.put(exception[0], exception[1]);
        }
    }

    public static String pluralize(String word) {
        if (word == null || word.isEmpty()) {
            return word;
        }
        word = word.trim();
        // Check if the word is an irregular noun
        if (irregularNouns.containsKey(word.toLowerCase())) {
            return irregularNouns.get(word.toLowerCase());
        }

        // Rule for words ending in 'y' if the letter before 'y' is not a vowel, replace 'y' with 'ies'
        if (word.endsWith("y") && word.length() > 1 && !isVowel(word.charAt(word.length() - 2))) {
            return word.substring(0, word.length() - 1) + "ies";
        }
        // Rule for words ending in 's', 'x', 'z', 'ch', 'sh', add 'es'
        if (word.endsWith("s") || word.endsWith("x") || word.endsWith("z")
                || word.endsWith("ch") || word.endsWith("sh")) {
            return word + "es";
        }
        // Default rule, add 's'
        return word + "s";
    }

    private static boolean isVowel(char c) {
        return "aeiou".indexOf(Character.toLowerCase(c)) != -1;
    }

}
