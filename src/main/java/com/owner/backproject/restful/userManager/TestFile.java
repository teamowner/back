package com.owner.backproject.restful.userManager;

import java.io.*;

public class TestFile {

	public static void main( String[] args) throws IOException {
		
//		String path = "c:\\liuhuan";
//		File file = new File(path);
//		
//		System.out.println("创建文件：" + file.exists());
//		boolean res = file.mkdir();
//		System.out.println("创建文件结果:：" + res);
		/*
		 * File dir = new File("C:\\dazhong"); String[] nameStrings = dir.list();
		 * 
		 * File[] files = dir.listFiles();
		 */
		
		/*
		 * for (String nameString : nameStrings) { System.out.println(nameString); }
		 */
		
		/*
		 * for(File f:files) { System.out.println(f); }
		 */
		
		//文件读取
	
		/*FileReader fileReader = new FileReader("c:/dazhong/liuhuan.txt");
		
		int b;
		while((b=fileReader.read()) != -1) {
			System.out.print((char)b);
			
		}
		fileReader.close();*/

		//缓冲流，文件复制测试
		long start = System.currentTimeMillis();
		try(
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:/dazhong/tool/jdk-8u181-windows-x64.exe"));
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("c:/dazhong/copy.exe"));
				){
			int len ;
			//byte[] bytes = new  byte[8 * 10024];
			while ((len = bis.read()) != -1){
				bos.write(len);
			}

		}catch (IOException e){
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("复制用时：" + (end-start) + " 毫秒");
	}
}
