package org.cath.ec.util;

import java.io.File;

public class URLUtils {
    public static final int LIMIT = 30;

    /**
     * Normalizes an URL. The url will be truncated at {@link #LIMIT} chars
     * 
     * @param url
     *            the url to normalize
     * @return the normalized url
     * @see #normalize(String, int, boolean)
     */
    public static String normalize(String url) {
        return normalize(url, LIMIT, true);
    }

    /**
     * 
     * @param url
     *            the url to normalize
     * @param limit
     *            do not process more than <code>limit + 1</code> chars
     * @param friendlyTruncate
     *            If <code>true</code>, will try to not cut a word if more than
     *            <code>limit</code> chars were processed. It will stop in the
     *            next special char
     * @return the normalized url
     */
    public static String normalize(String url, int limit, boolean friendlyTruncate) {
        char[] chars = url.toCharArray();

        StringBuffer sb = new StringBuffer(url.length());

        for (int i = 0; i < chars.length; i++) {
            if (i <= limit || (friendlyTruncate && i > limit && sb.charAt(sb.length() - 1) != '_')) {

                if (Character.isSpaceChar(chars[i]) || chars[i] == '-') {
                    if (friendlyTruncate && i > limit) {
                        break;
                    }

                    if (i > 0 && sb.charAt(sb.length() - 1) != '_') {
                        sb.append('_');
                    }
                }

                if (Character.isLetterOrDigit(chars[i])) {
                    sb.append(chars[i]);
                } else if (friendlyTruncate && i > limit) {
                    break;
                }
            }
        }

        return sb.toString().toLowerCase();
    }

    /**
     * Get relative path of a resource.
     * 
     * @param path
     * @param base
     * @return
     */
    public static String getRelativePath(String path, String base) {
        return new File(base).toURI().relativize(new File(path).toURI()).getPath();
    }
}
