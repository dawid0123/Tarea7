package Ejercicio7;


import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GenerarAlumnos {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element rootElement = doc.createElement("Alumnos");
            doc.appendChild(rootElement);

            Scanner scanner = new Scanner(System.in);

            for (int i = 1; i <= 5; i++) {
                System.out.println("Alumno " + i + ":");

                System.out.print("NIA");
                int nia = Integer.parseInt(scanner.nextLine());

                System.out.print("Nombre");
                String nombre = scanner.nextLine();

                System.out.print("Apellidos");
                String apellidos = scanner.nextLine();

                System.out.print("Género");
                char genero = scanner.nextLine().charAt(0);

                System.out.print("Fecha de Nacimiento");
                String fechaNacimiento = scanner.nextLine();

                System.out.print("Ciclo");
                String ciclo = scanner.nextLine();

                System.out.print("Curso");
                String curso = scanner.nextLine();

                System.out.print("Grupo");
                String grupo = scanner.nextLine();

                Element alumno = doc.createElement("Alumno");
                rootElement.appendChild(alumno);

                Element niaElement = doc.createElement("NIA");
                niaElement.appendChild(doc.createTextNode(String.valueOf(nia)));
                alumno.appendChild(niaElement);

                Element nombreElement = doc.createElement("Nombre");
                nombreElement.appendChild(doc.createTextNode(nombre));
                alumno.appendChild(nombreElement);

                Element apellidosElement = doc.createElement("Apellidos");
                apellidosElement.appendChild(doc.createTextNode(apellidos));
                alumno.appendChild(apellidosElement);

                Element generoElement = doc.createElement("Genero");
                generoElement.appendChild(doc.createTextNode(String.valueOf(genero)));
                alumno.appendChild(generoElement);

                Element fechaElement = doc.createElement("FechaNacimiento");
                fechaElement.appendChild(doc.createTextNode(fechaNacimiento));
                alumno.appendChild(fechaElement);

                Element cicloElement = doc.createElement("Ciclo");
                cicloElement.appendChild(doc.createTextNode(ciclo));
                alumno.appendChild(cicloElement);

                Element cursoElement = doc.createElement("Curso");
                cursoElement.appendChild(doc.createTextNode(curso));
                alumno.appendChild(cursoElement);

                Element grupoElement = doc.createElement("Grupo");
                grupoElement.appendChild(doc.createTextNode(grupo));
                alumno.appendChild(grupoElement);

                System.out.println("Alumno " + i + " agregado.\n");
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("alumnos.xml"));

            transformer.transform(source, result);

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

