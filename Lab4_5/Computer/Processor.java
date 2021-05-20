package Computer;
import java.io.Serializable;
import java.util.Objects;

public class Processor implements Serializable {
    private String name;

    Processor()
    {
        name = "Unknown";
    }
    Processor(String name)
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
        return "Processor: " + getName();
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
        Processor processor = (Processor) obj;
        return name.equals(processor.name);
    }
}