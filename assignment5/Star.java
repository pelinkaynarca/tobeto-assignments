import java.util.ArrayList;
import java.util.List;

public class Star extends Person {
	
	private List<String> roles;

	public Star() {
		this.roles=new ArrayList<String>();
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}
