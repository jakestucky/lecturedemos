package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame implements GameInterface {
    private IOConsole console = new IOConsole(AnsiColor.GREEN);
    private List<PlayerInterface> playerList = new ArrayList<>();
    private SlotsReel slotsReel = new SlotsReel();

    @Override
    public void add(PlayerInterface player) {
        console.println("Adding player %s to slots game", player.toString());
        playerList.add(player);
    }

    @Override
    public void remove(PlayerInterface player) {
        playerList.remove(player);
    }

    @Override
    public void run() {
        for (PlayerInterface playerInterface : playerList) {
            String userInput;
            do {
                SlotsPlayer slotsPlayer = (SlotsPlayer) playerInterface;
                console.println("Welcome to the slots game.");
                console.println("From here you can select any of the following options:");
                userInput = console.getStringInput("pull-lever, view-slot-reel, quit");
                slotsPlayer.play(slotsReel, userInput);
            } while(!"quit".equals(userInput)); // go to next player
        }
    }
}
