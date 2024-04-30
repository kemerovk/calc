import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Key extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_ENTER -> {
                Main.current += "=";
                Main.current = Result.getResult(Main.current);
                Frame.textArea.setText(Main.current);
            }

            case KeyEvent.VK_BACK_SPACE -> {
                Main.current = Main.current.substring(0, Main.current.length() - 1);
                Frame.textArea.setText(Main.current);
            }

            case KeyEvent.VK_E -> {
                Main.current += String.format("%.6f", Math.E);
                Frame.textArea.append(Main.current);
            }



            default -> {
                if (e.getKeyCode() >= 48 && e.getKeyCode() <= 57){
                    Main.current += e.getKeyChar();
                    Frame.textArea.setText(Main.current);
                }

                else if (e.getKeyCode() == KeyEvent.VK_ADD){
                    Main.current += "+";
                    Frame.textArea.append("+");
                }
                else if (e.getKeyCode() == KeyEvent.VK_MULTIPLY){
                    Main.current += "*";
                    Frame.textArea.append("*");
                }

                else if (e.getKeyCode() == KeyEvent.VK_DIVIDE){
                    Main.current += "/";
                    Frame.textArea.append("/");
                }

                else if (e.getKeyCode() == KeyEvent.VK_SUBTRACT){
                    Main.current += "-";
                    Frame.textArea.append("-");
                }
            }

        }
    }
}
