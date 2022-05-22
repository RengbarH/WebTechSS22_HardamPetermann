package de.htwberlin.web;

import de.htwberlin.web.service.CreditorService;
import de.htwberlin.web.api.Creditor;
import de.htwberlin.web.api.CreditorManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class CreditorRestController {

    private final CreditorService creditorService;

    public CreditorRestController(CreditorService creditorService) {
        this.creditorService = creditorService;
    }

    @GetMapping(path = "/api/v1/creditor")
    public ResponseEntity<List<Creditor>> fetchCreditors() {
        return ResponseEntity.ok(creditorService.findAll());
    }

    @GetMapping(path = "/api/v1/creditor/{id}")
    public ResponseEntity<Creditor> fetchCreditorById(@PathVariable long id) {
        var creditor = creditorService.findById(id);
        return creditor != null ? ResponseEntity.ok(creditor) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/creditor")
    public ResponseEntity<Creditor> createCreditor(@RequestBody CreditorManipulationRequest request) throws URISyntaxException {
        var creditor = creditorService.create(request);
        URI uri = new URI("/api/v1/creditor/" + creditor.getId());
        return ResponseEntity.created(uri).body(creditor);
    }

    @PutMapping(path = "/api/v1/creditor/{id}")
    public ResponseEntity<Creditor> updateCreditor(@PathVariable Long id, @RequestBody CreditorManipulationRequest request) {
        var creditor = creditorService.update(id, request);
        return creditor != null ? ResponseEntity.ok(creditor) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/creditor/{id}")
    public ResponseEntity<Void> deleteCreditor(@PathVariable Long id) {
        boolean successful = creditorService.deleteById(id);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
