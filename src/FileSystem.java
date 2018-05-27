import java.util.HashMap;
import java.util.Map;

public class FileSystem {
	Directory rootDir;
	Map<String, Entry> entriesMap;

	public FileSystem() {
		entriesMap = new HashMap<>();
		rootDir = new Directory("root", null);
		entriesMap.put("root", rootDir);
	}

	public void addFile(String parentDirName, String fileName, long fileSize) {
		Directory parent = ((Directory) entriesMap.get(parentDirName));
		File file = new File(fileName, parent, fileSize);
		parent.addEntry(file);
		entriesMap.put(fileName, file);
	}

	public void addDir(String parentDirName, String dirName) {
		Directory parent = ((Directory) entriesMap.get(parentDirName));
		Directory dir = new Directory(dirName, parent);
		parent.addEntry(dir);
		entriesMap.put(dirName, dir);
	}

	public void delete(String name) {
		Entry deleteMe = entriesMap.get(name);
		String parentName=deleteMe.parent.getName();
		Directory parent = ((Directory) entriesMap.get(parentName));
		
		/**
		 * In case we want to delete a Directory
		 * we will delete all of it's sub entries
		 */
		if (deleteMe instanceof Directory) {
			for (Entry e : ((Directory) deleteMe).getEntries()) {
				entriesMap.remove(e.getName());
			}
		}
		parent.deleteEntry(deleteMe);
		entriesMap.remove(name);
	}

	public void showFileSystem() {
		for (String key : entriesMap.keySet()) {
			Entry entry = entriesMap.get(key);
			entry.printData();
		}
	}

}
