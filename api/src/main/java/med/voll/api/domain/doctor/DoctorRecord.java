package med.voll.api.domain.doctor;

public record DoctorRecord(Long id, String nome, String email, String phone) {
    public DoctorRecord(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getPhone());
    };
}
