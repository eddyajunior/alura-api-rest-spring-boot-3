package med.voll.api.doctor;

public record ListDoctorRecord(Long id, String nome, String email, String telefone) {
    public ListDoctorRecord(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getTelefone());
    };
}
