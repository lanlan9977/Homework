package idv.david.homeworkiii;

public class BaseballTeam  {
    private int teamname;
    private int teampics;

    public BaseballTeam(int teamname, int teampics) {
        super();
        this.teamname = teamname;
        this.teampics = teampics;
    }

    public BaseballTeam() {
        super();

    }

    public int getTeamname() {
        return teamname;
    }

    public int getTeampics() {
        return teampics;
    }

    public void setTeamname(int teamname) {
        this.teamname = teamname;
    }

    public void setTeampics(int teampics) {
        this.teampics = teampics;
    }


}
