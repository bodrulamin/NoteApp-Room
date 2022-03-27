package com.bodrulamin.noteapp_room.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Note {
    @PrimaryKey(autoGenerate = true)
    int id;
    String title;
    String description;
}
