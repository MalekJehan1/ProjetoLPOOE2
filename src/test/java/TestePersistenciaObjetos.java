
import br.edu.ifsul.cc.lpoo.projetolpooe2_malek_rj.dao.PersistenciaJPA;
import br.edu.ifsul.cc.lpoo.projetolpooe2_malek_rj.model.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersistenciaObjetos {

    PersistenciaJPA jpa = new PersistenciaJPA();

    public TestePersistenciaObjetos() {
    }

    @Before
    public void setUp() {
        jpa.conexaoAberta();
    }

    @After
    public void tearDown() {
        jpa.fecharConexao();
    }

    //@Test
    public void Test2() throws Exception {
        Categoria c =  new Categoria("Salgado");
        
        Alimento a = new Alimento("Pão", 24.54, c);
        try {
            jpa.persist(c);
            jpa.persist(a);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
    
    //@Test
    public void Test3() throws Exception {
          Categoria c = new Categoria("Salgado");
          Categoria c1 = new Categoria("Doce");
          Categoria c2 = new Categoria("Bebida");
          
          Alimento a = new Alimento("Pão", 10.99, c);
          Alimento a1 = new Alimento("Brigadeiro", 2.99, c1);
          Alimento a2 = new Alimento("Coca cola 600ml", 6.99, c2);
          
         Pedido p = new Pedido(Calendar.getInstance());
         Pedido p2 = new Pedido(Calendar.getInstance());
         List<Alimento> lst = new ArrayList<>();
         lst.add(a);
         lst.add(a1);
         p2.setAlimentos(lst);
        try {
            jpa.persist(p);
            
            
            jpa.persist(c);
            jpa.persist(c1);
            jpa.persist(c2);
            
            jpa.persist(a);
            jpa.persist(a1);
            jpa.persist(a2);
            jpa.persist(p2);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
    @Test
    public void Test4() throws Exception {
        
        Pedido p = (Pedido) jpa.find(Pedido.class, 8);
        
        List<Alimento> lst = new ArrayList();
        
        p.setAlimentos(lst);
        
        jpa.persist(p);
    }
    
}
