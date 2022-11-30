package no.fintlabs.kurstest.note;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/note")
public class NoteController {

    private final NoteRepository repository;

    public NoteController(NoteRepository noteRepository) {
        this.repository = noteRepository;
    }

    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
      log.debug("Adding note with id {}", note.getId());

      repository.addOrUpdate(note);

      return ResponseEntity.ok(note);
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        return ResponseEntity.ok(repository.getAllNotes());
    }
}
