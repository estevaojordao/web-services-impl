package chapterOne.team;

import java.util.List;

import chapterOne.team.client.TeamsService;
import chapterOne.team.client.Teams;
import chapterOne.team.client.Team;
import chapterOne.team.client.Player;


public class TeamClient {

	
	public static void main(String[] args) {
		TeamsService service = new TeamsService();
		Teams port = service.getTeamsPort();
		
		List<chapterOne.team.client.Team> teams = port.getTeams();
		
		for (Team team : teams) {
			System.out.println(team.getName());
			System.out.println(team.getRosterCount());
			
			for (Player player : team.getPlayers()) {
				System.out.println(player.getName());
				System.out.println(player.getNickname());
			}
			
		}
		
		
	}
}
