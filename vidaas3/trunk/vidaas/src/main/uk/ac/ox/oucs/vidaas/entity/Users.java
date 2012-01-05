package uk.ac.ox.oucs.vidaas.entity;

// Generated 01-Aug-2011 14:49:06 by Hibernate Tools 3.4.0.CR1

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
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name = "users", catalog = "vidaas_v3")
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUserID", query = "SELECT u FROM Users u WHERE u.userId = :userID"),
    @NamedQuery(name = "Users.findByDepartment", query = "SELECT u FROM Users u WHERE u.department = :department"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findByFirstName", query = "SELECT u FROM Users u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "Users.findByGrp", query = "SELECT u FROM Users u WHERE u.grp = :grp"),
    @NamedQuery(name = "Users.findByLastName", query = "SELECT u FROM Users u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "Users.findByPosition", query = "SELECT u FROM Users u WHERE u.position = :position")})
public class Users implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4547320628162409645L;
	private Integer userId;
	private String department;
	private String email;
	private String firstName;
	private String grp;
	private String lastName;
	private String position;
	private Set<UserDatabase> userDatabases = new HashSet<UserDatabase>(0);
	private Set<Logins> loginses = new HashSet<Logins>(0);
	private Set<Dataspace> dataspaces = new HashSet<Dataspace>(0);
	private Set<UserProject> userProjects = new HashSet<UserProject>(0);
	private Set<SchemaLog> schemaLogs = new HashSet<SchemaLog>(0);
	private Set<XMLFiles> xmlFiles = new HashSet<XMLFiles>(0);

	public Users() {
	}

	public Users(String department, String email, String firstName,
			String lastName) {
		this.department = department;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Users(String department, String email, String firstName, String grp,
			String lastName, String position, Set<UserDatabase> userDatabases,
			Set<Logins> loginses, Set<UserProject> userProjects,
			Set<SchemaLog> schemaLogs) {
		this.department = department;
		this.email = email;
		this.firstName = firstName;
		this.grp = grp;
		this.lastName = lastName;
		this.position = position;
		this.userDatabases = userDatabases;
		this.loginses = loginses;
		this.userProjects = userProjects;
		this.schemaLogs = schemaLogs;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "User_ID", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "Department", nullable = false, length = 245)
	@NotNull
	@Length(max = 245)
	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "Email", nullable = false, length = 220)
	@NotNull
	@Length(max = 120)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "First_Name", nullable = false, length = 145)
	@NotNull
	@Length(max = 145)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "Grp", length = 220)
	@Length(max = 220)
	public String getGrp() {
		return this.grp;
	}

	public void setGrp(String grp) {
		this.grp = grp;
	}

	@Column(name = "Last_Name", nullable = false, length = 245)
	@NotNull
	@Length(max = 245)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "Position", length = 220)
	@Length(max = 220)
	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<UserDatabase> getUserDatabases() {
		return this.userDatabases;
	}

	public void setUserDatabases(Set<UserDatabase> userDatabases) {
		this.userDatabases = userDatabases;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Logins> getLoginses() {
		return this.loginses;
	}

	public void setLoginses(Set<Logins> loginses) {
		this.loginses = loginses;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Dataspace> getDataspaces() {
		return dataspaces;
	}

	public void setDataspaces(Set<Dataspace> dataspaces) {
		this.dataspaces = dataspaces;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<UserProject> getUserProjects() {
		return this.userProjects;
	}

	public void setUserProjects(Set<UserProject> userProjects) {
		this.userProjects = userProjects;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<SchemaLog> getSchemaLogs() {
		return this.schemaLogs;
	}

	public void setSchemaLogs(Set<SchemaLog> schemaLogs) {
		this.schemaLogs = schemaLogs;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<XMLFiles> getXmlFiles() {
		return xmlFiles;
	}

	public void setXmlFiles(Set<XMLFiles> xmlFiles) {
		this.xmlFiles = xmlFiles;
	}

}
