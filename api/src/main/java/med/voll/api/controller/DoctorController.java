package med.voll.api.controller;

import med.voll.api.mock.DoctorMock;
import med.voll.api.mock.DoctorObject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorMock mock;

    DoctorController(){
        this.mock = new DoctorMock();
    }

    @GetMapping
    public ArrayList<DoctorObject> listAll()
    {
        return mock.listAll();
    }

    @DeleteMapping
    public String delete()
    {
        return mock.delete();
    }

    @GetMapping("/{id}")
    public DoctorObject findOne()
    {
        return mock.findOne();
    }
    @PutMapping
    public String update(){
        return mock.update();
    }

    @PostMapping
    public String create()
    {
        return mock.create();
    }
}
