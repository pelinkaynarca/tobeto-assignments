import java.util.ArrayList;
import java.util.List;

public class Season {

	private List<Episode> episodes;

	public Season() {
		super();
		this.episodes=new ArrayList<Episode>();
	}

	public List<Episode> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(List<Episode> episodes) {
		this.episodes = episodes;
	}
}
