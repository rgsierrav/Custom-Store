import java.io.*;

public class FileManager {

    // Serialize an object and save it to a file
    public static void serialize(Object obj, String filename) {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(obj);
        } catch (IOException e) {
            System.out.println("An error occurred during serialization: " + e.getMessage());
        }
    }

    // Deserialize an object from a file
    public static Object deserialize(String filename) {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return in.readObject();
        } catch (IOException e) {
            System.out.println("An error occurred during deserialization: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
        return null;
    }
}
