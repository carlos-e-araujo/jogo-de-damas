import com.jogodedamas.controller.JogoDeDamasController;
import com.jogodedamas.model.JogoDeDamas;
import com.jogodedamas.view.JogoDeDamasView;

public class App {
    public static void main(String[] args) {
        JogoDeDamasController jogoDeDamasController = new JogoDeDamasController(new JogoDeDamas(),
            new JogoDeDamasView());
        jogoDeDamasController.iniciarJogo();
    }
}
