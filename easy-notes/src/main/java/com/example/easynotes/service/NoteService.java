package com.example.easynotes.service;

import com.example.easynotes.model.Category;
import com.example.easynotes.model.Note;
import com.example.easynotes.repository.CategoryRepository;
import com.example.easynotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by amer on 2/19/18.
 */

@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    public Note createNote(Note note){
        Category findCategory = note.getCategory();
        Category inputCategory = categoryRepository.findOne(findCategory.getId());
        note.setCategory(inputCategory);

        return noteRepository.save(note);
    }
}
