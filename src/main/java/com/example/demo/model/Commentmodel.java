package com.example.demo.model;

public class Commentmodel {
	private String comment;
	private long ID;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public Commentmodel(String comment, long iD) {

		this.comment = comment;
		ID = iD;
	}

	@Override
	public String toString() {
		return "Commentmodel [comment=" + comment + ", ID=" + ID + "]";
	}

}
