package com.njby.utils;

import com.google.gson.Gson;

public final class JsonUtil {

	public static final Gson gson = new Gson();
	
	public static String toJson(Object o) {
		String gsonStr = null;
		try {
			gsonStr = gson.toJson(o);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return gsonStr;
	}
}
