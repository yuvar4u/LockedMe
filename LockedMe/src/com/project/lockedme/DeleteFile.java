package com.project.lockedme;

import java.io.File;
import java.util.Scanner;

public class DeleteFile {
	public void delete() {
		try {
			System.out.println("Enter the file name");
			Scanner scSearch = new Scanner(System.in);
			String sFile	= scSearch.next();
			File file = new File(MainClass.folderLocation+"\\"+sFile);

			if (file.delete()) {
				System.out.println(file + " Got deleted");
			} else {
				System.out.println("File not deleted!");
			}
		}catch (Exception e) {
			System.out.println("File not deleted !");
			e.printStackTrace();

		}
	}

}
