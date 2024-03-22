package med.voll.api.domain.doctor;

public record ListDoctorRecord(Long id, String nome, String email, String phone) {
    public ListDoctorRecord(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getPhone());
    };
}
