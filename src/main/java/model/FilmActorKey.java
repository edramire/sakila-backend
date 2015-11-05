package model;

import java.io.Serializable;

/*
 * Idea de esta clase: 
 * http://stackoverflow.com/questions/13032948/how-to-create-and-handle-composite-primary-key-in-jpa
 */

public class FilmActorKey implements Serializable {
	
	private static final long serialVersionUID = 123L;
	
	private int actorId;
	private int filmId;
	
	public FilmActorKey(int filmId, int actorId) {
		this.filmId = filmId;
		this.actorId = actorId;
	}
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public int getFilmId() {
		return filmId;
	}
	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}
	
	
}
