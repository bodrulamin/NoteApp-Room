package com.bodrulamin.noteapp_room;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.room.Room;

import com.bodrulamin.noteapp_room.databinding.FragmentFirstBinding;
import com.bodrulamin.noteapp_room.model.Note;
import com.bodrulamin.noteapp_room.roomdb.NoteDatabase;

import java.util.List;

public class NoteListFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NoteDatabase db = Room.databaseBuilder(requireContext(),
                NoteDatabase.class, "database-name").build();

     //   List<Note> notes = db.noteDao().getAllNotes();




    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void gotoNoteListFragment() {
        NavHostFragment.findNavController(NoteListFragment.this)
                .navigate(R.id.action_NoteListFragment_to_AddNote);
    }
}