package com.example.lutfillahmafazi.planetzz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.lutfillahmafazi.planetzz.R.layout.activity_choose;

public class chooseActivity extends AppCompatActivity {

    @BindView(R.id.btnPlanetBagianDalam)
    Button btnPlanetBagianDalam;
    @BindView(R.id.btnPlanetBagianLuar)
    Button btnPlanetBagianLuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_choose);
        ButterKnife.bind(this);

    }
    @OnClick({R.id.btnPlanetBagianDalam, R.id.btnPlanetBagianLuar})
    public void onViewClicked(View view) {

        Intent pindah;
        switch (view.getId()) {
            case R.id.btnPlanetBagianDalam:
            pindah = new Intent(this,RecycleActivity.class);
            pindah.putExtra("tanda", "dalam");
            startActivity(pindah);
            break;
            case R.id.btnPlanetBagianLuar:
            pindah = new Intent(this,RecycleActivity.class);
            pindah.putExtra("tanda","luar");
            startActivity(pindah);
            break;
        }
    }
}
