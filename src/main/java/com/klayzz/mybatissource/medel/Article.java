package com.klayzz.mybatissource.medel;

import lombok.Data;

import java.util.Date;

@Data
public class Article {
    private Integer id;
    private String title;
    private String author;
    private String content;
    private Date createTime;
}
