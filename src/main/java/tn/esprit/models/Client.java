package tn.esprit.models;

import java.util.Objects;

public class Client extends Utilisateur {
    private String nomEntreprise;
    private String domaineActivite;


    public Client() {
        super();
        this.nomEntreprise = nomEntreprise;
        this.domaineActivite = domaineActivite;
    }


    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public String getDomaineActivite() {
        return domaineActivite;
    }

    public void setDomaineActivite(String domaineActivite) {
        this.domaineActivite = domaineActivite;
    }


    @Override
    public String toString() {
        return "Client{" +
                ", nomEntreprise='" + nomEntreprise + '\'' +
                ", domaineActivite='" + domaineActivite + '\'' +
                "} " + super.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nomEntreprise, domaineActivite);
    }

}
