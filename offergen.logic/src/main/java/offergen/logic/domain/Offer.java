package offergen.logic.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import offergen.logic.converters.LocalDateTimeConverter;
import offergen.logic.enums.OfferType;

/**
 * Class entity of Offer.
 * 
 * @author monta
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Offer implements Serializable {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String reference;

	@Column
	@Enumerated(EnumType.STRING)
	private OfferType type;

	@Column
	private String description;

	@Column
	private Boolean authorized;

	@Column
	private Boolean active;

	@Convert(converter = LocalDateTimeConverter.class)
	@Column(name = "creation_date")
	private LocalDateTime creationDate;

	@Convert(converter = LocalDateTimeConverter.class)
	@Column(name = "close_date")
	private LocalDateTime closeDate;

	@Convert(converter = LocalDateTimeConverter.class)
	@Column(name = "annulation_date")
	private LocalDateTime annulation_date;

	@OneToMany(mappedBy = "parentOffer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Modification> modifications;

	@OneToMany(mappedBy = "parentOffer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Lot> lots;

	/**
	 * {@link Offer} constructor.
	 */
	public Offer() {
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
	public OfferType getType() {
		return type;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
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
	public void setType(OfferType type) {
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
	 * @return the authorized
	 */
	public Boolean getAuthorized() {
		return authorized;
	}

	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param authorized
	 *            the authorized to set
	 */
	public void setAuthorized(Boolean authorized) {
		this.authorized = authorized;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @return the creationDate
	 */
	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	/**
	 * @return the closeDate
	 */
	public LocalDateTime getCloseDate() {
		return closeDate;
	}

	/**
	 * @return the annulation_date
	 */
	public LocalDateTime getAnnulation_date() {
		return annulation_date;
	}

	/**
	 * @param creationDate
	 *            the creationDate to set
	 */
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @param closeDate
	 *            the closeDate to set
	 */
	public void setCloseDate(LocalDateTime closeDate) {
		this.closeDate = closeDate;
	}

	/**
	 * @param annulation_date
	 *            the annulation_date to set
	 */
	public void setAnnulation_date(LocalDateTime annulation_date) {
		this.annulation_date = annulation_date;
	}

	/**
	 * @return the actions
	 */
	public List<Modification> getModifications() {
		return modifications;
	}

	/**
	 * @param modifications
	 *            the modifications to set
	 */
	public void setModifications(List<Modification> modifications) {
		this.modifications = modifications;
	}

	/**
	 * @return the lots
	 */
	public List<Lot> getLots() {
		return lots;
	}

	/**
	 * @param lots
	 *            the lots to set
	 */
	public void setLots(List<Lot> lots) {
		this.lots = lots;
	}
}
