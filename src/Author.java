public class Author {
    private String name;
    private String affiliation;
    private String email;
    private int citations;

    public Author() {
        // Constructor vacío
    }

    // Constructor con parámetros
    public Author(String name, String affiliation, String email, int citations) {
        this.name = name;
        this.affiliation = affiliation;
        this.email = email;
        this.citations = citations;
    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCitations() {
        return citations;
    }

    public void setCitations(int citations) {
        this.citations = citations;
    }
}
