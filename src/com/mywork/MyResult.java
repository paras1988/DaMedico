package com.mywork;

public class MyResult {
	Node first;
	Node second;
	Node third;

	public MyResult(final Node first,final Node second,final Node third) {
		this.first=first;
		this.second=second;
		this.third=third;
	}
	public MyResult(final Node first,final Node second) {
		this.first=first;
		this.second=second;
	}
	public Node getFirst() {
		return first;
	}
	public Node getSecond() {
		return second;
	}
	public Node getThird() {
		return third;
	}

}
