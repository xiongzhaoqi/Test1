package org.softedu.file.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class FileUtil {
	public String[] upload(HttpServletRequest request, String tempPathStr,
			String realFilePathStr, String realFileName) {
		String fileType[] = new String[3];
		try {
			File tempFile = getTempFile(request, tempPathStr);// 创建临时文件对象
			if (request.getContentLength() > 192) {
				int mark1, mark2;
				long mark3;
				RandomAccessFile random1 = new RandomAccessFile(tempFile, "r");// 声明RandomAccessFile对象，
				// 该对象有一被称为文件指针的标记，可用该标记控制读取位置
				String secondLine = null;
				for (int i = 0; i < 2; i++) {// 获得文件第二行内容
					secondLine = random1.readLine();
				}
				int fileTypePositionH = secondLine.lastIndexOf(".");
				int fileTypePositionE = secondLine.length() - 1;
				
				Random ran=new Random();
				int count=ran.nextInt(9999);
				String realName = secondLine.substring(secondLine.lastIndexOf("\\") + 1, secondLine.lastIndexOf(".")); // 获取源文件名
				fileType[2]=realName+count;
				
				fileType[0] = secondLine.substring(fileTypePositionH,
						fileTypePositionE);// 拿到文件后缀名包括"."
				secondLine = random1.readLine();
				int H = secondLine.lastIndexOf(":");
				int E = secondLine.length();
				fileType[1] = secondLine.substring(H + 2, E);// 拿到文件协议
				random1.seek(0);// 文件指针复位
				File realFilePath = new File(realFilePathStr);
				if (!realFilePath.isDirectory()) {
					realFilePath.mkdirs();
				}
				
				
				String name=fileType[2]+fileType[0];
				byte[] names=name.getBytes("iso-8859-1");
				String namess=new String(names,"utf-8");
				
				File realFile = new File(realFilePath, namess);// 创建实际文件对象
				
				RandomAccessFile random2 = new RandomAccessFile(realFile, "rw");
				long positionOfTextStart = 0;// 声明文件正文起始标记
				long positionOfTextEnd = 0;// 声明文件正文结束标记
				random1.seek(random1.length());
				positionOfTextEnd = random1.getFilePointer();// 将文件末尾赋值给正文结束标记
				mark2 = 1;
				random1.seek(0);// 重新定位到文件开头
				while ((mark1 = random1.readByte()) != -1 && (mark2 <= 4)) {// 找到文件正文开始位置
					if (mark1 == '\n') {
						positionOfTextStart = random1.getFilePointer();
						mark2++;
					}
				}
				mark3 = positionOfTextEnd;
				mark2 = 1;
				// while(mark3 >= 0 && mark2 <= 6){//正常情况下的request流中文件正文结束标记
				while (mark3 >= 0 && mark2 <= 2) {// 我的笔记本上request流中文件正文结束位置
					mark3--;
					random1.seek(mark3);
					mark1 = random1.readByte();
					if (mark1 == '\n') {
						positionOfTextEnd = random1.getFilePointer();
						mark2++;
					}
				}
				random1.seek(positionOfTextStart);
				while (positionOfTextStart < positionOfTextEnd - 1) {
					mark1 = random1.readByte();
					random2.write(mark1);
					positionOfTextStart = random1.getFilePointer();
				}
				random2.close();
				random1.close();
				tempFile.delete();
			} else {
				fileType[0] = "fileIsNull";
			}
		} catch (IOException e) {
			fileType[0] = "uploadFalse";
			e.printStackTrace();
		}
		return fileType;
	}

	public File getTempFile(HttpServletRequest request, String tempPathStr) {
		String tempFileName = (String) request.getSession().getId();// 以sessionId作为临时文件的文件名
		File tempFilePath = new File(tempPathStr);// 创建临时目录对象
		if (!tempFilePath.isDirectory()) {// 如果临时目录不存在，创建临时目录
			tempFilePath.mkdirs();
		}
		File tempFile = new File(tempFilePath, tempFileName);// 创建临时文件对象
		try {
			FileOutputStream out = new FileOutputStream(tempFile);
			if (request.getContentLength() > 192) {
				InputStream in = request.getInputStream();// 用request对象创建临时文件输入流
				byte b[] = new byte[1024];
				int mark;
				while ((mark = in.read(b)) != -1) {
					out.write(b, 0, mark);
				}
				out.close();
				in.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempFile;
	}
}
