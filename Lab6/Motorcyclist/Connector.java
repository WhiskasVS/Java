package Motorcyclist;
import java.io.*;

public class Connector {
    ObjectOutputStream output;
    ObjectInputStream input;
    String fileName;

    public Connector() throws IOException {
        this.fileName = "Text.txt";
        this.output = new ObjectOutputStream(new FileOutputStream(fileName));
        this.input = new ObjectInputStream(new FileInputStream(fileName));
    }
    public Connector(String fileName) throws IOException {
        this.fileName = fileName;
        this.output = new ObjectOutputStream(new FileOutputStream(fileName));
        this.input = new ObjectInputStream(new FileInputStream(fileName));
    }

    public void toSerializeInFile(Object[] Objects) throws IOException {
        for (Object object: Objects) {
            output.writeObject(object);
            System.out.println(object);
        }
    }
    public void toDeserializeFromFile(Object[] Objects) throws IOException, ClassNotFoundException {
        for (Object object: Objects) {
            Object newObject = (Object) input.readObject();
            System.out.println(newObject);
        }
    }
    public ObjectOutputStream getOutput() { return this.output; }
    public ObjectInputStream getInput() { return this.input; }
    public String getFileName() { return this.fileName; }
}