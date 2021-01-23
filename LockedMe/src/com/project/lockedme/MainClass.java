package com.project.lockedme;

import java.io.File;
import java.util.Scanner;

public class MainClass {
	
	public static String folderLocation = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("**********Welcome to the Locked Me Application!***********");
			System.out.println("**********************************************************");
			System.out.println("*************** Developer : Yuvaraja Kesavan. *************");
			System.out.println("\nLocked Me application will allow you to Read, Create, Delete, Modify a particular file in the folder");
			
			System.out.println("Please enter the folder location for performing the Read, Create, Delete, Modify operations.");
			System.out.println("Eg : C:\\Work\\FullStack");
			Scanner scanner = new Scanner(System.in);
			folderLocation	= scanner.next();	
			//folderLocation="C:\\Work\\Test";
			
			File folder = new File(folderLocation);
			if (!folder.isDirectory()) {
				System.out.println("Please enter a valid directory");
			}else {
				System.out.println("Below are the options");
				System.out.println("Enter 1 to list the contents of the folder.");
				System.out.println("Enter 2 to Create a file.");
				System.out.println("Enter 3 to Delete a file."); 
				System.out.println("Enter 4 to Search a file.");
				System.out.println("Enter 5 to close the Application.");
				System.out.println("*************" + "\n");
				System.out.println("");
				Scanner scInput = new Scanner(System.in);
				int input = 0 ;
				try {
					input = Integer.parseInt(scInput.next());
					if(input >5 || input <1) {
						System.out.println("Please enter the values between 1 and 5");
					}
				}catch(NumberFormatException e) {
					System.out.println("Please enter only numbers");
				}catch(Exception e) {
					System.out.println("Please enter only numbers");
				}
				switch (input) {
				case 1:
					//List the Files in the folder recursively
					IterateFilesFolders iterFiles = new IterateFilesFolders();
					iterFiles.display();
					break;
	
				case 2:
					//CreateFile
					CreateFile create = new CreateFile();
					create.creFile();
					break;
	
				case 3:
					//DeleteFile
					DeleteFile delete = new DeleteFile();
					delete.delete();
					break;
	
				case 4:
					//SearchFile
					IterateFilesFolders sFiles = new IterateFilesFolders();
					sFiles.getFile();
					break;
				case 5:
					System.out.println("Application closed!");
					System.exit(0);
					break;
				}
			}
		}

	}

}
