package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer implements PlayerInterface<SlotsReel> {
    private ArcadeAccount account;

    public SlotsPlayer(ArcadeAccount account) {
        this.account = account;
    }

    @Override
    public ArcadeAccount getArcadeAccount() {
        return account;
    }

    @Override
    public void play(SlotsReel slotsReel, String userInput) {
        IOConsole console = new IOConsole(AnsiColor.YELLOW);
        if("pull-lever".equals(userInput)) {
            slotsReel.spin();
        } else if("view-slot-reel".equals(userInput)) {
            slotsReel.display();
        } else if("quit".equals(userInput)) {
        } else {
            console.println("You dun messed up");
            console.println("Mm hmm, knew you would");
            console.println("%s is not a valid input", userInput);
            console.println("Please, try again");
            play(slotsReel, userInput);
        }
    }
}