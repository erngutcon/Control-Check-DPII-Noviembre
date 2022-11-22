package acme.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Lusit extends AbstractEntity {
	
	// Serialisation identifier -----------------------------------------------
	
	protected static final long serialVersionUID = 1L;
	
	// Attributes -------------------------------------------------------------

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "^\\w{5}.\\d{2}-\\w{2}_\\d{2}:\\d{2}$")
	protected String iname;
	
	@NotBlank
	@Length(max = 75)
	protected String logo;

	@NotBlank
	@Length(max = 255)
	protected String description;

	@NotNull
	@Valid
	protected Money budget; 
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date initialDate;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date initDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date finishDate;
	
	@URL
	protected String hyperlink;
	
	// Relationships ----------------------------------------------------------
	
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	protected TheoryTutorial theoryTutorial;
	
}