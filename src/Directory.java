import java.util.ArrayList;

public class Directory extends Entry {
	protected ArrayList<Entry> entries;

	public Directory(String n, Directory p) {
		super(n, p);
		entries = new ArrayList<Entry>();
	}

	public boolean deleteEntry(Entry entry) {
		return entries.remove(entry);
	}

	public void addEntry(Entry entry) {
		entries.add(entry);
	}

	protected ArrayList<Entry> getEntries() {
		return entries;
	}
	
}
