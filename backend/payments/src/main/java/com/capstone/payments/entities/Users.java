package com.capstone.payments.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sequenceId")
    private int sequenceId;
    @Column(name = "loginId")
    private String loginId;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
    @Column(name = "roleId")
    private String roleId;

    public Users() {
        super();
    }

    public Users(int sequenceId, String loginId, String password, String role, String roleId) {
        super();
        this.sequenceId = sequenceId;
        this.loginId = loginId;
        this.password = password;
        this.role = role;
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "User [SequenceId=" + sequenceId + ", LoginId=" + loginId + ", role =" + role
                + ", roleId =" + roleId + "]";
    }

    public int getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}

