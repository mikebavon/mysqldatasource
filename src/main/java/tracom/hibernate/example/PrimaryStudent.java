package tracom.hibernate.example;

public class PrimaryStudent {

    private int recorId;

    private String primaryName;

    private String primaryEmail;

    public int getRecorId() {
        return recorId;
    }

    public void setRecorId(int recorId) {
        this.recorId = recorId;
    }

    public String getPrimaryName() {
        return primaryName;
    }

    public void setPrimaryName(String primaryName) {
        this.primaryName = primaryName;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }
}
