package com.project.lockedme;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateFile {

	public static void creFile() {
		System.out.println("Enter the file name :\n");
		Scanner scSearch = new Scanner(System.in);
		Path path = Paths.get(MainClass.folderLocation + File.separator+scSearch.nextLine());
		List<String> list = new ArrayList<>();
		try {
			Files.write(path, list, StandardOpenOption.CREATE_NEW);
		} catch (IOException e) {
			System.out.println("\nFile Exists!");
			//e.printStackTrace();
		}
		System.out.println("\nFile Created!");
	}
}
