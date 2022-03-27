package com.bodrulamin.noteapp_room.roomdb;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.bodrulamin.noteapp_room.model.Note;

import java.util.List;

@androidx.room.Dao
public interface NoteDao {
    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("Delete from note")
    void deleteAllNotes();

    @Query("SELECT * FROM Note where title like :title or description like :description limit 1")
    Note findByTitleOrDescription(String title,String description);
    @Query("SELECT * FROM note order by title ASC")
    LiveData<List<Note>> getAllNotes();
}
