import java.util.ArrayList;
import java.util.List;

abstract class Pessoa {
    protected String nome;
    protected String email;

    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public void exibirDados() {
        System.out.println("Nome: " + nome + "\nEmail: " + email);
    }
}

class Usuario extends Pessoa {
    private String endereco;
    private List<Pedido> listaPedidos;

    public Usuario(String nome, String email, String endereco) {
        super(nome, email);
        this.endereco = endereco;
        this.listaPedidos = new ArrayList<>();
    }

    public void fazerPedido(Pedido pedido) {
        listaPedidos.add(pedido);
        System.out.println("Pedido feito com sucesso!");
    }

    public void listarPedidos() {
        for (Pedido p : listaPedidos) {
            System.out.println("Pedido #" + p.getIdPedido() + " - Status: " + p.getStatus());
        }
    }
}

class Restaurante extends Pessoa {
    private String nomeRestaurante;
    private List<Produto> cardapio;

    public Restaurante(String nome, String email, String nomeRestaurante) {
        super(nome, email);
        this.nomeRestaurante = nomeRestaurante;
        this.cardapio = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        cardapio.add(produto);
        System.out.println("Produto adicionado ao cardápio.");
    }

    public void listarCardapio() {
        System.out.println("Cardápio do " + nomeRestaurante + ":");
        for (Produto p : cardapio) {
            p.exibirInfo();
        }
    }
}

abstract class Produto {
    protected String nome;
    protected double preco;
    protected String descricao;

    public Produto(String nome, double preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public void exibirInfo() {
        System.out.println(nome + " - " + descricao + " | R$" + preco);
    }

    public double getPreco() {
        return preco;
    }
}

class Comida extends Produto {
    public Comida(String nome, double preco, String descricao) {
        super(nome, preco, descricao);
    }
}

class Bebida extends Produto {
    public Bebida(String nome, double preco, String descricao) {
        super(nome, preco, descricao);
    }
}

class Pedido {
    private static int contador = 1;
    private int idPedido;
    private List<Produto> listaProdutos;
    private double valorTotal;
    private String status;

    public Pedido() {
        this.idPedido = contador++;
        this.listaProdutos = new ArrayList<>();
        this.status = "Em aberto";
        this.valorTotal = 0.0;
    }

    public void adicionarProduto(Produto produto) {
        listaProdutos.add(produto);
        calcularTotal();
        System.out.println("Produto adicionado ao pedido.");
    }

    public void calcularTotal() {
        valorTotal = 0.0;
        for (Produto p : listaProdutos) {
            valorTotal += p.getPreco();
        }
    }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
        System.out.println("Status atualizado para: " + status);
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getStatus() {
        return status;
    }

    public double getValorTotal() {
        return valorTotal;
    }
}

public class Main {
    public static void main(String[] args) {
        Restaurante r1 = new Restaurante("Restaurante A", "contato@restaurantea.com", "Restaurante A");
        Produto comida1 = new Comida("Hamburguer", 24.0, "Pão, carne, queijo, salada");
        Produto bebida1 = new Bebida("Refrigerante", 6.0, "Lata 350ml");

        r1.adicionarProduto(comida1);
        r1.adicionarProduto(bebida1);
        r1.listarCardapio();

        Usuario u1 = new Usuario("Maria", "maria@email.com", "Rua A, 123");

        Pedido p1 = new Pedido();
        p1.adicionarProduto(comida1);
        p1.adicionarProduto(bebida1);

        u1.fazerPedido(p1);
        u1.listarPedidos();

        p1.atualizarStatus("Entregue");
        u1.listarPedidos();
        System.out.println("Total do pedido #" + p1.getIdPedido() + ": R$" + p1.getValorTotal());
    }
}
