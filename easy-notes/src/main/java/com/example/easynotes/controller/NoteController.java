package com.example.easynotes.controller;

import com.example.easynotes.model.Category;
import com.example.easynotes.model.Note;
import com.example.easynotes.repository.CategoryRepository;
import com.example.easynotes.repository.NoteRepository;
import com.example.easynotes.service.NoteService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;

/**
 * Created by amer on 2/16/18.
 */

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    NoteService noteService;

    // Get All Notes
    @GetMapping("/notes")
    public List<Note> getAllNotes(){
        return noteService.getAllNotes();
    }

    // Create a New Note
    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note){
        return noteService.createNote(note);
    }

    // Get a Single Note
    @GetMapping("/notes/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable(value="id") Long noteId) {
        Note note = noteService.getNoteById(noteId);
        if(note == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(note);
    }

    // Update a Note
    @PutMapping("notes/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable(value="id") Long noteId,
                                           @Valid @RequestBody Note noteDetails){
        Note updatedNote = noteService.updateNote(noteId, noteDetails);
        if(updatedNote==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedNote);
    }

    // Delete a Note
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<Note> deleteNote(@PathVariable(value="id") Long noteId){
        Boolean response = noteService.deleteNote(noteId);
        if(response==false){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }
}
