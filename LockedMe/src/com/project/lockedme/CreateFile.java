package com.project.lockedme;

import java.io.File;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class CreateFile {
	public void creFile() {
		PrintWriter writer;
		try {
			System.out.println("Enter the file name");
			Scanner scSearch = new Scanner(System.in);
			String sFile	= scSearch.next();
			File fExist = new File(MainClass.folderLocation+"\\"+sFile);
			if(fExist.exists()) {
				System.out.println("File Already Exists");
			}else {
				writer= new PrintWriter(MainClass.folderLocation+"\\"+sFile, "UTF-8");
				System.out.println("File created successfully");
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println("File creation failed");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("File creation failed");
			e.printStackTrace();
		}
		
	}
}
