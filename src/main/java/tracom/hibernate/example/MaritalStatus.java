package tracom.hibernate.example;

public enum MaritalStatus {

    MARRIED("Married"),
    SINGLE("Single"),
    COMPLICATED("Complicated");

    private String name;

    MaritalStatus(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
