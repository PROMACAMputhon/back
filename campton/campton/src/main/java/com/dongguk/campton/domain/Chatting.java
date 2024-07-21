package com.dongguk.campton.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;

import static jakarta.persistence.FetchType.LAZY;

@Table(name = "CHATTING_TB")
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
    @Lob
    private String answer;

    //createAt
    @Column(name = "create_at", nullable = false)
    private LocalDate createAt;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @Builder
    public Chatting(String question, String answer, Room room) {
        this.question = question;
        this.answer = answer;
        this.createAt = LocalDate.now();
        this.room = room;
    }
}
