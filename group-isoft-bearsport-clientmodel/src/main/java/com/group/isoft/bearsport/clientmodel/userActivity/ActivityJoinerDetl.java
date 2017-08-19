package com.group.isoft.bearsport.clientmodel.userActivity;

import java.util.List;

public class ActivityJoinerDetl {
	private int enrPeople;
	private int planPeople;
	private List<ActivityJoiner> joiners;
	
	public int getEnrPeople() {
		return enrPeople;
	}
	public void setEnrPeople(int enrPeople) {
		this.enrPeople = enrPeople;
	}
	public int getPlanPeople() {
		return planPeople;
	}
	public void setPlanPeople(int planPeople) {
		this.planPeople = planPeople;
	}
	public List<ActivityJoiner> getJoiners() {
		return joiners;
	}
	public void setJoiners(List<ActivityJoiner> joiners) {
		this.joiners = joiners;
	}
}
