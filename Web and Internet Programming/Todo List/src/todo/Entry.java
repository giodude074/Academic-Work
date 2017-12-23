package todo;
//MODEL CLASS
public class Entry {
	private int id;
	private String title;
	private boolean done, archive;
	

	public Entry(int id, String title, boolean done, boolean archive) {
		this.id = id;
		this.title = title;
		this.done = done;
		this.archive = archive;
	}
	
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public boolean isDone() {
		return done;
	}

	public boolean isArchive() {
		return archive;
	}
	
	
}