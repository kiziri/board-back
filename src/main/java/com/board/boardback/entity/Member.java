package com.board.boardback.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 알아서 생성해주는 것으로
    private long member_serial;
    private String member_id;
    private String password;
    private String name;
    private String tel_number;
    private String address;
    private String join_date;
    private String acc_lvl;

}
