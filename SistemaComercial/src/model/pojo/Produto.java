
package model.pojo;


public class Produto {
    private Long id;
    private String nome;
    private Double precoCompra;
    private Double precoVenda;
    private Integer quantidadeEstoque;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
    
    public void addQuantidadeEstoque(Integer qtde){
        this.quantidadeEstoque = this.quantidadeEstoque+qtde;
    }
    public void subQuantidadeEstoque(Integer qtde){
        this.quantidadeEstoque = this.quantidadeEstoque-qtde;
    }    
}
