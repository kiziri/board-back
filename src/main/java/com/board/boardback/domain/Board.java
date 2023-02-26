package com.board.boardback.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 알아서 생성해주는 것으로
    private long board_id;
    private String title;
    private String content;
    private Date write_date;
    private int view_count;
    private int comment_count;
    private String member_id;
}
