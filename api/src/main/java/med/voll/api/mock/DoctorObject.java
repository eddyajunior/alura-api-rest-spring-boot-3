package med.voll.api.mock;

public class DoctorObject{
    public DoctorObject(int id, String name, String document){
        this.setId(id);
        this.setName(name);
        this.setDocument(document);
    }
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDocument() {
        return Document;
    }

    public void setDocument(String document) {
        Document = document;
    }

    private int Id;
    private String Name;
    private String Document;

    public DoctorObject newDoctor()
    {
        return new DoctorObject(this.getId(), this.getName(), this.getDocument());
    }
}
