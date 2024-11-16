package dominio;

public class CategoriaPrestamos implements Comparable<CategoriaPrestamos> {
    public String categoria;
    public Integer prestamos;
    
    public CategoriaPrestamos(String cat) {
        categoria = cat;
        prestamos = 0;
    }
    
    public CategoriaPrestamos(String cat, Integer res) {
        categoria = cat;
        prestamos = res;
    }
    
    //Formato: categoria1#cantidad1|categoría2#cantidad2
    public String toString() {
        return categoria + "#" + "cantidad" + prestamos;
    }

    @Override
    public int compareTo(CategoriaPrestamos o) {
        if(this.categoria.compareTo(o.categoria) > 0) return 1;
        if(this.categoria.compareTo(o.categoria) == 0) return 0;
        return -1;
    }
    
    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if(o.getClass() != this.getClass()) return false;
        CategoriaPrestamos comparar = (CategoriaPrestamos) o;
        return categoria == comparar.categoria;                   
    }
}
