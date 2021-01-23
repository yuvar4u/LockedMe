package com.project.lockedme;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class IterateFilesFolders {
	@SuppressWarnings("unchecked")
	public void display() {
		try {
			ArrayList listFile = new ArrayList();
			ArrayList listFolder = new ArrayList();
			String folderPath = MainClass.folderLocation;
			Scanner scan = new Scanner(folderPath);
			File folder = new File(folderPath);
			File[] files = folder.listFiles();
			Arrays.sort(files);
			
			System.out.println(Arrays.toString(files));
			for (File file : files) {
				if (file.isFile()) {
					//System.out.println("File Name: " + file.getName());
					listFile.add(file.getName());
				} else if (file.isDirectory()) {
					//System.out.println("\nFolder Name: " + file.getName());
					listFolder.add(file.getName());
				}
			}
			Collections.sort(listFile);
			Collections.sort(listFolder);
			Iterator itr = listFile.iterator();
			System.out.println("\nFiles list in Ascending Order : ");
			while (itr.hasNext()) { 
	            System.out.println(itr.next()); 
	        }
			System.out.println("\nFolder list in Ascending Order : ");
			Iterator itrFolder = listFolder.iterator();
			while (itrFolder.hasNext()) { 
	            System.out.println(itrFolder.next()); 
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
					searchFile(fileName, folderPath + "\\" + file.getName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
