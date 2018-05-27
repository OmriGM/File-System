public class File extends Entry {
	private long size;

	public File(String n, Directory p, long sz) {
		super(n, p);
		size = sz;
	}
}
