import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main {
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
    static JLabel label1;
    static boolean booleanChange = true;


    public void calculate(){
        double finalePriceInt = getPriceInt() - ((getPriceInt() * getSaleInt()) / 100);
        String finalePriceString = String.valueOf(finalePriceInt);
        priceWithSale.setText(finalePriceString);
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

     public static void makeFrame(){
        frame = new JFrame("sale calculator");
        makeContentPane();

        frame.pack();
        frame.setVisible(true);
    }

    public static void refresh(){
        frame.setVisible(false);
    }

    public static void makeContentPane(){
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
            classListener listener = new classListener();
            clear.addActionListener(listener);

            calculate = new JButton("calculate");
            contentPane.add(calculate);
            classListener listener1 = new classListener();
            calculate.addActionListener(listener1);

            finalPriceLabel = new JLabel("the final price is : ");
            contentPane.add(finalPriceLabel);

            priceWithSale = new JTextField(10);
            contentPane.add(priceWithSale);


            change = new JButton("change");
            contentPane.add(change);
            classListener listener2 = new classListener();
            change.addActionListener(listener2);
        }
        else {

            contentPane.setLayout(new GridLayout(1,1,160,90));

            label1 = new JLabel("good programmer ");
            contentPane.add(label1);
        }

    }

    public static void main(String[] args) {
        makeFrame();
    }
}

class classListener extends Main implements ActionListener {
    public void actionPerformed(ActionEvent event)
    {
        String command = event.getActionCommand();
        if(command.equals("clear")){
            originalPrice.setText("");
            sale.setText("");
            priceWithSale.setText("");
        }
        if(command.equals("calculate")){
            calculate();
        }
        if(command.equals("change")){
            booleanChange = false;
            refresh();
            makeFrame();
        }

    }
}

