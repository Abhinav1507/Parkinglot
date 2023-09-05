package Models;

public abstract class BaseEntity {
    long id;

    public long getId() {
        return id;
    }

    public void setId(long Id) {
        this.id=Id;
    }
    
}