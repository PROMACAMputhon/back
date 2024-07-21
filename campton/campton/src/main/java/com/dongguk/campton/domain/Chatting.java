package com.dongguk.campton.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;

import static jakarta.persistence.FetchType.LAZY;

@Table(name = "CAHTTING_TB")
@Entity
@Getter
@NoArgsConstructor
@DynamicUpdate
public class Chatting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //question
    @Column(name = "question", nullable = false)
    private String question;
    //answer
    @Column(name = "answer", nullable = false)
    private String answer;

    //createAt
    @Column(name = "create_at", nullable = false)
    private LocalDate createAt;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;
}
