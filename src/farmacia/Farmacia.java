package farmacia;
import farmacia.view.Principal;
import farmacia.*;
import farmacia.controller.Controller;
import farmacia.model.Model;

public class Farmacia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Model model = new Model();
          
        new Principal(new Controller(model)).setVisible(true);
        
    }
    
}
