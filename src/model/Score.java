package model;

public class Score {

	private int time;
	private String nickName;
	
	public Score(int time, String nickName) {
		this.time = time;
		this.nickName = nickName;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String toString() {
		String msg = nickName +": "+time;
		return msg;
	}
	
	
}
