package com.example.collapsingcardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Group;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    CardView cardView;
    ImageView arrow;
    Group hiddenGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardView = findViewById(R.id.base_cardview);
        arrow = findViewById(R.id.show);
        hiddenGroup = findViewById(R.id.card_group);

        arrow.setOnClickListener(view -> {
            TransitionManager.beginDelayedTransition(cardView, new AutoTransition());

            if (hiddenGroup.getVisibility() == View.VISIBLE) {
                hiddenGroup.setVisibility(View.GONE);
                arrow.setImageResource(android.R.drawable.arrow_down_float);
            } else {
                hiddenGroup.setVisibility(View.VISIBLE);
                arrow.setImageResource(android.R.drawable.arrow_up_float);
            }
        });

    }
}