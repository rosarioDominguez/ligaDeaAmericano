/*
 * This java source file is generated by DAO4J v1.19
 * Generated on Sun Feb 25 05:11:22 CST 2018
 * For more information, please contact b-i-d@163.com
 * Please check http://sourceforge.net/projects/dao4j/ for the latest version.
 */

package modelo;

public class ArticuloKey implements java.io.Serializable, Cloneable {
    /* proveedor */
    protected String proveedor;

    /* nombre */
    protected String nombre;

    /* proveedor */
    public String getProveedor() {
        return proveedor;
    }

    /* proveedor */
    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    /* nombre */
    public String getNombre() {
        return nombre;
    }

    /* nombre */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /* Calculate hash code */
    public int hashCode() {
        int hashCode = 0;
        if (proveedor != null)  
            hashCode += proveedor.hashCode();
        if (nombre != null)  
            hashCode += nombre.hashCode();
        return hashCode;
    }
    
    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof ArticuloKey))
            return false;

        ArticuloKey key = (ArticuloKey) obj;

        if (this.proveedor == null) {
            if (key.proveedor != null)
                return false;
        }
        else if (!this.proveedor.equals(key.proveedor)) 
            return false;

        if (this.nombre == null) {
            if (key.nombre != null)
                return false;
        }
        else if (!this.nombre.equals(key.nombre)) 
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        ArticuloKey key = new ArticuloKey();
        key.proveedor = this.proveedor;
        key.nombre = this.nombre;
        return key;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("proveedor").append(" = ").append(proveedor).append("]");
        sb.append("[").append("nombre").append(" = ").append(nombre).append("]");
        return sb.toString();
    }
}