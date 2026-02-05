import java.util.Scanner;

public class Adventure
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        boolean isValid = false;
        
        System.out.print("Choose your character's name: ");
        String tempName = input.nextLine();
        
        while (isValid == false)
        {   
            if (tempName.length() <= 20)
            {
                isValid = true;
            }
            else
            {
                System.out.println("\nPlease choose a name that is 20 characters or less.\n");
                System.out.print("Choose your character's name: ");
                tempName = input.nextLine();
            }
        }
        
        isValid = false;
        
        System.out.print("\nChoose your character's class (Either Guardian, Gladiator, or Specter." +
                         "\nYou can also type 'help' to learn more about these classes): ");
        String tempClass = input.nextLine();
        
        while (isValid == false)
        {
            if ((tempClass.equalsIgnoreCase("Guardian")) || (tempClass.equalsIgnoreCase("Gladiator")) || (tempClass.equalsIgnoreCase("Specter")))
            {
                isValid = true;
            }
            else if (tempClass.equalsIgnoreCase("Help"))
            {
                System.out.println("\nGuardian: Your character learns healing magic. The rest move will now heal more than usual." +
                                   "\nGladiator: Your character is exceptionally skilled in combat. Max health and damage increases." + 
                                   "\nSpecter: Your character is agile and nimble. The dodge and hide moves become more effective.");
                System.out.print("\nPlease input Guardian, Gladiator, Specter, or help: ");
                tempClass = input.nextLine();
            }
            else
            {
                System.out.print("\nPlease input Guardian, Gladiator, Specter, or help: ");
                tempClass = input.nextLine();
            }
        }
        
        Player player = new Player(tempName, tempClass);
        
        if (player.getPlayerClass().equalsIgnoreCase("Gladiator"))
        {
            player.setGladiatorHealth();
        }
        
        Enemy enemy = null;
        isValid = false;
        int initializeFightCount = 0;
        
        System.out.print("\nInput the name of the enemy you wish to fight," +
                         "\nor input 'skip' to start a new game: ");
        String fightThis = input.nextLine();
        
        while (isValid == false)
        {
            if (fightThis.equalsIgnoreCase("Skip") || fightThis.equalsIgnoreCase("Flick"))
            {
                initializeFightCount = 1;
                isValid = true;
            }
            else if (fightThis.equalsIgnoreCase("Ronin"))
            {
                initializeFightCount = 2;
                isValid = true;
            }
            else if (fightThis.equalsIgnoreCase("Drake"))
            {
                initializeFightCount = 3;
                isValid = true;
            }
            else if (fightThis.equalsIgnoreCase("Xander"))
            {
                initializeFightCount = 4;
                isValid = true;
            }
            else if (fightThis.equalsIgnoreCase("Aethis"))
            {
                initializeFightCount = 5;
                isValid = true;
            }
            else
            {
                System.out.print("\nPlease input the name of the enemy you wish to fight," +
                                 "\nor input 'skip' to start a new game: ");
                fightThis = input.nextLine();
            }
        }
        
        if (initializeFightCount == 1)
        {
            System.out.println("\nYou find yourself in what appears to be a large stadium, with crowds gathered in the" + 
                               "\nstands. In the distance, you also see a humanoid figure on the other side of the arena.");
        
            System.out.println("\nThe announcer steps in: \"Flick vs " + player.getPlayerName() + "! This will be a fight to the death! Begin!\"");
        }
        
        String playerAction;
        int randomInt;
        int enemyDamage;
        int eHealAmount;
        enemy = new Enemy("Flick", 50);
        
        for (int fightCount = initializeFightCount; fightCount <= 5; fightCount++)
        {
            if (fightCount == 2)
            {
                enemy = new Enemy("Ronin", 75);
                player.resetPlayerHealth();
                System.out.println("\nFlick collapses to the ground. As they do, you hear the announcer say:" +
                                   "\n\"And we have a winner! " + player.getPlayerName() + " lives to see another day!\"" +
                                   "\nYou are given the rest of the day to rest. But, tomorrow..." +
                                   "\nThe announcer once again steps in: \"Ronin vs " + player.getPlayerName() + "! Like before, fight until someone dies! Begin!\"");
                
            }
            else if (fightCount == 3)
            {
                enemy = new Enemy("Drake", 100);
                player.resetPlayerHealth();
                System.out.println("\nRonin collapses to the ground. As they do, you once again hear the announcer say:" +
                                   "\n\"" + player.getPlayerName() + " has once again bested the competition!\"" +
                                   "\nLike before, the rest of the day is yours. Fast forward to the next day..." +
                                   "\nThe announcer steps in for a third time: \"Drake vs " + player.getPlayerName() + "! Surely you both know how this works by now! Begin!\"");
            }
            else if (fightCount == 4)
            {
                enemy = new Enemy("Xander", 125);
                player.resetPlayerHealth();
                System.out.println("\nDrake collapses to the ground. As they do, the announcer routinely says:" +
                                   "\n\"A winner has once again been decided! " + player.getPlayerName() + " will be moving on to the next round!\"" +
                                   "\nOnce again, you spend the rest of the day recovering from your last encounter. Before you know it, the next dawn arises..." +  
                                   "\nThe announcer announces the fourth fight: \"Xander vs " + player.getPlayerName() + "! Begin!\"");
            }
            else if (fightCount == 5)
            {
                enemy = new Enemy("Aethis", 150);
                player.resetPlayerHealth();
                System.out.println("\nXander collapses to the ground. As they do, the announcer once again routinely says:" +
                                   "\n\"For winning four consecutive fights, " + player.getPlayerName() + " will now be moving on to the final round!\"" +
                                   "\nAfter spending the rest of the day preparing for the most formidable foe yet, it is time for..." +
                                   "\n\"The final fight! Aethis vs " + player.getPlayerName() + "\" the announcer shouts. \"Begin!"); 
            }
            
            while (enemy.getEnemyHealth() > 0)
            {
                player.resetPlayerDodge();
                isValid = false;
            
                System.out.print("\nChoose what you would like to do on your turn (You can either attack, dodge, hide," + 
                                "\nsearch, or rest. You can also type 'help' to learn more about these actions," +
                                "\nor 'info' to get the stats of the current fight): ");
                playerAction = input.nextLine();
            
                while (isValid == false)
                {
                    if (playerAction.equalsIgnoreCase("Attack"))
                    {
                        if (enemy.isEnemyHidden() == false)
                        {
                            enemy.enemyIsAttacked(player.getPlayerClass(), player.isPlayerHidden());
                            player.resetPlayerHidden();
                            isValid = true;
                        }
                        else
                        {   
                            System.out.println("\nYou do not know where " + enemy.getEnemyName() + " is. As such, you cannot attack them.");
                            System.out.print("\nPlease input attack, dodge, hide, search, rest, help, or info: ");
                            playerAction = input.nextLine();
                        }
                    }
                    else if (playerAction.equalsIgnoreCase("Dodge"))
                    {
                        player.playerDodge();
                        isValid = true;
                    }
                    else if (playerAction.equalsIgnoreCase("Hide"))
                    {
                        player.playerHide(enemy.getEnemyName());
                        isValid = true;
                    }
                    else if (playerAction.equalsIgnoreCase("Search"))
                    {
                        if (enemy.isEnemyHidden() == true)
                        {
                            if (Math.random() <= 0.5)
                            {
                                enemy.resetEnemyHidden();
                                System.out.println("\nYou have found where " + enemy.getEnemyName() + " is hiding.");
                            }
                            else
                            {
                                System.out.println("\nYou tried to look for " + enemy.getEnemyName() + ", but did not find them.");
                            }
                            isValid = true;
                        }
                        else
                        {
                            System.out.println("\nYou cannot search for an enemy that is not hidden.");
                            System.out.print("\nPlease input attack, dodge, hide, search, rest, help, or info: ");
                            playerAction = input.nextLine();
                        }
                    }
                    else if (playerAction.equalsIgnoreCase("Rest"))
                    {
                        if ((player.getPlayerHealth() < 100) || ((player.getPlayerHealth() < 125) && (player.getPlayerClass().equalsIgnoreCase("Gladiator"))))
                        {
                            player.playerRest();
                            isValid = true;
                        }
                        else
                        {
                            System.out.println("\nYou cannot rest, as you are already at max health.");
                            System.out.print("\nPlease input attack, dodge, hide, search, rest, help, or info: ");
                            playerAction = input.nextLine();
                        }
                    }
                    else if (playerAction.equalsIgnoreCase("Help"))
                    {
                        System.out.println("\nAttack: Deal a random amount of damage to " + enemy.getEnemyName() + "." +
                                           "\nDodge: Chance for " + enemy.getEnemyName() + "'s attacks to miss for a turn." +
                                           "\nHide: Chance for you to become hidden from " + enemy.getEnemyName() + "." +
                                           "\nWhile hidden, " + enemy.getEnemyName() + " cannot attack you, and your next attack does double damage." + 
                                           "\n(Note that attacking also reveals yourself to " + enemy.getEnemyName() + ")" +
                                           "\nSearch: Chance for you to find where " + enemy.getEnemyName() + " is hiding (If they are hiding)." +
                                           "\nRest: Recover a small amount of health." +
                                           "\nInfo: Displays the current stats of the fight.");
                        System.out.print("\nPlease input attack, dodge, hide, search, rest, help, or info: ");
                        playerAction = input.nextLine();
                    }
                    else if (playerAction.equalsIgnoreCase("Info"))
                    {
                        System.out.println("\nYour character's name: " + player.getPlayerName() +
                                           "\nHealth remaining: " + player.getPlayerHealth() +
                                           "\nClass: " + player.getPlayerClass() + 
                                           "\nHidden from " + enemy.getEnemyName() + ": " + player.isPlayerHidden() + 
                                           "\n" + enemy.getEnemyName() + " is hidden from you: " + enemy.isEnemyHidden() +
                                           "\n" + enemy.getEnemyName() + " is prepared to dodge incoming attacks: " + enemy.isEnemyDodging());
                        System.out.print("\nPlease input attack, dodge, hide, search, rest, help, or info: ");
                        playerAction = input.nextLine();
                    }
                    else if (playerAction.equalsIgnoreCase("UpUpDownDownLeftRightLeftRightBA"))
                    {
                        boolean isValid2 = false;
                        System.out.print("\nCheat code inputted. Please now input an integer." +
                                           "\nIf a positive integer is inputted, your character will heal that much health (Up to their max health)." +
                                           "\nIf a negative integer is inputted, " + enemy.getEnemyName() + " will lose that much health." +
                                           "\nIf zero is entered, nothing happens. You can also input 'help' to display this message again." + 
                                           "\nInput: ");
                        playerAction = input.nextLine();
                        
                        while (isValid2 == false)
                        {
                            if (isInteger(playerAction))
                            {
                                if (Integer.parseInt(playerAction) > 0)
                                {
                                    player.playerCheat(Integer.parseInt(playerAction));
                                }
                                else if (Integer.parseInt(playerAction) < 0)
                                {
                                    enemy.enemyCheat(Integer.parseInt(playerAction));    
                                }
                                
                                isValid2 = true;
                                if (enemy.getEnemyHealth() < 1)
                                {
                                    isValid = true;
                                }
                            }
                            else if (playerAction.equalsIgnoreCase("Help"))
                            {
                                System.out.print("\nPlease input an integer." +
                                                 "\nIf a positive integer is inputted, your character will heal that much health (Up to their max health)." +
                                                 "\nIf a negative integer is inputted, " + enemy.getEnemyName() + " will lose that much health." +
                                                 "\nIf zero is entered, nothing happens." + 
                                                 "\nInput: ");
                                playerAction = input.nextLine();
                            }
                            else
                            {
                                System.out.print("\nPlease input an integer: ");
                                playerAction = input.nextLine();
                            }
                        }
                    }
                    else
                    {
                        System.out.print("\nPlease input attack, dodge, hide, search, rest, help, or info: ");
                        playerAction = input.nextLine();
                    }
                }
            
                enemy.resetEnemyDodge();
                isValid = false;
            
                while ((isValid == false) && (enemy.getEnemyHealth() > 0))
                {
                    randomInt = (int) (Math.random() * 5) + 1;
                
                    if (randomInt == 1 && player.isPlayerHidden() == false)
                    {
                        if (enemy.isEnemyHidden() == false)
                        {
                            enemyDamage = (int) (Math.random() * 25 * fightCount) + 1;
                        }
                        else
                        {
                            enemyDamage = (int) (Math.random() * 50 * fightCount) + 1;
                        }
                        player.playerIsAttacked(enemyDamage, enemy.getEnemyName());
                        if (player.getPlayerHealth() < 1)
                        {
                            System.out.println("\nAs your health has dropped to 0, you collapse. Just before you fall unconscious," +
                                               "\nyou hear the announcer say: \"And we have a winner! " + enemy.getEnemyName() + " lives to see another day!");
                            System.exit(0);
                        }
                        enemy.resetEnemyHidden();
                        isValid = true;
                        }
                        else if (randomInt == 2)
                        {
                            enemy.enemyDodge();
                            isValid = true;
                        }
                    else if (randomInt == 3 && enemy.isEnemyHidden() == false)
                    {
                        enemy.enemyHide();
                        isValid = true;
                    }
                    else if (randomInt == 4 && player.isPlayerHidden() == true)
                    {
                        if (enemy.searchForPlayer(player.getPlayerClass()) == true)
                        {
                            player.resetPlayerHidden();
                        }
                        isValid = true;
                    }
                    else if (randomInt == 5 && enemy.getEnemyHealth() < (50 + (25 * (fightCount - 1))))
                    {
                        eHealAmount = (int) (Math.random() * 12 * fightCount) + 1;
                        enemy.enemyRest(eHealAmount, fightCount);
                        isValid = true;
                    }
                }
            }
        }
        
        System.out.println("\nAethis collapses to the ground. As they do, the announcer says:" + 
                           "\n\"Congratulations, " + player.getPlayerName() + "! You have defeated every opponnent thrown your way!\"");
    }
    
    public static boolean isInteger (String potentialInteger)
    {
        try
        {
            Integer.parseInt(potentialInteger);
            return true;
        }
        catch (NumberFormatException error)
        {
            return false;    
        }
    }
}
