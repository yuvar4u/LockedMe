package com.project.lockedme;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class DeleteFile {

	public static void delete() {
		System.out.println("Enter the filename to be deleted\n");
		Scanner scSearch = new Scanner(System.in);
		Path path = Paths.get(MainClass.folderLocation + File.separator + scSearch.nextLine());
		System.out.println(path.toString());
		try {
			Files.delete(path);
			System.out.println("File Deleted!");
		} catch (DirectoryNotEmptyException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
