import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {
    Pedido pedido;
    Pizza pizzaVazia;
    Pedido pedidoComPizza;

    @BeforeEach 
    public void setUp() {
        // Arrange
        pedido = new Pedido();
        pizzaVazia = new Pizza();
        pedidoComPizza = new Pedido();
        pedidoComPizza.adicionarPizza(pizzaVazia);
    }
    
    @Test
    public void naoAdicionaPizzaEmPedidoFechado(){
        //Act
        int quantidade = pedido.adicionarPizza(new Pizza());
    
        //Assert
        assertEquals(1, quantidade);
    }

    @Test
    public void adicionaPizzaEmPedidoAberto(){
        //Act
        int quantidade = pedidoComPizza.adicionarPizza(new Pizza());
    
        //Assert
        assertEquals(2, quantidade);
    }
    
    @Test
    public void verificarPrecoAPagarComPizzaVazia() {
        // Act
        double preco = pedidoComPizza.precoAPagar();

        // Assert
        assertEquals(29, preco, 0.01);
    }
    
    @Test
    public void verificarPrecoAPagarComDuasPizzasVazias() {
        pedidoComPizza.adicionarPizza(pizzaVazia);

        // Act
        double preco = pedidoComPizza.precoAPagar();

        // Assert
        assertEquals(58, preco, 0.01);
    }


    @Test
    public void verificarPrecoAPagarComPizzaCompleta() {
        // Arrange
        Pedido pedidoComPizzaCompleta = new Pedido();
        Pizza pizzaCompleta = new Pizza();
        pizzaCompleta.adicionarIngredientes(8);
        pedidoComPizzaCompleta.adicionarPizza(pizzaCompleta);

        // Act
        double valorPedidoComPizzaCompleta = pedidoComPizzaCompleta.precoAPagar();

        // Assert
        assertEquals(69, valorPedidoComPizzaCompleta, 0.01); 
    }

    @Test 
    public void verificarRelatorioComPizzaVazia() {
        // Act
        String relatorio = pedidoComPizza.relatorio();

        // Assert
        assertEquals("Pedido nº 2 - 2026-09-16 (aberto) com 1 pizzas\n" +
                        "----\n" + 
                        "Xulambs Pizza!!!\n" +
                        "Pizza com 0 ingredientes\n" +
                        "\tPreço base: R$ 29,00\n" + 
                        "\tAdicionais: R$ 0,00\n" +
                        "VALOR A PAGAR: R$ 29,00\n" +
                        "VALOR: R$ 29,00", relatorio);
    }

    @Test 
    public void verificarRelatorioComPizzaCompleta() {
        // Arrange
        Pedido pedidoComPizzaCompleta = new Pedido();
        Pizza pizzaCompleta = new Pizza();
        pizzaCompleta.adicionarIngredientes(8);
        pedidoComPizzaCompleta.adicionarPizza(pizzaCompleta);

        // Act
        String relatorio = pedidoComPizzaCompleta.relatorio();

        // Assert
        assertEquals("Pedido nº 3 - 2026-09-16 (aberto) com 1 pizzas\n" +
                        "----\n" + 
                        "Xulambs Pizza!!!\n" +
                        "Pizza com 8 ingredientes\n" +
                        "\tPreço base: R$ 29,00\n" + 
                        "\tAdicionais: R$ 40,00\n" +
                        "VALOR A PAGAR: R$ 69,00\n" +
                        "VALOR: R$ 69,00", relatorio);
    }
}
