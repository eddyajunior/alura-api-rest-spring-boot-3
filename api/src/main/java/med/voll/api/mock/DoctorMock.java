package med.voll.api.mock;

import java.util.ArrayList;

public class DoctorMock {
    public ArrayList<DoctorObject> listAll(){
        var doctor1 = new DoctorObject(1, "John Snow", "1234BR");
        var doctor2 = new DoctorObject(1, "John Snow", "1234BR");
        var doctor3 = new DoctorObject(1, "John Snow", "1234BR");
        var doctor4 = new DoctorObject(1, "John Snow", "1234BR");

        var doctors = new ArrayList<DoctorObject>();
        doctors.add(doctor1);
        doctors.add(doctor2);
        doctors.add(doctor3);
        doctors.add(doctor4);

        return doctors;
    }
    public DoctorObject findOne(){
        return new DoctorObject(1, "John Snow", "1234BR");
    }
    public String delete()
    {
        return "Médico excluído com sucesso!";
    }
    public String update()
    {
        return "Médico atualizado com sucesso!";
    }
    public String create()
    {
        return "Médico cadastrado com sucesso!";
    }
}

