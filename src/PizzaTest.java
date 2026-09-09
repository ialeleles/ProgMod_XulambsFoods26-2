import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PizzaTest {
    Pizza pizza;

    @BeforeEach 
    public void setUp() {
        //Arrange
        pizza = new Pizza();
        pizza.adicionarIngredientes(2);

    }

    @Test
    public void adicionaIngredientesCorretamente(){
        //Arrange
        Pizza pizza = new Pizza();

        //Act
        int quantos = 
            pizza.adicionarIngredientes(4);

        //Assert
        assertEquals(6, quantos);
    }

    @Test
    public void naoAdicionaIngredientesEmExcesso() {
        //Act
        int quantos = pizza.adicionarIngredientes(7);

        //Assert
        assertEquals(4, quantos);
    }

    @Test 
    public void calculaPrecoCorretamente() {
        //Act
        double valor = pizza.valorFinal();

        //Assert
        assertEquals(39, valor, 0.01); //Margem de erro para números double
    }

    @Test
    public void calculaPrecoDePizzaVazia() {
        //Arrange
        Pizza pizzaVazia = new Pizza();

        //Act
        double valor = pizzaVazia.valorFinal();

        //Assert
        assertEquals(29, valor, 0.01);
    }

    @Test 
    public void cupomContemInformacoesNeessarias() {
        //Act
        String cupom = pizza.gerarCupom();

        //Assert
        assertTrue(cupom.contains("2 ingredientes") &&
                    cupom.contains("29,00") &&
                    cupom.contains("10,00") &&
                    cupom.contains("39,00")
                );
        
    }
}


