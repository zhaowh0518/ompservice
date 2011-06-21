package omp.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*
 * File Operate
 */
public class FileUtil {
	
	/*Read a file*/
	public static String ReadFile(String filename) {
		File file = new File(filename);
		String result = "";
		String str = "";
		if (file.exists()) {
			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);

				while ((str = br.readLine()) != null) {
					result += str;
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		} 
		else {
			System.out.print("file does not exsit.");
		}
		return result;
	}
}
