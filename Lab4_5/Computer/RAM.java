package Computer;
import java.io.Serializable;
import java.util.Objects;

public class RAM implements Serializable {
    private String type;
    private int size;

    RAM() {
        type = "Unknown";
        size = 0;
    }
    RAM(String type, int size) throws Exception {
        if(size < 0) throw new Exception("Size of RAM less than zero!");
        this.size = size;
        this.type = type;
    }

    public String getType()
    {
        return this.type;
    }
    public int getSize()
    {
        return this.size;
    }
    public void setType(String type)
    {
        this.type = type;
    }
    public void setSize(int size) throws Exception {
        if(size < 0) throw new Exception("Size of RAM less than zero!");
        this.size = size;
    }

    @Override
    public String toString()
    {
        return "Type of RAM: " + getType() + "\nSize of RAM: " + getSize();
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(type, size);
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        RAM ram = (RAM) obj;
        return (type.equals(ram.type) && size == ram.size);
    }
}