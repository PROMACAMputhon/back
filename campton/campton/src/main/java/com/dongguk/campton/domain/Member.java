package com.dongguk.campton.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Table(name = "MEMBER_TB")
@Entity
@Getter
@NoArgsConstructor
@DynamicUpdate
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //member_login_id
    @Column(name = "member_login_id", nullable = false)
    private String loginId;

    //member_password
    @Column(name = "member_password", nullable = false)
    private String password;

    //is_login
    @Column(name = "is_login", nullable = false)
    private Boolean isLogin;

    @OneToMany(mappedBy = "member", cascade = CascadeType.MERGE)
    private List<Room> rooms = new ArrayList<>();


    @Builder
    public Member(String loginId, String password){
        this.loginId = loginId;
        this.password = password;
    }
}