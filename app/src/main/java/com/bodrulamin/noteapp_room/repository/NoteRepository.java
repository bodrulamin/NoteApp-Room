package com.bodrulamin.noteapp_room.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.bodrulamin.noteapp_room.model.Note;
import com.bodrulamin.noteapp_room.roomdb.NoteDao;
import com.bodrulamin.noteapp_room.roomdb.NoteDatabase;

import java.util.List;

public class NoteRepository {
    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;

    NoteRepository(Application application) {
        NoteDatabase db = NoteDatabase.getDatabase(application);
        noteDao = db.noteDao();
        allNotes = noteDao.getAllNotes();
    }

    LiveData<List<Note>> getAllWords() {
        return allNotes;
    }

    void insert(Note note) {
        NoteDatabase.databaseWriteExecutor.execute(() -> {
            noteDao.insert(note);
        });
    }



}
