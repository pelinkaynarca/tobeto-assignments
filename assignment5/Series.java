import java.util.ArrayList;
import java.util.List;

public class Series extends Media{

	private List<Season> seasons;

	public Series() {
		super();
		this.seasons=new ArrayList<Season>();
	}

	public List<Season> getSeasons() {
		return seasons;
	}

	public void setSeasons(List<Season> seasons) {
		this.seasons = seasons;
	}

}
