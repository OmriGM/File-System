import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		FileSystem fs = new FileSystem();
		printMenu(fs);

		/**
		 * Uncomment if you want to test 
		 * the system without CLI
		 */
//		fs.addDir("root", "Downloads");
//		fs.addDir("root", "Documents");
//		fs.addDir("Downloads", "Movies");
//		fs.addFile("Downloads", "Thor", 15);
//		fs.addDir("Downloads", "Pictures");
//		fs.addFile("Downloads", "SpiderMan", 44);
//		fs.showFileSystem();
//		System.out.println();
//		fs.delete("Downloads");
//		fs.showFileSystem();
	}

	public static void printMenu(FileSystem fs) {
		String input;
		String parent;
		String folderOrFile;
		boolean play = true;
		long size;
		Scanner sc = new Scanner(System.in);
		while (play) {
			System.out.println("Welcome to my file system, please pick one of the options below: ");
			System.out.println("Add Folder - d");
			System.out.println("Add File - f");
			System.out.println("Delete entry - e");
			System.out.println("Show all entries - p");
			System.out.println("Exit - x");
			input = sc.nextLine();
			switch (input) {
			case "d":
				System.out.println("Parent name: ");
				parent = sc.nextLine();
				System.out.println("Dir name: ");
				folderOrFile = sc.nextLine();
				try {
					fs.addDir(parent, folderOrFile);
				} catch (Exception e) {
					System.out.println("Error...Please Try Again!\n If it is your first file, put root as the parent!\n");
				}
				
				break;
			case "f":
				System.out.println("Parent name: ");
				parent = sc.nextLine();
				System.out.println("File name: ");
				folderOrFile = sc.nextLine();
				System.out.println("File size: ");
				size = sc.nextLong();
				try {
					fs.addDir(parent, folderOrFile);
				} catch (Exception e) {
					System.out.println("Error...Please Try Again!\n If it is your first file, put root as the parent!\n");
				}
				break;

			case "e":
				System.out.println("Which entry do you want to delete?");
				fs.showFileSystem();
				folderOrFile=sc.nextLine();
				try {
					fs.delete(folderOrFile);
				} catch (Exception e) {
					System.out.println("Error...Please Try Again!\n");
				}
				break;

			case "p":
				System.out.println("ALL THE FOLDERS AND FILES IN THE SYSTEM: \n");
				fs.showFileSystem();
				System.out.println();
				break;
			case "x":
				System.out.println("Bye Bye!");
				play = false;
				break;
			default:
				break;
			}
		}
	}
}
