package com.haven.techassessment.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/*
    Not Used:
    This class was created to combat type erasure that happens when passing/returning model objects.

    I created this class before I learned that Gson would handle it for me. It is no longer required/used, but I left it
    in so you could see the thought process.
 */
public class TMDbTypeResolver<T> implements ParameterizedType {
    private Class<T> clazz;

    public TMDbTypeResolver(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return new Type[]{clazz};
    }

    @Override
    public Type getRawType() {
        return clazz;
    }

    @Override
    public Type getOwnerType() {
        return null;
    }
}
