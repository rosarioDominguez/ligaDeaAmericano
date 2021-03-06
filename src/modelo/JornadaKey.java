/*
 * This java source file is generated by DAO4J v1.19
 * Generated on Sun Feb 25 05:11:23 CST 2018
 * For more information, please contact b-i-d@163.com
 * Please check http://sourceforge.net/projects/dao4j/ for the latest version.
 */

package modelo;

public class JornadaKey implements java.io.Serializable, Cloneable {
    /* temporada */
    protected String temporada;

    /* noJornada */
    protected int nojornada;

    /* temporada */
    public String getTemporada() {
        return temporada;
    }

    /* temporada */
    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    /* noJornada */
    public int getNojornada() {
        return nojornada;
    }

    /* noJornada */
    public void setNojornada(int nojornada) {
        this.nojornada = nojornada;
    }

    /* Calculate hash code */
    public int hashCode() {
        int hashCode = 0;
        if (temporada != null)  
            hashCode += temporada.hashCode();
        hashCode += new Integer(nojornada).hashCode();
        return hashCode;
    }
    
    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof JornadaKey))
            return false;

        JornadaKey key = (JornadaKey) obj;

        if (this.temporada == null) {
            if (key.temporada != null)
                return false;
        }
        else if (!this.temporada.equals(key.temporada)) 
            return false;

        if (this.nojornada != key.nojornada)
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        JornadaKey key = new JornadaKey();
        key.temporada = this.temporada;
        key.nojornada = this.nojornada;
        return key;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("temporada").append(" = ").append(temporada).append("]");
        sb.append("[").append("nojornada").append(" = ").append(nojornada).append("]");
        return sb.toString();
    }
}