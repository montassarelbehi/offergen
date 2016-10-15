package offergen.logic.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import offergen.logic.converters.LocalDateTimeConverter;

/**
 * Class entity of Lot.
 * 
 * @author monta
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Lot {

	/**
	 * id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * reference.
	 */
	@Column
	private String reference;

	/**
	 * type.
	 */
	@OneToOne
	private LotType type;

	/**
	 * description.
	 */
	@Column
	private String description;

	/**
	 * annulation_date.
	 */
	@Convert(converter = LocalDateTimeConverter.class)
	@Column(name = "annulation_date")
	private LocalDateTime annulation_date;

	/**
	 * parentOffer.
	 */
	@ManyToOne
	@JoinColumn(name = "offer_id")
	@JsonBackReference
	private Offer parentOffer;

	/**
	 * Default constructor.
	 */
	public Lot() {
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @return the type
	 */
	public LotType getType() {
		return type;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the annulation_date
	 */
	public LocalDateTime getAnnulation_date() {
		return annulation_date;
	}

	/**
	 * @param reference
	 *            the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(LotType type) {
		this.type = type;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param annulation_date
	 *            the annulation_date to set
	 */
	public void setAnnulation_date(LocalDateTime annulation_date) {
		this.annulation_date = annulation_date;
	}

	/**
	 * @return the parentOffer
	 */
	public Offer getParentOffer() {
		return parentOffer;
	}

	/**
	 * @param parentOffer
	 *            the parentOffer to set
	 */
	public void setParentOffer(Offer parentOffer) {
		this.parentOffer = parentOffer;
	}
}
