public class Enemy 
{
    private String enemyName = new String();
    
    private int enemyHealth;
    private int enemyDamageTaken;
    private int enemyHealAmount;
    
    private boolean enemyIsDodging = false;
    private boolean enemyIsHidden = false;
    
    public Enemy(String eName, int eHealth)
    {
        enemyName = eName;
        enemyHealth = eHealth;
    }
    
    public String getEnemyName()
    {
        return enemyName;
    }
    
    public int getEnemyHealth()
    {
        return enemyHealth;
    }
    
    public void killEnemy()
    {
        enemyHealth = 0;
    }
    
    public void enemyIsAttacked(String playerClass, boolean playerHidden)
    {
        if (enemyIsDodging == false || Math.random() <= 0.5)
        {
            if ((Math.random() <= 0.05) && (playerClass.equalsIgnoreCase("Goku")))
            {
                enemyDamageTaken = 9001;    
            }
            else if ((playerHidden == true) && (playerClass.equalsIgnoreCase("Gladiator")))
            {
                enemyDamageTaken = (int) (Math.random() * 91) + 30;
            }
            else if (playerHidden == true)
            {
                enemyDamageTaken = (int) (Math.random() * 61) + 20;
            }
            else if (playerClass.equalsIgnoreCase("Gladiator"))
            {
                enemyDamageTaken = (int) (Math.random() * 46) + 15;
            }
            else
            {
                enemyDamageTaken = (int) (Math.random() * 31) + 10;
            }
            enemyHealth = enemyHealth - enemyDamageTaken;
            System.out.println("\nYou dealt " + enemyDamageTaken + " damage to " + enemyName + ".");
        }
        else
        {
            System.out.println("\n" + enemyName + " dodged your attack!");
        }
    }
    
    public void enemyDodge()
    {
        enemyIsDodging = true;
        System.out.println("\n" + enemyName + " is prepared to dodge incoming attacks!");
    }
    
    public boolean isEnemyDodging()
    {
        return enemyIsDodging;
    }
    
    public void resetEnemyDodge()
    {
        enemyIsDodging = false;
    }
    
    public void enemyHide()
    {
        if (Math.random() <= 0.5)
        {
            enemyIsHidden = true;
            System.out.println("\n" + enemyName + " is now out of your sight...");
        }
        else
        {
            System.out.println("\n" + enemyName + " tried to hide from you, but failed.");
        }
    }
    
    public boolean isEnemyHidden()
    {
        return enemyIsHidden;
    }
    
    public void resetEnemyHidden()
    {
        enemyIsHidden = false;
    }
    
    public boolean searchForPlayer(String playerClass)
    {
        if ((Math.random() <= 0.25) && (playerClass.equalsIgnoreCase("Specter")))
        {
            System.out.println("\n" + enemyName + " has spotted you!");
            return true;
        }
        else if ((Math.random() <= 0.5) && !(playerClass.equalsIgnoreCase("Specter")))
        {
            System.out.println("\n" + enemyName + " has spotted you!");
            return true;
        }
        else
        {
            System.out.println("\n" + enemyName + " tried to look for you, but failed.");
            return false;
        }
    }
    
    public void enemyRest(int enemyHealAmount, int fightCount)
    {
        enemyHealth = enemyHealth + enemyHealAmount;
        if (enemyHealth > (50 + (25 * (fightCount - 1))))
        {
            enemyHealAmount = enemyHealAmount - (enemyHealth - (50 + (25 * (fightCount - 1))));
            enemyHealth = (50 + (25 * (fightCount - 1)));
        }
        System.out.println("\n" + enemyName + " rested, regaining " + enemyHealAmount + " health.");
    }
    
    public void enemyCheat(int enemyDamageAmount)
    {
        enemyHealth = enemyHealth + enemyDamageAmount;
    }
}
