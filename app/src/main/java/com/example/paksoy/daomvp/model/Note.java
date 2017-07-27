package com.example.paksoy.daomvp.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by MONSTER on 5.7.2017.
 */

@Entity
public class Note {
    private String note;

    @Id(autoincrement = true)
    private Long messageId;

    @Generated(hash = 233377341)
    public Note(String note, Long messageId) {
        this.note = note;
        this.messageId = messageId;
    }

    @Generated(hash = 1272611929)
    public Note() {
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getMessageId() {
        return this.messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }
}
