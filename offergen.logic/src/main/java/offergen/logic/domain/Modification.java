package offergen.logic.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Class entity for Modification.
 * 
 * @author monta
 *
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Modification implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "modification_date")
	private LocalDateTime modificationDate;

	@Column
	private String description;

	@ManyToOne
	@JoinColumn(name = "offer_id")
	@JsonBackReference
	private Offer parentOffer;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;

	public Modification() {
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the modificationDate
	 */
	public LocalDateTime getModificationDate() {
		return modificationDate;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the parentOffer
	 */
	public Offer getParentOffer() {
		return parentOffer;
	}

	/**
	 * @return the author
	 */
	public Author getAuthor() {
		return author;
	}

	/**
	 * @param modificationDate
	 *            the modificationDate to set
	 */
	public void setModificationDate(LocalDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param parentOffer
	 *            the parentOffer to set
	 */
	public void setParentOffer(Offer parentOffer) {
		this.parentOffer = parentOffer;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(Author author) {
		this.author = author;
	}

}
