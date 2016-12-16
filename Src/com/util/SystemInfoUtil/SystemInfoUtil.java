package com.util.SystemInfoUtil;

public abstract class SystemInfoUtil {

	public static String getSystemProperty(String property) {
		return System.getProperty(property);
	}

	public static String getSystemEnv(String envVar) {
		return System.getenv(envVar);
	}

	public static String getSystemBitType() {
		String arch = System.getenv("PROCESSOR_ARCHITECTURE");
		String wow64Arch = System.getenv("PROCESSOR_ARCHITEW6432");

		return arch.endsWith("64") || wow64Arch != null
				&& wow64Arch.endsWith("64") ? "64" : "32";
	}

}
