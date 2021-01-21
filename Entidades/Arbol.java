package Entidades;

import java.util.ArrayList;

/**
 *
 * @author juliocanizalez
 */
public class Arbol {

    public String valor;
    public ArrayList<Arbol> sub;
    //Estructura del XML
    private final String abrirR = "<arbol>";
    private final String cerrarR = "</arbol>";
    private final String abrirP = "<padre>";
    private final String cerrarP = "</padre>";
    private final String abrirH = "<hijo>";
    private final String cerrarH = "</hijo>";
    private final String abrirV = "<valor>";
    private final String cerrarV = "</valor>";
    private StringBuilder builder = new StringBuilder();
    private String xmlString;
    //Fin de estructura XML

    public Arbol(String valor) {
        this.valor = valor;
        sub = new ArrayList<>();
    }

    public void recorrer(Arbol elemento, String hoja, String vInsert) {
        if (elemento.valor.equals(hoja)) {
            Arbol aux = new Arbol(vInsert);
            elemento.sub.add(0, aux);
        } else {
            for (int i = 0; i < elemento.sub.size(); i++) {
                if (elemento.sub.get(i).valor.equals(hoja)) {
                    Arbol estesi = new Arbol(vInsert);
                    elemento.sub.get(i).sub.add(0, estesi);
                    break;
                } else {
                    if (elemento.sub.get(i).sub.size() > 0) {
                        this.recorrer(elemento.sub.get(i), hoja, vInsert);
                    }
                }
            }
        }
    }

    public void createXML(Arbol estructura) {

        for (int i = 0; i < estructura.sub.size(); i++) {
            
            if (estructura.sub.get(i).sub.isEmpty()) {
                builder.append("     ").append(abrirH).append("\n");
                builder.append("      ").append(abrirV).append(estructura.sub.get(i).valor).append(cerrarV).append("\n");
                builder.append("     ").append(cerrarH).append("\n");
            } else {
                builder.append("   ").append(abrirP).append("\n");
                builder.append("    ").append(abrirV).append(estructura.sub.get(i).valor).append(cerrarV).append("\n");
                this.createXML(estructura.sub.get(i));
                builder.append("   ").append(cerrarP).append("\n");
            }
            
        }
    }
    public void deleteFromList(Arbol l, String ele){
        for (int i = 0; i < l.sub.size(); i++) {
            if (l.sub.get(i).valor.equals(ele)) {
                l.sub.remove(i);
            }
            else{
                if (l.sub.get(i).sub.size()>0) {
                    this.deleteFromList(l.sub.get(i), ele);
                }
            }
        }
    }
    public void abrirXML(Arbol estructura) {
        builder.append(abrirR).append("\n");
        builder.append(" ").append(abrirP).append("\n");
        builder.append("  ").append(abrirV).append(estructura.valor).append(cerrarV).append("\n");
        this.createXML(estructura);
    }

    public void cerrarXML() {
        builder.append(cerrarR);
    }

    public void setXmlString(StringBuilder xmlString) {
        this.xmlString = xmlString.toString();
    }

    public String getXmlString() {
        setXmlString(builder);
        return xmlString;
    }

}
