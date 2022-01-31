package farmacia;
import farmacia.view.Principal;
import farmacia.controller.Controller;
import farmacia.model.Model;

public class Farmacia {

    public static void main(String[] args) {
        
        Model model = new Model();
          
        new Principal(new Controller(model)).setVisible(true);
        
    }
    
}
