package repository;

public class Manufacturer {
    private String name;
    private boolean extendGuarantee;

    public Manufacturer(String name, boolean extendGuarantee){
        this.name = name;
        this.extendGuarantee = extendGuarantee;
    }

    public boolean ExtendGuarantee(){
        if (this.extendGuarantee == true)
            return true;

        return false;
    }

    @Override
    public String toString() {
        return "repository.Manufacturer{" +
                "name='" + name + '\'' +
                ", extendGuarantee" + extendGuarantee + '\'' +
                '}';
    }
}
