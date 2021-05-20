package Computer;
import java.io.Serializable;
import java.util.Objects;

public class Winchester implements Serializable {
    private String type;
    private int size;

    Winchester() {
        type = "Unknown";
        size = 0;
    }
    Winchester(String type, int size) throws Exception {
        if(size < 0) throw new Exception("Size of winchester less than zero!");
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
        if(size < 0) throw new Exception("Size of winchester less than zero!");
        this.size = size;
    }

    @Override
    public String toString()
    {
        return "Type of Winchester: " + getType() + "\nSize of Winchester: " + getSize();
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
        Winchester winchester = (Winchester) obj;
        return (type.equals(winchester.type) && size == winchester.size);
    }
}