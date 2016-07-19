package br.edu.ifms.pizzaria.model;

public class SubCategoria {

    private Integer catId;
    private Integer subId;
    private String subNome;

    public SubCategoria(String subNome) {
        this.subNome = subNome;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public String getSubNome() {
        return subNome;
    }

    public void setSubNome(String subNome) {
        this.subNome = subNome;
    }
}
