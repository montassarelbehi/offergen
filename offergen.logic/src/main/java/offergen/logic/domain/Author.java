package offergen.logic.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import offergen.logic.enums.ProfileType;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String login;

	@Column
	private String password;

	@Column
	@Enumerated(EnumType.STRING)
	private ProfileType profile;

	@OneToMany(mappedBy = "author")
	private List<Modification> actions;

	public Author() {
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the profile
	 */
	public ProfileType getProfile() {
		return profile;
	}

	/**
	 * @return the actions
	 */
	public List<Modification> getActions() {
		return actions;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param profile
	 *            the profile to set
	 */
	public void setProfile(ProfileType profile) {
		this.profile = profile;
	}

	/**
	 * @param actions
	 *            the actions to set
	 */
	public void setActions(List<Modification> actions) {
		this.actions = actions;
	}

}
