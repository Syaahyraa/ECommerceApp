package com.oum.e_commerceapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.oum.e_commerceapp.adapter.CategoryAdapter;
import com.oum.e_commerceapp.adapter.ProductAdapter;
import com.oum.e_commerceapp.modal.ProductDomain;

import java.util.ArrayList;

public class ProductActivity extends Activity {
    int itemCount = 0;
    GridView gridView;
    TextView txtItemCount;

    ArrayList<ProductDomain> productList = new ArrayList<ProductDomain>();
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        productList = new ArrayList<ProductDomain>();

        int position = getIntent().getIntExtra("position", 0);

        gridView = findViewById(R.id.grid_product);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.description_layout, null));
        builder.create();

        Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_LONG).show();

        ProductDomain productDomain;

        switch (position) {
            case 0:
                String[] clothList = {"JEANS", "SHIRTS", "PANTS", "T-SHIRTS", "DRESS", "PYJAMAS", "BLOUSE"};
                int[] clothImageList = {R.drawable.jeans, R.drawable.shirts, R.drawable.pants, R.drawable.tshirt, R.drawable.dress, R.drawable.pyjamas, R.drawable.blouse};

                String[] clothpriceList = {"200 MYR", "250 MYR", "100 MYR", "300 MYR", "250 MYR", "200 MYR", "300 MYR"};

                for (int i = 0; i < clothList.length; i++) {
                    productDomain = new ProductDomain(clothList[i], clothpriceList[i], clothImageList[i]);
                    productList.add(productDomain);
                }

                gridView.setAdapter(new ProductAdapter(productList, getApplicationContext()));

                break;

            case 1:
                String[] electronicsList = {"TV", "REFRIGERATOR", "OVEN", "WASHING MACHINE", "COMPUTER", "PRINTER", "MOBILE"};
                int[] electronicsImageList = {R.drawable.tv, R.drawable.refrigerator, R.drawable.oven, R.drawable.washingmachine, R.drawable.computer, R.drawable.printer, R.drawable.mobile};

                String[] electropriceList = {"2000 MYR", "2500 MYR", "1000 MYR", "3000 MYR", "800 MYR", "200 MYR", "3000 MYR"};

                for (int i = 0; i < electronicsList.length; i++) {
                    productDomain = new ProductDomain(electronicsList[i], electropriceList[i], electronicsImageList[i]);
                    productList.add(productDomain);
                }

                gridView.setAdapter(new ProductAdapter(productList, getApplicationContext()));
                break;

            case 2:
                String[] softwareList = {"USB", "RAM", "MONITOR", "PROCESSOR", "HDD", "MOTHERBOARD", "PROJECTOR"};
                int[] softwareImageList = {R.drawable.usb, R.drawable.ram, R.drawable.monitor, R.drawable.processor, R.drawable.hdd, R.drawable.motherboard, R.drawable.projector};

                String[] softpriceList = {"20 MYR", "25 MYR", "1000 MYR", "300 MYR", "250 MYR", "200 MYR", "300 MYR"};

                for (int i = 0; i < softwareList.length; i++) {
                    productDomain = new ProductDomain(softpriceList[i], softpriceList[i], softwareImageList[i]);
                    productList.add(productDomain);
                }

                gridView.setAdapter(new ProductAdapter(productList, getApplicationContext()));

                break;

            case 3:
                String[] cellphonesList = {"SAMSUNG", "IPHONE", "OPPO", "HUAWEI", "LENOVO", "NOKIA", "SONY"};
                int[] cellphoneImageList = {R.drawable.samsung_galaxy, R.drawable.lg_g, R.drawable.pixel, R.drawable.samsung_j, R.drawable.lg_g, R.drawable.pixel, R.drawable.samsung_j};

                String[] cellphonespriceList = {"2000 MYR", "2500 MYR", "1000 MYR", "3000 MYR", "2050 MYR", "2000 MYR", "3000 MYR"};

                for (int i = 0; i < cellphonesList.length; i++) {

                    productDomain = new ProductDomain(cellphonesList[i], cellphonespriceList[i], cellphoneImageList[i]);
                    productList.add(productDomain);
                }
                gridView.setAdapter(new ProductAdapter(productList, getApplicationContext()));

                break;

            case 4:
                String[] automobilesList = {"PERODUA", "TOYOTA", "HONDA", "VOLKSWAGEN", "MERCEDEZS", "NISSAN", "PROTON"};
                int[] automobilesImageList = {R.drawable.axia, R.drawable.toyota, R.drawable.honda, R.drawable.volkswagen, R.drawable.mercedes, R.drawable.nissan, R.drawable.proton};

                String[] autopriceList = {"200000 MYR", "250000 MYR", "100000 MYR", "300000 MYR", "250000 MYR", "200000 MYR", "300000 MYR"};

                for (int i = 0; i < automobilesList.length; i++) {

                    productDomain = new ProductDomain(automobilesList[i], autopriceList[i], automobilesImageList[i]);
                    productList.add(productDomain);
                }

                gridView.setAdapter(new ProductAdapter(productList, getApplicationContext()));

                break;
        }

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    //Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_LONG).show();
                    productDetails(productList.get(i).getProductName(), productList.get(i).getProductPrice(), productList.get(i).getImageId(), i);
                }
            });
        }

    public void productDetails(String productName, String productPrice, int imgId, final int position) {
        final AlertDialog alert;
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //Get the layout inflater
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        //Inflate and set the layout for the dialog
        //Pass null as the parent view because its going in the dialog layout
        View view = inflater.inflate(R.layout.description_layout, null);

        builder.setView(view);
        alert = builder.create();
        alert.show();

        TextView txtProduct = view.findViewById(R.id.txt_product_name);
        TextView txtPrice = view.findViewById(R.id.txt_price);
        ImageView imageView = view.findViewById(R.id.img_product);
        Button btnCart = view.findViewById(R.id.button);

        txtProduct.setText(productName);
        txtPrice.setText(productPrice);
        imageView.setImageResource(imgId);

        btnCart.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(final View view){

        //cartArray.add(productList.get(position));
        itemCount++;
        updateHotCount(itemCount);
        alert.dismiss();
        }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cart_menu, menu);

        final View notifications = menu.findItem(R.id.cart_item).getActionView();

        txtItemCount = (TextView) notifications.findViewById(R.id.cart_badge);
        updateHotCount(itemCount++);
        /*txtItemCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateHotCount(itemCount++);
            }
        });*/

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle item selection
        switch (item.getItemId()) {
            case R.id.cart_item:
                //newGame();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public  void updateHotCount(final int new_number){
        itemCount = new_number;
        if (itemCount < 0) return;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (itemCount == 0)
                    txtItemCount.setVisibility(View.GONE);
                else{
                    txtItemCount.setVisibility(View.VISIBLE);
                    txtItemCount.setText(Integer.toString(itemCount));
                    //supportInvalidOptionsMenu();

            }
        }
        });
    }
}








