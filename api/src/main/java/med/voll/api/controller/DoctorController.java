package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private IDoctorRepository repository;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid CreateDoctorRecord doctor)
    {
        repository.save(new Doctor(doctor));
    }

    @GetMapping
    public Page<ListDoctorRecord> list(@PageableDefault(size = 10, sort = { "name" }) Pageable pagination)
    {
        return repository.findAll(pagination).map(ListDoctorRecord::new);
    }
    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid UpdateDoctorRecord doctorData)
    {
        var doctor = repository.getReferenceById(doctorData.id());
        doctor.UpdateData(doctorData);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id)
    {
        repository.deleteById(id);
    }
}
