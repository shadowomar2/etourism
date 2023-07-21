package com.example.demo.model;

public class Images_response {
    private Long id;
    private Long id_entity;
    private String imageURL;

	public Long getId_entity() {
		return id_entity;
	}

	public void setId_entity(Long id_entity) {
		this.id_entity = id_entity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	@Override
	public String toString() {
		return "Images_response [id=" + id + ", id_entity=" + id_entity + ", imageURL=" + imageURL + "]";
	}

	public Images_response(Long id, Long id_entity, String imageURL) {
		 
		this.id = id;
		this.id_entity = id_entity;
		this.imageURL = imageURL;
	}

	 
    
}
