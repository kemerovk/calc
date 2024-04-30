import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Action implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Main.current += e.getActionCommand();
        Frame.textArea.append(e.getActionCommand());

        if (e.getActionCommand().equals("=")){
            Main.current = Result.getResult(Main.current);
            Frame.textArea.setText(Main.current);
        }

        else if (e.getActionCommand().equals("c")) {
            Main.current = "";
            Frame.textArea.setText("");
        }

        else if (e.getActionCommand().equals("e")){
            Main.current = Main.current.replace("e", String.format("%.6f", Math.E).replace(',', '.'));
            Frame.textArea.setText(Main.current);
        }

    }
}
