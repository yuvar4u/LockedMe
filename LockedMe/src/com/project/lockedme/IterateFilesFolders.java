package com.project.lockedme;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class IterateFilesFolders {
	@SuppressWarnings("unchecked")
	public void display() {
		try {
			List listFile = new ArrayList();
			String folderPath = MainClass.folderLocation;
			Scanner scan = new Scanner(folderPath);
			File folder = new File(folderPath);
			File[] files = folder.listFiles();

			for (File file : files) {
				if (file.isFile()) {
					System.out.println("File Name: " + file.getName());
					listFile.add(file.getName());
				} else if (file.isDirectory()) {
					System.out.println("\nFolder Name: " + file.getName());
				}

			}
			System.out.println("listFile ==> " +listFile);
			Collections.sort(listFile);
			Iterator it = listFile.iterator();
			if(it.hasNext()) {
				System.out.println("File Name: " + it.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getFile() {
		try {
			System.out.println("Enter the file name");
			Scanner scSearch = new Scanner(System.in);
			String sFile = scSearch.next();
			searchFile(sFile, MainClass.folderLocation);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchFile(String fileName, String folderPath) {
		try {
			Scanner scan = new Scanner(folderPath);
			File folder = new File(folderPath);
			File[] files = folder.listFiles();

			for (File file : files) {
				if (file.isFile()) {
					if (fileName.equals(file.getName())) {
						System.out.println("File Found !!!");
						System.out.println("File Name: " + file.getName());
						System.out.println("File location: " + folderPath+File.separator+file.getName());
					}
				} else if (file.isDirectory()) {
					System.out.println("\nFolder Name: " + file.getName());
					searchFile(fileName, folderPath + "\\" + file.getName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
