# Ifood-Poo

- Matheus = Classes e Subclasses
- Julio = Getters e Setters
- Emidio = Main geral
- William = Metodos

- Vao adicionando as aplicacoes que forem fazendo

Ideia inicial:

# Pessoa (superclasse – herança)
- Atributos: nome, email
- Métodos: exibirDados()
- Herança:
  Usuário → faz pedidos.
  Restaurante → gerencia cardápio.
    
# Usuário (extends Pessoa)
- Atributos: endereço, listaPedidos
- Métodos:
  fazerPedido()
  listarPedidos()

# Restaurante (extends Pessoa)

- Atributos: nomeRestaurante, cardápio (lista de Produtos)
- Métodos:
  adicionarProduto()
  listarCardapio()

# Produto

- Atributos: nome, preço, descrição
- Métodos: exibirInfo()

Possível herança:
- Produto → Comida e Bebida (para diferenciar).

# Pedido

- Atributos: idPedido, listaProdutos, valorTotal, status
- Métodos:
  adicionarProduto()
  calcularTotal()
  atualizarStatus()
  
# Relações entre os objetos

- Usuário → Pedido (um usuário pode ter vários pedidos).
- Pedido → Produto (um pedido tem vários produtos).
- Restaurante → Produto (um restaurante oferece vários produtos).

Quer que eu monte agora o **código Java completo** dessa versão simplificada do iFood (com classes, herança, e um menu interativo no console)?
