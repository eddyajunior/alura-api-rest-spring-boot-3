package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private IDoctorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid CreateDoctorRecord doctor, UriComponentsBuilder uriBuilder)
    {
        var item = new Doctor(doctor);
        repository.save(item);

        var uri = uriBuilder.path("/doctor/{id}").buildAndExpand(item.getId()).toUri();
        return ResponseEntity.created(uri).body(item);
    }

    @GetMapping
    public ResponseEntity<Page<ListDoctorRecord>> list(@PageableDefault(size = 10, sort = { "name" }) Pageable pagination)
    {
        var page = repository.findAll(pagination).map(ListDoctorRecord::new);
        return ResponseEntity.ok(page);
    }
    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateDoctorRecord doctorData)
    {
        var doctor = repository.getReferenceById(doctorData.id());
        doctor.UpdateData(doctorData);
        return ResponseEntity.ok(new DoctorDetails(doctor));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id)
    {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity details(@PathVariable Long id)
    {
        var doctor = repository.getReferenceById(id);

        return ResponseEntity.ok(new DoctorDetails(doctor));
    }
}
