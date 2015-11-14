package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * The persistent class for the film database table.
 * 
 */
@Entity
@Table(name="film")
@NamedQuery(name="Film.findAll", query="SELECT f FROM Film f")
public class Film implements Serializable {
	private static final long serialVersionUID = 2L;
	
	//despues se veran los default

	@Id
	@Column(name="film_id", unique=true, nullable=false)
  	private int filmId;

	@Column(name="title", nullable=false, length=255)
  	private String title;
	
	@Column(name="description")
  	private String description;
  	
  	@Column(name="release_year")
  	private int releaseYear;
  	//private Date releaseYear;

  	@Column(name="language_id", nullable=false)
  	private int languageId;
  	
  	@Column(name="original_language_id",nullable=false)
  	private int originalLanguageId;
  	
  	@Column(name="rental_duration", nullable=false)
  	private int rentalDuration;
  	
  	@Column(name="rental_rate", nullable=false)
  	private double rentalRate;
  	//private java.math.BigDecimal rentalRate;
  	
  	@Column(name="length")
  	private int length;
  	//private short lenght;
  	
  	@Column(name="replacement_cost", nullable=false)
  	private double replacementCost;
  	//private java.math.BigDecimal replacementeCost;
  	
  	@Column(name="rating")
  	private String rating;
  	//ENUM('G','PG','PG-13','R','NC-17') NULL DEFAULT 'G',
  	
  	@Column(name="special_features")
  	private String specialFeatures;
  	//SET('Trailers','Commentaries','Deleted Scenes','Behind the Scenes') NULL DEFAULT NULL,
  	
  	@Column(name="last_update", nullable=false)
  	private Timestamp lastUpdate;
  	//TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

  	//Autogenerado
  	
	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
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

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getOriginalLanguageId() {
		return originalLanguageId;
	}

	public void setOriginalLanguageId(int originalLanguageId) {
		this.originalLanguageId = originalLanguageId;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
