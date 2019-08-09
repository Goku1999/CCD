package com.example.ccd;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity
{
    int quantity = 2;
    int cp=300;
    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view)
    {
        quantity = quantity + 1;
        display(quantity);
    }
    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view)
    {
        if(quantity>0)
        {
            quantity = quantity - 1;
            display(quantity);
        }
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view)
    {
        EditText tt=(EditText) findViewById(R.id.name_field);
        String value= tt.getText().toString();
        CheckBox whippedcream=(CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean haswhipped=whippedcream.isChecked();
        CheckBox chocolatecream=(CheckBox) findViewById(R.id.chocolate_cream_checkbox);
        boolean haschocolate=chocolatecream.isChecked();
        int price=calculatePrice(haswhipped,haschocolate);
        String priceMessage=createorder(value,price,haswhipped,haschocolate);
        displayMessage(priceMessage);
    }
    private int calculatePrice(boolean addwhippedcream,boolean addchoco)
    {
        int base=300;
        if(addwhippedcream)
        {
            base+=100;
        }
        if(addchoco)
        {
            base+=200;
        }
        return cp=quantity*base;
    }
    private String createorder(String names,int price,boolean addwhipped,boolean addchocolate)
    {
        String priceMessage="Name: "+names;
        priceMessage+="\nAdd whipped cream"+addwhipped;
        priceMessage+="\n Quantity "+quantity;
        priceMessage+="\nTotal: Rs."+price;
        priceMessage+="\nThank You!";
        return priceMessage;
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number)
    {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private void displayMessage(String message)
    {
        TextView orderSummaryTextView=(TextView)findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}
