package com.example.blocodenotas.controllers;

import com.example.blocodenotas.models.entitys.Notepad;
import com.example.blocodenotas.models.repositorys.NotepadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "notepad/")
public class NotepadController {
    @Autowired
    private NotepadRepository notepadRepository;

    @PostMapping(value = "add/{userId}")
    public ResponseEntity<Object> add(@PathVariable Long userId) {
        Notepad notepad = new Notepad(userId);
        try{
            notepad = notepadRepository.save(notepad);
            return ResponseEntity.ok(notepad);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("ERRO-> "+e.getMessage());
        }
    }
    @GetMapping(value = "get/{notepadId}")
    public ResponseEntity<Object> get(@PathVariable Long notepadId) {
        Notepad notepad = notepadRepository.findById(notepadId).get();
        if(notepad == null)
            return ResponseEntity.badRequest().body("notepad não encontrado");
        return ResponseEntity.ok(notepad);
    }
    @GetMapping("/get-all/{userId}")
    public ResponseEntity<Object> getAllNotepads(
            @PathVariable Long userId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
            @RequestParam(defaultValue = "DESC") String orderBy) {
        if (startDate == null) {
            startDate = LocalDateTime.of(1970, 1, 1, 0, 0);
        }
        if (endDate == null) {
            endDate = LocalDateTime.now();
        }
        List<Notepad> notepads;
        if ("ASC".equalsIgnoreCase(orderBy)) {
            notepads = notepadRepository.findByIdFilterAsc(userId, startDate, endDate);
        } else {
            notepads = notepadRepository.findByIdFilterDesc(userId, startDate, endDate);
        }
        return ResponseEntity.ok(notepads);
    }
    @PutMapping(value = "update/{notepadId}")
    public ResponseEntity<Object> update(@PathVariable Long notepadId, @RequestBody Notepad notepad) {
        Notepad notepadAux = notepadRepository.findById(notepadId).get();
        if(notepadAux == null)
            return ResponseEntity.badRequest().body("notepad não encontrado");
        if(notepad.getTitle() != null)
            notepadAux.setTitle(notepad.getTitle());
        if(notepad.getInformation() != null)
            notepadAux.setInformation(notepad.getInformation());
        notepadAux.setModificationDate(LocalDateTime.now());
        if(notepadAux.getInformation() != null)
            notepadAux.setNumberWords(notepadAux.getInformation().trim().split("\\s+").length);
        try{
            notepadRepository.save(notepadAux);
            return ResponseEntity.ok("Notepad atualizado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("ERRO-> "+e.getMessage());
        }
    }
    @DeleteMapping(value = "delete/{notepadId}")
    public ResponseEntity<Object> delete(@PathVariable Long notepadId) {
        Notepad notepad = notepadRepository.findById(notepadId).get();
        if(notepad == null)
            return ResponseEntity.badRequest().body("notepad não encontrado");
        try{
            notepadRepository.delete(notepad);
            return ResponseEntity.ok("Notepad deletado com sucesso!");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("ERRO-> "+e.getMessage());
        }
    }
}
