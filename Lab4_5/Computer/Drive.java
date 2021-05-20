package Computer;
import java.io.Serializable;
import java.util.Objects;

public class Drive implements Serializable {
    private String name;

    Drive()
    {
        name = "Unknown";
    }
    Drive(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Type of drive: " + getName();
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(name);
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Drive drive = (Drive) obj;
        return name.equals(drive.name);
    }
}