package com.example.demo.model;

public class Comment_Response {
	 
    private Long id;
    private String name;
    private Long id_entity;
    private String comment;
    
	public Comment_Response(Long id, String name, Long id_entity, String comment) {
	 
		this.id = id;
		this.name = name;
		this.id_entity = id_entity;
		this.comment = comment;
	}
 
	@Override
	public String toString() {
		return "Comment_Response [id=" + id + ", name=" + name + ", id_entity=" + id_entity + ", comment=" + comment
				+ "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_entity() {
		return id_entity;
	}
	public void setId_entity(Long id_entity) {
		this.id_entity = id_entity;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
    
	
}
