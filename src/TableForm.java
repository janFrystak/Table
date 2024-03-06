import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TableForm extends JFrame {

    private JPanel panel;
    private JTextArea textArea;
    private JTextField textField;
    private JButton button;
    private final JFileChooser fc = new JFileChooser(".");
    private final JMenuBar mainMenu = new JMenuBar();
        private final JMenu optionMenu = new JMenu("Actions");
            private final JMenuItem copyBtn = new JMenuItem("Copy");
            private final JMenuItem loadFileBtn = new JMenuItem("Load File");

    public TableForm(){
        InitWindow();
        initActionListeners();
        initMenu();
    }

    public void remakeText(){
        textArea.setText(String.valueOf(getText()));
        textField.setText("");
    }
    public StringBuilder getText(){
        StringBuilder text = new StringBuilder();
        text.append(textField.getText()).append("\n").append(textArea.getText());
        return text;
    }
    public void InitWindow(){
        setJMenuBar(mainMenu);
        setTitle("PetrTest");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void initActionListeners(){
        button.addActionListener(e-> remakeText());
    }

    public static void main(String[] args) {
        TableForm frame = new TableForm();
        frame.setContentPane(frame.panel);
        frame.setVisible(true);
    }
    public void initMenu(){
        mainMenu.add(optionMenu);
        optionMenu.add(copyBtn);
        optionMenu.add(loadFileBtn);

        copyBtn.addActionListener(e -> remakeText());
        loadFileBtn.addActionListener(e -> chooseFile());
    }
    public void chooseFile(){
        int result = fc.showOpenDialog(this);
        StringBuilder text = new StringBuilder();
        if (result == JFileChooser.APPROVE_OPTION) {
            try(Scanner sc = new Scanner(new BufferedReader(new FileReader(fc.getSelectedFile())))){
                while (sc.hasNextLine()) text.append(sc.nextLine()).append("\n");
                textArea.setText(String.valueOf(text));
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, "Couldn't find file");
            }
        }
    }
}
