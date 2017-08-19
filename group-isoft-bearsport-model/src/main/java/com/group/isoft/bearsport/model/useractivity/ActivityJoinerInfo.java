package com.group.isoft.bearsport.model.useractivity;

import java.util.List;

public class ActivityJoinerInfo {
	private int planPeople;
	private List<Joiner> joiners;
	
	public int getPlanPeople() {
		return planPeople;
	}
	public void setPlanPeople(int planPeople) {
		this.planPeople = planPeople;
	}
	public List<Joiner> getJoiners() {
		return joiners;
	}
	public void setJoiners(List<Joiner> joiners) {
		this.joiners = joiners;
	}
}
