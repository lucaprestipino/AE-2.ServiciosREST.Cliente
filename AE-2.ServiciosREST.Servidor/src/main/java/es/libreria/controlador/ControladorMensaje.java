package es.libreria.controlador;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorMensaje {

    @GetMapping(value="mensajeHTML", produces = MediaType.TEXT_HTML_VALUE)
    public String obtenMensajeHTML() {
        StringBuffer buffer = new StringBuffer();
        
        buffer.append("<html>");
        buffer.append("<head>");
        buffer.append("<style>");
        buffer.append("body {");
        buffer.append("background-color: lightblue;");
        buffer.append("}");
        buffer.append("h1 {");
        buffer.append("color: navy;");
        buffer.append("margin-left: 20px;");
        buffer.append("}");
        buffer.append("</style>");
        buffer.append("</head>");
        buffer.append("<body>");
        buffer.append("<h1>Conexión recibida</h1>");
        buffer.append("</body>");
        buffer.append("</html>");

        return buffer.toString();
    }

    
    @GetMapping(value ="mensaje")
    public String obtenerMensaje() {
    	return "Esto es un mensaje de Prueba";
    }
}
