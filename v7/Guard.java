public class Guard extends Monster{
    public Guard() {
        super();
        this.health = 100;
        this.maxHealth = 100;
        this.speed = 0;
        this.strength = 50;
        this.attackRating = 1.5;
        this.defense = 0;
    }
    public String getType() {
        return "Guard";
    }
    public int attack(Character e) {
        calcNewDamage(this, e);
        if (attackState.equals("RNGesus Bash")) {
          //System.out.println("Swinging Hammer...");
          int amplifier = (int) (Math.random() * 10);
          if (amplifier > 5) {
            this.damage += amplifier * 2;
            e.lowerHP(this.damage, this.getType());
            this.test = "WOWEE! Thy gods have blessed thee I see! Extra DAMAGE! You attack ";
          } else {
            this.test = "Youg swung too hard, and bashed thy skull. Ye lost 5 health! You attack ";
            lowerHP(5);
            e.lowerHP(this.damage, this.getType());
          }
        } else if (Math.random() > 0.6) {
            this.defense += 10;
            e.lowerHP(this.damage, this.getType());
            
            this.test = "\nGuard performs strengthen. Guard's defense now increases by 10. Guard also attacks you";
        } else {
          this.test = "\nGuard stabs with a pike. Guard attacks you";
          e.lowerHP(this.damage, this.getType());
        }
        return this.damage;
      }
}
