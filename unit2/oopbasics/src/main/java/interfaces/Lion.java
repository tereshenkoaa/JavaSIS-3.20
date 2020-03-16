package interfaces;

import java.time.LocalDate;

public class Lion extends Animal {
    public Lion(String name, String color, double weight, LocalDate birthDay) {
        super(name, color, weight, birthDay);
    }

    @Override
    public String paint() {
        return "                       \\\\\\\\\\\\\\////\n"
                + "                             \\\\//\\/\\\\\\\\\\\\\\///\n"
                + "                           \\\\\\`      \\\\\\\\\\\\///\n"
                + "                          \\\\       ||\\      \\\n"
                + "                          \\  \\\\   //     _\\  `\\\n"
                + "                         /  /. \\  \\\\    /O.    `\\,\n"
                + "                        //  |__\\\\ //\\         . __\\\n"
                + "                      /`           //\\\\      , .\\ /\n"
                + "                     \\\\\\\\          //\\        ___|\n"
                + "                    ////\\\\            \\\\     `   \\\n"
                + "                  //////////\\\\\\\\       //__       |\n"
                + "                 |`  \\\\\\//////\\\\        \\_ \\______|\n"
                + "                 |     \\\\\\\\//\\\\/////\\\\\\   \\\n"
                + "                ./      \\\\\\\\////////\\\\     |\\\n"
                + "                |        \\\\\\\\////\\\\//\\\\\\\\\\\\\\\\\n"
                + "                |          \\\\\\///      \\\\\\\\\\\\\n"
                + "                |          \\\\\\//         \\//\n"
                + "                |            \\/        \\ |\n"
                + "                |             `         \\|\n"
                + "                | |                      \\                       /\n"
                + "                | |           \\           \\                     //\n"
                + "                | |                        \\                   ////\n"
                + "                | |             .          `|                 /////\n"
                + "                | |                         `\\                \\\\////\n"
                + "                 \\`|                          `|              \\\\||/\n"
                + "                  | |             \\            `|  ,--.         \\ \\,\n"
                + "                  |  \\                          |./    `\\        | |\n"
                + "                   |  |                                 |        | |\n"
                + "                   |___|            .                   |        | |\n"
                + "                   /   |                                |        | |\n"
                + "                   |    |                               ;        | |\n"
                + "                   |                                    |        | |\n"
                + "                 __|                                   /`       /` ;\n"
                + "                /   \\                          ,      ; \\     ,` ,/\n"
                + "                \\____\\              \\       \\,/__________|__.' ,`\n"
                + "                  nmf \\______________\\_______________________.'\n ";
    }
}
