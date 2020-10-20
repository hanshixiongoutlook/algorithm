package hans.algorithm.utils;

/**
 * 打印日志
 */
public class Logger {
	/**
	 * 打印日志
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
}
