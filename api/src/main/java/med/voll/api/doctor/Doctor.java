package med.voll.api.doctor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "doctor")
@Entity(name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String telefone;
    private String document;

    public Doctor(CreateDoctorRecord doctor) {
        this.name = doctor.name();
        this.email = doctor.email();
        this.telefone = doctor.telefone();
        this.document = doctor.document();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void UpdateData(UpdateDoctorRecord doctorData) {
        if (doctorData.name() != null)
            this.name = doctorData.name();

        if (doctorData.email() != null)
            this.email = doctorData.email();

        if (doctorData.telefone() != null)
            this.telefone = doctorData.telefone();
    }
}
