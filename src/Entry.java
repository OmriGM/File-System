import java.util.Date;

public abstract class Entry {
	protected Directory parent;
	protected Date created;
	protected String name;

	public Entry(String n, Directory p) {
		name = n;
		parent = p;
		created = new Date();
	}

	public boolean delete() {
		if (parent == null)
			return false;
		return parent.deleteEntry(this);
	}

	public String getName() {
		return name;
	}
	
	public void printData(){
		if(parent==null){
			System.out.println("This is the Root Entry, Entry name: " +this.name);
		}
		else
			System.out.println("Parent name: " + this.parent.getName() + " Entry name: " +this.name);
	}
}
