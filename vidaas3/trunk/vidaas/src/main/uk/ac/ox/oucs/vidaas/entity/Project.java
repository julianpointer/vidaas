package uk.ac.ox.oucs.vidaas.entity;

// Generated 01-Aug-2011 14:49:06 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * Project generated by hbm2java
 */
@Entity
@Table(name = "project", catalog = "vidaas_v3")
@NamedQueries({
		@NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p"),
		@NamedQuery(name = "Project.findByProjectID", query = "SELECT p FROM Project p WHERE p.projectId = :projectID"),
		@NamedQuery(name = "Project.findByDescription", query = "SELECT p FROM Project p WHERE p.description = :description"),
		@NamedQuery(name = "Project.findByEndDate", query = "SELECT p FROM Project p WHERE p.endDate = :endDate"),
		@NamedQuery(name = "Project.findByStartDate", query = "SELECT p FROM Project p WHERE p.startDate = :startDate"),
		@NamedQuery(name = "Project.findByTitle", query = "SELECT p FROM Project p WHERE p.title = :title") })
public class Project implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2592730545381307526L;
	private Integer projectId;
	private String description;
	private Date endDate;
	private Date startDate;
	private String title;
	private String name;
	private Set<Dataspace> dataspaces = new HashSet<Dataspace>(0);
	private Set<UserProject> userProjects = new HashSet<UserProject>(0);

	public Project() {
	}

	public Project(String description, Date endDate, Date startDate,
			String title) {
		this.description = description;
		this.endDate = endDate;
		this.startDate = startDate;
		this.title = title;
	}

	public Project(String description, Date endDate, Date startDate,
			String title, Set<Dataspace> dataspaces,
			Set<UserProject> userProjects) {
		this.description = description;
		this.endDate = endDate;
		this.startDate = startDate;
		this.title = title;
		this.dataspaces = dataspaces;
		this.userProjects = userProjects;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Project_ID", unique = true, nullable = false)
	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@Column(name = "Description", nullable = false, length = 250)
	@NotNull
	@Length(max = 250)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "End_Date", nullable = true, length = 10)
	// @Null
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Start_Date", nullable = false, length = 10)
	@NotNull
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "Title", nullable = false, length = 165)
	@NotNull
	@Length(max = 165)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "Name", nullable = false, length = 165)
	@NotNull
	@Length(max = 165)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	public Set<Dataspace> getDataspaces() {
		return this.dataspaces;
	}

	public void setDataspaces(Set<Dataspace> dataspaces) {
		this.dataspaces = dataspaces;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	public Set<UserProject> getUserProjects() {
		return this.userProjects;
	}

	public void setUserProjects(Set<UserProject> userProjects) {
		this.userProjects = userProjects;
	}

}
