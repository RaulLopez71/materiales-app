package com.example.materiales_app.web;

import com.example.materiales_app.entity.Material;
import com.example.materiales_app.repo.MaterialRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/materiales")
public class MaterialController {

    private final MaterialRepository repo;

    public MaterialController(MaterialRepository repo) {
        this.repo = repo;
    }

    @GetMapping({"", "/"})
    public Page<Material> listar(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> porId(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping({"", "/"})
    public ResponseEntity<Material> crear(@Valid @RequestBody Material m) { //Agregando @Valid
        Material creado = repo.save(m);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}") //Agregando @Valid
    public ResponseEntity<Material> actualizar(@PathVariable Long id, @Valid @RequestBody Material m) {

        return repo.findById(id).map(db -> {

            db.setNombre(m.getNombre());
            db.setUnidad(m.getUnidad());
            db.setPrecio(m.getPrecio());
            return ResponseEntity.ok(repo.save(db));
        }).orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
