package de.htwberlin.web;

import de.htwberlin.web.api.Debts;
import de.htwberlin.web.api.DebtsManipulationRequest;
import de.htwberlin.web.service.DebtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class DebtsRestController {

    private final DebtService debtService;

    public DebtsRestController(DebtService debtService) {
        this.debtService = debtService;
    }

    @GetMapping(path = "/api/v1/debts")
    public ResponseEntity<List<Debts>> fetchDebts() {
        return ResponseEntity.ok(debtService.findAll());
    }

    @GetMapping(path = "api/v1/debts/{id}")
    public ResponseEntity<List<Debts>> fetchDebtsSorted(@PathVariable Long id){
        return ResponseEntity.ok(debtService.findByCreditor(id));
    }

    @PostMapping(path = "/api/v1/debts")
    public ResponseEntity<Void> createDebt(@Valid @RequestBody DebtsManipulationRequest request) throws URISyntaxException {
        var debt = debtService.create(request);
        URI uri = new URI("/api/v1/debts" + debt.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/debts/{id}")
    public ResponseEntity<Debts> updateDebt(@PathVariable Long id, @RequestBody DebtsManipulationRequest request) {
        var debt = debtService.update(id, request);
        return debt != null ? ResponseEntity.ok(debt) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/debts/{id}")
    public ResponseEntity<Void> deleteDebt(@PathVariable Long id) {
        boolean successfull = debtService.deleteById(id);
        return successfull ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
