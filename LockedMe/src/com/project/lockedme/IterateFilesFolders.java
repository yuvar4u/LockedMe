package com.project.lockedme;

import java.io.File;
import java.util.Scanner;

public class IterateFilesFolders {
	public void display() {
		try {
			String folderPath = MainClass.folderLocation;
			Scanner scan = new Scanner(folderPath);
			File folder = new File(folderPath);
			File[] files = folder.listFiles();

			for (File file : files) {
				if (file.isFile()) {
					System.out.println("File Name: " + file.getName());
				} else if (file.isDirectory()) {
					System.out.println("\nFolder Name: " + file.getName());
				}

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
						System.out.println("File location: " + file.getName());
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
