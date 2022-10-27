package com.example.memorygameradeff;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private Chronometer chro;

    TextView tv_p1, tv_p2;

    ImageView iv_1, iv_2, iv_3, iv_4, iv_5, iv_6, iv_7, iv_8, iv_9, iv_10, iv_11, iv_12, iv_13, iv_14, iv_15, iv_16, iv_17, iv_18, iv_19, iv_20,
     iv_21, iv_22, iv_23, iv_24, iv_25, iv_26, iv_27, iv_28, iv_29, iv_30, iv_31, iv_32, iv_33, iv_34, iv_35, iv_36, iv_37, iv_38, iv_39, iv_40;

    //Array das imagens (100 = primeira_carta e 200 = Segunda_carta)
    Integer[] cardsArray = {101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,
                            201,202,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220};

    //Imagens atuais
    int image101, image102, image103, image104, image105, image106, image107, image108, image109, image110, image111, image112, image113,image114,
        image115, image116, image117, image118, image119, image120, image201, image202, image203, image204, image205, image206, image207, image208,
        image209, image210, image211, image212, image213,image214, image215, image216, image217, image218, image219, image220;

    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;



    int turn = 1;
    int player1Points = 0, player2Points = 0;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //remoção da ActionBar e da TittleBar - (A barra "roxa" do topo):
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide(); //Essa linha oculta a ActionBar
        setContentView(R.layout.activity_main);


        tv_p1 = findViewById(R.id.tv_player1);
        tv_p2 = findViewById(R.id.tv_player2);

        iv_1 = findViewById(R.id.iv_1);
        iv_2 = findViewById(R.id.iv_2);
        iv_3 = findViewById(R.id.iv_3);
        iv_4 = findViewById(R.id.iv_4);
        iv_5 = findViewById(R.id.iv_5);
        iv_6 = findViewById(R.id.iv_6);
        iv_7 = findViewById(R.id.iv_7);
        iv_8 = findViewById(R.id.iv_8);
        iv_9 = findViewById(R.id.iv_9);
        iv_10 = findViewById(R.id.iv_10);
        iv_11 = findViewById(R.id.iv_11);
        iv_12 = findViewById(R.id.iv_12);
        iv_13 = findViewById(R.id.iv_13);
        iv_14 = findViewById(R.id.iv_14);
        iv_15 = findViewById(R.id.iv_15);
        iv_16 = findViewById(R.id.iv_16);
        iv_17 = findViewById(R.id.iv_17);
        iv_18 = findViewById(R.id.iv_18);
        iv_19 = findViewById(R.id.iv_19);
        iv_20 = findViewById(R.id.iv_20);
        iv_21 = findViewById(R.id.iv_21);
        iv_22 = findViewById(R.id.iv_22);
        iv_23 = findViewById(R.id.iv_23);
        iv_24 = findViewById(R.id.iv_24);
        iv_25 = findViewById(R.id.iv_25);
        iv_26 = findViewById(R.id.iv_26);
        iv_27 = findViewById(R.id.iv_27);
        iv_28 = findViewById(R.id.iv_28);
        iv_29 = findViewById(R.id.iv_29);
        iv_30 = findViewById(R.id.iv_30);
        iv_31 = findViewById(R.id.iv_31);
        iv_32 = findViewById(R.id.iv_32);
        iv_33 = findViewById(R.id.iv_33);
        iv_34 = findViewById(R.id.iv_34);
        iv_35 = findViewById(R.id.iv_35);
        iv_36 = findViewById(R.id.iv_36);
        iv_37 = findViewById(R.id.iv_37);
        iv_38 = findViewById(R.id.iv_38);
        iv_39 = findViewById(R.id.iv_39);
        iv_40 = findViewById(R.id.iv_40);

        iv_1.setTag("0");
        iv_2.setTag("1");
        iv_3.setTag("2");
        iv_4.setTag("3");
        iv_5.setTag("4");
        iv_6.setTag("5");
        iv_7.setTag("6");
        iv_8.setTag("7");
        iv_9.setTag("8");
        iv_10.setTag("9");
        iv_11.setTag("10");
        iv_12.setTag("11");
        iv_13.setTag("12");
        iv_14.setTag("13");
        iv_15.setTag("14");
        iv_16.setTag("15");
        iv_17.setTag("16");
        iv_18.setTag("17");
        iv_19.setTag("18");
        iv_20.setTag("19");
        iv_21.setTag("20");
        iv_22.setTag("21");
        iv_23.setTag("22");
        iv_24.setTag("23");
        iv_25.setTag("24");
        iv_26.setTag("25");
        iv_27.setTag("26");
        iv_28.setTag("27");
        iv_29.setTag("28");
        iv_30.setTag("29");
        iv_31.setTag("30");
        iv_32.setTag("31");
        iv_33.setTag("32");
        iv_34.setTag("33");
        iv_35.setTag("34");
        iv_36.setTag("35");
        iv_37.setTag("36");
        iv_38.setTag("37");
        iv_39.setTag("38");
        iv_40.setTag("39");

        //Carregar as imagens das cartas
        frontOfCardsResources();

        //Shuffle de imagens/embaralhamento
        Collections.shuffle(Arrays.asList(cardsArray));

        //Cronometro
        Chronometer chronometer = (Chronometer) findViewById(R.id.tv_chronometro);
        this.chro = chronometer;
        chronometer.start();

        //troca a cor do jogador(quando inativo)
        tv_p2.setTextColor(Color.GRAY);

        iv_1.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_1, theCard);
        });

        iv_2.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_2, theCard);
        });

        iv_3.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_3, theCard);
        });
        iv_4.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_4, theCard);
        });
        iv_5.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_5, theCard);
        });
        iv_6.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_6, theCard);
        });

        iv_7.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_7, theCard);
        });

        iv_8.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_8, theCard);
        });

        iv_9.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_9, theCard);
        });

        iv_10.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_10, theCard);
        });

        iv_11.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_11, theCard);
        });

        iv_12.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_12, theCard);
        });

        iv_13.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_13, theCard);
        });
        iv_14.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_14, theCard);
        });
        iv_15.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_15, theCard);
        });
        iv_16.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_16, theCard);
        });

        iv_17.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_17, theCard);
        });

        iv_18.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_18, theCard);
        });

        iv_19.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_19, theCard);
        });

        iv_20.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_20, theCard);
        });

        iv_21.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_21, theCard);
        });

        iv_22.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_22, theCard);
        });

        iv_23.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_23, theCard);
        });
        iv_24.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_24, theCard);
        });
        iv_25.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_25, theCard);
        });
        iv_26.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_26, theCard);
        });

        iv_27.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_27, theCard);
        });

        iv_28.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_28, theCard);
        });

        iv_29.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_29, theCard);
        });

        iv_30.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_30, theCard);
        });

        iv_31.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_31, theCard);
        });

        iv_32.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_32, theCard);
        });

        iv_33.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_33, theCard);
        });
        iv_34.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_34, theCard);
        });
        iv_35.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_35, theCard);
        });
        iv_36.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_36, theCard);
        });

        iv_37.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_37, theCard);
        });

        iv_38.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_38, theCard);
        });

        iv_39.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_39, theCard);
        });

        iv_40.setOnClickListener(view -> {
            int theCard = Integer.parseInt((String) view.getTag());
            doStuff(iv_40, theCard);
        });
    }


    //identificar e setar as imagens corretas para o imageView

    private void doStuff(ImageView iv, int card){
        if(cardsArray[card] == 101){
            iv.setImageResource(image101);
        }else if (cardsArray[card] == 102){
            iv.setImageResource(image102);
        }else if (cardsArray[card] == 103){
            iv.setImageResource(image103);
        }else if (cardsArray[card] == 104){
            iv.setImageResource(image104);
        }else if (cardsArray[card] == 105){
            iv.setImageResource(image105);
        }else if (cardsArray[card] == 106){
            iv.setImageResource(image106);
        }else if (cardsArray[card] == 107){
            iv.setImageResource(image107);
        }else if (cardsArray[card] == 108){
            iv.setImageResource(image108);
        }else if (cardsArray[card] == 109){
            iv.setImageResource(image109);
        }else if (cardsArray[card] == 110){
            iv.setImageResource(image110);
        }else if (cardsArray[card] == 111){
            iv.setImageResource(image111);
        }else if (cardsArray[card] == 112){
            iv.setImageResource(image112);
        }else if (cardsArray[card] == 113){
            iv.setImageResource(image113);
        }else if (cardsArray[card] == 114){
            iv.setImageResource(image114);
        }else if (cardsArray[card] == 115){
            iv.setImageResource(image115);
        }else if (cardsArray[card] == 116){
            iv.setImageResource(image116);
        }else if (cardsArray[card] == 117){
            iv.setImageResource(image117);
        }else if (cardsArray[card] == 118){
            iv.setImageResource(image118);
        }else if (cardsArray[card] == 119){
            iv.setImageResource(image119);
        }else if (cardsArray[card] == 120){
            iv.setImageResource(image120);
        //familia do 200
        }else if(cardsArray[card] == 201){
            iv.setImageResource(image201);
        }else if (cardsArray[card] == 202){
            iv.setImageResource(image202);
        }else if (cardsArray[card] == 203){
            iv.setImageResource(image203);
        }else if (cardsArray[card] == 204){
            iv.setImageResource(image204);
        }else if (cardsArray[card] == 205){
            iv.setImageResource(image205);
        }else if (cardsArray[card] == 206){
            iv.setImageResource(image206);
        }else if (cardsArray[card] == 207){
            iv.setImageResource(image207);
        }else if (cardsArray[card] == 208){
            iv.setImageResource(image208);
        }else if (cardsArray[card] == 209){
            iv.setImageResource(image209);
        }else if (cardsArray[card] == 210){
            iv.setImageResource(image210);
        }else if (cardsArray[card] == 211){
            iv.setImageResource(image211);
        }else if (cardsArray[card] == 212){
            iv.setImageResource(image212);
        }else if (cardsArray[card] == 213){
            iv.setImageResource(image213);
        }else if (cardsArray[card] == 214){
            iv.setImageResource(image214);
        }else if (cardsArray[card] == 215){
            iv.setImageResource(image215);
        }else if (cardsArray[card] == 216){
            iv.setImageResource(image216);
        }else if (cardsArray[card] == 217){
            iv.setImageResource(image217);
        }else if (cardsArray[card] == 218){
            iv.setImageResource(image218);
        }else if (cardsArray[card] == 219){
            iv.setImageResource(image219);
        }else if (cardsArray[card] == 220) {
            iv.setImageResource(image220);
        }

        //Checa a imagem selecionada e salva ela como uma variavel temporaria
        if (cardNumber == 1) {
            firstCard = cardsArray[card];
            if (firstCard > 200) {
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            clickedFirst = card;

            iv.setEnabled(false);
        }else if (cardNumber == 2){
            secondCard = cardsArray[card];
            if (secondCard > 200) {
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            clickedSecond = card;

            iv_1.setEnabled(false);
            iv_2.setEnabled(false);
            iv_3.setEnabled(false);
            iv_4.setEnabled(false);
            iv_5.setEnabled(false);
            iv_6.setEnabled(false);
            iv_7.setEnabled(false);
            iv_8.setEnabled(false);
            iv_9.setEnabled(false);
            iv_10.setEnabled(false);
            iv_11.setEnabled(false);
            iv_12.setEnabled(false);
            iv_13.setEnabled(false);
            iv_14.setEnabled(false);
            iv_15.setEnabled(false);
            iv_16.setEnabled(false);
            iv_17.setEnabled(false);
            iv_18.setEnabled(false);
            iv_19.setEnabled(false);
            iv_20.setEnabled(false);
            iv_21.setEnabled(false);
            iv_22.setEnabled(false);
            iv_23.setEnabled(false);
            iv_24.setEnabled(false);
            iv_25.setEnabled(false);
            iv_26.setEnabled(false);
            iv_27.setEnabled(false);
            iv_28.setEnabled(false);
            iv_29.setEnabled(false);
            iv_30.setEnabled(false);
            iv_31.setEnabled(false);
            iv_32.setEnabled(false);
            iv_33.setEnabled(false);
            iv_34.setEnabled(false);
            iv_35.setEnabled(false);
            iv_36.setEnabled(false);
            iv_37.setEnabled(false);
            iv_38.setEnabled(false);
            iv_39.setEnabled(false);
            iv_40.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(() -> {
                //Checar se as imagens selecionadas são iguais
                calculate();
            }, 800);

        }

    }

    @SuppressLint("SetTextI18n")
    private void calculate() {
        //se as cartas forem iguais, remove-las e add pontos
        if (firstCard == secondCard) {
            if (clickedFirst == 0) {
                iv_1.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 1) {
                iv_2.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 2) {
                iv_3.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 3) {
                iv_4.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 4) {
                iv_5.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 5) {
                iv_6.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 6) {
                iv_7.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 7) {
                iv_8.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 8) {
                iv_9.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 9) {
                iv_10.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 10) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 11) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 12) {
                iv_13.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 13) {
                iv_14.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 14) {
                iv_15.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 15) {
                iv_16.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 16) {
                iv_17.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 17) {
                iv_18.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 18) {
                iv_19.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 19) {
                iv_20.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 20) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 21) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 22) {
                iv_23.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 23) {
                iv_24.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 24) {
                iv_25.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 25) {
                iv_26.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 26) {
                iv_27.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 27) {
                iv_28.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 28) {
                iv_29.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 29) {
                iv_30.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 30) {
                iv_31.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 31) {
                iv_32.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 32) {
                iv_33.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 33) {
                iv_34.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 34) {
                iv_35.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 35) {
                iv_36.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 36) {
                iv_37.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 37) {
                iv_38.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 38) {
                iv_39.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 39) {
                iv_40.setVisibility(View.INVISIBLE);
            }

            if (clickedSecond == 0) {
                iv_1.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 1) {
                iv_2.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 2) {
                iv_3.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 3) {
                iv_4.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 4) {
                iv_5.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 5) {
                iv_6.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 6) {
                iv_7.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 7) {
                iv_8.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 8) {
                iv_9.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 9) {
                iv_10.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 10) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 11) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 12) {
                iv_13.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 13) {
                iv_14.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 14) {
                iv_15.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 15) {
                iv_16.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 16) {
                iv_17.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 17) {
                iv_18.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 18) {
                iv_19.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 19) {
                iv_20.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 20) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 21) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 22) {
                iv_23.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 23) {
                iv_24.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 24) {
                iv_25.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 25) {
                iv_26.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 26) {
                iv_27.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 27) {
                iv_28.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 28) {
                iv_29.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 29) {
                iv_30.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 30) {
                iv_31.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 31) {
                iv_32.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 32) {
                iv_33.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 33) {
                iv_34.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 34) {
                iv_35.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 35) {
                iv_36.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 36) {
                iv_37.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 37) {
                iv_38.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 38) {
                iv_39.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 39) {
                iv_40.setVisibility(View.INVISIBLE);
            }

            //Adcionar pontos aos jogadores corretos
            if (turn == 1) {
                player1Points++;
                tv_p1.setText("Player 1: " + player1Points);
            } else if (turn == 2) {
                player2Points++;
                tv_p2.setText("Player 2: " + player2Points);
            }

        }else {
            iv_1.setImageResource(R.drawable.back_image);
            iv_2.setImageResource(R.drawable.back_image);
            iv_3.setImageResource(R.drawable.back_image);
            iv_4.setImageResource(R.drawable.back_image);
            iv_5.setImageResource(R.drawable.back_image);
            iv_6.setImageResource(R.drawable.back_image);
            iv_7.setImageResource(R.drawable.back_image);
            iv_8.setImageResource(R.drawable.back_image);
            iv_9.setImageResource(R.drawable.back_image);
            iv_10.setImageResource(R.drawable.back_image);
            iv_11.setImageResource(R.drawable.back_image);
            iv_12.setImageResource(R.drawable.back_image);
            iv_13.setImageResource(R.drawable.back_image);
            iv_14.setImageResource(R.drawable.back_image);
            iv_15.setImageResource(R.drawable.back_image);
            iv_16.setImageResource(R.drawable.back_image);
            iv_17.setImageResource(R.drawable.back_image);
            iv_18.setImageResource(R.drawable.back_image);
            iv_19.setImageResource(R.drawable.back_image);
            iv_20.setImageResource(R.drawable.back_image);
            iv_21.setImageResource(R.drawable.back_image);
            iv_22.setImageResource(R.drawable.back_image);
            iv_23.setImageResource(R.drawable.back_image);
            iv_24.setImageResource(R.drawable.back_image);
            iv_25.setImageResource(R.drawable.back_image);
            iv_26.setImageResource(R.drawable.back_image);
            iv_27.setImageResource(R.drawable.back_image);
            iv_28.setImageResource(R.drawable.back_image);
            iv_29.setImageResource(R.drawable.back_image);
            iv_30.setImageResource(R.drawable.back_image);
            iv_31.setImageResource(R.drawable.back_image);
            iv_32.setImageResource(R.drawable.back_image);
            iv_33.setImageResource(R.drawable.back_image);
            iv_34.setImageResource(R.drawable.back_image);
            iv_35.setImageResource(R.drawable.back_image);
            iv_36.setImageResource(R.drawable.back_image);
            iv_37.setImageResource(R.drawable.back_image);
            iv_38.setImageResource(R.drawable.back_image);
            iv_39.setImageResource(R.drawable.back_image);
            iv_40.setImageResource(R.drawable.back_image);

            //Escolhendo as cores dos players de acordo com seu Turno
            if (turn == 1) {
                turn = 2;
                tv_p1.setTextColor(Color.GRAY);
                tv_p2.setTextColor(Color.BLUE);
            }else if (turn == 2){
                turn = 1;
                tv_p2.setTextColor(Color.GRAY);
                tv_p1.setTextColor(Color.BLUE);

            }
        }

        iv_1.setEnabled(true);
        iv_2.setEnabled(true);
        iv_3.setEnabled(true);
        iv_4.setEnabled(true);
        iv_5.setEnabled(true);
        iv_6.setEnabled(true);
        iv_7.setEnabled(true);
        iv_8.setEnabled(true);
        iv_9.setEnabled(true);
        iv_10.setEnabled(true);
        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_13.setEnabled(true);
        iv_14.setEnabled(true);
        iv_15.setEnabled(true);
        iv_16.setEnabled(true);
        iv_17.setEnabled(true);
        iv_18.setEnabled(true);
        iv_19.setEnabled(true);
        iv_20.setEnabled(true);
        iv_21.setEnabled(true);
        iv_22.setEnabled(true);
        iv_23.setEnabled(true);
        iv_24.setEnabled(true);
        iv_25.setEnabled(true);
        iv_26.setEnabled(true);
        iv_27.setEnabled(true);
        iv_28.setEnabled(true);
        iv_29.setEnabled(true);
        iv_30.setEnabled(true);
        iv_31.setEnabled(true);
        iv_32.setEnabled(true);
        iv_33.setEnabled(true);
        iv_34.setEnabled(true);
        iv_35.setEnabled(true);
        iv_36.setEnabled(true);
        iv_37.setEnabled(true);
        iv_38.setEnabled(true);
        iv_39.setEnabled(true);
        iv_40.setEnabled(true);

        //verificar se o Game acabou
        checkEnd();
    }

    private void checkEnd() {
        if (iv_1.getVisibility() == View.INVISIBLE &&
                iv_2.getVisibility() == View.INVISIBLE &&
                iv_3.getVisibility() == View.INVISIBLE &&
                iv_4.getVisibility() == View.INVISIBLE &&
                iv_5.getVisibility() == View.INVISIBLE &&
                iv_6.getVisibility() == View.INVISIBLE &&
                iv_7.getVisibility() == View.INVISIBLE &&
                iv_8.getVisibility() == View.INVISIBLE &&
                iv_9.getVisibility() == View.INVISIBLE &&
                iv_10.getVisibility() == View.INVISIBLE &&
                iv_11.getVisibility() == View.INVISIBLE &&
                iv_12.getVisibility() == View.INVISIBLE &&
                iv_13.getVisibility() == View.INVISIBLE &&
                iv_14.getVisibility() == View.INVISIBLE &&
                iv_15.getVisibility() == View.INVISIBLE &&
                iv_16.getVisibility() == View.INVISIBLE &&
                iv_17.getVisibility() == View.INVISIBLE &&
                iv_18.getVisibility() == View.INVISIBLE &&
                iv_19.getVisibility() == View.INVISIBLE &&
                iv_20.getVisibility() == View.INVISIBLE &&
                iv_21.getVisibility() == View.INVISIBLE &&
                iv_22.getVisibility() == View.INVISIBLE &&
                iv_23.getVisibility() == View.INVISIBLE &&
                iv_24.getVisibility() == View.INVISIBLE &&
                iv_25.getVisibility() == View.INVISIBLE &&
                iv_26.getVisibility() == View.INVISIBLE &&
                iv_27.getVisibility() == View.INVISIBLE &&
                iv_28.getVisibility() == View.INVISIBLE &&
                iv_29.getVisibility() == View.INVISIBLE &&
                iv_30.getVisibility() == View.INVISIBLE &&
                iv_31.getVisibility() == View.INVISIBLE &&
                iv_32.getVisibility() == View.INVISIBLE &&
                iv_33.getVisibility() == View.INVISIBLE &&
                iv_34.getVisibility() == View.INVISIBLE &&
                iv_35.getVisibility() == View.INVISIBLE &&
                iv_36.getVisibility() == View.INVISIBLE &&
                iv_37.getVisibility() == View.INVISIBLE &&
                iv_38.getVisibility() == View.INVISIBLE &&
                iv_39.getVisibility() == View.INVISIBLE &&
                iv_40.getVisibility() == View.INVISIBLE) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder
                    .setMessage("Fim de jogo!\nPlayer 1: " + player1Points + "\nPlayer 2: " + player2Points)
                    .setCancelable(false)
                    .setPositiveButton("Novo Jogo", (dialog, i) -> {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        finish();
                    })
                    .setNegativeButton("Tela Inicial", (dialog, i) -> finish());
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }
    private void frontOfCardsResources() {

        image101 = R.drawable.image101;
        image102 = R.drawable.image102;
        image103 = R.drawable.image103;
        image104 = R.drawable.image104;
        image105 = R.drawable.image105;
        image106 = R.drawable.image106;
        image107 = R.drawable.image107;
        image108 = R.drawable.image108;
        image109 = R.drawable.image109;
        image110 = R.drawable.image110;
        image111 = R.drawable.image111;
        image112 = R.drawable.image112;
        image113 = R.drawable.image113;
        image114 = R.drawable.image114;
        image115 = R.drawable.image115;
        image116 = R.drawable.image116;
        image117 = R.drawable.image117;
        image118 = R.drawable.image118;
        image119 = R.drawable.image119;
        image120 = R.drawable.image120;

        image201 = R.drawable.image201;
        image202 = R.drawable.image202;
        image203 = R.drawable.image203;
        image204 = R.drawable.image204;
        image205 = R.drawable.image205;
        image206 = R.drawable.image206;
        image207 = R.drawable.image207;
        image208 = R.drawable.image208;
        image209 = R.drawable.image209;
        image210 = R.drawable.image210;
        image211 = R.drawable.image211;
        image212 = R.drawable.image212;
        image213 = R.drawable.image213;
        image214 = R.drawable.image214;
        image215 = R.drawable.image215;
        image216 = R.drawable.image216;
        image217 = R.drawable.image217;
        image218 = R.drawable.image218;
        image219 = R.drawable.image219;
        image220 = R.drawable.image220;


    }
}