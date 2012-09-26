package org.cath.ec.model;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbstractModel implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @SuppressWarnings("rawtypes")
    public String toJson() {
        JSONObject builder = new JSONObject();
        try {
            for (Field field : getClass().getDeclaredFields()) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object fieldValue = null;
                try {
                    fieldValue = field.get(this);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (fieldValue == null) {
                    builder.put(fieldName, JSONObject.NULL);
                    continue;
                }
                if (field.getType().isArray()) {
                    // Field is array
                } else if (field.getGenericType() instanceof ParameterizedType) {
                    // Field is a parameterized type
                    try {
                        if (fieldValue instanceof Collection) {
                            JSONArray arr = new JSONArray();
                            for (Object obj : (Collection) fieldValue) {
                                if (obj == null) {
                                    arr.put(JSONObject.NULL);
                                } else if (obj instanceof AbstractModel) {
                                    arr.put(((AbstractModel) obj).toJson());
                                } else {
                                    arr.put(obj.toString());
                                }
                            }
                            builder.put(fieldName, arr);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    if (fieldValue instanceof AbstractModel) {
                        builder.put(fieldName, ((AbstractModel) fieldValue).toJson());
                    } else {
                        builder.put(fieldName, fieldValue.toString());
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
