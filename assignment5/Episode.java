
public class Episode {

	private int runtime;
	private String title;
	
	public Episode() {
		super();
	}

	public Episode(int runtime, String title) {
		super();
		this.runtime = runtime;
		this.title = title;
	}
	
	public int getRuntime() {
		return runtime;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
