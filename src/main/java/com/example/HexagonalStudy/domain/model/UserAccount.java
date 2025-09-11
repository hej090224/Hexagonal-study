package com.example.HexagonalStudy.domain.model;

import java.util.Set;

public class UserAccount {
    private Long id;
    private String username;
    private String password;
    private Set<String> roles;

    public UserAccount() {}
    public UserAccount(Long id, String username, String password, Set<String> roles) {
        this.id = id; this.username = username; this.password = password; this.roles = roles;
    }

    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public Set<String> getRoles() { return roles; }
    public void setId(Long id) { this.id = id; }
    public void setUsername(String u) { this.username = username = u; }
    public void setPassword(String p) { this.password = p; }
    public void setRoles(Set<String> r) { this.roles = roles = r; }
}
