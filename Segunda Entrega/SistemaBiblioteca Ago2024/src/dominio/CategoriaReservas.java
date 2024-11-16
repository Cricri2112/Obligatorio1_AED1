package dominio;

public class CategoriaReservas implements Comparable<CategoriaReservas> {
    public String categoria;
    public Integer reservas;
    
    public CategoriaReservas(String cat) {
        categoria = cat;
        reservas = 0;
    }
    
    public CategoriaReservas(String cat, Integer res) {
        categoria = cat;
        reservas = res;
    }
    
    //Formato: categoria1#cantidad1|categoría2#cantidad2
    public String toString() {
        return categoria + "#" + "cantidad" + reservas;
    }

    @Override
    public int compareTo(CategoriaReservas o) {
        if(this.categoria.compareTo(o.categoria) > 0) return 1;
        if(this.categoria.compareTo(o.categoria) == 0) return 0;
        return -1;
    }
    
    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if(o.getClass() != this.getClass()) return false;
        CategoriaReservas comparar = (CategoriaReservas) o;
        return categoria == comparar.categoria;                   
    }
}
