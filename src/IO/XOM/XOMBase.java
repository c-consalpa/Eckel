package IO.XOM;



import javax.print.Doc;
import java.io.*;

public class XOMBase {
//    public static void main(String[] args) {
//    Person person = new Person("1123123", "asdadwd");
//
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream("xomData");
//            Serializer s = new Serializer(fileOutputStream, "UTF-8");
//            s.setIndent(4);
//            s.setMaxLength(64);
//            Document document = new Document(person.getAsXML());
//            s.write(document);
//            s.flush();
//            fileOutputStream.close();
//        } catch (IOException e) {
//            System.err.println(e);
//        }
//
////      read:
//
//        try {
//            Builder parser = new Builder();
//            Document doc = parser.build(new File("xomData"));
//            System.out.println("restored:");
//            System.out.println(doc.toXML());
//        } catch (IOException e) {
//            System.err.println(e);
//        } catch (ValidityException e) {
//            e.printStackTrace();
//        } catch (ParsingException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//class Person {
//    public String name;
//    public String lastName;
//
//    public Person(String name, String lastName) {
//        this.name = name;
//        this.lastName = lastName;
//    }
//
//    public Element getAsXML() {
//        Element element = new Element("Person");
//        Element fName = new Element("first");
//        fName.appendChild(name);
//        element.appendChild(fName);
//
//        return element;
//    }
}
