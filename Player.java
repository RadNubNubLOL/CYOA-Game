public class Player 
{
    private String playerName = new String();
    private String playerClass = new String();
    
    private int playerHealth = 100;
    private int playerHealAmount;
    
    private boolean playerIsDodging = false;
    private boolean playerIsHidden = false;
    
    public Player(String pName, String pClass)
    {
        playerName = pName;
        playerClass = pClass;
    }
    
    public String getPlayerName()
    {
        return playerName;
    }
    
    public int getPlayerHealth()
    {
        return playerHealth;
    }
    
    public void setGladiatorHealth()
    {
        playerHealth = 125;
    }
    
    public String getPlayerClass()
    {
        return playerClass;
    }
    
    public void resetPlayerHealth()
    {
        if (!(playerClass == "Gladiator"))
        {
            playerHealth = 100;
        }
        else
        {
            playerHealth = 125;
        }
    }
    
    public void playerIsAttacked(int damageReceived, String enemyName)
    {
        if ((playerIsDodging == true) && (playerClass == "Specter") && (Math.random() <= 0.25))
        {
            playerHealth = playerHealth - damageReceived;
            System.out.println("\nYou got attacked, and took " + damageReceived + " damage.");
        }
        else if (((playerIsDodging == false) || (Math.random() <= 0.5)) && !((playerClass == "Specter") && (playerIsDodging == true)))
        {
            playerHealth = playerHealth - damageReceived;
            System.out.println("\nYou got attacked, and took " + damageReceived + " damage.");
        }
        else
        {
            System.out.println("\nYou dodged " + enemyName + "'s attack!");
        }
    }
    
    public void playerDodge()
    {
        playerIsDodging = true;
        System.out.println("\nYou are prepared to dodge incoming attacks!");
    }
    
    public void resetPlayerDodge()
    {
        playerIsDodging = false;
    }
    
    public void playerHide(String enemyName)
    {
        if ((Math.random() <= 0.75) && (playerClass == "Specter"))
        {
            playerIsHidden = true;
            System.out.println("\nYou are now hidden from " + enemyName + "'s view.");
        }
        else if ((Math.random() <= 0.5) && !(playerClass == "Specter"))
        {
            playerIsHidden = true;
            System.out.println("\nYou are now hidden from " + enemyName + "'s view.");
        }
        else
        {
            System.out.println("\nYou tried to hide from " + enemyName + ", but failed.");
        }
    }
    
    public boolean isPlayerHidden()
    {
        return playerIsHidden;
    }
    
    public void resetPlayerHidden()
    {
        playerIsHidden = false;
    }
    
    public void playerRest()
    {
        if (playerClass.equals("Guardian"))
        {
            playerHealAmount = (int) (Math.random() * 50) + 1;
        }
        else
        {
            playerHealAmount = (int) (Math.random() * 25) + 1;
        }
        playerHealth = playerHealth + playerHealAmount;
        if ((playerHealth > 100) && !(playerClass == "Gladiator"))
        {
            playerHealth = 100;
        }
        else if (playerHealth > 125)
        {
            playerHealth = 125;
        }
        System.out.println("\nYou rested, regaining " + playerHealAmount + " health.");
    }
    
    public void playerCheat(int playerHealAmount)
    {
        playerHealth = playerHealth + playerHealAmount;
    }
}
