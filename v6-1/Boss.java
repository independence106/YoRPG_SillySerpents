public class Boss extends Monster {
    public Boss() {
        super();
        this.health = 300;
        this.maxHealth = 300;
        this.speed = 0;
        this.strength = 70;
        this.attackRating = 1.5;
        this.defense = 30;
    }
    public String getType() {
        return "Boss";
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
        } else if (Math.random() > 0.8) {
            this.damage = e.getMaxHealth() / 5;
            e.lowerHP(this.damage, this.getType());
            this.test = "\nBoss performs lifedrain. You lose 1/5 of your health! OUCH! He attacks you";
        } else {
          this.test = "\nBoss flicks you with his finger and attacks you";
          e.lowerHP(this.damage, this.getType());
        }
        return this.damage;
      }
}
