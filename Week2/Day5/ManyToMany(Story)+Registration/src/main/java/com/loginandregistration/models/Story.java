package com.loginandregistration.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="stories")
public class Story {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	// title 
	@NotNull(message="Title should not be null !")
	@Size(min=3,message="the story title must be at least 3 characters")
	private String title;
	//description
	@NotNull(message="description should not be null !")
	@Size(min=3,message="the story description must be at least 3 characters")
	private String description;
	//createdAt
	 @Column(updatable=false)
	    private Date createdAt;
	//updatedAt
	    private Date updatedAt;
	    
	    //ManyToOne
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="user_id")
	    User creator;
	    
	    
	    //ManyToMany
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name="stories_users",
	    		joinColumns = @JoinColumn(name = "story_id"), 
	            inverseJoinColumns = @JoinColumn(name = "user_id")
	    )
	    List<User> likers;
	    
	 // methods on create & on update 
	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	        this.updatedAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	    
	    // empty constructor 
	    public Story() {}
	    
	    //getters and setters 
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		public Date getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
		public User getCreator() {
			return creator;
		}
		public void setCreator(User creator) {
			this.creator = creator;
		}
		public List<User> getLikers() {
			return likers;
		}
		public void setLikers(List<User> likers) {
			this.likers = likers;
		}
	    
}
