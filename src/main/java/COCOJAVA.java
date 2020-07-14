import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class COCOJAVA extends Canvas {

    //DATOS MIEMBRO

    //MÉTODOS CONSTRUCTORES

    //MÉTODOS DE SERVICIO
    public void paint (Graphics g) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        //Imágen 1: OSO CON TECLADO (ID: 42889) (Segmentada y Normal)
        Image imagen1a = toolkit.getImage("COCOO/val2017/000000042889.png");
        Image imagen1b = toolkit.getImage("COCOO/val2017/000000042889.jpg");
        //Imágen 2: OSOS Y CAMA (ID: 776) (Segmentada y Normal)
        Image imagen2a = toolkit.getImage("COCOO/val2017/000000000776.png");
        Image imagen2b = toolkit.getImage("COCOO/val2017/000000000776.jpg");
        //Imágen 3: OSO (ID: 522638) (Segmentada y Normal)
        Image imagen3a = toolkit.getImage("COCOO/val2017/000000522638.png");
        Image imagen3b = toolkit.getImage("COCOO/val2017/000000522638.jpg");

        //Arreglos para guardar ancho (w) y alto (h) de las imágenes
        int [] w = new int[3];
        int [] h = new int[3];
        w[0] = (int) (0.5*(imagen1a.getWidth(this)));
        w[1] = (int) (0.4*(imagen2a.getWidth(this)));
        w[2] = (int) (0.3*(imagen3a.getWidth(this)));
        h[0] = (int) (0.5*(imagen1a.getHeight(this)));
        h[1] = (int) (0.4*(imagen2a.getHeight(this)));
        h[2] = (int) (0.3*(imagen3a.getHeight(this)));
        //Variables para guardar posición de imágen horizontal y vertical
        int x = 0;
        int y = 0;

        //Dibujo de la imagen en la interfaz gráfica
        //Imágen 1: OSO CON TECLADO (ID: 42889) (Segmentada y Normal)
        g.drawImage(imagen1a, x = 120, y = 100, w[0], h[0], this);
        g.drawImage(imagen1b, x += w[0]+50, y, w[0], h[0],this);
        //Imágen 2: OSOS Y CAMA (ID: 776) (Segmentada y Normal)
        g.drawImage(imagen2a, x += w[0] + 50, y, w[1], h[1], this);
        g.drawImage(imagen2b, x += w[1] + 50, y, w[1], h[1], this);
        //Imágen 3: OSO (ID: 522638) (Segmentada y Normal)
        g.drawImage(imagen3a, x = 120, y = 400, w[2], h[2], this);
        g.drawImage(imagen3b, x += w[2] + 50, y, w[2], h[2], this);
    }

    //MÉTODO PRINCIPAL
    public static void main (String [] args){

        //CONVERSIÓN DE OBJETO JSON de COCO a OBJETO JAVA con JSON ELEMENT
        //Creación del objeto Gson con (setPrettyPrinting para poder leer la
        //información fácilmente), donde se colocará Json de Anotaciones de
        //COCO
        Gson gson = new GsonBuilder ().setPrettyPrinting ().create();
        //Manejo de Excepción In/Out
        try {
            //Se lee archivo de objeto de las anotaciónes de validación de las
            //imágenes elegidas de COCO, .
            //CATEGORÍA PRINCIPAL: TEDDY BEAR (88)
            //Categorías Secundarias: BED (65), KEYBOARD (76)
            Reader reader = new FileReader ("COCOO/instances_val2017.json");
            //Conversión Json a JsonElement
            JsonElement json = gson.fromJson(reader, JsonElement.class);
            //Conversdión JsonElement a String para lectura en pantalla
            String jsonString = gson.toJson(json);
            //Impresión del String
            System.out.println ("Anotaciones de Imagenes leídas con JsonElement:"
                    + " \n "  + jsonString);
        }
        catch (IOException e) {
            e.printStackTrace ();
        }

        String nombreArchivo = "TEDDY BEAR 1"; //"Oso1.jpg";
        COCOJAVA mImagen = new COCOJAVA ();
        JFrame jFrame = new JFrame ("HANDLIN' JSON OBJECTS (COCO's IMAGES \t TEDDY BEAR \t (2017's DATA SET)");
        jFrame.setLayout(new BorderLayout ());
        jFrame.add (mImagen, BorderLayout.CENTER); //Componentes se van agregando en el JFRAME creado en el centro

        try {
            //Se lee archivo de objeto de las anotaciónes de validación de las
            //imágenes elegidas de COCO, .
            //CATEGORÍA PRINCIPAL: TEDDY BEAR (88)
            //Categorías Secundarias: BED (65), KEYBOARD (76)
            Reader reader = new FileReader ("COCOO/instances_val2017.json");
            //Conversión Json a JsonElement
            JsonElement json = gson.fromJson(reader, JsonElement.class);
            //Conversdión JsonElement a String para lectura en pantalla
            String jsonString = gson.toJson(json);
            //Impresión del String
            String texto = "Anotaciones de Imagenes leídas con JsonElement:"
                    + " \n "  + jsonString;
            JTextArea textoArea = new JTextArea (texto); //Se crea área de texto
            jFrame.add (textoArea, BorderLayout.EAST); //Se coloca en el este
        }
        catch (IOException e) {
            e.printStackTrace ();
        }

        JButton boton = new JButton ("Soy un botón");
        jFrame.add(boton, BorderLayout.WEST); //se crea botón en el oeste

        jFrame.add (new JTextArea ("Otras cosas importantes"), BorderLayout.SOUTH); //En el sur se crean otras cosas importantes

        JLabel etiqueta = new JLabel (nombreArchivo);
        etiqueta.setHorizontalAlignment(JLabel.CENTER);
        etiqueta.setPreferredSize(new Dimension (50,50));
        etiqueta.setBorder (BorderFactory.createLineBorder (Color.RED));


        jFrame.add(etiqueta, BorderLayout.NORTH);

        jFrame.setSize (2000,3000);
        jFrame.setVisible (true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}