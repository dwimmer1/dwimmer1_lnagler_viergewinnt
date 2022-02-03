package com.example.viergewinnt_dwimmer1_lnagler1.controller;


import com.example.viergewinnt_dwimmer1_lnagler1.modell.Player;
import com.example.viergewinnt_dwimmer1_lnagler1.modell.Stone;
import com.example.viergewinnt_dwimmer1_lnagler1.view.PlayerView;
import com.example.viergewinnt_dwimmer1_lnagler1.view.StoneView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 * @generated
 */
public class GameController {
    public static void main(String[] args) {
        PlayerView createPl = new PlayerView();
        GameController rand = new GameController();
        Player Player1 = new Player();
        Player Player2 = new Player();

        StoneView st = new StoneView();
        StoneView st1 = new StoneView();
        Stone stone = new Stone();
        Stone stone1 = new Stone();
        StoneView stoneview = new StoneView();

        String[] decision = {
                "Wollen sie ein Standardsymbol verwenden? (J/N)",
                "Wollen sie als Standardsymbol X oder O verwenden?",
                "Welches Symbol wollen sie dann verwenden?"
        };

        do {
            InputStreamReader pl1 = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(pl1);
            createPl.createPlayer();
            String eingabe = null;
            try {
                eingabe = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Player1.setName(eingabe);


            Scanner choosesc = new Scanner(System.in);
            st.createStone(decision[0]);
            char choose = choosesc.next().charAt(0);
            if (choose == 'J' || choose == 'j') { // d
                Character[] playerSymbol = stone.getSymbol();
                stoneview.showStone(playerSymbol);
                Scanner c = new Scanner(System.in);
                int auswahl = c.nextInt();
                if (auswahl == 0) {
                    stone.setSymbol('X');
                } else if (auswahl == 1) {
                    stone.setSymbol('O');
                }
            } else {
                Scanner nonstandard = new Scanner(System.in);
                st.createStone(decision[2]);
                char symbol = nonstandard.next().charAt(0);
                stone.setSymbol(symbol);
            }


        } while (Player.rv);
        do {
            InputStreamReader pl2 = new InputStreamReader(System.in);
            BufferedReader br1 = new BufferedReader(pl2);
            createPl.createPlayer();
            String eingabe1 = null;
            try {
                eingabe1 = br1.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Player2.setName(eingabe1);
        } while (Player.rv);

        do {
            Scanner choosesc1 = new Scanner(System.in);
            st.createStone(decision[0]);
            char choose = choosesc1.next().charAt(0);
            if (choose == 'J' || choose == 'j') {
                Character[] playerSymbol = stone1.getSymbol();
                stoneview.showStone(playerSymbol);
                Scanner c = new Scanner(System.in);
                int auswahl = c.nextInt();
                if (auswahl == 0) {
                    stone1.setSymbol('X');
                } else if (auswahl == 1) {
                    stone1.setSymbol('O');
                }
            } else {
                Scanner nonstandard = new Scanner(System.in);
                st.createStone(decision[2]);
                char symbol = nonstandard.next().charAt(0);
                stone1.setSymbol(symbol);
            }
        } while (Stone.rv);

        if (rand.getRandStarter() == 0) {
            createPl.showPlayer(Player1.getName());
        } else {
            createPl.showPlayer(Player2.getName());
        }
    }

    /**
     * @generated
     */
    private Integer randStarter;


    /**
     * @generated
     */
    public Integer getRandStarter() {
        Random rand = new Random();
        int value = rand.nextInt(2);
        randStarter = value;
        System.out.println(value);

        return this.randStarter;
    }

    /**
     * @generated
     */
    public Integer setRandStarter(Integer randStarter) {
        this.randStarter = randStarter;

        return 0;
    }


}
