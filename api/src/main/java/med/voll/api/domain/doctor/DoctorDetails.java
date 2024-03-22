package med.voll.api.domain.doctor;

public record DoctorDetails(Long id, String name, String email, String phone, String document) {
    public DoctorDetails(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getPhone(), doctor.getDocument());
    }
}
