package ch.rpg.felix.rpg.ShopSystem;

import android.view.View;
import android.widget.TextView;

import ch.rpg.felix.rpg.R;

public class MoneyCalculation {

    ShopBuyFragment sf = new ShopBuyFragment();

    protected void moneyConversion(View v) {
        TextView bronze = (TextView) v.findViewById(R.id.bronzecoin);
        TextView silver = (TextView) v.findViewById(R.id.silvercoin);
        TextView gold = (TextView) v.findViewById(R.id.goldcoin);

        sf.bronzecoin = Integer.parseInt(bronze.getText().toString());
        sf.silvercoin = Integer.parseInt(silver.getText().toString());
        sf.goldcoin = Integer.parseInt(gold.getText().toString());

        if (sf.bronzecoin >= 100) {
            int silverconversion = sf.bronzecoin / 100;
            int rest = sf.bronzecoin - silverconversion * 100;
            bronze.setText(String.valueOf(sf.bronzecoin - silverconversion * 100 + rest));
            silver.setText(String.valueOf(sf.silvercoin + silverconversion));
        }

        if (sf.silvercoin >= 100) {
            int goldconversion = sf.bronzecoin / 100;
            int rest = sf.silvercoin - goldconversion * 100;
            silver.setText(String.valueOf(sf.bronzecoin - goldconversion * 100 + rest));
            gold.setText(String.valueOf(sf.silvercoin + goldconversion));
        }
    }

    protected void payMoney(View v) {
        TextView bronze = (TextView) v.findViewById(R.id.bronzecoin);
        TextView silver = (TextView) v.findViewById(R.id.silvercoin);
        TextView gold = (TextView) v.findViewById(R.id.goldcoin);

        sf.bronzecoin = Integer.parseInt(bronze.getText().toString());
        sf.silvercoin = Integer.parseInt(silver.getText().toString());
        sf.goldcoin = Integer.parseInt(gold.getText().toString());

        if (sf.bronzecoin >= 100) {
            int silverconversion = sf.bronzecoin / 100;
            int rest = sf.bronzecoin - silverconversion * 100;
            bronze.setText(String.valueOf(sf.bronzecoin - silverconversion * 100 + rest));
            silver.setText(String.valueOf(sf.silvercoin + silverconversion));
        }

        if (sf.silvercoin >= 100) {
            int goldconversion = sf.bronzecoin / 100;
            int rest = sf.silvercoin - goldconversion * 100;
            silver.setText(String.valueOf(sf.bronzecoin - goldconversion * 100 + rest));
            gold.setText(String.valueOf(sf.silvercoin + goldconversion));
        }
    }
}
