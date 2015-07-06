/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.view;

import byu.cit260.Charcoaled.control.GameControl;
import byu.cit260.Charcoaled.control.InventoryControl;
import byui.cit260.Charcoaled.model.InventoryItem;

/**
 *
 * @author raquel
 */
public class PlayerInventoryView extends View {

    public PlayerInventoryView() {
        super("______________________                      \n"
                + "   Inventory Menu     \\____________________\n"
                + "                                            \n"
                + " W - View Player Inventory                  \n"
                + " K - View Total Items in Player Inventory   \n"
                + "                                            \n"
                + " E - Exit                                   \n"
                + "____________________________________________");
    }

    @Override
    public boolean doAction(Object obj) {
        char selection = (char) obj;
        switch (selection) {
            case 'W':
                this.viewPlayerItems();
                break;
            case 'K':
                this.viewQuantityOfPlayerItems();
                break;
            case 'E':
                return true;
            default:
                System.out.println(
                        "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                        + "             Invalid selection - Please, try again.                 \n"
                        + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                );
        }
        return true;
    }

    private void viewPlayerItems() {

        InventoryItem[] inventory = InventoryControl.getPlayerInventory(true);
        System.out.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
        );

        for (InventoryItem item : inventory) {
            System.out.println(
                    "\t" + item.getQuantityInStock() + " " + item.getInventoryType() + " available. \n"
            );
        }
        System.out.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
        );
    }

    private void viewQuantityOfPlayerItems() {
        InventoryItem[] inventory = InventoryControl.getPlayerInventory(false);
        System.out.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
        );
        int x = InventoryControl.getQuantityOfItems(inventory);

        System.out.println(
                "         Total # of Items in Player Inventory --> " + x + "         \n"
                + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
        );
    }
}
