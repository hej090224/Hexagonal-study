package com.example.HexagonalStudy.adapter.out.persistence;

import com.example.HexagonalStudy.domain.model.UserAccount;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class JpaUserEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<String> roles;

    protected JpaUserEntity() {}

    public JpaUserEntity(Long id, String username, String password, Set<String> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public static JpaUserEntity fromDomain(UserAccount user) {
        return new JpaUserEntity(user.getId(), user.getUsername(), user.getPassword(), user.getRoles());
    }

    public UserAccount toDomain(){
        return new UserAccount(id, username, password, roles);
    }
}
