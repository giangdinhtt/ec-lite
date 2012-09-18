package org.cath.ec.util;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils {

	public static JSONObject putJSONValue(JSONObject json, String key, Object value) throws JSONException {
        if (value == null) {
            value = JSONObject.NULL;
        }

        return json.put(key, value);
    }
}
