import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main implements ActionListener{
    private static JFrame frame;

    static JLabel insertPriceLabel;
    static JLabel insertSaleLabel;
    static JLabel finalPriceLabel;
    static JTextField originalPrice;
    static JTextField sale;
    static JTextField priceWithSale;
    static JButton clear;
    static JButton calculate;
    static JButton change;
    static JLabel ageLabel;
    JLabel yearLabel;
    JTextField ageText;
    JTextField yearText;
    JButton defineButton;
    boolean booleanChange = true;


    public void calculate(){
        double finalePriceInt = getPriceInt() - ((getPriceInt() * getSaleInt()) / 100);
        String finalePriceString = String.valueOf(finalePriceInt);
        priceWithSale.setText(finalePriceString);
    }

    public void define(){
        if(yearText.getText().equals("")){
            yearText.setText(""+(2023 - getAge()));          
        }
        else{
            ageText.setText(""+(2023 - getYear()));
        }
    }

    public Double getPriceInt(){
        String inputText = originalPrice.getText();
        double priceInt = Double.parseDouble(inputText);
        return priceInt;
    }

    public double getSaleInt(){
        String inputSale = sale.getText();
        double saleInt = Double.parseDouble(inputSale);
        return saleInt;
    }

    public int getAge(){
        return Integer.parseInt(ageText.getText());
    }

    public int getYear(){
        return Integer.parseInt(yearText.getText());
    }

    public  void makeFrame(){
        frame = new JFrame("sale calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        makeContentPane();

        frame.pack();
        frame.setVisible(true);
    }

    public static void refresh(){
        frame.setVisible(false);
    }

    public  void makeContentPane(){
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(5,1,15,15));

        if (booleanChange) {
            insertPriceLabel = new JLabel("full price ");
            contentPane.add(insertPriceLabel);

            originalPrice = new JTextField(10);
            contentPane.add(originalPrice);

            insertSaleLabel = new JLabel("insert sale ");
            contentPane.add(insertSaleLabel);

            sale = new JTextField(10);
            contentPane.add(sale);

            clear = new JButton("clear");
            contentPane.add(clear);
            
            clear.addActionListener(this);

            calculate = new JButton("calculate");
            contentPane.add(calculate);
            
            calculate.addActionListener(this);

            finalPriceLabel = new JLabel("the final price is : ");
            contentPane.add(finalPriceLabel);

            priceWithSale = new JTextField(10);
            contentPane.add(priceWithSale);


            change = new JButton("change");
            contentPane.add(change);
            change.addActionListener(this);
        }
        else {

            contentPane.setLayout(new GridLayout(0,2,15,15));

            ageLabel = new JLabel("age: ");
            yearLabel = new JLabel("year");
            yearText = new JTextField(20);
            ageText = new JTextField(20);
            defineButton = new JButton("define age");
            defineButton.addActionListener(this);


            contentPane.add(ageLabel);
            contentPane.add(ageText);
            contentPane.add(yearLabel);
            contentPane.add(yearText);
            contentPane.add(defineButton);
        }

    }
    public Main(){
        makeFrame();
    }

    public static void main(String[] args) {
       new Main();
    }
    public void actionPerformed(ActionEvent event)
    {
        String command = event.getActionCommand();
        if(command.equals("clear")){
            originalPrice.setText("");
            sale.setText("");
            priceWithSale.setText("");
        }
        else if(command.equals("calculate")){
            calculate();
        }
        else if(command.equals("change")){
            booleanChange = false;
            refresh();
            makeFrame();
        }
        else if (command.equals("define age")){
            define();
        }

    }
}



