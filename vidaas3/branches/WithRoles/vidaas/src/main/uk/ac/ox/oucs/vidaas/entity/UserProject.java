package uk.ac.ox.oucs.vidaas.entity;

// Generated 01-Aug-2011 14:49:06 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.validator.NotNull;

/**
 * UserProject generated by hbm2java
 */
@Entity
@Table(name = "user_project", catalog = "vidaas_v3")
@NamedQueries({
    @NamedQuery(name = "UserProject.findAll", query = "SELECT u FROM UserProject u"),
    @NamedQuery(name = "UserProject.findByProjectID", query = "SELECT u FROM UserProject u WHERE u.id.projectId = :projectID"),
    @NamedQuery(name = "UserProject.findByUserID", query = "SELECT u FROM UserProject u WHERE u.id.userId = :userID"),
    @NamedQuery(name = "UserProject.findByUserIDAndProjectID", query = "SELECT u FROM UserProject u WHERE u.id.userId = :userID AND u.id.projectId = :projectID"),
    @NamedQuery(name = "UserProject.findByUserRole", query = "SELECT u FROM UserProject u WHERE u.userRole = :userRole")})
public class UserProject implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7219350320024039447L;
	private UserProjectId id;
	private Users users;
	private Project project;
	private String userRole;

	public UserProject() {
	}

	public UserProject(UserProjectId id, Users users, Project project,
			String userRole) {
		this.id = id;
		this.users = users;
		this.project = project;
		this.userRole = userRole;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "projectId", column = @Column(name = "Project_ID", nullable = false)),
			@AttributeOverride(name = "userId", column = @Column(name = "User_ID", nullable = false)) })
	@NotNull
	public UserProjectId getId() {
		return this.id;
	}

	public void setId(UserProjectId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)//May need to be eager
	@JoinColumn(name = "User_ID", nullable = false, insertable = false, updatable = false)
	@NotNull
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Project_ID", nullable = false, insertable = false, updatable = false)
	@NotNull
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Column(name = "User_Role", nullable = false)
	@NotNull
	public String getUserRole() {
		return this.userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
