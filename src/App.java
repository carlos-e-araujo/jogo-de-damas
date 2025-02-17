import com.jogodedamas.controller.TabuleiroController;
import com.jogodedamas.model.Tabuleiro;
import com.jogodedamas.view.TabuleiroView;

public class App {
    public static void main(String[] args) {
        TabuleiroController tabuleiroController = new TabuleiroController(new Tabuleiro(), new TabuleiroView());
        tabuleiroController.iniciarJogo();
    }
}
