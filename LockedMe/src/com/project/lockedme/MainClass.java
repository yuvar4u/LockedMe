package com.project.lockedme;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {
	
	public static String folderLocation = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		entryOperations();

	}

	private static void entryOperations() {
		while (true) {
			System.out.println("**********Welcome to the Locked Me Application!***********");
			System.out.println("**********************************************************");
			System.out.println("*************** Developer : Yuvaraja Kesavan. *************");
			System.out.println("\nLocked Me application will allow you to Add, Delete, search a particular file in the folder");
			System.out.println("Please enter the folder location for performing the Add, Delete, search operations.");
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
				System.out.println("Enter 2 for File operations.");
				System.out.println("Enter 3 to close the Application.");
				System.out.println("*************" + "\n");
				System.out.println("");
				Scanner scInput = new Scanner(System.in);
				int input = 0;
				try {
					input = Integer.parseInt(scInput.next());
				}catch(NumberFormatException e) {
					System.out.println("Please enter only numbers\n\n");
				}catch(Exception e) {
					System.out.println("Please enter only numbers\n\n");
				}
				switch (input) {
				case 1:
					//List the Files in the folder recursively
					IterateFilesFolders iterFiles = new IterateFilesFolders();
					iterFiles.display();
					break;
	
				case 2:
					fileOperations();
					break;
				case 3:
					System.out.println("Exiting the application !!!");
					System.exit(0);
					break;
					
				default:
					System.out.println("Wrong choice entered !!!");
					break;
				}
			}
		}
	}
	
	public static void fileOperations() {
		try {	
			while (true) {
				System.out.println("\n\n***Please Enter your choice*****\n");
				System.out.println("Press 1: Add a file to the existing directory list");
				System.out.println("Press 2: Delete a user specified file from the existing directory list");
				System.out.println("Press 3: Search a user specified file from the main directory");
				System.out.println("Press 4: Navigate back to the main context\n");
				Scanner scInput = new Scanner(System.in);
				int n = scInput.nextInt();
				switch (n) {
				case 1:
					CreateFile create = new CreateFile();
					create.creFile();
					break;
				case 2:
					DeleteFile delete = new DeleteFile();
					delete.delete();
					break;
				case 3:
					IterateFilesFolders sFiles = new IterateFilesFolders();
					sFiles.getFile();
					break;
				case 4:
					entryOperations();
					break;
				default:
					System.out.println("Wrong choice entered !!!");
				} 
			}
		}catch(InputMismatchException e) {
			System.out.println("Please enter any number from 1 to 4");
			fileOperations();
		}catch(Exception e) {
			System.out.println("Please enter any number from 1 to 4");
			fileOperations();
		}
	}

}
