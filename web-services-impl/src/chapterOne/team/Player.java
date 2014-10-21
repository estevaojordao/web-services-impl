package chapterOne.team;

public class Player {

	private String Name;

	private String nickname;

	public Player(String name, String nickname) {
		Name = name;
		this.nickname = nickname;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
