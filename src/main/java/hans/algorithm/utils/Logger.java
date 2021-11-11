package hans.algorithm.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * Logger Util
 * @author hanshixiong
 */
public class Logger {
	/**
	 * print log with placeholder
	 *
	 * @param message
	 * 		打印内容，支持{}作为占位符
	 * @param params
	 * 		替换参数，依次替换message中的{}
	 */
	public static void log(String message, Object ...params) {
		if (message==null) {
			System.out.println("null");
			return;
		}
		if (params==null || params.length==0) {
			System.out.println(message);
			return;
		}
		int replaceCount = -1;
		while (message.contains("{}")&&(replaceCount++)<params.length-1) {
			message = message.replaceFirst("\\{}", String.valueOf(params[replaceCount]));
		}
		System.out.println(message);
	}

	/**
	 * print message
	 * @param message
	 */
	public static void log(Object message) {
		if (message==null) {
			System.out.println("null");
			return;
		}
		System.out.println(message);
	}
	public static void logWithoutEnter(Object message) {
		if (message==null) {
			System.out.println("null");
			return;
		}
		System.out.print(message);
	}
	/**
	 * Print log and convert param to json.
	 * @param message
	 * 		打印内容，支持{}作为占位符
	 * @param params
	 * 		替换参数，依次替换message中的{}
	 */
	public static void log2Json(String message, Object ...params) {
		if (message==null) {
			System.out.println("null");
			return;
		}
		if (params==null || params.length==0) {
			System.out.println(message);
			return;
		}
		int replaceCount = -1;
		while (message.contains("{}")&&(replaceCount++)<params.length-1) {
			message = message.replaceFirst("\\{}", String.valueOf(JSONObject.toJSONString(params[replaceCount])));
		}
		System.out.println(message);
	}
	public static void log2Json(Object message) {
		System.out.println(JSONObject.toJSONString(message));
	}
}
