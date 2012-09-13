package org.cath.ec.util;

import java.text.Normalizer;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    /**
     * Removes accents from an unicode string.
     * 
     * @param str
     * @return
     */
    public static String deAccent(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFKD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

    /**
     * Returns a version of the input where all contiguous whitespace characters are replaced with a single space. Line
     * terminators are treated like whitespace.
     * 
     * @param str
     * @return
     */
    public static String removeDuplicateWhitespace(String str) {
        String patternStr = "\\s+";
        String replaceStr = " ";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(str);
        return matcher.replaceAll(replaceStr).trim();
    }

    /**
     * Capitalize the first letter of every word.
     * 
     * @param str
     * @return
     */
    public static String capitalizeFirstLetter(String str) {
        final StringTokenizer st = new StringTokenizer(str.toLowerCase(), " ", true);
        final StringBuilder sb = new StringBuilder();

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            token = String.format("%s%s", Character.toUpperCase(token.charAt(0)), token.substring(1));
            sb.append(token);
        }
        return sb.toString();
    }

    /**
     * Normalize a string. The string will be capitalized first letter of every word and removed duplicated
     * whitespace.
     * 
     * @param str
     * @return
     */
    public static String normalize(String str) {
        return capitalizeFirstLetter(removeDuplicateWhitespace(str));
    }
}
