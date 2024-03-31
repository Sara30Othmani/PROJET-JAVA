package tn.esprit.models;

public class Tache {
    private int id;
    private String titre;
    private String description;
    private String Status;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tache(int id, String titre, String description,String Status) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.Status = Status;
    }

    public Tache(String titre, String description) {
        this.titre = titre;
        this.description = description;
    }

    public Tache(String titre, String description, String status) {
        this.titre = titre;
        this.description = description;
        Status = status;
    }

    @Override
    public String toString() {
        return "Tache{" + "id=" + id + ", titre=" + titre + ", description=" + description + '}';
    }

    public Tache() {
    }

}
